/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg251project;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author 96653
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       // User[] user ;
       Scanner input = new Scanner(System.in);
        ArrayList<User> u = new ArrayList<User>();
        User use;
        System.out.println("--------------------------------\n\n\n");
        System.out.println("            Welcome to Pet clinic\n\n\n");
        System.out.println("--------------------------------");
        System.out.println("            1.Sign up ");
        System.out.println("            2.Login   ");
        System.out.println("       Please Enter a number:");
        int number = input.nextInt();
        if(number==1)
            System.out.println("Please enter all the information");
        else{
          use =  Login(u);
          if(use==null){
              System.out.println("The user password or Username is incorrect");
              System.out.println("Please try Again");
          }
        }
    }
    
    //Nora Aloufi : method login search for all system users if the user exist then the system 
    //will return the user's object if not then will return null
    public static User Login(ArrayList<User> u){
        String username ;
        String password;
        
        Scanner input = new Scanner(System.in);
        System.out.println("Enter User name: ");
        username = input.next();
        System.out.println("Enter Password");
        password = input.next();
       for(int i = 0;i<u.size();i++){
           if(u.get(i).getPassword().equals(password)&&u.get(i).getUsername().equals(username)){
            return u.get(i);
       }
       }
        return null;
    }
    
}
