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
public class User {
    String Name;
    
    String Phone;
    String Email;
    Date DoB;
    String Password;
    String username;
    int ID;
    char gender;

    public User(String Fname, String Lname, String Phone, String Email, Date DoB, String Password, String username, int ID) {
        this.Name = Fname +" "+Lname;
        
        this.Phone = Phone;
        this.Email = Email;
        this.DoB = DoB;
        this.Password = Password;
        this.username = username;
        this.ID = ID;
    }
    
    
    public String getUsername(){
        return username;
    }
    public String getPassword(){
        return Password;
    }
            
    
}
