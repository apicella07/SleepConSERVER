/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serversleepapp;

import Server.Patient;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author 99lorena
 */
public class PatientsInformationController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
        //declaramos botones
            @FXML 
        private Button back;
         
            @FXML
        private TableView <Patient> TablePatient;

            @FXML
        private TableColumn<Patient, Integer> IdCL;

            @FXML
        private TableColumn<Patient, String> NameCL;

            @FXML
        private TableColumn<Patient, String> LastNameCL;

            @FXML
        private TableColumn<Patient, String> TelephoneCL;

            @FXML
        private TableColumn<Patient, String> AddressCL;

            @FXML
        private TableColumn<Patient, Date> DateOfBirthCL;

            @FXML
        private TableColumn<Patient, String> DNICL;   

            @FXML
        private TableColumn<Patient, String> GenderCL;
          
           @FXML
        ObservableList <Patient> patients;
           
            

        
         public void start(Stage primaryStage) throws Exception {

           Parent root = FXMLLoader.load(getClass().getResource("PatientsInformation.fxml"));

           //will load a different xml when the button is pressed 
           //what we are looking forward is when clicking the button of the getstarted scene changes into the following one

           Scene scene = new Scene(root);
  
           primaryStage.setScene(scene);
           primaryStage.show();
           

       }
         
                        @FXML
           public void AniadirPatient (ActionEvent event) throws IOException{
               Patient p= new Patient();
               
               // de alguna forma que se le pase a p el paciente obtenido en AccessInformationController p= paciente encontrado
               
               patients.add(p);
      
               
               
           }
           
           
        /* Si hay muchos patients con el mismo ID (QUE NO DEBERIA SER) se muestran en la tabla con un array list,
           En nuestro caso solo vamos a tener uno, asi que hay que imprimirlo
           
        */
           ArrayList<Patient> patientArrayList = new ArrayList<>();
           
               public ObservableList<Patient> observableList(){
               ObservableList<Patient> patients = FXCollections.observableArrayList();
               patients.addAll(patientArrayList);
               return patients;
                }

            
           
                        @FXML
           public void goBackMenuOptions (ActionEvent event) throws IOException{
               Parent root = FXMLLoader.load(getClass().getResource("MenuOptionsServer.fxml"));

               Scene loginScene = new Scene(root);

               Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();

               window.setScene(loginScene);
               window.show();
           }
    

            
            
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        //PARA INICIALIZAR LAS COLUMNAS 
        
        // Hay que hacer un cast en Patient para que esto este bien al 100%
       
                   
        IdCL.setCellValueFactory(new PropertyValueFactory<Patient, Integer>("Id"));
        NameCL.setCellValueFactory(new PropertyValueFactory<Patient, String>("Name"));
        LastNameCL.setCellValueFactory(new PropertyValueFactory<Patient, String>("Lastname"));
        DateOfBirthCL.setCellValueFactory(new PropertyValueFactory<Patient, Date>("DateOfBirth"));
        TelephoneCL.setCellValueFactory(new PropertyValueFactory<Patient, String>("Lastname"));
        AddressCL.setCellValueFactory(new PropertyValueFactory<Patient, String>("Lastname"));
        DNICL.setCellValueFactory(new PropertyValueFactory<Patient, String>("Lastname"));
        GenderCL.setCellValueFactory(new PropertyValueFactory<Patient, String>("Lastname"));
        TablePatient.setItems(observableList());
    }    
    
}
