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
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.retreat.sms.business.BOFactory;
import lk.retreat.sms.business.custom.EmployeeBO;
import lk.retreat.sms.dto.EmployeeDTO;

 
/**
 * FXML Controller class
 *
 * @author User
 */
public class EditEmployeeController implements Initializable {

    @FXML
    private AnchorPane editEmployeePane;
    @FXML
    private JFXTextField eId;
    @FXML
    private JFXTextField eName;
    @FXML
    private JFXTextField eadd;
    @FXML
    private JFXTextField eTel;
    @FXML
    private JFXTextField mail;
    @FXML
    private ImageView edit;
    
    private EmployeeBO empBo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        empBo=(EmployeeBO) BOFactory.getInstance().getBO(BOFactory.BOFactoryTpes.Employee);
        // TODO
    }    

    private void clickToCancel(MouseEvent event) {
          try {
            Parent root=FXMLLoader.load(this.getClass().getResource("/lk/retreat/sms/view/salonEmployee.fxml"));
            Scene temp=new Scene(root);
            Stage stage=(Stage) this.editEmployeePane.getScene().getWindow();
            stage.setScene(temp);
        } catch (IOException ex) {
            Logger.getLogger(SalonEmployeeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void clickToEdit(MouseEvent event) {
        
        try {
            String id=eId.getText();
            String name=eName.getText();
            String address=eadd.getText();
            int tele=Integer.parseInt(eTel.getText());
            String emil=mail.getText();
            
            EmployeeDTO dto= new EmployeeDTO(id,name,address,tele,emil);
            boolean ok=empBo.update(dto);
            
            if(ok){
                Alert a=new Alert(Alert.AlertType.INFORMATION,"Edit Successfull",ButtonType.OK);
                a.show();
            }else{
                Alert a=new Alert(Alert.AlertType.ERROR,"Edit Failed",ButtonType.OK);
                a.show();
                
            }
        } catch (Exception ex) {
            Logger.getLogger(EditEmployeeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        
        
    }
    
}
