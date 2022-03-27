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


    public Customer(Pets[] pet, Appointment[] app, double Bill, String Fname, String Lname, String Phone, String Email, Date DoB, String Password, String username, int ID) {
        super(Fname, Lname, Phone, Email, DoB, Password, username, ID);
        this.pet = pet;
        this.app = app;
        this.Bill = Bill;
    }

    
    
    public void printAppointmentInfo(){
        if(app.length == 0 ){
          System.out.println("You don't have any appointment");  
        }else{
        System.out.println("You have "+app.length+" appointment");
        for(int i = 0 ; i < app.length; i++  ){
             System.out.println("------  "+(i+1)+" .");
             //here Print all Appointment info from APPOINTMENT CLASS
        }
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

    public Appointment[] getApp() {
        return app;
    }

    public double getBill() {
        return Bill;
    }
    
    public void setPet(Pets[] pet) {
        this.pet = pet;
    }

    public void setApp(Appointment[] app) {
        this.app = app;
    }

    public void setBill(double Bill) {
        this.Bill = Bill;
    }
    
}
