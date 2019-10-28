/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.retreat.sms.entity;

/**
 *
 * @author Vidu
 */
public class ServiceDetail {
    
    private String serviceDetailId;
    private String category;
    private String appId;

    public ServiceDetail() {
    }

    public ServiceDetail(String serviceDetailId, String category, String appId) {
        this.serviceDetailId = serviceDetailId;
        this.category = category;
        this.appId = appId;
    }

    /**
     * @return the serviceDetailId
     */
    public String getServiceDetailId() {
        return serviceDetailId;
    }

    /**
     * @param serviceDetailId the serviceDetailId to set
     */
    public void setServiceDetailId(String serviceDetailId) {
        this.serviceDetailId = serviceDetailId;
    }

    /**
     * @return the category
     */
    public String getCategory() {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(String category) {
        this.category = category;
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

    @Override
    public String toString() {
        return "ServiceDetail{" + "serviceDetailId=" + serviceDetailId + ", category=" + category + ", appId=" + appId + '}';
    }
    
    
    
}
