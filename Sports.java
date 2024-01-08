/**
 * the sports class will display the menu of all sports
 * 
 */
package Project1;
import java.io.*;
import java.util.Scanner;

public class Sports {
   
    private String[] sportstype={"","","","",""};
    private double price;
    private int i;

    

    public Sports() {
        i=0;
        this.price=0;

    }
    
    public void choseSport(){
    Scanner scan=new Scanner(System.in);
    int choice;
    
    double totalPrice=0;
    
    
    do{
    System.out.println("\tSports club \n Sport\t time \t price\n"+
            "1-tennis\t 3pm-4pm\t 35$\n2-Swimming\t 4pm-5pm\t 40$\n3-Basketball\t 5pm-6pm"
            +"\t 35$\n4-Yoga\t 6pm-7pm\t 30$\n5-Gymnastics\t 8pm-9pm\t 45$\n"+
            " choose number of sport ypu want\n6-for exit");
    choice=scan.nextInt();
    switch(choice){
        case 1:
            setSportsType("tennis 3pm-4pm");
            totalPrice+=35;
            i++;
            break;
        case 2:
            setSportsType("Swimming 4pm-5pm");
            totalPrice+=40;
            i++;
            break;
        case 3:
            setSportsType("Basketball 5pm-6pm");
            totalPrice+=35;
            i++;
            break;
        case 4:
            setSportsType("Yoga 6pm-7pm");
            totalPrice+=30;
            i++;
            break;
        case 5:
            setSportsType("Gymnastics 8pm-9pm");
            totalPrice+=45;
            i++;
            break;
        default:
            System.out.println("wrong number,Enter number from 1 to 5");
    }
    }while(choice!=6);
    setPrice(totalPrice);
    }
    public void setSportsType(String s){
        for(;i<5;){
        sportstype[i]=s;
        break;
        }    
    }
    
    public String getSportsType(){
          for(i=0; i< sportstype[i].length() ;i++){
             break;
           }   
           return "\n\t"+ sportstype[0] +"\n\t"+ sportstype[1] +"\n\t"+sportstype[2]
                  + "\n\t"+sportstype[3]+"\n\t"+sportstype[4];
    }
     
    
     public void setPrice (double p){     
         price = p;
     }
     
     
    public double getPrice(){
       return price;
    }

    
    public String toString(){
        return  "\nThe sport you choose are : " + getSportsType() 
                +"\n\nThe price of all the events you selected = "+ price +"$";
    }
  
    }