/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.retreat.sms.view.util.tblmodel;

/**
 *
 * @author Vidu
 */

//appointement table model

public class AppointmentTM {
    
//    attributes for appointement table
    
    private String appId;
    private String time;
    private String date;
    private String empName;
    private String clientId;
    private String service;
    private String status;
    
//    generated get set methods

    public AppointmentTM() {
    }

    public AppointmentTM(String appId, String time, String date, String empName, String clientId, String service, String status) {
        this.appId = appId;
        this.time = time;
        this.date = date;
        this.empName = empName;
        this.clientId = clientId;
        this.service = service;
        this.status = status;
    }

    /**
     * @return the appId
     */
    public String getAppId() {
        return appId;
    }

    /**
     * @param appId the appId to set
     */
    public void setAppId(String appId) {
        this.appId = appId;
    }

    /**
     * @return the time
     */
    public String getTime() {
        return time;
    }

    /**
     * @param time the time to set
     */
    public void setTime(String time) {
        this.time = time;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * @return the empName
     */
    public String getEmpName() {
        return empName;
    }

    /**
     * @param empName the empName to set
     */
    public void setEmpName(String empName) {
        this.empName = empName;
    }

    /**
     * @return the clientId
     */
    public String getClientId() {
        return clientId;
    }

    /**
     * @param clientId the clientId to set
     */
    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    /**
     * @return the service
     */
    public String getService() {
        return service;
    }

    /**
     * @param service the service to set
     */
    public void setService(String service) {
        this.service = service;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "AppointmentTM{" + "appId=" + appId + ", time=" + time + ", date=" + date + ", empName=" + empName + ", clientId=" + clientId + ", service=" + service + ", status=" + status + '}';
    }

    
    
}
