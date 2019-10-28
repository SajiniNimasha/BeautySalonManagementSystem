/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.retreat.sms.business.custom.impl;

import lk.retreat.sms.business.custom.LoginBO;
import lk.retreat.sms.dao.DAOFactory;
import lk.retreat.sms.dao.custom.LoginDAO;
import lk.retreat.sms.dto.LoginDTO;
import lk.retreat.sms.entity.Login;

/**
 *
 * @author User
 */
public class LoginBOImpl implements LoginBO{
    
    private LoginDAO loginDAO;
    
       public LoginBOImpl(){
        loginDAO= (LoginDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.LOGIN);

    }

    @Override
    public LoginDTO getLogin() throws Exception {
        Login login=loginDAO.getAll1();
        return new LoginDTO(login.getUserName(),login.getPassword()); }
    
}
