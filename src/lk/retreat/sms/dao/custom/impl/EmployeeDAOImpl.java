/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.retreat.sms.dao.custom.impl;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import lk.retreat.sms.dao.CrudUtil;
import lk.retreat.sms.dao.custom.EmployeeDAO;
import lk.retreat.sms.entity.Employee;

/**
 *
 * @author User
 */
public class EmployeeDAOImpl implements EmployeeDAO{

    @Override
    public ArrayList<Employee> getAll()throws Exception{
         
            ResultSet rst = CrudUtil.executeQuery("select EmployeeId,EmployeeName from employee");
            ArrayList<Employee> empAll = new ArrayList<>();
            while (rst.next()) {
                Employee emp = new Employee(rst.getString(1), rst.getString(2));
                empAll.add(emp);
            }
            return empAll;
   
        
        
    }

    @Override
    public boolean delete(String ID) throws Exception{
        
            return CrudUtil.executeUpdate("Delete from Employee where EmployeeId=?", ID);
  
       
   }

    @Override
    public Employee getSearchDetails(String text) throws Exception {
        
        ResultSet rs=CrudUtil.executeQuery("Select * from employee where employeeId=?",text);
        
        if(rs.next()){
         return  new Employee(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getString(6));
        }
        return null;
   }

    @Override
    public boolean save(Employee entity) throws Exception {
        return CrudUtil.executeUpdate("insert into employee values(?,?,?,?,?,?)",entity.getEmployeeId(),entity.getEmployeeName(),entity.getEmployeeAddress(),entity.getEmployeeTel(),entity.getEmployeeEmail(),entity.getEmpFirstInDate());
        
    }

    @Override
    public boolean update(Employee employee) throws Exception{
              String sql="Update Employee set  employeeName=? , address=? ,tele=?, Email=? where employeeId=?";
        return CrudUtil.executeUpdate(employee.getEmployeeId(),employee.getEmployeeName(),employee.getEmployeeAddress(),employee.getEmployeeTel(),employee.getEmployeeEmail());
   
 }
    
}
