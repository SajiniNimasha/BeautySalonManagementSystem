/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.retreat.sms.business.custom.impl;

import java.util.ArrayList;
import lk.retreat.sms.business.custom.MainCategoryBO;
import lk.retreat.sms.dao.DAOFactory;
import lk.retreat.sms.dao.custom.MainCategoryDAO;
import lk.retreat.sms.dto.MainCategoryDTO;

/**
 *
 * @author User
 */
public class MainCategoryBOImpl implements MainCategoryBO{
        private MainCategoryDAO mainCategoryDao;

    public MainCategoryBOImpl(){
        mainCategoryDao=(MainCategoryDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.MainCategory);
       }
    @Override
    public ArrayList<MainCategoryDTO> getAllServices() throws Exception {
            return null;
      
   }
   }
    
    

    

