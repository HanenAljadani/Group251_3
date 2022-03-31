/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg251project;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author 96653
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
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

        if (number == 1) {
            Register(u,input);
        } else {
            use = Login(u,input);
            if (use == null) {
                System.out.println("The user password or Username is incorrect");
                System.out.println("Please try Again");
            }
        }
        System.out.println("       Choose one of the services:");
        System.out.println("            1.Book an appointment "
                + "            2.Update your appointment ");
        int select = input.nextInt();

        switch (select) {
            case 1:

            case 2:
        }

    }

    public static void Register(ArrayList<User> u, Scanner input ) throws ParseException {

        System.out.println("Please enter all the information");
        System.out.println("--------------------------------");
        System.out.println("----First name: ");
        String Fname = input.next();
        System.out.println("----Last name: ");
        String Lname = input.next();
        System.out.println("----Phone number: ");
        String phone = input.next();
        System.out.println("----Email: ");
        String email = input.next();
        System.out.println("----ID: ");
        int id = input.nextInt();
        System.out.println("----Date of birth in this format(dd/MM/yyyy): ");
        String date = input.next();
        Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(date);
        System.out.println("----User name: ");
        String userName = input.next();
        System.out.println("----Password: ");
        String password = input.next();
        System.out.println("Successfully sign up ");
        User user = new User(Fname, Lname, phone, email, date1, password, userName, id);

        u.add(user);
    }

    //Nora Aloufi : method login search for all system users if the user exist then the system 
    //will return the user's object if not then will return null
    public static User Login(ArrayList<User> u,Scanner input) {
        String username;
        String password;

        
        System.out.println("Enter User name: ");
        username = input.next();
        System.out.println("Enter Password");
        password = input.next();
        for (int i = 0; i < u.size(); i++) {
            if (u.get(i).getPassword().equals(password) && u.get(i).getUsername().equals(username)) {
                return u.get(i);
            }
        }
        return null;
    }
    
   public void OrganizeDocterschedule(){
        
        
    }
  public void GenerateAppointments(){
        
        
    }
    
     
 
}
