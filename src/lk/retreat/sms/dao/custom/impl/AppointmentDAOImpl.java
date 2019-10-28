/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.retreat.sms.dao.custom.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import lk.retreat.sms.dao.CrudUtil;
import lk.retreat.sms.dao.custom.AppointmentDAO;
import lk.retreat.sms.entity.Appointment;

/**
 *
 * @author Vidu
 */
public class AppointmentDAOImpl implements AppointmentDAO{

    
    @Override
    public ArrayList<Appointment> getAll() throws Exception {
        
        ResultSet rst = CrudUtil.executeQuery("select * from appointment");
            ArrayList<Appointment> appAll = new ArrayList<>();
            while (rst.next()) {
                Appointment app = new Appointment(rst.getString(1), rst.getString(2),rst.getString(3),rst.getString(4),rst.getString(5),rst.getString(6),rst.getString(7));
                appAll.add(app);
            }
            return appAll;
    }

    @Override
    public boolean delete(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean save(Appointment entity) throws Exception {
        System.out.println("appointment: "+entity.getAppId());
        return CrudUtil.executeUpdate("insert into appointment values(?,?,?,?,?,?,?);",entity.getAppId(),entity.getDate(),entity.getTime(),entity.getClientId(),entity.getEmpId(),entity.getPaymentId(),entity.getStatus());
    }

    @Override
    public boolean updateStatus(Appointment appointment) throws Exception {
        
        if(CrudUtil.executeUpdate("update appointment set date=?,time=?,clientId=?,employeeId=?,paymentId=?,status=? where appointmentId=?", appointment.getDate(),appointment.getTime(),appointment.getClientId(),appointment.getEmpId(),appointment.getPaymentId(),appointment.getStatus(),appointment.getAppId())){
            return true;
        }
        return false;
    }

    @Override
    public boolean update(Appointment entity) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}