/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.retreat.sms.view.util.tblmodel;

/**
 *
 * @author User
 */
public class MainCategoryTM {
    
    private String  mainCategoryName;

    public MainCategoryTM() {
    }

    public MainCategoryTM(String mainCategoryName) {
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
        return "MainCategoryTM{" + "mainCategoryName=" + mainCategoryName + '}';
    }
    
    
    
}
