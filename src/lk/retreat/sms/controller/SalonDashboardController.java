/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.retreat.sms.controller;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import lk.retreat.sms.db.DBConnection;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 * FXML Controller class
 *
 * @author User
 */
public class SalonDashboardController implements Initializable {

    @FXML
    private AnchorPane dashBoardPane;
    @FXML
    private ImageView appointImage;
    @FXML
    private ImageView serviceImage;
    @FXML
    private ImageView clientImage;
    @FXML
    private ImageView employeeImage;
    @FXML
    private ImageView pointOfSaleImage;
    @FXML
    private ImageView logout;
    @FXML
    private Label lblDescription;
    @FXML
    private ImageView reportImage;
    @FXML
    private Label dateLbl;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        Date date=new Date();
        String formatDate=formatDate(date);
        dateLbl.setText(formatDate);
       
    }    

 

    

    @FXML
    private void clickToLogout(MouseEvent event) throws IOException {
        
                 
            Parent root=FXMLLoader.load(this.getClass().getResource("/lk/retreat/sms/view/salonLogin.fxml"));
            Scene temp=new Scene(root);
             Stage stage=(Stage) this.dashBoardPane.getScene().getWindow();
            stage.setScene(temp);  
            stage.centerOnScreen();
        
    }

    @FXML
    private void navigate(MouseEvent event) throws IOException {
         if (event.getSource() instanceof ImageView){
             try {
                 ImageView icon = (ImageView) event.getSource();
                 
                 Parent root = null;
                 
                 switch(icon.getId()){
                     case "employeeImage":
                         root = FXMLLoader.load(this.getClass().getResource("/lk/retreat/sms/view/salonEmployee.fxml"));
                         break;
                     case "serviceImage":
                         root = FXMLLoader.load(this.getClass().getResource("/lk/retreat/sms/view/salonServices.fxml"));
                         break;
                     case "clientImage":
                         root = FXMLLoader.load(this.getClass().getResource("/lk/retreat/sms/view/salonClient.fxml"));
                         break;
                     case "appointImage":
                         root = FXMLLoader.load(this.getClass().getResource("/lk/retreat/sms/view/SalonAppointmentList.fxml"));
                         break;
                     case"pointOfSaleImage":
//                         root = FXMLLoader.load(this.getClass().getResource("/lk/retreat/sms/view/pointOfSale.fxml"));
                               InputStream is=this.getClass().getResourceAsStream("/lk/retreat/sms/reports/sales.jasper");
                                 Connection conn=DBConnection.getInstance().getConnection();
                                    HashMap map=new HashMap();
                                    JasperPrint report=JasperFillManager.fillReport(is, map,conn);
                                     JasperViewer.viewReport(report,false);
                         break;
                     case "reportImage":
                    root=FXMLLoader.load(this.getClass().getResource("/lk/retreat/sms/view/Reports.fxml"));
                   
                         break;
                         
                 }
                 
                 if (root != null){
                     Scene subScene = new Scene(root);
                     Stage primaryStage = (Stage) this.dashBoardPane.getScene().getWindow();
                     primaryStage.setScene(subScene);
                     primaryStage.centerOnScreen();
                     
                     
                     TranslateTransition tt = new TranslateTransition(Duration.millis(350), subScene.getRoot());
                     tt.setFromX(-subScene.getWidth());
                     tt.setToX(0);
                     tt.play();
                 }} catch (Exception ex) {
                 Logger.getLogger(SalonDashboardController.class.getName()).log(Level.SEVERE, null, ex);
             }
        }
        
    }

    @FXML
    private void enterToAnimation(MouseEvent event) {
         if (event.getSource() instanceof ImageView){
            ImageView icon = (ImageView) event.getSource();
            
            switch(icon.getId()){
                case "employeeImage":
                    lblDescription.setText("Click to add, edit, delete, search or view employee");
                    break;
                case "serviceImage":
         
                    lblDescription.setText("Click to add, edit, delete, search or view service");
                    break;
                case "clientImage":
                
                    lblDescription.setText("Click to add, edit, delete, search or view client");
                    break;
                case "appointImage":
        
                    lblDescription.setText("Click if you want to make appoinment");
                    break;
                    
                   case "pointOfSaleImage":
        
                    lblDescription.setText("Click if you want to view sales details");
                    break;  
                    
                   case "reportImage":
        
                    lblDescription.setText("Click if you want to generate reports");
                    break;     
            }
            
          
            
            DropShadow glow = new DropShadow();
            glow.setColor(Color.CORNFLOWERBLUE);
            glow.setWidth(20);
            glow.setHeight(20);
            glow.setRadius(20);
            icon.setEffect(glow);            
         }
    }

    @FXML
    private void exitAnimation(MouseEvent event) {
         if (event.getSource() instanceof ImageView){
            ImageView icon = (ImageView) event.getSource();
            ScaleTransition scaleT =new ScaleTransition(Duration.millis(200), icon);
            scaleT.setToX(1);
            scaleT.setToY(1);
            scaleT.play(); 
            
            icon.setEffect(null);
            
         lblDescription.setText("Welcome");
        }
        
    }

    private String formatDate(Date date) {
        SimpleDateFormat sdf=new SimpleDateFormat("YYYY-MM-dd");
        return sdf.format(date);
    }
}
   
