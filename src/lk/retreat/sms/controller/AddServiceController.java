/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.retreat.sms.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.retreat.sms.business.BOFactory;
import lk.retreat.sms.business.custom.MainCategoryBO;
import lk.retreat.sms.business.custom.SubCategoryBO;
import lk.retreat.sms.dto.MainCategoryDTO;
import lk.retreat.sms.dto.SubCategoryDTO;

    


/**
 * FXML Controller class
 *
 * @author User
 */
public class AddServiceController implements Initializable {

    @FXML
    private AnchorPane addServicePane;
    @FXML
    private Label cancel;
    @FXML
    private Label addBtn;
    @FXML
    private JFXTextField price;
    
    private MainCategoryBO mainCategoryBo;
     
     private ToggleGroup group;
     
     private String type;
    private JFXComboBox<String> combo;
    @FXML
    private JFXTextField subCategoryName;
    @FXML
    private JFXTextField mainCategoryName;
    
     private SubCategoryBO subCategoryBo;
     
     

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       mainCategoryBo=(MainCategoryBO) BOFactory.getInstance().getBO(BOFactory.BOFactoryTpes.MainCategory);
       subCategoryBo=(SubCategoryBO) BOFactory.getInstance().getBO(BOFactory.BOFactoryTpes.SubCategory);
          
        // TODO
    }    

    @FXML
    private void clickToCancel(MouseEvent event) {
           try{
            Parent root=FXMLLoader.load(this.getClass().getResource("/lk/retreat/sms/view/salonServices.fxml"));
            Scene temp=new Scene(root);
            Stage stage=(Stage) this.addServicePane.getScene().getWindow();
            stage.setScene(temp);
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
   
    
    @FXML
    private void clickToAddService(MouseEvent event) {
          try {
            String main =mainCategoryName.getText();
            String sub=subCategoryName.getText();
            double p= Double.parseDouble(price.getText());
          
      
            
            
            SubCategoryDTO dto=new SubCategoryDTO(main,sub,p);
            
            boolean res=subCategoryBo.save(dto);
            
            if(res){
                Alert a=new Alert(Alert.AlertType.CONFIRMATION,"successfully saved",ButtonType.OK);
                a.show();
            }else{
                Alert a=new Alert(Alert.AlertType.CONFIRMATION,"Faileds",ButtonType.OK);
                a.show();
                
                
            }
        } catch (Exception ex) {
            Logger.getLogger(AddServiceController.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    
    }
        
    
    

    private void loadMainServices(MouseEvent event) {
        try {
            ObservableList<String> services=FXCollections.observableArrayList();
            ArrayList<MainCategoryDTO> list=mainCategoryBo.getAllServices();
            
            for(MainCategoryDTO dto:list){
                services.add(dto.getMainCategoryName());
            }
            combo.setItems(services);
        } catch (Exception ex) {
            Logger.getLogger(AddServiceController.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        }
    }
    

    

