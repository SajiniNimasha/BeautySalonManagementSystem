/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.retreat.sms.dao;

import lk.retreat.sms.dao.custom.impl.AppointmentDAOImpl;
import lk.retreat.sms.dao.custom.impl.ClientDAOImpl;
import lk.retreat.sms.dao.custom.impl.EmployeeDAOImpl;
import lk.retreat.sms.dao.custom.impl.LoginDAOImpl;
import lk.retreat.sms.dao.custom.impl.PaymentDAOImpl;
import lk.retreat.sms.dao.custom.impl.ServiceDetailDAOImpl;
import lk.retreat.sms.dao.custom.impl.SubCategoryDAOImpl;

/**
 *
 * @author User
 */
public class DAOFactory {

 public enum DAOTypes{
        Client,Employee,SubCategory,MainCategory,QUERY,APPOINTMENT,SERVICE_DETAIL,PAYMENT,LOGIN;
    }
    
    private static DAOFactory dAOFactory;
    
    private DAOFactory(){
        
    }
    
    public static DAOFactory getInstance(){
        if (dAOFactory == null){
            dAOFactory = new DAOFactory();
        }
        return dAOFactory;
    }
    
    public SuperDAO getDAO(DAOTypes daoType){
        switch(daoType){
            case Client:
                return new ClientDAOImpl();
            case Employee:
                return new EmployeeDAOImpl();  
            case SubCategory:
                return  new SubCategoryDAOImpl();
            case APPOINTMENT:
                return new AppointmentDAOImpl();
            case SERVICE_DETAIL:
                return new ServiceDetailDAOImpl();
            case PAYMENT:
                return new PaymentDAOImpl();
                case LOGIN:
                    return  new LoginDAOImpl();
            default:
                return null;
        }
        
    }    
}
