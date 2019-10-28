/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.retreat.sms.business.custom.impl;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import lk.retreat.sms.business.custom.ClientBO;
import lk.retreat.sms.dao.DAOFactory;
import lk.retreat.sms.dao.custom.AppointmentDAO;
import lk.retreat.sms.dao.custom.ClientDAO;
import lk.retreat.sms.dao.custom.PaymentDAO;
import lk.retreat.sms.dao.custom.ServiceDetailDAO;
import lk.retreat.sms.db.DBConnection;
import lk.retreat.sms.dto.AppointmentDTO;
import lk.retreat.sms.dto.ClientDTO;
import lk.retreat.sms.dto.PaymentDTO;
import lk.retreat.sms.dto.ServiceDetailDTO;
import lk.retreat.sms.entity.Appointment;
import lk.retreat.sms.entity.Client;
import lk.retreat.sms.entity.Payment;
import lk.retreat.sms.entity.ServiceDetail;

/**
 *
 * @author User
 */
public class ClientBOImpl implements ClientBO{
     
     private ClientDAO clientDao;
     private AppointmentDAO appointmentDAO;
     private PaymentDAO paymentDAO;
     private ServiceDetailDAO serviceDetailDAO;
     
     private Connection connection;
        
        public ClientBOImpl(){
            
            clientDao=(ClientDAO)DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.Client);
            appointmentDAO=(AppointmentDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.APPOINTMENT);
            paymentDAO=(PaymentDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.PAYMENT);
            serviceDetailDAO=(ServiceDetailDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.SERVICE_DETAIL);
            
         try {
             connection=DBConnection.getInstance().getConnection();
         } catch (Exception ex) {
             Logger.getLogger(ClientBOImpl.class.getName()).log(Level.SEVERE, null, ex);
         }
        }

    @Override
    public ArrayList<ClientDTO> loadAllClient() throws Exception {
         ArrayList<ClientDTO>alClient=new ArrayList<>();
        
        ArrayList<Client> allClient=clientDao.getAll();
        for (Client client : allClient) {
            ClientDTO cus=new ClientDTO(client.getClientId(),client.getClientName(),client.getClientAddress(),client.getClientTel(),client.getClientEmaill(),client.getFirstInDate());
            alClient.add(cus);
        }
        return alClient;
   }

    @Override
    public boolean deleteClient(String clientId) throws Exception {
           return  clientDao.delete(clientId);
   }

    @Override
    public ClientDTO getSearchDetail(String text) throws Exception {
        
        Client c=clientDao.getSearchDetail(text);
        if(c!=null){
            return new ClientDTO(c.getClientId(), c.getClientName(), c.getClientAddress(), c.getClientTel(), c.getClientEmaill(), c.getFirstInDate());
    
        }
            return null;
    }

    @Override
    public boolean saveClient(ClientDTO clientDTO) throws Exception {
        
        return clientDao.save(new Client(clientDTO.getClientId(),clientDTO.getClientName(),clientDTO.getClientAddress(),clientDTO.getClientTel(),clientDTO.getClientEmail(),clientDTO.getFirstInDate()));
    }

    @Override
    public boolean saveWithNewClient(ClientDTO clientDTO, AppointmentDTO appointmentDTO, PaymentDTO paymentDTO, ServiceDetailDTO serviceDetailDTO) throws Exception {
        System.out.println("cllientA: "+clientDTO);
        System.out.println("AppointmentA: "+appointmentDTO);
        System.out.println("pymentA: "+paymentDTO);
        System.out.println("serviceA: "+serviceDetailDTO);
        
        connection.setAutoCommit(false);
        try{
            if(clientDao.save(new Client(clientDTO.getClientId(),clientDTO.getClientName(),clientDTO.getClientAddress(),clientDTO.getClientTel(),clientDTO.getClientEmail(),clientDTO.getFirstInDate()))){
                if(paymentDAO.save(new Payment(paymentDTO.getPaymentId(),paymentDTO.getPrice()))){
                    if(appointmentDAO.save(new Appointment(appointmentDTO.getAppId(),appointmentDTO.getDate(),appointmentDTO.getTime(),appointmentDTO.getClientId(),appointmentDTO.getEmpId(),appointmentDTO.getPaymentId(),appointmentDTO.getStatus()))){
                        if(serviceDetailDAO.save(new ServiceDetail(serviceDetailDTO.getServiceDetailId(),serviceDetailDTO.getCategory(),serviceDetailDTO.getAppId()))){
                            connection.commit();
                            return true;
                        }
                    }
                }
            }
            connection.rollback();
            return false;
        }catch(Exception ex){
            ex.printStackTrace();
            connection.rollback();
            return false;
        }finally{
            connection.setAutoCommit(true);
        }
    }

    @Override
    public boolean saveWithRegClient(AppointmentDTO appointmentDTO, PaymentDTO paymentDTO, ServiceDetailDTO serviceDetailDTO) throws Exception {
        
//        System.out.println("cllientA: "+clientDTO);
        System.out.println("AppointmentA: "+appointmentDTO);
        System.out.println("pymentA: "+paymentDTO);
        System.out.println("serviceA: "+serviceDetailDTO);
        
        connection.setAutoCommit(false);
        try{
            if(paymentDAO.save(new Payment(paymentDTO.getPaymentId(),paymentDTO.getPrice()))){
                    if(appointmentDAO.save(new Appointment(appointmentDTO.getAppId(),appointmentDTO.getDate(),appointmentDTO.getTime(),appointmentDTO.getClientId(),appointmentDTO.getEmpId(),appointmentDTO.getPaymentId(),appointmentDTO.getStatus()))){
                        if(serviceDetailDAO.save(new ServiceDetail(serviceDetailDTO.getServiceDetailId(),serviceDetailDTO.getCategory(),serviceDetailDTO.getAppId()))){
                            connection.commit();
                            return true;
                        }
                    }
                }
            connection.rollback();
            return false;
        }catch(Exception ex){
            ex.printStackTrace();
            connection.rollback();
            return false;
        }finally{
            connection.setAutoCommit(true);
        }
        
    }

    @Override
    public boolean update(ClientDTO dto) throws Exception {
        return clientDao.update(new Client(dto.getClientId(),dto.getClientName(),dto.getClientAddress(),dto.getClientTel(),dto.getClientEmail()));
    }
}
