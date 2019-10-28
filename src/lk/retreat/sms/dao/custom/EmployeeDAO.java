/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.retreat.sms.dao.custom;

import lk.retreat.sms.dao.CrudDAO;
import lk.retreat.sms.entity.Employee;

/**
 *
 * @author User
 */
public interface EmployeeDAO extends CrudDAO<Employee,String>{

    public Employee getSearchDetails(String text)throws Exception;

    

 
    
}
