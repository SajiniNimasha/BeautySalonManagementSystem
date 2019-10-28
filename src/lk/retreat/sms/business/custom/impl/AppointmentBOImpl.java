/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.retreat.sms.business.custom.impl;

import java.util.ArrayList;
import java.util.List;
import lk.retreat.sms.business.custom.AppointmentBO;
import lk.retreat.sms.dao.DAOFactory;
import lk.retreat.sms.dao.custom.AppointmentDAO;
import lk.retreat.sms.dto.AppointmentDTO;
import lk.retreat.sms.entity.Appointment;

/**
 *
 * @author Vidu
 */
public class AppointmentBOImpl implements AppointmentBO{
    
    private AppointmentDAO appointmentDAO;

    public AppointmentBOImpl() {
        
        appointmentDAO=(AppointmentDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.APPOINTMENT);
    }
    
    

    @Override
    public ArrayList<AppointmentDTO> loadAllAppointments() throws Exception {
        
        List<Appointment> list=appointmentDAO.getAll();
        
        ArrayList<AppointmentDTO> appList=new ArrayList<>();
        for (Appointment appointment : list) {
           
            appList.add(new AppointmentDTO(appointment.getAppId(),appointment.getDate(),appointment.getTime(),appointment.getClientId(), appointment.getEmpId(),appointment.getPaymentId(),appointment.getStatus()));
        }
        
        return appList;
    }

    @Override
    public boolean updateStatus(AppointmentDTO appointment) throws Exception {
        
        return appointmentDAO.updateStatus(new Appointment(appointment.getAppId(),appointment.getDate(),appointment.getTime(),appointment.getClientId(), appointment.getEmpId(),appointment.getPaymentId(),appointment.getStatus()));
    }

   
    
}
