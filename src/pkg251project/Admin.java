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
public class Admin extends User {
    
    double Salary;
    char gender;
    
    public Admin( int ID,String Fname, String Lname, String Phone, String Email, String DoB, String Password, String username,char g,double salary){
        super(Fname, Lname, Phone, Email, DoB, Password, username, ID);
        this.gender = g;
        this.Salary = salary;
                
    }

    public int getId() {
        return ID;
    }

    public void setId(int id) {
        this.ID = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

   

    
}
