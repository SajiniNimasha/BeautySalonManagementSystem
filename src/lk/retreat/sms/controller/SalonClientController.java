/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.retreat.sms.controller;

import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import lk.retreat.sms.business.BOFactory;
import lk.retreat.sms.business.custom.AppointmentBO;
import lk.retreat.sms.business.custom.ClientBO;
import lk.retreat.sms.business.custom.EmployeeBO;
import lk.retreat.sms.business.custom.PaymentBO;
import lk.retreat.sms.business.custom.ServiceDetailBO;
import lk.retreat.sms.business.custom.SubCategoryBO;
import lk.retreat.sms.dto.AppointmentDTO;
import lk.retreat.sms.dto.ClientDTO;
import lk.retreat.sms.view.util.tblmodel.ClientTM;




/**
 * FXML Controller class
 *
 * @author User
 */
public class SalonClientController implements Initializable {

    @FXML
    private AnchorPane clientPane;
    @FXML
    private Label cancelLbl;
    @FXML
    private Button appointment;
    @FXML
    private Button clientDetail;
    @FXML
    private AnchorPane clientSubPane;
    @FXML
    private Label editClientInformation;
    @FXML
    private TableView<ClientTM> clientDetailTable;
    
       private ClientBO clientBo;
    @FXML
    private Label deleteBtn;
    @FXML
    private TextField searchText;
    @FXML
    private Button searchbutton;
    @FXML
    private Pane firstpane;
    @FXML
    private JFXTextField clientid2;
    @FXML
    private JFXTextField cientnametext2;
    @FXML
    private JFXTextField addresstext2;
    @FXML
    private JFXTextField contactnotext2;
    @FXML
    private JFXTextField emailtext2;
    @FXML
    private JFXTextField firstindatetext2;
    @FXML
    private Pane secondpane;
    @FXML
    private TextField onlyIdTxt;
    
    private AppointmentBO appBo;
    private EmployeeBO employeeBO; 
    private AppointmentBO appointmentBO;
    private SubCategoryBO subCategoryBO;
    private ClientBO clientBO;
    private ServiceDetailBO serviceDetailBO;
    private PaymentBO paymentBO;
    @FXML
    private JFXTextField appid;
    @FXML
    private JFXTextField date;
    @FXML
    private JFXTextField time;
    @FXML
    private JFXTextField service;
    @FXML
    private JFXTextField emp;
    @FXML
    private JFXTextField status;

    
   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        clientBo=(ClientBO) BOFactory.getInstance().getBO(BOFactory.BOFactoryTpes.Client);
        appBo=(AppointmentBO) BOFactory.getInstance().getBO(BOFactory.BOFactoryTpes.APPOINTMENT);
        
