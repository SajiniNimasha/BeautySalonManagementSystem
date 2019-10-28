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
public class SubCategoryDTO {
   
    private String mainCategoryName;
   
    private String subCategoryName;
    private double subCategoryPrice;
 

    public SubCategoryDTO() {
    }

  

    public SubCategoryDTO(String mainCategoryName, String subCategoryName, double subCategoryPrice) {
    
        this.mainCategoryName = mainCategoryName;
    
        this.subCategoryName = subCategoryName;
        this.subCategoryPrice = subCategoryPrice;
       
   }



   

    /**
     * @return the mainCategoryName
     */
    public String getMainCategoryName() {
        return mainCategoryName;
    }

    /**
     * @param mainCategoryName the mainCategoryName to set
     */
    public void setMainCategoryName(String mainCategoryName) {
        this.mainCategoryName = mainCategoryName;
    }

  

    /**
     * @return the subCategoryName
     */
    public String getSubCategoryName() {
        return subCategoryName;
    }

    /**
     * @param subCategoryName the subCategoryName to set
     */
    public void setSubCategoryName(String subCategoryName) {
        this.subCategoryName = subCategoryName;
    }

    /**
     * @return the subCategoryPrice
     */
    public double getSubCategoryPrice() {
        return subCategoryPrice;
    }

    /**
     * @param subCategoryPrice the subCategoryPrice to set
     */
    public void setSubCategoryPrice(double subCategoryPrice) {
        this.subCategoryPrice = subCategoryPrice;
    }

    @Override
    public String toString() {
        return "SubCategoryDTO{" + "mainCategoryName=" + mainCategoryName + ", subCategoryName=" + subCategoryName + ", subCategoryPrice=" + subCategoryPrice + '}';
    }

 


    
 
    
    
    
    
    
}
