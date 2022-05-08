/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg251project;

import java.util.Date;

/**
 *
 * @author 96653
 */
public class Customer extends User {
    Pets[] pet;
    Appointment[] app;
    double Bill;
    Medication medication;


    public Customer( String Fname, String Lname, String Phone, String Email, Date DoB, String Password, String username, int ID) {
        super(Fname, Lname, Phone, Email, DoB, Password, username, ID);
        app = new Appointment[3];
        this.Bill=0;
        
    }

    public void setMedication(Medication medication) {
        this.medication = medication;
    }

    public void printMed(){
        if(medication==null){
            System.out.println("There's no prescription\n");
            System.out.println("--------------------------------------------\n");
        }else{
        System.out.println("Medication Name: "+medication.getName());
        System.out.println("Medication Code: "+medication.getMedicineCode());
        System.out.println("Medication Price: "+medication.getMedicinePrice());
        }
    }
    
    public int printAppointmentInfo(){
        int i;
        if(app[0] == null ){
          System.out.println("You don't have any appointment");  
          return -1;
        }else{
        System.out.println("Your Appointments");
        for( i = 0 ; i < app.length; i++  ){
            if(app[i]==null)
                break;
             System.out.println("------"+(i+1)+" . "+app[i].appId+" .");
             //here Print all Appointment info from APPOINTMENT CLASS
        }
        return i;
        }
        
    }
    
    public void printPetInfo(){
        if(pet.length == 0 ){
          System.out.println("You don't have any pet");  
        }else{
        System.out.println("You have "+pet.length+" pet");
        for(int i = 0 ; i < pet.length; i++  ){
             System.out.println("------  "+(i+1)+" .");
             //here Print all pet info from  PET CLASS
        }
        }
    }
    
   
    
    public Pets[] getPet() {
        return pet;
    }

    public Appointment getApp(int index) {
        return app[index];
    }
 public Appointment[] getAppArray() {
        return app;
    }
    public double getBill() {
        return Bill;
    }
    
    public void setPet(Pets pet,int index) {
        this.pet[index] = pet;
    }

    public void setApp(Appointment app,int index) {
        this.app[index] = app;
        Bill=100+Bill;
    }

    public void setBill(double Bill) {
        this.Bill = Bill;
    }
    public  int Nullappointment(){
         for(int i=0;i<app.length;i++){
             if(app[i]==null)
                 return i;
         }
         return -1;      
    }
    public  int Nullpet(){
         for(int i=0;i<pet.length;i++){
             if(pet[i]==null)
                 return i;
         }
         return -1;      
    }

}
