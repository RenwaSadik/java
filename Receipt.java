package Project1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class Receipt {
    
   private Client client; 
   private Sports sports;   
   private double total;    

   
   public Receipt( Client c , Sports s){
       client = c;
       sports = s;
   }

   
   public Client getClient(){
       return client;
   }
   
   
   public Sports getSports(){
      return sports;
   }
   
   
   public void setTotal( Sports sp){
       total =  sp.getPrice();
   }
   
   
   public double getTotal(){
       return total;
   }
   
   
   public String toString(){
       
       return "\t\tYour Receipt Information\n"+
               "\tYour Personal information are\n"+client 
              + sports + "\nThe total price = "+total+"$\n";
       
   }

  
}