/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.retreat.sms.controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.retreat.sms.business.BOFactory;
import lk.retreat.sms.business.custom.LoginBO;
import lk.retreat.sms.dto.LoginDTO;
import lk.retreat.sms.main.Main;

/**
 * FXML Controller class
 *
 * @author User
 */
public class LoginController  {

    @FXML
    private AnchorPane loginPane;
    @FXML
    private JFXTextField name;
    @FXML
    private JFXPasswordField password;
    @FXML
    private Button log;
     private  LoginBO loginBo;

    public LoginController() {
        loginBo=(LoginBO) BOFactory.getInstance().getBO(BOFactory.BOFactoryTpes.LOGIN);
        
    }
     


    

    @FXML
    void clickLogin() {
        String userName=name.getText();
        String pass=password.getText();
        
        try {
            
            LoginDTO dto=loginBo.getLogin();
            if(userName.equals(dto.getUserName())&& pass.equals(dto.getPassword())){
            Parent root=FXMLLoader.load(this.getClass().getResource("/lk/retreat/sms/view/salonDashboard.fxml"));
            Scene temp=new Scene(root);
            Stage stage=(Stage) this.loginPane.getScene().getWindow();
            stage.setScene(temp);
            stage.centerOnScreen();
            stage.show();
            Main.getLoginStage().close();
            
             
            }else{
                Alert a=new Alert(Alert.AlertType.INFORMATION);
                a.setContentText("Wrong User Name Or PassWord");
                a.show();
                
                name.clear();
                password. clear();
     
            }
        } catch (Exception ex) {
            ex.printStackTrace();
       }
      
        
    }

    @FXML
    void clickOnName(ActionEvent event) {
        password.requestFocus();
        
        
    }

    @FXML
     void clickOnPassword(ActionEvent event) {
         clickLogin();
    }

  
    
}
