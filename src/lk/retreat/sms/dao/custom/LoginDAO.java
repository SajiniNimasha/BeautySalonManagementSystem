/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.retreat.sms.dao.custom;

import lk.retreat.sms.dao.CrudDAO;
import lk.retreat.sms.entity.Login;

/**
 *
 * @author User
 */
public interface LoginDAO extends CrudDAO<Login,String>{

    public Login getAll1()throws Exception;
    
}
