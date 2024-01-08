package Project1;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Client {
    
    private int Client_Id ;
    private String NameOfClient;
    private int Age;
    private double Height ;
    private double Weight ;
    private String TelephoneNum;
    private int durationOfsubscription;

    public Client()
 {
        
        Client_Id=0;
        NameOfClient="";
        Age=0;
        Height=0 ;
        Weight=0 ;
        TelephoneNum="";
        durationOfsubscription=0;
    }

    public Client(int ID, String name, int age, double H , double W ,String Num , int duration ) 
{
        Client_Id = ID;
        NameOfClient = name;
        Age = age;
        Height = H;
        Weight = W;
        TelephoneNum=Num;
        durationOfsubscription = duration;
}
public Client (Client sports)
{
        Client_Id = sports.Client_Id;
        NameOfClient = sports.NameOfClient;
        Age = sports.Age; 
        Height = sports.Height;
        Weight = sports.Weight ;
        TelephoneNum = sports.TelephoneNum;
        durationOfsubscription = sports.durationOfsubscription;
    }

    public int getClient_Id() {
        return Client_Id;
    }

    public void setClient_Id(int Client_Id) {
        this.Client_Id = Client_Id;
    }

    public String getNameOfClient() {
        return NameOfClient;
    }

    public void setNameOfClient(String NameOfClient) {
        this.NameOfClient = NameOfClient;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int Age) {
        this.Age = Age;
    }

    public double getHeight() {
        return Height;
    }

    public void setHeight(double Height) {
        this.Height = Height;
    }

    public double getWeight() {
        return Weight;
    }

    public void setWeight(double Weight) {
        this.Weight = Weight;
    }

    public String getTelephoneNum() {
        return TelephoneNum;
    }

    public void setTelephoneNum(String TelephoneNum) {
        this.TelephoneNum = TelephoneNum;
    }

    public int getDurationOfsubscription() {
        return durationOfsubscription;
    }

    public void setDurationOfsubscription(int durationOfsubscription) {
        this.durationOfsubscription = durationOfsubscription;
    }


public String toString()


{
      String fit;
fit = "client Information : \n the ID number of client "+Client_Id+"\n Client name: "+NameOfClient
+"\nThe Age of client : "+Age+"\nThe Height "+Height +"\nThe Weight "+Weight +"\n phone Of Number "+TelephoneNum+"\n duration of the subscription "+durationOfsubscription;

     return fit;
        
    }
    
    public void writeSport() throws IOException
{
        FileWriter sport=new FileWriter("Customer.txt",true);
        PrintWriter psport = new PrintWriter(sport);
        psport.print(Client_Id+"\t\t");
        psport.print(NameOfClient+"\t\t");
        psport.print(Age+"\t\t");
        psport.println(Height);
        psport.print(Weight +"\t\t");
        psport.print(TelephoneNum+"\t\t");
        psport.println(durationOfsubscription);

        psport.close();  
    }

    public void showAllClient() throws FileNotFoundException{
        
        System.out.println("\tNameOfClient \tAge\tClient_Id \t Height \t Weight \t TelephoneNum  \t durationOfsubscription");

        File fsport=new File("Customer.txt");
        Scanner rsport=new Scanner(fsport);

        int count=1;
        while(rsport.hasNext()){
            
            String line=rsport.nextLine();
            
            System.out.println(count+"\t"+line);
            count++;
        }
        
        rsport.close();
    }
        
    
    
}