        clientDetailTable.getColumns().get(0).setStyle("-fx-alignment:center");
        clientDetailTable.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("clientId"));
        clientDetailTable.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("clientName"));
       
        loadAllClients();
        
      
       
        
        
        
        
        
       
    }    

    @FXML
    private void clickOnCancelLbl(MouseEvent event) {
          try {
            Parent root=FXMLLoader.load(this.getClass().getResource("/lk/retreat/sms/view/salonDashboard.fxml"));
            Scene temp=new Scene(root);
            Stage stage=(Stage) this.clientPane.getScene().getWindow();
            stage.setScene(temp);
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void loadAppointment(MouseEvent event) {
        try {
            AnchorPane clientAppointmentPane = FXMLLoader.load(this.getClass().getResource("/lk/retreat/sms/view/clientAppointments.fxml"));
            this.clientSubPane.getChildren().add(clientAppointmentPane);
        } catch (IOException ex) {
            Logger.getLogger(SalonClientController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void loadClientDetail(MouseEvent event) {
        try {
            AnchorPane clientDetailPane = FXMLLoader.load(this.getClass().getResource("/lk/retreat/sms/view/clientDetails.fxml"));
            this.clientSubPane.getChildren().add(clientDetailPane);
        } catch (IOException ex) {
            Logger.getLogger(SalonClientController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void clickOnEditClientInformation(MouseEvent event) {
        try {
            Parent root=FXMLLoader.load(this.getClass().getResource("/lk/retreat/sms/view/editClient.fxml"));
            Scene temp=new Scene(root);
            Stage stage=new Stage();
            stage.centerOnScreen();
//            Stage stage=(Stage) this.clientPane.getScene().getWindow();
            stage.setScene(temp);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(SalonClientController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void loadAllClients() {
 try {
            ArrayList<ClientDTO> alClients = clientBo.loadAllClient();

            ObservableList<ClientTM> olClients = clientDetailTable.getItems();
            
            olClients.removeAll(olClients);


            for (ClientDTO client : alClients) {
                olClients.add(new ClientTM(client.getClientId(),
                        client.getClientName()));
            }
        } catch (Exception ex) {
            Logger.getLogger(SalonClientController.class.getName()).log(Level.SEVERE, null, ex);
        } 
   }

    @FXML
    private void clickToDelete(MouseEvent event) {
        
        try {
            ClientTM cus=clientDetailTable.getSelectionModel().getSelectedItem();
            
            if(cus == null){
                return;
            }
            
            boolean result=clientBo.deleteClient(cus.getClientId());
            if (result){
                new Alert(Alert.AlertType.CONFIRMATION,"Delete Successful",ButtonType.OK).show();
            }else{
                new Alert(Alert.AlertType.ERROR,"Delete fail", ButtonType.OK).show();
            }
            
            loadAllClients();
        } catch (Exception ex) {
            Logger.getLogger(SalonClientController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

 

    @FXML
    private void MouseClickedSelectRW(MouseEvent event) {
        ClientTM m=clientDetailTable.getSelectionModel().getSelectedItem();
        searchText.setText(m.getClientId()); 
    }

    @FXML
    private void MouseClickedSearch(MouseEvent event) {
        
//            ArrayList<AppointmentDTO> alClients = appBo.loadAllAppointments();
//               for (AppointmentDTO dto : alClients) {
//                appid.setText(dto.getAppId());
//                date.setText(dto.getDate());
//                time.setText(dto.getTime());
//                emp.setText(dto.getEmpId());
//                status.setText(dto.getStatus());
//                        
//            }
                  
                

            
            try {
                ClientDTO cdto=clientBo.getSearchDetail(searchText.getText());
                if(cdto!=null){
                    clientid2.setText(cdto.getClientId());
                    onlyIdTxt.setText(cdto.getClientId());
                    cientnametext2.setText(cdto.getClientName());
                    addresstext2.setText(cdto.getClientAddress());
                    contactnotext2.setText(Integer.toString(cdto.getClientTel()));
                    emailtext2.setText(cdto.getClientEmail());
                    firstindatetext2.setText(cdto.getFirstInDate());
                    
                    
                         
            ArrayList<AppointmentDTO> alClients = appBo.loadAllAppointments();
               for (AppointmentDTO dto : alClients) {
                appid.setText(dto.getAppId());
                date.setText(dto.getDate());
                time.setText(dto.getTime());
                
                emp.setText(dto.getEmpId());
                status.setText(dto.getStatus());
                        
            }
                    
                    
                    
                    
                    
                    
                }else{
                    Alert a=new Alert(Alert.AlertType.ERROR, "error", ButtonType.OK);
                    a.show();
                }
            } catch (Exception ex) {
                Logger.getLogger(SalonClientController.class.getName()).log(Level.SEVERE, null, ex);
            }
       
    }

    @FXML
    private void MouseClickedButtonHandle(MouseEvent event) {
        
        if(event.getSource()==clientDetail){
            firstpane.toFront();
        }else if(event.getSource()==appointment){
            secondpane.toFront();
        }
    }
}


 
    
