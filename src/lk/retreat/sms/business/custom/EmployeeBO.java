/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.retreat.sms.business.custom;

import java.util.ArrayList;
import lk.retreat.sms.business.SuperBO;
import lk.retreat.sms.dto.EmployeeDTO;

/**
 *
 * @author User
 */
public interface EmployeeBO extends SuperBO{

    public  EmployeeDTO getSearchDetails(String text)throws Exception;
    
    public ArrayList<EmployeeDTO>loadAllEmployee() throws Exception;

    public boolean deleteEmployee(String employeeId)throws Exception;

    public boolean saveEmployee(EmployeeDTO dto) throws Exception;

    public boolean update(EmployeeDTO dto)throws Exception;
    
}
