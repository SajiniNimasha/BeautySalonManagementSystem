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
public class MainCategoryDTO {
    private  String mainCategoryId;
    private String mainCategoryName;

    public MainCategoryDTO() {
    }

    public MainCategoryDTO(String mainCategoryName) {
        
        this.mainCategoryName = mainCategoryName;
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

    @Override
    public String toString() {
        return "MainCategoryDTO{" + "mainCategoryId=" + mainCategoryId + ", mainCategoryName=" + mainCategoryName + '}';
    }
  
    
    
    
    
}
