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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author 99lorena
 */

public class PatientInformationErrorController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private TextField MessageTF;
    
    @FXML
    private Button back;
        
    @FXML
    private Label MessageLB;
    
    
    @FXML
    public void goBackMenuOptions (ActionEvent event) throws IOException{
        
        Parent root = FXMLLoader.load(getClass().getResource("PatientsInformation.fxml"));

        Scene loginScene = new Scene(root);
        
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();

        window.setScene(loginScene);
        window.show();
        
    }
    
     public void start(Stage primaryStage) throws Exception {
         
         Parent root = FXMLLoader.load(getClass().getResource("PatientsInformationError.fxml"));
         
         Scene scene = new Scene(root);

         primaryStage.setTitle("MESSAGE FROM THE DATABASE");
         primaryStage.setScene(scene);
         primaryStage.show();
     }
           
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
