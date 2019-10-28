/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.retreat.sms.entity;

/**
 *
 * @author User
 */
public class Employee {
    private String EmployeeId;
    private String EmployeeName;
    private String EmployeeAddress;
    private int EmployeeTel;
    private String EmployeeEmail;
  
    private String EmpFirstInDate;

    public Employee() {
    }

    public Employee(String EmployeeId, String EmployeeName, String EmployeeAddress, int EmployeeTel, String EmployeeEmail, String EmpFirstInDate) {
        this.EmployeeId = EmployeeId;
        this.EmployeeName = EmployeeName;
        this.EmployeeAddress = EmployeeAddress;
        this.EmployeeTel = EmployeeTel;
        this.EmployeeEmail = EmployeeEmail;
       
        this.EmpFirstInDate = EmpFirstInDate;
    }

    public Employee(String EmployeeId, String EmployeeName) {
        this.EmployeeId = EmployeeId;
        this.EmployeeName = EmployeeName;
          
   }

    public Employee(String employeeId, String employeeName, String employeeAddress, int employeeTel, String employeeEmail) {
   this.EmployeeId = employeeId;
        this.EmployeeName = employeeName;
        
        this.EmployeeAddress = employeeAddress;
        this.EmployeeTel = employeeTel;
        this.EmployeeEmail = employeeEmail;}

    /**
     * @return the EmployeeId
     */
    public String getEmployeeId() {
        return EmployeeId;
    }

    /**
     * @param EmployeeId the EmployeeId to set
     */
    public void setEmployeeId(String EmployeeId) {
        this.EmployeeId = EmployeeId;
    }

    /**
     * @return the EmployeeName
     */
    public String getEmployeeName() {
        return EmployeeName;
    }

    /**
     * @param EmployeeName the EmployeeName to set
     */
    public void setEmployeeName(String EmployeeName) {
        this.EmployeeName = EmployeeName;
    }

    /**
     * @return the EmployeeAddress
     */
    public String getEmployeeAddress() {
        return EmployeeAddress;
    }

    /**
     * @param EmployeeAddress the EmployeeAddress to set
     */
    public void setEmployeeAddress(String EmployeeAddress) {
        this.EmployeeAddress = EmployeeAddress;
    }

    /**
     * @return the EmployeeTel
     */
    public int getEmployeeTel() {
        return EmployeeTel;
    }

    /**
     * @param EmployeeTel the EmployeeTel to set
     */
    public void setEmployeeTel(int EmployeeTel) {
        this.EmployeeTel = EmployeeTel;
    }

    /**
     * @return the EmployeeEmail
     */
    public String getEmployeeEmail() {
        return EmployeeEmail;
    }

    /**
     * @param EmployeeEmail the EmployeeEmail to set
     */
    public void setEmployeeEmail(String EmployeeEmail) {
        this.EmployeeEmail = EmployeeEmail;
    }



    /**
     * @return the EmpFirstInDate
     */
    public String getEmpFirstInDate() {
        return EmpFirstInDate;
    }

    /**
     * @param EmpFirstInDate the EmpFirstInDate to set
     */
    public void setEmpFirstInDate(String EmpFirstInDate) {
        this.EmpFirstInDate = EmpFirstInDate;
    }

    @Override
    public String toString() {
        return "Employee{" + "EmployeeId=" + EmployeeId + ", EmployeeName=" + EmployeeName + ", EmployeeAddress=" + EmployeeAddress + ", EmployeeTel=" + EmployeeTel + ", EmployeeEmail=" + EmployeeEmail + ", EmpFirstInDate=" + EmpFirstInDate + '}';
    }

 
    
    
    
}
