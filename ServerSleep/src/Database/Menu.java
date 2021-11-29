/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Server.Patient;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author gabri
 */

public class Menu {
    private static DBManagerInterface dbm;
    private static Database.DBManagerInterface dbman;
    private static PatientManagerInterface pmi; 
    private static UserManagerInterface umi;
    private static BufferedReader br;
    
    
    public static void main(String[] args) throws IOException, ParseException {
       
        dbman=new DBManager();
        dbman.connect();
        dbman.createTables();
        
        br = new BufferedReader (new InputStreamReader(System.in));
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Hello, type the option you want: 1. Add patient, 2: Todavia no");
        int number = sc.nextInt();
        
        switch(number){
            
            case 1: 
                addPatient();
                break;
        }
        
    }
        public static String takeGender(BufferedReader reader, String text) {
		String gender = " ";
		String answer;
		try {
			do {
				System.out.println(text + "(m/f)");
				answer = reader.readLine();
				switch (answer) {
				case "M":
				case "m":
					gender = "Male";
					break;
				case "F":
				case "f":
					gender = "Female";
					break;
				default:
					System.out.println("The data introduced is NOT correct.");
					System.out.println("Please introduce m in case of Male or f in case of Female");
					System.out.println("Try again.");
					gender = " ";
					break;
				}
			} while (gender.equals(" "));
		} catch (IOException ex) {
			System.out.println("Error reading");
		}
		return gender;
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
             //System.out.println("Type the Date of Birth of the patient in format (dd-mm-yyyy):");
             //String dat = br.readLine();
             //java.util.Date date = new SimpleDateFormat("dd-MM-yyyy").parse(dat);
             //java.sql.Date dob = (java.sql.Date) date;
             System.out.println("Type the DNI of the patient");
             String dni = br.readLine();
             String gender = takeGender(br,"Type the gender of the patient: ");
            
             
             Patient newpat = new Patient(name, lastname, telephone,address,dni, gender);
             pmi.addpatientbyRegister(newpat);
        }
        
    }
    




    

