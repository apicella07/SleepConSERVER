/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serversleepapp;

import Database.DBManager;
import Database.DBManagerInterface;
import Database.PatientManagerInterface;
import Server.Patient;
import java.io.BufferedReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author marin
 */
public class Server extends Application {
    private static DBManagerInterface dbm;
    private static Database.DBManagerInterface dbman;
    private static PatientManagerInterface pmi; 
    private static BufferedReader br;
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("GetStarted.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }
    public static void  addPatient() throws IOException, ParseException {
            System.out.println("Type the name of the patient you'll add");
            String name = br.readLine();
            System.out.println("Type the lastname of the patient:");
             String lastname = br.readLine();
             System.out.println("Type the telephone of the patient");
             String telephone = br.readLine();
             System.out.println("Type the address of the patient");
             String address = br.readLine();
             System.out.println("Type the Date of Birth of the patient followed by /");
             String date = br.readLine();
              java.util.Date dateBirth = new SimpleDateFormat().parse(date);
              java.sql.Date dob = (java.sql.Date) dateBirth;
             System.out.println("Type the DNI of the patient");
             String dni = br.readLine();
             System.out.println("Type the gender of the patient: ");
             String gender = br.readLine();
             
             Patient newpat = new Patient(1, name, lastname, telephone,address, dob,dni, gender);
             pmi.addpatientbyRegister(newpat);
        }

    /**
     * @param args the command line arguments
     */
     public static void main(String[] args) throws Exception {
        launch(args);
        
        
        
    }
    
}
