/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.retreat.sms.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
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
import lk.retreat.sms.dto.EmployeeDTO;
import lk.retreat.sms.dto.PaymentDTO;
import lk.retreat.sms.dto.ServiceDetailDTO;
import lk.retreat.sms.dto.SubCategoryDTO;
import lk.retreat.sms.view.util.tblmodel.AppointmentTM;
import lk.retreat.sms.view.util.tblmodel.AvaliableTimeTM;

/**
 * FXML Controller class
 *
 * @author User
 */
public class SalonAppointmentListController implements Initializable {

    @FXML
    private AnchorPane appointmentListPane;
    @FXML
    private Label cancelLbl;
    @FXML
    private JFXDatePicker dtPicker;
    @FXML
    private TableView<AvaliableTimeTM> tblDetail;
    @FXML
    private JFXComboBox cmbEmp;
    @FXML
    private Button btnPayment;
    @FXML
    private Button btnEnd;
    @FXML
    private JFXTextField txtAppId;
    @FXML
    private JFXTextField txtDate;
    @FXML
    private JFXTextField txtTime;
    @FXML
    private JFXTextField txtEmp;
    @FXML
    private JFXComboBox cmbService;
    @FXML
    private JFXRadioButton radHair;
    @FXML
    private JFXRadioButton radFace;
    @FXML
    private JFXRadioButton radMakeup;
    @FXML
    private JFXRadioButton radNail;
    @FXML
    private JFXRadioButton radDress;
    @FXML
    private JFXTextField txtPrice;
    @FXML
    private TableView<AppointmentTM> tblAppointment;
    @FXML
    private TextField txtSearch;
    @FXML
    private JFXTextField txtClientId;
    @FXML
    private JFXTextField txtName;
    @FXML
    private RadioButton radReg;
    @FXML
    private RadioButton radNew;
    @FXML
    private Button btnFinish;
    
    private EmployeeBO employeeBO; 
    private AppointmentBO appointmentBO;
    private SubCategoryBO subCategoryBO;
    private ClientBO clientBO;
    private ServiceDetailBO serviceDetailBO;
    private PaymentBO paymentBO;
    
    private AppointmentDTO appointmentDTO;
    
    private String selectCategory;
    private String selectType="New";
    
    private ServiceDetailDTO dbServiceDetailDTO;
    private AppointmentDTO dbAppointmentDTO;
    private PaymentDTO dbPaymentDTO;
    @FXML
    private JFXTextField addresstxt;
    @FXML
    private JFXTextField teltxt;
    @FXML
    private JFXTextField mailtxt;
    @FXML
    private JFXTextField datetxt;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
//        initialize the employee

        employeeBO=(EmployeeBO) BOFactory.getInstance().getBO(BOFactory.BOFactoryTpes.Employee);
        appointmentBO=(AppointmentBO) BOFactory.getInstance().getBO(BOFactory.BOFactoryTpes.APPOINTMENT);
        subCategoryBO=(SubCategoryBO) BOFactory.getInstance().getBO(BOFactory.BOFactoryTpes.SubCategory);
        clientBO=(ClientBO) BOFactory.getInstance().getBO(BOFactory.BOFactoryTpes.Client);
        serviceDetailBO=(ServiceDetailBO) BOFactory.getInstance().getBO(BOFactory.BOFactoryTpes.SERVICE_DETAIL);
        paymentBO=(PaymentBO) BOFactory.getInstance().getBO(BOFactory.BOFactoryTpes.PAYMENT);
        
        tblAppointment.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("appId"));
        tblAppointment.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("time"));
        tblAppointment.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("Date"));
        tblAppointment.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("empName"));
        tblAppointment.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("clientId"));
        tblAppointment.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("service"));
        tblAppointment.getColumns().get(6).setCellValueFactory(new PropertyValueFactory<>("status"));
        
//        avaliable time table set here
        
        tblDetail.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("availableTime"));
        
//        radio button configured in here
        
        ToggleGroup group1 = new ToggleGroup();
        ToggleGroup group2 = new ToggleGroup();
   
        radDress.setToggleGroup(group1);
        radFace.setToggleGroup(group1);
        radHair.setToggleGroup(group1);
        radMakeup.setToggleGroup(group1);
        radNail.setToggleGroup(group1);
        
        radNew.setToggleGroup(group2);
        radReg.setToggleGroup(group2);
     
        radNew.setSelected(true);
        
