/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.retreat.sms.business.custom;

import lk.retreat.sms.business.SuperBO;
import lk.retreat.sms.dto.LoginDTO;

/**
 *
 * @author User
 */
public interface LoginBO extends SuperBO{

    public LoginDTO getLogin()throws Exception;
    
}
