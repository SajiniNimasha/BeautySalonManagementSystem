/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.retreat.sms.business.custom.impl;

import java.util.ArrayList;
import lk.retreat.sms.business.custom.SubCategoryBO;
import lk.retreat.sms.dao.DAOFactory;
import lk.retreat.sms.dto.SubCategoryDTO;
import lk.retreat.sms.entity.SubCategory;
import lk.retreat.sms.dao.custom.SubCategoryDAO;

/**
 *
 * @author User
 */
public class SubCategoryBOImpl implements SubCategoryBO{
    private SubCategoryDAO subCategoryDao;

    public SubCategoryBOImpl() {
        subCategoryDao=(SubCategoryDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.SubCategory);
    }
    
    

    @Override
    public ArrayList<SubCategoryDTO>loadAllServices() throws Exception{
        
        ArrayList<SubCategoryDTO> dto=new ArrayList<>();
        
        ArrayList<SubCategory> tm =subCategoryDao.getAll();
       
        
 
        for(SubCategory t: tm){
            SubCategoryDTO acd=new SubCategoryDTO(t.getMainCategoryName(),t.getSubCategoryName(),t.getSubCategoryPrice());
             dto.add(acd);
        }
        return dto;
        
        
   }

    @Override
    public boolean save(SubCategoryDTO dto) throws Exception {
              return subCategoryDao.save(new SubCategory(dto.getMainCategoryName(),dto.getSubCategoryName(),dto.getSubCategoryPrice()));
   }

    @Override
    public boolean update(SubCategoryDTO dto) throws Exception {
         return subCategoryDao.update(new SubCategory(dto.getMainCategoryName(),dto.getSubCategoryName(),dto.getSubCategoryPrice()));
    }

    @Override
    public boolean delete(String mainCategoryName) throws Exception{
        return subCategoryDao.delete(mainCategoryName);
    }
    
    
}
