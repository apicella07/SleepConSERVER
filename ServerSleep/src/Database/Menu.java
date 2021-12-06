/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Server.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.sql.Connection;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author marin
 */
public class Menu {
   private Connection c;
    private static Database.DBManagerInterface dbman;
    private static PatientManagerInterface pmi;
    private static BufferedReader br;
    private  PatientManager pm;
    private static Patient patientUsing = new Patient();
    private static int num,numUsing;
    private static boolean inUse;
    private static boolean logged;
    private static String ipString;
    private static InetAddress ip;

    public static void main(String[] args) throws IOException, ParseException, Exception {
        dbman = new DBManager();
        dbman.connect();
        pmi = dbman.getPatientManager();
      
        br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        
        inUse=false;
        logged=false;
        int max;
        System.out.println("WELCOME TO SLEEP CONTROL MANAGER\n");
        
        while(true){
            searchbyDNI(); //Now variable patientUsing is the patient with this DNI
            System.out.println("What do you want to do?\n"+"1.View patient's EEG history.\n"+"2.View patient's report history.\n"+"3.View patient's personal information"+"4.Receive an EEG of your patient.");
            System.out.println("0. Exit.\n");
            max=4;
            num=requestNumber(max);
            numUsing=num;
            inUse=true;
            
            while(inUse){
                switch(numUsing){
                    case 1:
                        viewEEGHistory(patientUsing.getDni());
                        break;
                    case 2:
                        reportHistory(patientUsing.getDni());
                        break;
                    case 3:
                        System.out.println(patientUsing.toString());
                        break;
                    case 4:
                        //receivePatient();
                        //receiveEEG();
                        break;
                    default:
                        inUse=false;
                        logged=false;  
                        break;
                }
                break; //NO ESTOY SEGURA DE SI ESTE TENGO QUE PONERLO HASTA QUE NO LO PRUEBE
            }
      
            pressEnter();
        }

    }
    

    
    public static void searchbyDNI() throws IOException{
        System.out.println("Type the dni of the patient you want to search" );
        String dniobtained = br.readLine();
        patientUsing = pmi.searchSpecificPatientByDNI(dniobtained);
        System.out.println("The patient is:" +patientUsing.toString());
       
    }
    
       public static void getReport() throws IOException{
         LocalDate data= ui.takeDate(br,"Type the day of the report you want to get like this yyyy-MM-dd");
        java.util.Date repsday = java.sql.Date.valueOf(data);
        
        Report newrepobtained = pmi.getDailyReport(repsday);
        System.out.println("The report is: " +newrepobtained);
    }
       
       public static void reportHistory(String dni){
            ArrayList<Report> reps = new ArrayList<Report>();

          Report newrepo;
          reps = pmi.reportHistory(dni);
          Iterator it = reps.iterator();

          while(it.hasNext()){
              newrepo = (Report) it.next();
              System.out.println(newrepo.toString());
              System.out.println("");
          }
       }
       public static void viewEEGHistory(String dni){
            ArrayList<Signals> eegs = new ArrayList<Signals>();

          Signals neweeg;
          eegs = pmi.viewEEGHistory(dni);
          Iterator it = eegs.iterator();

          while(it.hasNext()){
              neweeg = (Signals) it.next();
              System.out.println(neweeg.toString());
              System.out.println("");
          }
       }
       
      
       public static int requestNumber(int max) {
		// int max is the maximum option that is acceptable
		int num;
		do {

			num = ui.takeInteger(br, "Introduce the number: ");

		} while (ui.CheckOption(num, max));

		return num;
	}
        public static void pressEnter() {
		System.out.println("Press enter to go to the main menu and continue.");
		try {
			String nothing;
			nothing = br.readLine();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

       
}
