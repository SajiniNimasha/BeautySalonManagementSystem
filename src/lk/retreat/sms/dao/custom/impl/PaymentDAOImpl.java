/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.retreat.sms.dao.custom.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import lk.retreat.sms.dao.CrudUtil;
import lk.retreat.sms.dao.custom.PaymentDAO;
import lk.retreat.sms.entity.Payment;

/**
 *
 * @author Vidu
 */
public class PaymentDAOImpl implements PaymentDAO{

    @Override
    public ArrayList<Payment> getAll() throws Exception {
        
        ResultSet rst = CrudUtil.executeQuery("select * from payment");
            ArrayList<Payment> appAll = new ArrayList<>();
            while (rst.next()) {
                Payment pay = new Payment(rst.getString(1), rst.getDouble(2));
                appAll.add(pay);
            }
            return appAll;
    }

    @Override
    public boolean delete(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean save(Payment entity) throws Exception {
        System.out.println("payment: "+entity.getPaymentId());
        return CrudUtil.executeUpdate("insert into payment values(?,?)",entity.getPaymentId(),entity.getPrice());
    }

    @Override
    public boolean update(Payment entity) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
