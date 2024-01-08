
package project1;

import java.util.Scanner; 
import java.io.*;
public class Project1 {


    public static void main(String[] args)throws IOException {
        double price;                          
               
        Scanner scan = new Scanner(System.in);
        Client client = new Client();       
        Sports sports = new Sports();          
        Receipt receipt = new Receipt(client , sports);
     
        System.out.println("welcome to our sports club");
        

        System.out.println("please enter your name: ");
        client.setNameOfClient=scan.nextLine(); 
        System.out.println("please enter your Id: ");
        client.setClient_Id(scan.nextLine());
        
         
        if(!(client.Client_IdCheck(client.getClient_Id()))){
            
        System.out.println("please enter your phone number: ");
        client.setPhone(scan.nextLine());
        
        
        sports.choseSport(); 
        
        
        receipt.setTotal(client, sports);
         
        System.out.println(receipt);
        
        } 
    }   
    }