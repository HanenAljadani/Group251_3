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
////array list for all the users

    static ArrayList<User> u = new ArrayList<User>();
   static ArrayList<Appointment> appointment = new ArrayList<Appointment>();
   static User user;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException, FileNotFoundException {

        //File have Vetenrinary data
        File file = new File("input.txt");
        //File to store Customers data 
        File customers = new File("Customer.txt");
        Scanner input = new Scanner(System.in);
        //ArrayLists

        
        //File of appointments 
        StartingUp(file);
        File appointmentFile = new File("Appointment.txt");
        readAppointment(appointmentFile);
//        //file of medication
//        File Medication3File=new File ("Medication.txt");

         user = null;
        while(true){
        System.out.println("--------------------------------------\n");
        System.out.println("        Welcome to Pet clinic\n");
        System.out.println("--------------------------------------");
        System.out.println("            1.Sign up ");
        System.out.println("            2.Login   ");
        System.out.println("            3.Exit  ");
        System.out.println("       Please Enter a number:");
        int number = input.nextInt();

        if (number == 1) {
            user = Register(input, file);
            continue;
        } else if (number == 2) {
            user = Login(input);
            if (user == null) {
                System.out.println("The user password or Username is incorrect");
                System.out.println("Please try Again");
                continue;
                
            }
        }else if (number == 3){
            System.exit(0);
        }
        if(user instanceof Customer){
            CustomerMenu(input);
        }
        if(user instanceof Vetenrinary){
            Vetenrinary(input);
         }
        if(user instanceof Admin){
            
        }
        }
    }
    public static void AdminMenu(){
        System.out.println(" Welcome back Admin");
        System.out.println("Report generation ...");
        //Method of reports 
        
    }
    public static void CustomerMenu(Scanner input){
        System.out.println("       Welcome Back ");
        System.out.println("       Choose one of the services:");
        System.out.println("            1.Book an appointment\n"
                + "            2.Reschedule your appointment \n" );
        System.out.println("            3.View prescription ");
        System.out.println("            4.delete an appointment ");

        int select = input.nextInt();

        switch (select) {
            case 1:
                bookAppointment( input);

            case 2:
                boolean checkCustomerAppointment = checkAppointment(user, u);
            case 3:
                updeteApp( input);

            case 4:
                GenerateAppointments(appointment, user, input);
                case 5:
                   //we need to genreat appointmentnum with math.random and set it to AppID
                  deleteAppointment(input);

        }
    }
    public static void Vetenrinary(Scanner input){
        System.out.println("Welcome back Vetenrinary");
        System.out.println("Enter the Customer ID");
        
        int id = input.nextInt();
        user = SearchCustomer(id);
        if(user == null){
            System.out.println("Sorry, this customer not found");
        }else{
            System.out.println("You can add medicine to "+user.getName());
            System.out.print("Write the medicine code : ");
            int code = input.nextInt();
            System.out.print("Write the name of medicine : ");
            String name = input.next();
            System.out.print("Write the price of medicine : ");
            double price = input.nextDouble();
            
            Medication medicine = new Medication(code, name , price);
            
           ((Customer)user).setMedication(medicine);
           
           System.out.println("Thank you, ");
        } 
        
    }
    
    //this method print a menu for available appointments
    public static void bookAppointment( Scanner input) {
        //print statetments
        System.out.println("       Choose One Of The Available Appointments     ");
        System.out.println("    Doctor     Day    Time ");
        System.out.println("--------------------------");
        //printing the menu
        for (int i = 0; i < appointment.size(); i++) {
            Appointment app = appointment.get(i);
            Vetenrinary us = app.getDoctor();
            System.out.println(i + 1 + ".     " + us.getDectorID() + "     " + app.getDay() + "     " + app.getDate());

        }
        //takes the customer's choose
        int number = input.nextInt();
        int id = ((Customer) user).getID();
        //loop to get into the customer's appointments array
        for (int i = 0; i < u.size(); i++) {
            if (id == u.get(i).ID) {
                int index = ((Customer) u.get(i)).Nullappointment();
                //bring back the index to save the appointment in customer file
                //if the index is 0 or greater then assgine the appointment
                if (index >= 0) {
                    ((Customer) u.get(i)).setApp(appointment.get(number - 1), index);
                    //mark the appointment booked
                    appointment.get(number - 1).setValid(false);
                    System.out.println("You have successfully Booked an appointment with Dr." + appointment.get(number - 1).getDoctor().getDectorName());
                    //if the index is less than 0 that means the customer have 3 appointments 
                    //and can't book more than 3 till the customer goes to one and that appoitment will be deleted
                } else if (index < 0) {
                    System.out.println("You reached the Limits for booking an appointments");
                }
            }

        }

    }

    //might delete
    public static void GenerateAppointments(ArrayList<Appointment> appointment, User user, Scanner input) {
        System.out.println("       Choose One Of The Available Appointments     ");
        System.out.println("    Doctor     Day    Time ");
        System.out.println("--------------------------");
        for (int i = 0; i < appointment.size() - 1; i++) {
            Appointment app = appointment.get(i);
            Vetenrinary us = app.getDoctor();
            System.out.println(i + 1 + ".     " + us.getDectorID() + "     " + app.getDay() + "     " + app.getDate());

        }
        int number = input.nextInt();

        System.out.println("      Print All info    ");
        for (int i = 0; i < appointment.size(); i++) {
            if (i == number) {
                Appointment app = appointment.get(i);

                Vetenrinary us = app.getDoctor();

                System.out.println("user ID" + user.ID);
                System.out.println("User phone" + user.Phone);
                System.out.println("\n Doctor name   \n" + appointment.get(number - 1).getDoctor().getDectorName() + "\n Doctore ID  \n " + appointment.get(number - 1).getDoctor().getDectorID() + "\n Day   \n" + appointment.get(number - 1).getDay() + "\n Date  \n" + appointment.get(number - 1).getDate());;

            }

        }

    }

    //might delete 2
    public static boolean checkAppointment(User user, ArrayList<User> users) {
        return false;
    }
    
      public static boolean deleteAppointment(Scanner input) {
          ((Customer)user).printAppointmentInfo();
                  
           System.out.println("Enter your appointment number");
           int appointmentnum = input.nextInt();
           appointmentnum = (appointmentnum-1);
//          appointmentnum.getAppId();
       for (int i=0;i<appointment.size();i++){
            Appointment app = appointment.get(i);
//         if(((Customer)user).app[i] == appointmentnum)
          appointment.set(i, null);
        System.out.println("Appointment deleted successfully");  
        return true;
        }
           System.out.println("no booked Appointment with that number ");  
        return false;
          
    }

    //search thruogh the main array for veterinary object
    public static User SearchVetenrinary(int id) {

        //for loop 
        for (User vet : u) {
            //check if the user is a vetenrinary
            if (vet instanceof Vetenrinary) {
                if (((Vetenrinary) vet).getDectorID() == id) {
                    return vet;
                }
            }

        }
        return null;
    }
    public static User SearchCustomer(int id) {

        //for loop 
        for (User cust : u) {
            //check if the user is a vetenrinary
            if (cust instanceof Customer) {
                if (((Customer) cust).getID() == id) {
                    return cust;
                }
            }

        }
        return null;
    }
    //Signing up a new customer
    public static Customer Register(Scanner input, File file) throws ParseException, FileNotFoundException {
        //ask customer to fill the required info
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
        Scanner read = new Scanner(file);
        //to save all the information from input file
        ArrayList<String> line = new ArrayList<>();
        String readline;
        while (read.hasNextLine()) {
            readline = read.nextLine();
            line.add(readline);
        }
        //print the information again with the new cusotmer info
        PrintWriter P2W = new PrintWriter(file);
        for (int i = 0; i < line.size(); i++) {
            P2W.println(line.get(i));
        }
        P2W.println("Add_Customer " + id + " " + Fname + " " + Lname + " " + phone + " " + email + " " + date + " " + userName + " " + password);
        P2W.close();
        u.add(user);

        return user;
    }

    // method login search for all system users if the user exist then the system 
    //will return the user's object if not then will return null
    public static User Login(Scanner input) {
        String username;
        String password;
        //ask for login info
        System.out.println("Enter User name: ");
        username = input.next();
        System.out.println("Enter Password");
        password = input.next();
        //search for the user and return it
        for (int i = 0; i < u.size(); i++) {
            if (u.get(i).getPassword().equals(password) && u.get(i).getUsername().equals(username)) {
                return u.get(i);
            }
        }
        return null;
    }
    //
    public void OrganizeDocterschedule() {

    }
    //needs checking
    public static void updeteApp( Scanner input) {
        //printing user info
        System.out.println(user.ID);
        System.out.println(user.Phone);
        //create a customer object
        Customer cus = (Customer) user;
        cus.printAppointmentInfo();
        System.out.println("if you want to updete enter 1\n" + "if not enter 2 ");
        int r = input.nextInt();

        if (r == 1) {
//           System.out.println("enter your app id");
//         int numapp=input.nextInt();
//             Appointment[] appp = cus.getApp();
//             for (int i=0;i<appp.length;i++){
//                if (appp[i].getAppId()==numapp){
//                    boolean name = appp[i]==null;
//                }
//             }
            System.out.println("       Choose One Of The Available Appointments     ");
            System.out.println("    Doctor     Day    Time ");
            System.out.println("--------------------------");

            for (int i = 0; i < appointment.size(); i++) {

                Appointment app = appointment.get(i);
                Vetenrinary us = app.getDoctor();
                System.out.println(i + 1 + ".     " + us.getDectorID() + "     " + app.getDay() + "     " + app.getDate());

            }
            int number = input.nextInt();
            int id = ((Customer) user).getID();
            for (int i = 0; i < u.size(); i++) {
                if (id == u.get(i).ID) {
                    int index = ((Customer) u.get(i)).Nullappointment();
                    if (index >= 0) {
                        ((Customer) u.get(i)).setApp(appointment.get(number - 1), index);
                        appointment.get(number - 1).setValid(false);
                        System.out.println("You have successfully update your appointment with Dr." + appointment.get(number - 1).getDoctor().getDectorName());

                    } else if (index < 0) {
                        System.out.println("You reached the Limits for booking an appointments");
                    }
                }

            }
        } else if (r == 2) {

        }

    }
    //read the available appointments from the file and save if in appointments array
    public static void readAppointment(File file) throws FileNotFoundException, ParseException {
        Scanner input = new Scanner(file);
        while (input.hasNext()) {
            int id = input.nextInt();
            Vetenrinary vet = (Vetenrinary) SearchVetenrinary(id);
            if (vet == null) {
                System.out.println("Vet is null");
            } else {
                String day = input.next();
                // System.out.println(day);
                String time = input.next();

                String stringDate = input.next();
                Date date = new SimpleDateFormat("dd/MM").parse(stringDate);
                Appointment appointment1 = new Appointment(vet, day, date, time);
                appointment.add(appointment1);
            }

        }
    }
    //reads and store all the users information from the input file 
    public static void StartingUp(File file) throws FileNotFoundException, ParseException {

        //Scanner to read from the file
        Scanner readfile = new Scanner(file);
        // Vetenrinary[] vet = new Vetenrinary[readfile.nextInt()];
        // Admin[] admin = new Admin[readfile.nextInt()]; 
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
                // User user = new User(fname,lname,phone,email,date,Password, Username , id );//Extra
                User vet = new Vetenrinary(id, fname, lname, phone, email, date, Password, Username, room, g, sal);
                u.add(vet);
                // u.add(user);//Extra

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
                User admin = new Admin(id, fname, lname, phone, email, date, Password, Username, g, sal);
                u.add(admin);
            }
            if (command.equalsIgnoreCase("Add_Customer")) {
                int id = readfile.nextInt();
                String fname = readfile.next();
                String lname = readfile.next();
                String phone = readfile.next();
                String email = readfile.next();
                DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                Date date = dateFormat.parse(readfile.next());
                String Password = readfile.next();
                String Username = readfile.next();
                User customer = new Customer(fname, lname, phone, email, date, Username, Password, id);
                u.add(customer);
            }
        }

    }

}
