/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serversleepapp;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.application.Application;
import javafx.fxml.*;
import javafx.scene.*;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javafx.scene.control.*;
import java.util.Date;
import static javafx.application.Application.launch;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author gabri
 */
public class AccessInformationController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML 
    private Button goback;
    @FXML 
    private Button continuemenu;
    
            public void start(Stage primaryStage) throws Exception {

           Parent root = FXMLLoader.load(getClass().getResource("AccessInformation.fxml"));

           //will load a different xml when the button is pressed 
           //what we are looking forward is when clicking the button of the getstarted scene changes into the following one

           Scene scene = new Scene(root);

           primaryStage.setTitle("ACCESS INFORMATION");
           primaryStage.setScene(scene);
           primaryStage.show();

       }

         
                      @FXML
        public void continueToMenuOptions (ActionEvent event) throws IOException{
            Parent root = FXMLLoader.load(getClass().getResource("MenuOptionsServer.fxml"));

            Scene loginScene = new Scene(root);

            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();

            window.setScene(loginScene);
            window.show();
        }
        
             
                      @FXML
        public void gobackGetStarted (ActionEvent event) throws IOException{
            Parent root = FXMLLoader.load(getClass().getResource("GetStarted.fxml"));

            Scene loginScene = new Scene(root);

            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();

            window.setScene(loginScene);
            window.show();
        }

            
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
