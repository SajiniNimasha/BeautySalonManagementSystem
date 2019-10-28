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
import lk.retreat.sms.business.custom.ClientBO;
import lk.retreat.sms.dto.ClientDTO;

/**
 * FXML Controller class
 *
 * @author User
 */
public class EditClientController implements Initializable {

    @FXML
    private AnchorPane editClientPane;
    @FXML
    private ImageView editBtn;
    @FXML
    private JFXTextField id;
    @FXML
    private JFXTextField name;
    @FXML
    private JFXTextField address;
    @FXML
    private JFXTextField tel;
    @FXML
    private JFXTextField mail;
    
    private ClientBO clientBo;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        clientBo=(ClientBO) BOFactory.getInstance().getBO(BOFactory.BOFactoryTpes.Client);
        // TODO
    }    

    private void clickOnCancel(MouseEvent event) {
        try {
            Parent root=FXMLLoader.load(this.getClass().getResource("/lk/retreat/sms/view/salonClient.fxml"));
            Scene temp=new Scene(root);
            Stage stage=(Stage) editClientPane.getScene().getWindow();
            stage.setScene(temp);
        } catch (IOException ex) {
            Logger.getLogger(EditClientController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void clickToEdit(MouseEvent event) {
        
        try {
            String clientId=id.getText();
            String clientName=name.getText();
            String clientAddress=address.getText();
            int tele=Integer.parseInt(tel.getText());
            String email=mail.getText();
            ClientDTO dto=new ClientDTO(clientId,clientName,clientAddress,tele,email);
            boolean isUpdate=clientBo.update(dto);
            
            if(isUpdate){
                Alert a=new Alert(Alert.AlertType.INFORMATION,"Edit Successfull",ButtonType.OK);
                a.show();
            }else{
                Alert a=new Alert(Alert.AlertType.ERROR,"Edit Failed",ButtonType.OK);
                a.show();
                
            }
        } catch (Exception ex) {
            Logger.getLogger(EditClientController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
    }
    
}
