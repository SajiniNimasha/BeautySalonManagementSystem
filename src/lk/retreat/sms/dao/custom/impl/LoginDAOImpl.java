/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.retreat.sms.dao.custom.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import lk.retreat.sms.dao.CrudUtil;
import lk.retreat.sms.dao.custom.LoginDAO;
import lk.retreat.sms.entity.Login;

/**
 *
 * @author User
 */
public class LoginDAOImpl implements LoginDAO{

    @Override
    public Login getAll1() throws Exception {
      ResultSet rst= CrudUtil.executeQuery("select * from login");
        while (rst.next()){
            return new Login(rst.getString(1), rst.getString(2));
        }
        return null; }

    @Override
    public ArrayList<Login> getAll() throws Exception {
        return null;
    }

    @Override
    public boolean delete(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean save(Login entity) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Login entity) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
