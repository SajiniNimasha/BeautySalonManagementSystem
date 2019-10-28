/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.retreat.sms.dto;

/**
 *
 * @author User
 */
public class ClientDTO {
    private String clientId;
    private String clientName;
    private String clientAddress;
    private int clientTel;
    private String clientEmail;
    private String  firstInDate;

    public ClientDTO() {
    }

    public ClientDTO(String clientId, String clientName, String clientAddress, int clientTel, String clientEmail, String firstInDate) {
        this.clientId = clientId;
        this.clientName = clientName;
        this.clientAddress = clientAddress;
        this.clientTel = clientTel;
        this.clientEmail = clientEmail;
        this.firstInDate = firstInDate;
    }

    public ClientDTO(String clientId, String clientName, String clientAddress, int tele, String email) {
         this.clientId = clientId;
        this.clientName = clientName;
        this.clientAddress = clientAddress;
        this.clientTel = tele;
        this.clientEmail = email;
        
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
     * @return the clientEmail
     */
    public String getClientEmail() {
        return clientEmail;
    }

    /**
     * @param clientEmail the clientEmail to set
     */
    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
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
        return "ClientDTO{" + "clientId=" + clientId + ", clientName=" + clientName + ", clientAddress=" + clientAddress + ", clientTel=" + clientTel + ", clientEmail=" + clientEmail + ", firstInDate=" + firstInDate + '}';
    }

    
    
    
    
    
}
