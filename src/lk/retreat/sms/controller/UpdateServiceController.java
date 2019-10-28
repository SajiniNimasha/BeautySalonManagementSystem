/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.retreat.sms.controller;

import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.retreat.sms.business.BOFactory;
import lk.retreat.sms.business.custom.SubCategoryBO;
import lk.retreat.sms.dto.SubCategoryDTO;

/**
 * FXML Controller class
 *
 * @author User
 */
public class UpdateServiceController implements Initializable {

    @FXML
    private AnchorPane editServicePane;
    @FXML
    private JFXTextField price;
    @FXML
    private ImageView edit;
    @FXML
    private JFXTextField service;
    @FXML
    private JFXTextField category;
    
    private SubCategoryBO subBo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        subBo=(SubCategoryBO) BOFactory.getInstance().getBO(BOFactory.BOFactoryTpes.SubCategory);
        
        // TODO
    }    

    private void clickCancel(MouseEvent event) {
           try{
            Parent root=FXMLLoader.load(this.getClass().getResource("/lk/retreat/sms/view/salonServices.fxml"));
            Scene temp=new Scene(root);
            Stage stage=(Stage) this.editServicePane.getScene().getWindow();
            stage.setScene(temp);
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void clickToEdit(MouseEvent event) {
        try {
            String main=category.getText();
            String sub=service.getText();
            double p=Double.parseDouble(price.getText());
            SubCategoryDTO dto=new SubCategoryDTO(main,sub,p);
            
            boolean ok=subBo.update(dto);
            if(ok){
                Alert a=new Alert(Alert.AlertType.INFORMATION,"Edit Successfull",ButtonType.OK);
                a.show();
            }else{
                Alert a=new Alert(Alert.AlertType.ERROR,"Edit Failed",ButtonType.OK);
                a.show();
                
            }
        } catch (Exception ex) {
            Logger.getLogger(UpdateServiceController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
}
