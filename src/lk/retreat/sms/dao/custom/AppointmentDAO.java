/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.retreat.sms.dao.custom;

import java.sql.Connection;
import lk.retreat.sms.dao.CrudDAO;
import lk.retreat.sms.entity.Appointment;

/**
 *
 * @author Vidu
 */
public interface AppointmentDAO extends CrudDAO<Appointment,String> {
    
    public boolean updateStatus(Appointment appointment)throws Exception;
   
}
