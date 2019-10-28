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
public class MainCategory {
    
    private String mainCategoryName;

    public MainCategory(String mainCategoryName) {
        this.mainCategoryName = mainCategoryName;
    }

    public MainCategory() {
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
        return "MainCategory{" + "mainCategoryName=" + mainCategoryName + '}';
    }
    
    
    
    
    
    
}
