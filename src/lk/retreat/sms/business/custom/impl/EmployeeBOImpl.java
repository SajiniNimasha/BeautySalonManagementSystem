/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.retreat.sms.business.custom.impl;

import java.util.ArrayList;
import lk.retreat.sms.business.custom.EmployeeBO;
import lk.retreat.sms.dao.DAOFactory;
import lk.retreat.sms.dao.custom.EmployeeDAO;
import lk.retreat.sms.dto.EmployeeDTO;
import lk.retreat.sms.entity.Employee;

/**
 *
 * @author User
 */
public class EmployeeBOImpl implements EmployeeBO{
    private EmployeeDAO EmployeeDao;

    public EmployeeBOImpl() {
        EmployeeDao=(EmployeeDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.Employee);
    }
    
    
    @Override
    public ArrayList<EmployeeDTO> loadAllEmployee() throws Exception {
           ArrayList<EmployeeDTO>alEmployee=new ArrayList<>();
        
        ArrayList<Employee> allEmp=EmployeeDao.getAll();
        for (Employee emp : allEmp) {
            EmployeeDTO ed=new EmployeeDTO(emp.getEmployeeId(),emp.getEmployeeName());
            alEmployee.add(ed);
        }
        return alEmployee;
   }

    @Override
    public boolean deleteEmployee(String employeeId) throws Exception {
        return EmployeeDao.delete(employeeId);
                
 }

    @Override
    public EmployeeDTO getSearchDetails(String text) throws Exception {
        Employee e=EmployeeDao.getSearchDetails(text);
        if(e!=null){
            return new EmployeeDTO(e.getEmployeeId(),e.getEmployeeName(),e.getEmployeeAddress(),e.getEmployeeTel(),e.getEmployeeEmail(),e.getEmpFirstInDate());
        
        }
        return null;
        
  }

    @Override
    public boolean saveEmployee(EmployeeDTO dto) throws Exception {
        
        return EmployeeDao.save(new Employee(dto.getEmployeeId(),dto.getEmployeeName(),dto.getEmployeeAddress(),dto.getEmployeeTel(),dto.getEmployeeEmail(),dto.getEmpFirstInDate()));
   }

    @Override
    public boolean update(EmployeeDTO dto) throws Exception {
        return EmployeeDao.update(new Employee(dto.getEmployeeId(),dto.getEmployeeName(),dto.getEmployeeAddress(),dto.getEmployeeTel(),dto.getEmployeeEmail()));
   }
    
}
