/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg251project;

import java.util.Date;

/**
 *
 * @author noha
 */
public class Vetenrinary extends User {
    
    double salary;
    int DectorRoom;
    

    public Vetenrinary( int ID,String Fname, String Lname, String Phone, String Email, String DoB, String Password, String username, int DectorRoom ,char gender,double salary) {
        super(Fname, Lname, Phone, Email, DoB, Password, username, ID);
       
        this.gender = gender;
        this.salary = salary;
        this.DectorRoom = DectorRoom;
    }

    public int getDectorID() {
        return ID;
    }

    public void setDectorID(int DectorID) {
        this.ID = DectorID;
    }

    public String getDectorName() {
        return Name;
    }

    public void setDectorName(String DectorName) {
        this.Name = DectorName;
    }

    public int getDectorRoom() {
        return DectorRoom;
    }

    public void setDectorRoom(int DectorRoom) {
        this.DectorRoom = DectorRoom;
    }

    public String getDectorphone() {
        return Phone;
    }

    public void setDectorphone(String Dectorphone) {
        this.Phone = Dectorphone;
    }

    @Override
    public String toString() {
        return "Vetenrinary{" + "Vetenrinary ID=" + ID + ", Vetenrinary Name=" + Name + ", Vetenrinary Room=" + DectorRoom + ", Vetenrinary Phone=" + Phone + '}';
    }
    
   
}
