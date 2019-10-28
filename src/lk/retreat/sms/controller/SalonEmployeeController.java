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
import javafx.stage.Stage;
import lk.retreat.sms.business.BOFactory;
import lk.retreat.sms.business.custom.EmployeeBO;
import lk.retreat.sms.dto.EmployeeDTO;
import lk.retreat.sms.view.util.tblmodel.EmployeeTM;

/**
 * FXML Controller class
 *
 * @author User
 */
public class SalonEmployeeController implements Initializable {

    @FXML
    private AnchorPane employeePane;
    @FXML
    private Label cancelLbl;
    @FXML
    private Label editEmployeeInformation;
    @FXML
    private Label addEmployee;
    @FXML
    private TableView<EmployeeTM> EmployeeTable;
    
    private EmployeeBO EmpBo;
    @FXML
    private Label deleteBtn;
    @FXML
    private TextField searchtxt;
    @FXML
    private Button searchBtn;
    @FXML
    private TextField idText;
    @FXML
    private JFXTextField nametxt;
    @FXML
    private JFXTextField addresstxt;
    @FXML
    private JFXTextField contacttxt;
    @FXML
    private JFXTextField mailtxt;
    @FXML
    private JFXTextField datatxt;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        EmpBo=(EmployeeBO) BOFactory.getInstance().getBO(BOFactory.BOFactoryTpes.Employee);
        
        EmployeeTable.getColumns().get(0).setStyle("-fx-alignment:center");
        EmployeeTable.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("EmployeeId"));
        EmployeeTable.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("EmployeeName"));
        
       
        loadAllEmployee();
        // TODO
    }    

    @FXML
    private void clickOnCancelLbl(MouseEvent event) {
          try {
            Parent root=FXMLLoader.load(this.getClass().getResource("/lk/retreat/sms/view/salonDashboard.fxml"));
            Scene temp=new Scene(root);
            Stage stage=(Stage) this.employeePane.getScene().getWindow();
            stage.setScene(temp);
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @FXML
    private void cllickOnEditEmployeeInformation(MouseEvent event) {
        try {
            Stage stage=new Stage();
            Parent root=FXMLLoader.load(this.getClass().getResource("/lk/retreat/sms/view/EditEmployee.fxml"));
            Scene temp=new Scene(root);
//            Stage stage=(Stage) this.employeePane.getScene().getWindow();
            stage.setScene(temp);
            stage.centerOnScreen();
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(SalonEmployeeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @FXML
    private void clickOnAddEmployee(MouseEvent event) {
          try {
             Stage stage=new Stage();
            Parent root=FXMLLoader.load(this.getClass().getResource("/lk/retreat/sms/view/AddEmployee.fxml"));
            Scene temp=new Scene(root);
            
            
//            Stage stage=(Stage) this.employeePane.getScene().getWindow();
            stage.setScene(temp);
            stage.centerOnScreen();
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(SalonEmployeeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void loadAllEmployee() {
        try {
            
            ArrayList<EmployeeDTO> alEmp=EmpBo.loadAllEmployee();
            
            ObservableList<EmployeeTM> olEmp = EmployeeTable.getItems();
            
            olEmp.removeAll(olEmp);
            
            
            for (EmployeeDTO employee : alEmp) {
                olEmp.add(new EmployeeTM(employee.getEmployeeId(),
                        employee.getEmployeeName()));
            }
        } catch (Exception ex) {
            Logger.getLogger(SalonEmployeeController.class.getName()).log(Level.SEVERE, null, ex);
        }
     
 }

    @FXML
    private void clickToDelete(MouseEvent event) {
        try {
            EmployeeTM tm=EmployeeTable.getSelectionModel().getSelectedItem();
            
            if(tm == null){
                return;
            }
            
            boolean result=EmpBo.deleteEmployee(tm.getEmployeeId());
            if (result){
                new Alert(Alert.AlertType.CONFIRMATION,"Delete Successful",ButtonType.OK).show();
            }else{
                new Alert(Alert.AlertType.ERROR,"Delete fail", ButtonType.OK).show();
            }
            
            loadAllEmployee();     
        } catch (Exception ex) {
            Logger.getLogger(SalonEmployeeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void clickOnRow(MouseEvent event) {
        EmployeeTM tm=EmployeeTable.getSelectionModel().getSelectedItem();
        searchtxt.setText(tm.getEmployeeId());
    }

    @FXML
    private void clickTiSearch(MouseEvent event) {
    try{
       EmployeeDTO dto=EmpBo.getSearchDetails(searchtxt.getText());
       
       if(dto!=null){
           idText.setText(dto.getEmployeeId());
           nametxt.setText(dto.getEmployeeName());
           addresstxt.setText(dto.getEmployeeAddress());
           contacttxt.setText(Integer.toString(dto.getEmployeeTel()));
           mailtxt.setText(dto.getEmployeeEmail());
           datatxt.setText(dto.getEmpFirstInDate());
           
       }else{
           Alert a=new Alert(Alert.AlertType.ERROR,"Error",ButtonType.OK);
           a.show();
       }
        } catch (Exception ex) {
            Logger.getLogger(SalonEmployeeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
}
