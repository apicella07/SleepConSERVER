/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serversleepapp;

import Database.PatientManager;
import Server.Patient;
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
import javafx.beans.property.SimpleStringProperty;
import javafx.stage.Stage;
import Database.PatientManagerInterface;
import Database.UserManagerInterface;
import java.io.BufferedReader;
import java.util.ArrayList;

/**
 * FXML Controller class
 *
 * @author 99lorena
 */
public class AccessInformationController implements Initializable {


    /**
     * Initializes the controller class.
     */
    
 
    @FXML 
    private Button search;
    @FXML 
    private Button goback;
    @FXML 
    private Button continuemenu;
    @FXML
    private TextField dniTF;
    
    private static PatientManagerInterface pmi;
    private static Database.DBManagerInterface dbman;
    private static UserManagerInterface umi;
    private static BufferedReader br;
    private  PatientManager pm;
        
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
        
        
                    @FXML
        public void searchByDNI (ActionEvent event) throws IOException {
            
             //for bucle que recorra todos los pacientes, algo así (i= patient1, i < length.pacients , i++)
             //{ aquí dentro el codigo de esta funcion }
             
            ArrayList<Patient> patients = new ArrayList<Patient>();
            patients = pmi.showPatients();
        
            
             Patient pat= new Patient();
            //patient = pmi.searchSpecificPatientByDNI(dniTF.getText());
            
            for (Patient patient : patients){
                
            if (dniTF.getText().equals(patient.getDni())){
             
            pat=patient;
            Parent root = FXMLLoader.load(getClass().getResource("PatientsInformation.fxml"));
            Scene loginScene = new Scene(root);

            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();

            window.setScene(loginScene);
            window.show();
            
            }
            
            else{
                
            Parent root = FXMLLoader.load(getClass().getResource("PatientsInformationError.fxml"));
            Scene loginScene = new Scene(root);

            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();

            window.setScene(loginScene);
            window.show();
            }
             
            }
            
        }
            
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
