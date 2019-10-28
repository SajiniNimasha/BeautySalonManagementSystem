/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.retreat.sms.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author User
 */
public class Main extends Application {
    private static  Stage loginStage;



    @Override
    public void start(Stage primaryStage) throws Exception {
      Parent root=FXMLLoader.load(this.getClass().getResource("/lk/retreat/sms/view/salonLogin.fxml"));
      Scene temp=new Scene(root);
      
      primaryStage.setScene(temp);
      primaryStage.show();
      primaryStage.setResizable(false);
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
    public static Stage getLoginStage() {
        return loginStage;
        
        
    }
  
    
    
}
