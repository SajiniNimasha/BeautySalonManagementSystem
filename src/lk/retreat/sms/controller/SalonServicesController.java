/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.retreat.sms.controller;

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
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.retreat.sms.business.BOFactory;
import lk.retreat.sms.business.custom.SubCategoryBO;
import lk.retreat.sms.dto.SubCategoryDTO;
import lk.retreat.sms.view.util.tblmodel.SubCategoryTM;

/**
 * FXML Controller class
 *
 * @author User
 */
public class SalonServicesController implements Initializable {

    @FXML
    private AnchorPane servicePane;
    @FXML
    private Label cancelLbl;
    @FXML
    private Label editServiceInformation;
    @FXML
    private Label addService;
    @FXML
    private TableView<SubCategoryTM> serviceTable;
    
    private SubCategoryBO subCategoryBo;
    @FXML
    private Label deletebtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        subCategoryBo=(SubCategoryBO) BOFactory.getInstance().getBO(BOFactory.BOFactoryTpes.SubCategory);
        
         serviceTable.getColumns().get(0).setStyle("-fx-alignment:center");
        
        serviceTable.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("mainCategoryName"));
        serviceTable.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("subCategoryName"));
        serviceTable.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("subCategoryPrice"));
       
       
        loadAllServices();
        // TODO
    }    

    @FXML
    private void clickOnCancelLbl(MouseEvent event) {
          try {
            Parent root=FXMLLoader.load(this.getClass().getResource("/lk/retreat/sms/view/salonDashboard.fxml"));
            Scene temp=new Scene(root);
            Stage stage=(Stage) this.servicePane.getScene().getWindow();
            stage.setScene(temp);
        } catch (IOException ex) {
            Logger.getLogger(SalonServicesController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void clickToEditService(MouseEvent event) {
           try{
            Parent root=FXMLLoader.load(this.getClass().getResource("/lk/retreat/sms/view/updateService.fxml"));
            Scene temp=new Scene(root);
//            Stage stage=(Stage) this.servicePane.getScene().getWindow();
               Stage stage=new Stage();
                 stage.setScene(temp);
                 stage.centerOnScreen();
                 stage.show();
        } catch (IOException ex) {
            Logger.getLogger(SalonServicesController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void clickToAddService(MouseEvent event) {
             try{
   
            Parent root=FXMLLoader.load(this.getClass().getResource("/lk/retreat/sms/view/addService.fxml"));
            Scene temp=new Scene(root);
            Stage stage=new Stage();
            stage.setScene(temp);
            stage.centerOnScreen();
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(SalonServicesController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void loadAllServices() {
     try{   
        ArrayList<SubCategoryDTO> alSer=subCategoryBo.loadAllServices();
      
        ObservableList<SubCategoryTM> olSer=serviceTable.getItems();
        olSer.removeAll(olSer);
        
        for(SubCategoryDTO sc:alSer){
            olSer.addAll(new SubCategoryTM(sc.getMainCategoryName(),sc.getSubCategoryName(),sc.getSubCategoryPrice()));
        
        }
         } catch (Exception ex) {
            Logger.getLogger(SalonServicesController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
   }

    @FXML
    private void dclickToDelete(MouseEvent event) {
        
        try {
            SubCategoryTM ser=serviceTable.getSelectionModel().getSelectedItem();
            
            if(ser== null){
                return;
            }
            
            boolean result=subCategoryBo.delete(ser.getMainCategoryName());
            if (result){
                new Alert(Alert.AlertType.CONFIRMATION,"Delete Successful",ButtonType.OK).show();
            }else{
                new Alert(Alert.AlertType.ERROR,"Delete fail", ButtonType.OK).show();
            }
            
            loadAllServices();
        } catch (Exception ex) {
            Logger.getLogger(SalonServicesController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
