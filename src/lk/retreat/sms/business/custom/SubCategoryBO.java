/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.retreat.sms.business.custom;

import java.util.ArrayList;
import lk.retreat.sms.business.SuperBO;
import lk.retreat.sms.dto.SubCategoryDTO;

/**
 *
 * @author User
 */
public interface SubCategoryBO extends SuperBO{

    public ArrayList<SubCategoryDTO> loadAllServices()throws Exception;

    public boolean save(SubCategoryDTO dto)throws Exception;

    public boolean update(SubCategoryDTO dto)throws Exception;

    public boolean delete(String mainCategoryName)throws Exception;

  
 
}
