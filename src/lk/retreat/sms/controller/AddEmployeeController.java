/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.retreat.sms.controller;

import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import com.sun.deploy.uitoolkit.ToolkitStore;
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
public class AddEmployeeController implements Initializable {

    @FXML
    private AnchorPane addEmployeePane;
    @FXML
    private Label cancel;
    @FXML
    private JFXTextField empId;
    @FXML
    private JFXTextField empName;
    @FXML
    private JFXTextField address;
    @FXML
    private JFXTextField tel;
    @FXML
    private JFXTextField mail;
    @FXML
    private JFXTextField date;
    @FXML
    private Label addBtn;
    
    private EmployeeBO EmpBo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        EmpBo=(EmployeeBO) BOFactory.getInstance().getBO(BOFactory.BOFactoryTpes.Employee);
    }    

    @FXML
    private void clickOnCancel(MouseEvent event) {
       
        
    }

    @FXML
    private void clickToAdd(MouseEvent event) {
        
        try {
            String id= empId.getText();
            String name=empName.getText();
            String add= address.getText();
            int tele = Integer.parseInt(tel.getText());
            String email= mail.getText();
            String firstInDate= date.getText();
            
            EmployeeDTO dto=new EmployeeDTO(id,name,add,tele,email,firstInDate);
            
            boolean res=EmpBo.saveEmployee(dto);
            
            if(res){
                Alert a=new Alert(Alert.AlertType.CONFIRMATION,"Employee has been successfully saved",ButtonType.OK);
                a.show();
            }else{
                Alert a=new Alert(Alert.AlertType.CONFIRMATION,"Failed to save the Employee",ButtonType.OK);
                a.show();
                
                
            }
            
            
        } catch (Exception ex) {
            Logger.getLogger(AddEmployeeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
