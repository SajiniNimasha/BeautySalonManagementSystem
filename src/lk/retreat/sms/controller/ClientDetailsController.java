/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.retreat.sms.controller;

import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author User
 */
public class ClientDetailsController implements Initializable {

    @FXML
    private AnchorPane clientDetailPane;
    @FXML
    private JFXTextField clientid;
    @FXML
    private JFXTextField cientnametext;
    @FXML
    private JFXTextField addresstext;
    @FXML
    private JFXTextField contactnotext;
    @FXML
    private JFXTextField emailtext;
    @FXML
    private JFXTextField firstindatetext;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        
    }    
    
}
