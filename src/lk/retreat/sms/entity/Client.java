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
public class Client {
    private String clientId;
    private String clientName;
    private String  clientAddress;
    private int clientTel;
    private String clientEmaill;
    private String firstInDate;

    public Client() {
    }

    public Client(String clientId, String clientName, String clientAddress, int clientTel, String clientEmaill, String firstInDate) {
        this.clientId = clientId;
        this.clientName = clientName;
        this.clientAddress = clientAddress;
        this.clientTel = clientTel;
        this.clientEmaill = clientEmaill;
        this.firstInDate = firstInDate;
    }

    public Client(String clientId,String clientName) {
        this.clientId = clientId;
        this.clientName = clientName;
        
   }

    public Client(String clientId, String clientName, String clientAddress, int clientTel, String clientEmaill) {
         this.clientId = clientId;
        this.clientName = clientName;
        this.clientAddress = clientAddress;
        this.clientTel = clientTel;
        this.clientEmaill = clientEmaill;
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
     * @return the clientName
     */
    public String getClientName() {
        return clientName;
    }

    /**
     * @param clientName the clientName to set
     */
    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    /**
     * @return the clientAddress
     */
    public String getClientAddress() {
        return clientAddress;
    }

    /**
     * @param clientAddress the clientAddress to set
     */
    public void setClientAddress(String clientAddress) {
        this.clientAddress = clientAddress;
    }

    /**
     * @return the clientTel
     */
    public int getClientTel() {
        return clientTel;
    }

    /**
     * @param clientTel the clientTel to set
     */
    public void setClientTel(int clientTel) {
        this.clientTel = clientTel;
    }

    /**
     * @return the clientEmaill
     */
    public String getClientEmaill() {
        return clientEmaill;
    }

    /**
     * @param clientEmaill the clientEmaill to set
     */
    public void setClientEmaill(String clientEmaill) {
        this.clientEmaill = clientEmaill;
    }

    /**
     * @return the firstInDate
     */
    public String getFirstInDate() {
        return firstInDate;
    }

    /**
     * @param firstInDate the firstInDate to set
     */
    public void setFirstInDate(String firstInDate) {
        this.firstInDate = firstInDate;
    }

    @Override
    public String toString() {
        return "Client{" + "clientId=" + clientId + ", clientName=" + clientName + ", clientAddress=" + clientAddress + ", clientTel=" + clientTel + ", clientEmaill=" + clientEmaill + ", firstInDate=" + firstInDate + '}';
    }
    
    
    
}
