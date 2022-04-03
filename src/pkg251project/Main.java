/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg251project;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.DateFormat;
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
    public static void main(String[] args) throws ParseException, FileNotFoundException {
        // TODO code application logic here
        
        File file = new File("input.txt");
        File customers = new File("Customer.txt");
        Scanner input = new Scanner(System.in);
        ArrayList<User> u = new ArrayList<User>();
        StartingUp(u,file);
        User use;
        System.out.println("--------------------------------\n\n\n");
        System.out.println("            Welcome to Pet clinic\n\n\n");
        System.out.println("--------------------------------");
        System.out.println("            1.Sign up ");
        System.out.println("            2.Login   ");
        System.out.println("       Please Enter a number:");
        int number = input.nextInt();

        if (number == 1) {
            Register(u, input,file);
        } else if (number == 2) {
            use = Login(u, input);
            if (use == null) {
                System.out.println("The user password or Username is incorrect");
                System.out.println("Please try Again");
                System.exit(0);
            }
        } else {
            System.out.println("incorrect number");
            System.exit(0);
        }
        System.out.println("       Choose one of the services:");
        System.out.println("            1.Book an appointment\n"
                + "            2.Reschedule your appointment ");
        int select = input.nextInt();

        switch (select) {
            case 1:

            case 2:
        }

    }

    public static void Register(ArrayList<User> u, Scanner input,File file) throws ParseException, FileNotFoundException {

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
        Customer user = new Customer(Fname, Lname, phone, email, date1, password, userName, id);

        u.add(user);
       
       PrintWriter P2W = new PrintWriter(file);
       P2W.print("Add_Customer "+id+" "+Fname+" "+Lname+" "+phone+" "+email+" "+date+" "+userName+" "+password);
       P2W.close();
    }

    //Nora Aloufi : method login search for all system users if the user exist then the system 
    //will return the user's object if not then will return null
    public static User Login(ArrayList<User> u, Scanner input) {
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

    public void OrganizeDocterschedule() {

    }

    public void GenerateAppointments() {

    }

    public static void StartingUp(ArrayList<User> u,File file) throws FileNotFoundException, ParseException {
        
        //Scanner to read from the file
        Scanner readfile = new Scanner(file);
        Vetenrinary[] vet = new Vetenrinary[readfile.nextInt()];
        Admin[] admin = new Admin[readfile.nextInt()];
        int count = 0;
        while (readfile.hasNext()) {
            String command = readfile.next();
            if (command.equalsIgnoreCase("Add_VETERINARY")) {
                int id = readfile.nextInt();
                String fname = readfile.next();
                String lname = readfile.next();
                int room = readfile.nextInt();
                String phone = readfile.next();
                String email = readfile.next();
                DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                Date date = dateFormat.parse(readfile.next());
                String Username = readfile.next();
                String Password = readfile.next();
                
                char g = readfile.next().charAt(0);
                double sal = readfile.nextDouble();
                vet[count] = new Vetenrinary(id, fname, lname, phone, email, date, Password, Username, room, g, sal);
                u.add(vet[count]);
                count++;
                if (count == vet.length) {
                    count = 0;
                }
            }
            if (command.equalsIgnoreCase("Add_Admin")) {
                int id = readfile.nextInt();
                String fname = readfile.next();
                String lname = readfile.next();
                String phone = readfile.next();
                String email = readfile.next();
                DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                Date date = dateFormat.parse(readfile.next());
                String Password = readfile.next();
                String Username = readfile.next();
                char g = readfile.next().charAt(0);
                double sal = readfile.nextDouble();
                admin[count]= new Admin(id,fname,lname,phone,email,date,Password,Username,g,sal);
                u.add(admin[count]);
            }
        }

    }

}
