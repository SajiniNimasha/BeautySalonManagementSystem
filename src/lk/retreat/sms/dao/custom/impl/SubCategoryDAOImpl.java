  /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.retreat.sms.dao.custom.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import lk.retreat.sms.dao.CrudUtil;
import lk.retreat.sms.entity.SubCategory;
import lk.retreat.sms.dao.custom.SubCategoryDAO;

/**
 *
 * @author User
 */
public class SubCategoryDAOImpl implements SubCategoryDAO{

    @Override
    public ArrayList<SubCategory> getAll() throws Exception{
        
            ResultSet rst = CrudUtil.executeQuery("select*from subCategory");
            ArrayList<SubCategory> all = new ArrayList<>();
            while (rst.next()) {
                SubCategory sc = new SubCategory(rst.getString(1),rst.getString(2),rst.getDouble(3));
                all.add(sc);
                
            }   
        return all;
    }

    @Override
    public boolean delete(String ID) throws Exception{
        return  CrudUtil.executeUpdate("Delete from subCategory where mainCategoryName=?",ID);
  }

    @Override
    public boolean save(SubCategory entity) throws Exception {
            return CrudUtil.executeUpdate("Insert into subCategory values(?,?,?)",entity.getMainCategoryName(),entity.getSubCategoryName(),entity.getSubCategoryPrice());
  }

    @Override
    public boolean update(SubCategory entity) throws Exception {
        String sql="Update subCategory set  subCategoryName=? ,subCategoryPrice=? where mainCategoryName=?";
        return CrudUtil.executeUpdate(sql,entity.getMainCategoryName(),entity.getSubCategoryName(),entity.getSubCategoryPrice());
   }
    
}
