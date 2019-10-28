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
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.retreat.sms.db.DBConnection;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 * FXML Controller class
 *
 * @author User
 */
public class ReportsController implements Initializable {

    @FXML
    private AnchorPane reportPane;
    @FXML
    private ImageView btn;
    @FXML
    private Button clientDetails;
    @FXML
    private Button clientAppointments;
    @FXML
    private Button beauticianBtn;
    @FXML
    private Button beauticianBtn2;
    @FXML
    private Button mainService;
    @FXML
    private Button subService;
    @FXML
    private Button shedule;
    @FXML
    private Button demand;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void back(MouseEvent event) {
        try {
            Parent root=FXMLLoader.load(this.getClass().getResource("/lk/retreat/sms/view/salonDashboard.fxml"));
            Scene temp=new Scene(root);
            Stage stage=(Stage) this.reportPane.getScene().getWindow();
            stage.setScene(temp);
        } catch (IOException ex) {
            Logger.getLogger(ReportsController.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }

    @FXML
    private void openClientDetails(ActionEvent event)throws Exception{
        try {
            InputStream is=this.getClass().getResourceAsStream("/lk/retreat/sms/reports/clientDetails.jasper");
            Connection conn=DBConnection.getInstance().getConnection();
            HashMap map=new HashMap();
            JasperPrint report=JasperFillManager.fillReport(is, map,conn);
            JasperViewer.viewReport(report,false);
        } catch (Exception ex) {
            Logger.getLogger(ReportsController.class.getName()).log(Level.SEVERE, null, ex);
        }
                
    }

    @FXML
    private void openClientAppointment(ActionEvent event) {
        try {
            InputStream is=this.getClass().getResourceAsStream("/lk/retreat/sms/reports/clientAppoint.jasper");
            Connection conn=DBConnection.getInstance().getConnection();
            HashMap map=new HashMap();
            JasperPrint report=JasperFillManager.fillReport(is, map,conn);
            JasperViewer.viewReport(report,false);
        } catch (Exception ex) {
            Logger.getLogger(ReportsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void clickToBeauticianDetail(MouseEvent event) {
        try {
            InputStream is=this.getClass().getResourceAsStream("/lk/retreat/sms/reports/BeauticianDetails.jasper");
            Connection conn=DBConnection.getInstance().getConnection();
            HashMap map=new HashMap();
            JasperPrint report=JasperFillManager.fillReport(is, map,conn);
            JasperViewer.viewReport(report,false);
        } catch (Exception ex) {
            Logger.getLogger(ReportsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void clickToBeauticianAppointment(MouseEvent event) {
        try {
            InputStream is=this.getClass().getResourceAsStream("/lk/retreat/sms/reports/clientAppointments.jasper");
            Connection conn=DBConnection.getInstance().getConnection();
            HashMap map=new HashMap();
            JasperPrint report=JasperFillManager.fillReport(is, map,conn);
            JasperViewer.viewReport(report,false);
        } catch (Exception ex) {
            Logger.getLogger(ReportsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void clickToMainSrviceDetail(MouseEvent event) {
        try {
            InputStream is=this.getClass().getResourceAsStream("/lk/retreat/sms/reports/mainServices.jasper");
            Connection conn=DBConnection.getInstance().getConnection();
            HashMap map=new HashMap();
            JasperPrint report=JasperFillManager.fillReport(is, map,conn);
            JasperViewer.viewReport(report,false);
        } catch (Exception ex) {
            Logger.getLogger(ReportsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void clickToSubSrviceDetail(MouseEvent event) {
        try {
            InputStream is=this.getClass().getResourceAsStream("/lk/retreat/sms/reports/subServiceDetails.jasper");
            Connection conn=DBConnection.getInstance().getConnection();
            HashMap map=new HashMap();
            JasperPrint report=JasperFillManager.fillReport(is, map,conn);
            JasperViewer.viewReport(report,false);
        } catch (Exception ex) {
            Logger.getLogger(ReportsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void shedule(ActionEvent event) throws Exception {
        try {
            InputStream is=this.getClass().getResourceAsStream("/lk/retreat/sms/reports/BeauticianShedule.jasper");
            Connection conn=DBConnection.getInstance().getConnection();
            HashMap map=new HashMap();
            JasperPrint report=JasperFillManager.fillReport(is, map,conn);
            JasperViewer.viewReport(report,false);
        } catch (JRException ex) {
            Logger.getLogger(ReportsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @FXML
    private void demand(ActionEvent event) {
        try {
            InputStream is=this.getClass().getResourceAsStream("/lk/retreat/sms/reports/wow.jasper");
            Connection conn=DBConnection.getInstance().getConnection();
            HashMap map=new HashMap();
            JasperPrint report=JasperFillManager.fillReport(is, map,conn);
            JasperViewer.viewReport(report,false);
        } catch (Exception ex) {
            Logger.getLogger(ReportsController.class.getName()).log(Level.SEVERE, null, ex);
        }
   
      
    }
    
}
