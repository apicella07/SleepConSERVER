/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.*;
/**
 *
 * @author marin
 */
public class ConnectionClient  {
    
    
    
    public static Patient receivePatient() {
        InputStream is = null;
        ObjectInputStream ois = null;
        ServerSocket serversocket = null;
        Socket socket = null;
        BufferedReader buf = null;
        InputStreamReader ins = null;
        Patient pat = null;
        try {
            serversocket = new ServerSocket(9010); //podrÃ­a poner socket.getPort();
            socket = serversocket.accept();
            is = socket.getInputStream();
            System.out.println("Connection established from the address" + socket.getInetAddress());
            ins = new InputStreamReader(socket.getInputStream());
            buf = new BufferedReader(ins);
            //Tengo que leer: name,lastname,telep,addres,dni y gender
            String line;
            String name, lastname, telephone, address, dni, gender;
            while ((line = buf.readLine()) != null) {
                if (line.toLowerCase().contains("finish")) {
                    System.out.println("Stopping the server.");
                    releaseResources(buf, socket, serversocket);
                    System.exit(0);
                }
                name = line;
                lastname = buf.readLine();
                telephone = buf.readLine();
                address = buf.readLine();
                dni = buf.readLine();
                gender = buf.readLine();
                pat = new Patient(name, lastname, telephone, address, dni, gender);
                System.out.println(pat.toString());
            }
            
        } catch (IOException ex) {
            System.out.println("Not possible to start the server.");
            ex.printStackTrace();
        } finally {
            releaseResources(buf, socket, serversocket);
        }
        return pat;
    }
    
    
    public static Report receiveReport() throws ParseException {
        InputStream is = null;
        ObjectInputStream ois = null;
        ServerSocket serversocket = null;
        Socket socket = null;
        BufferedReader buf = null;
        InputStreamReader ins = null;
        Report rep = null;
        SimpleDateFormat formato=null;
        try {
            serversocket = new ServerSocket(9010); //podrÃ­a poner socket.getPort();
            socket = serversocket.accept();
            is = socket.getInputStream();
            System.out.println("Connection established from the address" + socket.getInetAddress());
            ins = new InputStreamReader(socket.getInputStream());
            buf = new BufferedReader(ins);
            String line;
            String sleepqual,exhaus,average,movement,timeToFall,rest,stayAwake,timesAwake,dreams,worries,todaysMood,doubtsForDoctor;
            Date todaysDate;
            while ((line = buf.readLine()) != null) {
                if (line.toLowerCase().contains("finish")) {
                    System.out.println("Stopping the server.");
                    releaseResources(buf, socket, serversocket);
                    System.exit(0);
                }
                formato= new SimpleDateFormat("dd-MM-yyyy");
                todaysDate=formato.parse(line);
                sleepqual = buf.readLine();
                exhaus = buf.readLine();
                average = buf.readLine();
                movement = buf.readLine();
                timeToFall = buf.readLine();
                rest=buf.readLine();
                stayAwake=buf.readLine();
                timesAwake=buf.readLine();
                dreams=buf.readLine();
                worries=buf.readLine();
                todaysMood=buf.readLine();
                doubtsForDoctor=buf.readLine();
                rep=new Report(todaysDate,sleepqual,exhaus,average,movement,timeToFall,rest,stayAwake,timesAwake,dreams,worries,todaysMood,doubtsForDoctor);
                System.out.println(rep.toString());
            }
            
        } catch (IOException ex) {
            System.out.println("Not possible to start the server.");
            ex.printStackTrace();
        } finally {
            releaseResources(buf, socket, serversocket);
        }
        return rep;
    }
    
    public static EEG receiveEEG() throws ParseException, ClassNotFoundException {
        InputStream is = null;
        ObjectInputStream ois = null;
        ServerSocket serversocket = null;
        Socket socket = null;
        BufferedReader buf = null;
        InputStreamReader ins = null;
        EEG eeg = null;
        SimpleDateFormat formato=null;
        try {
            serversocket = new ServerSocket(9010);
            socket = serversocket.accept();
            is = socket.getInputStream();
            System.out.println("Connection established from the address" + socket.getInetAddress());
            ois=new ObjectInputStream(is);
            Object mensaje;
            formato= new SimpleDateFormat("dd-MM-yyyy");
            Date todaysDate=formato.parse(buf.readLine());
            String dni=buf.readLine();
            mensaje=ois.readObject();
            eeg=new EEG(todaysDate,dni,mensaje);
            System.out.println(eeg.toString());
            
            
        } catch (IOException ex) {
            System.out.println("Not possible to start the server.");
            ex.printStackTrace();
        } finally {
            releaseResources(buf, socket, serversocket);
        }
        return eeg;
    }
    
 

    
    
    
    private static void releaseResources(BufferedReader bu, Socket socket, ServerSocket serverSocket) {

        try {
            bu.close();
        } catch (IOException ex) {
            Logger.getLogger(ConnectionClient.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(ConnectionClient.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            serverSocket.close();
        } catch (IOException ex) {
            Logger.getLogger(ConnectionClient.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}

