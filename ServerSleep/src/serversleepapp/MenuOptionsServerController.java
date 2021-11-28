/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serversleepapp;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author gabri
 */
public class MenuOptionsServerController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML 
    private Button viewEEG;
    @FXML 
    private Button dailyreport;
    @FXML 
    private Button historyreport;
    @FXML 
    private Button historyEEG;
    
    
           public void start(Stage primaryStage) throws Exception {

           Parent root = FXMLLoader.load(getClass().getResource("MenuOptionsServer.fxml"));

           //will load a different xml when the button is pressed 
           //what we are looking forward is when clicking the button of the getstarted scene changes into the following one

           Scene scene = new Scene(root);

           primaryStage.setTitle("MENU OPTIONS");
           primaryStage.setScene(scene);
           primaryStage.show();

       }

            @FXML
           public void gotoReportHistory (ActionEvent event) throws IOException{
               Parent root = FXMLLoader.load(getClass().getResource("DailyReportHistory.fxml"));

               Scene loginScene = new Scene(root);

               Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();

               window.setScene(loginScene);
               window.show();
           }

                @FXML
           public void gotoEEGHistory (ActionEvent event) throws IOException{
               Parent root = FXMLLoader.load(getClass().getResource("EEGHistory.fxml"));

               Scene loginScene = new Scene(root);

               Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();

               window.setScene(loginScene);
               window.show();
           }
           
                          @FXML
           public void goBack (ActionEvent event) throws IOException{
               Parent root = FXMLLoader.load(getClass().getResource("AccessInformation.fxml"));

               Scene loginScene = new Scene(root);

               Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();

               window.setScene(loginScene);
               window.show();
           }

                       @FXML
           public void personalInformation (ActionEvent event) throws IOException{
               Parent root = FXMLLoader.load(getClass().getResource("PatientsInformation.fxml"));

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
