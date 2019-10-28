/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.retreat.sms.business;

import lk.retreat.sms.business.custom.impl.AppointmentBOImpl;
import lk.retreat.sms.business.custom.impl.ClientBOImpl;
import lk.retreat.sms.business.custom.impl.EmployeeBOImpl;
import lk.retreat.sms.business.custom.impl.LoginBOImpl;
import lk.retreat.sms.business.custom.impl.PaymentBOImpl;
import lk.retreat.sms.business.custom.impl.ServiceDetailBOImpl;
import lk.retreat.sms.business.custom.impl.SubCategoryBOImpl;

/**
 *
 * @author User
 */
public class BOFactory {
    public enum BOFactoryTpes{
        Client,Employee,SubCategory,MainCategory,APPOINTMENT,SERVICE_DETAIL,PAYMENT,LOGIN;
        
    }
    private static BOFactory bOFactory;
    
    private BOFactory(){
    
    }
    
    public static BOFactory getInstance(){
        if(bOFactory == null){
            bOFactory=new BOFactory();
        }
        return bOFactory;
    }
    
    public SuperBO getBO(BOFactoryTpes boTypes){
        switch(boTypes){
            case Client:
                return new ClientBOImpl();
            case Employee:
                return new EmployeeBOImpl(); 
            case SubCategory:
                return new SubCategoryBOImpl();
            case APPOINTMENT:
                return new AppointmentBOImpl();
            case SERVICE_DETAIL:
                return new ServiceDetailBOImpl();
            case PAYMENT:
                return new PaymentBOImpl();
                case LOGIN:
                    return new LoginBOImpl();
            default:
                return null;
        }
    }
    
}
