/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.retreat.sms.business.custom;

import java.util.ArrayList;
import lk.retreat.sms.business.SuperBO;
import lk.retreat.sms.dto.AppointmentDTO;
import lk.retreat.sms.dto.ClientDTO;
import lk.retreat.sms.dto.PaymentDTO;
import lk.retreat.sms.dto.ServiceDetailDTO;

/**
 *
 * @author User
 */
public interface ClientBO extends SuperBO{
    
    public ArrayList<ClientDTO>loadAllClient() throws Exception;

    public boolean deleteClient(String clientId) throws Exception;

    public ClientDTO getSearchDetail(String text)throws Exception;
    
    public boolean saveClient(ClientDTO clientDTO)throws Exception;
    
    public boolean saveWithNewClient(ClientDTO clientDTO,AppointmentDTO appointmentDTO,PaymentDTO paymentDTO,ServiceDetailDTO serviceDetailDTO)throws Exception;
    
    public boolean saveWithRegClient(AppointmentDTO appointmentDTO,PaymentDTO paymentDTO,ServiceDetailDTO serviceDetailDTO)throws Exception;

    public boolean update(ClientDTO dto)throws Exception;
    
    
}