//        load the beauticians

        loadAllEmployees();
        
//        load the table

        loadAllAppointments();
        
//        set the new customer id

        setNewCustomerID();
        
        
    }    

    @FXML
    private void clickOnCancelLbl(MouseEvent event) {
          try {
            Parent root=FXMLLoader.load(this.getClass().getResource("/lk/retreat/sms/view/salonDashboard.fxml"));
            Scene temp=new Scene(root);
            Stage stage=(Stage) this.appointmentListPane.getScene().getWindow();
            stage.setScene(temp);
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void clickToBookAppointment(MouseEvent event) {
        try{
            Parent root=FXMLLoader.load(this.getClass().getResource("/lk/retreat/sms/view/Booking an appointment.fxml"));
            Scene temp=new Scene(root);
            Stage stage=(Stage) this.appointmentListPane.getScene().getWindow();
            stage.setScene(temp);
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void clickToEditEmployee(MouseEvent event) {
        try{
            Parent root=FXMLLoader.load(this.getClass().getResource("/lk/retreat/sms/view/editAppointment.fxml"));
            Scene temp=new Scene(root);
            Stage stage=(Stage) this.appointmentListPane.getScene().getWindow();
            stage.setScene(temp);
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
    

    private void clickToPayment(MouseEvent event) {
        try{
            Parent root=FXMLLoader.load(this.getClass().getResource("/lk/retreat/sms/view/payment.fxml"));
            Scene temp=new Scene(root);
            Stage stage=(Stage) this.appointmentListPane.getScene().getWindow();
            stage.setScene(temp);
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @FXML
    private void cmbEmpOnAction(ActionEvent event) {
        
        tblDetail.getItems().clear();
        
        try {
            
            String time[]={"08:00-09:00","09:10-10:10","10:20-11:20","11:30-12:30","13:30-14:30","14:40-15:40","15:50-16:50"};
            
            LocalDate local=dtPicker.getValue();
            String date=local.format(DateTimeFormatter.ISO_DATE);
            
            String employee=cmbEmp.getSelectionModel().getSelectedItem().toString();
            String empId="";
            for (EmployeeDTO employeeDTO : employeeBO.loadAllEmployee()) {
                if(employeeDTO.getEmployeeName().equals(employee)){
                    empId=employeeDTO.getEmployeeId();
                }
            }
            
            List<AppointmentDTO>appList=appointmentBO.loadAllAppointments();
            ObservableList<AvaliableTimeTM> tblList=FXCollections.observableArrayList();
            
            List<String> reservedList=new ArrayList<>();
            
            for (AppointmentDTO appointmentDTO : appList) {
                if(appointmentDTO.getEmpId().equals(empId)){                    
                    if(appointmentDTO.getDate().equals(date)){
                        reservedList.add(appointmentDTO.getTime());
                    }
                }
                
            }
            
            for (String string : time) {
                int count=0;
                for (String string1 : reservedList) {
                    if(string1.equals(string)){
                        count++;
                    }
                }
                if(count==0){
                    tblList.add(new AvaliableTimeTM(string));
                }
            }
            
            tblDetail.setItems(tblList);
           
        } catch (Exception ex) {
            System.out.println(ex);
            Logger.getLogger(SalonAppointmentListController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @FXML
    private void endOnAction(ActionEvent event) {
        
        if(appointmentDTO!=null){
            try {
                appointmentDTO.setStatus("Finished");
                if(appointmentBO.updateStatus(appointmentDTO)){
                    refreshAppointmentTable();
                }
            } catch (Exception ex) {
                Logger.getLogger(SalonAppointmentListController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    @FXML
    private void appointmentTblOnMouseClick(MouseEvent evt){
        
        try {
            String appId=tblAppointment.getSelectionModel().getSelectedItem().getAppId();
            for (AppointmentDTO loadAllAppointment : appointmentBO.loadAllAppointments()) {
                if(loadAllAppointment.getAppId().equals(appId)){
                    appointmentDTO=loadAllAppointment;
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(SalonAppointmentListController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    @FXML
    private void radRegCustOnAction(ActionEvent evt){
        selectType="Reg";
        txtClientId.setText("");
        txtClientId.setDisable(true);
        
        addresstxt.setText("");
        addresstxt.setDisable(true);
        
        teltxt.setText("");
        teltxt.setDisable(true);
        
        mailtxt.setText("");
        mailtxt.setDisable(true);
        
        datetxt.setText("");
        datetxt.setDisable(true);
        
    }
    
    @FXML
    private void radNewCustOnAction(ActionEvent evt){
        selectType="New";
        txtClientId.setDisable(false);
//        setNewCustomerID();
        
        addresstxt.setDisable(false);
        teltxt.setDisable(false);
        mailtxt.setDisable(false);
        datetxt.setDisable(false);
         setNewCustomerID();
    }

    @FXML
    private void radHairOnAction(ActionEvent event) {
        
        try {
            
            selectCategory="Hair Care";
            
            cmbService.setValue(null);
            List<SubCategoryDTO> subList=subCategoryBO.loadAllServices();
            ObservableList<String> subs=FXCollections.observableArrayList();
            for (SubCategoryDTO subCategoryDTO : subList) {
                if(subCategoryDTO.getMainCategoryName().equals("Hair Care")){
                    subs.add(subCategoryDTO.getSubCategoryName());
                }
                
            }
            cmbService.setItems(subs);
        } catch (Exception ex) {
            Logger.getLogger(SalonAppointmentListController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

    @FXML
    private void radFaceOnAction(ActionEvent event) {
        
        selectCategory="Face & Skin";
        try {
            cmbService.setValue(null);
            List<SubCategoryDTO> subList=subCategoryBO.loadAllServices();
            ObservableList<String> subs=FXCollections.observableArrayList();
            for (SubCategoryDTO subCategoryDTO : subList) {
                if(subCategoryDTO.getMainCategoryName().equals("Face & Skin")){
                    subs.add(subCategoryDTO.getSubCategoryName());
                }
                
            }
            cmbService.setItems(subs);
        } catch (Exception ex) {
            Logger.getLogger(SalonAppointmentListController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void radMakeupOnAction(ActionEvent event) {
        
        selectCategory="Makeup";
        try {
            cmbService.setValue(null);
            List<SubCategoryDTO> subList=subCategoryBO.loadAllServices();
            ObservableList<String> subs=FXCollections.observableArrayList();
            for (SubCategoryDTO subCategoryDTO : subList) {
                if(subCategoryDTO.getMainCategoryName().equals("Makeup")){
                    subs.add(subCategoryDTO.getSubCategoryName());
                }
                
            }
            cmbService.setItems(subs);
        } catch (Exception ex) {
            Logger.getLogger(SalonAppointmentListController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void radNailOnAction(ActionEvent event) {
        
        selectCategory="Nail Care";
        try {
            cmbService.setValue(null);
            List<SubCategoryDTO> subList=subCategoryBO.loadAllServices();
            ObservableList<String> subs=FXCollections.observableArrayList();
            for (SubCategoryDTO subCategoryDTO : subList) {
                if(subCategoryDTO.getMainCategoryName().equals("Nail Care")){
                    subs.add(subCategoryDTO.getSubCategoryName());
                }
                
            }
            cmbService.setItems(subs);
        } catch (Exception ex) {
            Logger.getLogger(SalonAppointmentListController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void radDressOnAction(ActionEvent event) {
        
        selectCategory="Dressing";
        try {
            cmbService.setValue(null);
            List<SubCategoryDTO> subList=subCategoryBO.loadAllServices();
            ObservableList<String> subs=FXCollections.observableArrayList();
            for (SubCategoryDTO subCategoryDTO : subList) {
                if(subCategoryDTO.getMainCategoryName().equals("Dressing")){
                    subs.add(subCategoryDTO.getSubCategoryName());
                }
                
            }
            cmbService.setItems(subs);
        } catch (Exception ex) {
            Logger.getLogger(SalonAppointmentListController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void searchOnAction(KeyEvent event) {
        tblAppointment.getItems().clear();
        try {
            List<AppointmentDTO> appList=appointmentBO.loadAllAppointments();
            ObservableList<AppointmentTM> list=FXCollections.observableArrayList();
            for (AppointmentDTO appointmentDTO : appList) {
                    String empName="";
                    String clientName="";
                    String service="";
                    for (EmployeeDTO employeeDTO : employeeBO.loadAllEmployee()) {
                        if(employeeDTO.getEmployeeId().equals(appointmentDTO.getEmpId())){
                             empName=employeeDTO.getEmployeeName();
                        }
                    }
                    for (ClientDTO clientDTO : clientBO.loadAllClient()) {
                        if(clientDTO.getClientId().equals(appointmentDTO.getClientId())){
                             clientName=clientDTO.getClientName();
                        }
                    }
                    for (ServiceDetailDTO serviceDetailDTO : serviceDetailBO.loadAllServices()) {
                        if(serviceDetailDTO.getAppId().equals(appointmentDTO.getAppId())){
                             service=serviceDetailDTO.getCategory();
                        }
                    }
                    if(clientName.toLowerCase().trim().substring(0, txtSearch.getText().length()).equals(txtSearch.getText().trim().toLowerCase())){
                        list.add(new AppointmentTM(appointmentDTO.getAppId(),appointmentDTO.getTime(),appointmentDTO.getDate(),empName,clientName,service, appointmentDTO.getStatus()));
                    }else if(txtSearch.getText().equals("")){
                        refreshAppointmentTable();
                    }
                    
            }
            tblAppointment.setItems(list);
        } catch (Exception ex) {
                Logger.getLogger(SalonAppointmentListController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @FXML
    private void btnFinishOnAction(ActionEvent event) {
        try {
            if(selectType.equals("Reg")){

                setPaymentDetails();
                
                for (ClientDTO clientDTO : clientBO.loadAllClient()) {
                    if(clientDTO.getClientName().equals(txtName.getText())){
                        dbAppointmentDTO.setClientId(clientDTO.getClientId());
                        
                        if(clientBO.saveWithRegClient(dbAppointmentDTO, dbPaymentDTO, dbServiceDetailDTO)){
                          refreshAppointmentTable();
                        }else{
                            System.out.println("fail");
                        }
                    }
                }
                
            }else{
                   setPaymentDetails();
                dbAppointmentDTO.setClientId(txtClientId.getText());
                if(clientBO.saveWithNewClient(new ClientDTO(txtClientId.getText(),txtName.getText(),addresstxt.getText(),Integer.parseInt(teltxt.getText()),mailtxt.getText(),datetxt.getText()),dbAppointmentDTO, dbPaymentDTO, dbServiceDetailDTO)){
                    
                    refreshAppointmentTable();
                }else{
                    System.out.println("fail");
                }
                loadAllAppointments();
                
            }
        } catch (Exception ex) {
            System.out.println(ex);
            Logger.getLogger(SalonAppointmentListController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void cmbServiceOnAction(ActionEvent evt){
        
        try {
            for (SubCategoryDTO service : subCategoryBO.loadAllServices()) {
                if(service.getSubCategoryName().equals(cmbService.getSelectionModel().getSelectedItem().toString()))
                    txtPrice.setText(Double.toString(service.getSubCategoryPrice()));
                }
        } catch (Exception ex) {
            Logger.getLogger(SalonAppointmentListController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    @FXML
    private void detailTblOnMouseClick(MouseEvent evt){
        
        try {
            String last="";
            List<AppointmentDTO> list=appointmentBO.loadAllAppointments();
            for (AppointmentDTO appointmentDTO : list) {
                last=appointmentDTO.getAppId();
            }
            String next="";
            if(list.size()>0){
                int nextId=Integer.parseInt(last)+1;
                next=Integer.toString(nextId);
            }else{
                next="1";
            }
            
            txtAppId.setText(next);
            txtDate.setText(dtPicker.getValue().format(DateTimeFormatter.ISO_DATE));
            txtTime.setText(tblDetail.getSelectionModel().getSelectedItem().getAvailableTime());
            txtEmp.setText(cmbEmp.getSelectionModel().getSelectedItem().toString());
            
        } catch (Exception ex) {
            Logger.getLogger(SalonAppointmentListController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

    private void loadAllEmployees() {
        
        try {
            List<EmployeeDTO> empList=employeeBO.loadAllEmployee();
            ObservableList<String> list=FXCollections.observableArrayList();
            for (EmployeeDTO employeeDTO : empList) {
                list.add(employeeDTO.getEmployeeName());
            }
            cmbEmp.setItems(list);
        } catch (Exception ex) {
            Logger.getLogger(SalonAppointmentListController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void loadAllAppointments(){
        
      
        try {
            List<AppointmentDTO> appList=appointmentBO.loadAllAppointments();
            
            ObservableList<AppointmentTM> list=FXCollections.observableArrayList();
            for (AppointmentDTO appointmentDTO : appList) {
                    String empName="";
                    String clientName="";
                    String service="";
                    for (EmployeeDTO employeeDTO : employeeBO.loadAllEmployee()) {
                        if(employeeDTO.getEmployeeId().equals(appointmentDTO.getEmpId())){
                             empName=employeeDTO.getEmployeeName();
                             
                        }
                    }
                    for (ClientDTO clientDTO : clientBO.loadAllClient()) {
                        if(clientDTO.getClientId().equals(appointmentDTO.getClientId())){
                             clientName=clientDTO.getClientName();
                        }
                    }
                    for (ServiceDetailDTO serviceDetailDTO : serviceDetailBO.loadAllServices()) {
                        System.out.println(serviceDetailDTO.getAppId()+"    sv" );
                       
                        if(serviceDetailDTO.getAppId().equals(appointmentDTO.getAppId())){
                             service=serviceDetailDTO.getCategory();
                        }
                    }
                    list.add(new AppointmentTM(appointmentDTO.getAppId(),appointmentDTO.getTime(),appointmentDTO.getDate(),empName,clientName,service, appointmentDTO.getStatus()));
                    
            }
            tblAppointment.setItems(list);
        } catch (Exception ex) {
                Logger.getLogger(SalonAppointmentListController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
    
    private void refreshAppointmentTable(){
        tblAppointment.getItems().clear();
        loadAllAppointments();
    }

    private void setNewCustomerID() {
        
        try {
            String lastId="";
            for (ClientDTO clientDTO : clientBO.loadAllClient()) {
                lastId=clientDTO.getClientId();
            }
            String newId=Integer.toString(Integer.parseInt(lastId)+1);
            txtClientId.setText(newId);
        } catch (Exception ex) {
            Logger.getLogger(SalonAppointmentListController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    private void setPaymentDetails() {
        
        try {
            
            String empId="";
            
            String lastServiceId="";
            String lastPaymentId="";
            
            String nextServiceId="";
            String nextPaymentId="";
            
            List<ServiceDetailDTO> services=serviceDetailBO.loadAllServices();
            if(services.size()>0){
                for (ServiceDetailDTO loadAllService : serviceDetailBO.loadAllServices()) {
                    
                    lastServiceId=loadAllService.getServiceDetailId();
                }
                nextServiceId=Integer.toString(Integer.parseInt(lastServiceId)+1);
            }else{
                nextServiceId="1";
            }
            
            List<PaymentDTO> payments=paymentBO.loadAllPayments();
            if(payments.size()>0){
                for (PaymentDTO paymentDTO : paymentBO.loadAllPayments()) {
                    lastPaymentId=paymentDTO.getPaymentId();
                }
                nextPaymentId=Integer.toString(Integer.parseInt(lastPaymentId)+1);
            }else{
                nextPaymentId="1";
            }
            
            for (EmployeeDTO employeeDTO : employeeBO.loadAllEmployee()) {
                if(employeeDTO.getEmployeeName().equals(txtEmp.getText())){
                    empId=employeeDTO.getEmployeeId();
                }
            }
            
            
            
            ServiceDetailDTO serviceDetailDTO=new ServiceDetailDTO(nextServiceId,selectCategory,txtAppId.getText());
            PaymentDTO paymentDTO=new PaymentDTO(nextPaymentId,Double.parseDouble(txtPrice.getText()));
            AppointmentDTO appointmentDTO=new AppointmentDTO(txtAppId.getText(),txtDate.getText(),txtTime.getText(),"", empId, nextPaymentId, "not yet");
            
            
            dbAppointmentDTO=appointmentDTO;
            dbPaymentDTO=paymentDTO;
            dbServiceDetailDTO=serviceDetailDTO;
            
        } catch (Exception ex) {
            Logger.getLogger(SalonAppointmentListController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public boolean validateClient(){
        String name=txtName.getText();
        String address=addresstxt.getText();
        int tele=Integer.parseInt(teltxt.getText());
        String mail=mailtxt.getText();
        String date=datetxt.getText();
       // boolean mat=datetxt.m("[0-9]{4}[.][0-9]{1,2}[.][0-9]{1,2}");
        return false;
        
    }
    
}
