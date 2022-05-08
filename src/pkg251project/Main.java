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
           AdminMenu(input); 
        }
        }
    }
    //get back to it
    public static void AdminMenu(Scanner input){
        System.out.println(" Welcome back Admin"+user.getName());
        System.out.print("You can generate report ,but first Enter vetenrinary ID : ");
        int ID = input.nextInt();      
        
        User vetenrainary = SearchVetenrinary(ID);
        
        System.out.println("-------------------- Report of "+vetenrainary.getName()+" --------------------");
        System.out.println("   Vetenrainary Information "); 
        System.out.println("Name   : "+ vetenrainary.getName() +   "          ID    : "+vetenrainary.getID());
        System.out.println("Email  : "+ vetenrainary.getEmail() +  "          Phone : "+vetenrainary.getPhone());
        System.out.println("Gender : "+ vetenrainary.getGender() + "          Date of Birth : "+vetenrainary.getDoB());
        
        
        //Print all Appointments of vetenrainary 
        SearchInCustomerAppointment(vetenrainary);
        
        
        
        //Print the time and date of report 
        SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date d = new Date();
        System.out.println("Report of "+vetenrainary.getName()+ " written in "+f.format(d));
        
        
        
    }
     public static void SearchInCustomerAppointment( User Veten) {

        //for loop 
        Appointment[] app = null;
        Pets pet = null;
        int m = 1;
        for (User cust : u) {
            //check if the user is a vetenrinary
            if (cust instanceof Customer) {
                app = ((Customer) cust).getAppArray();
                for(int i = 0 ; i < app.length ; i++){
                    if(app[i].getDoctor() == Veten){
                        pet = app[i].getPet();
                        
                        System.out.println("   " +m+" Appointment");
                        m++;
                        
                        System.out.println("    Customer Information   ");
                        System.out.println("Name   : " + cust.getName()   + "          ID    : " + cust.getID());
                        System.out.println("Email  : " + cust.getEmail()  + "          Phone : " + cust.getPhone());
                        System.out.println("Gender : " + cust.getGender() + "          Date of Birth : " + cust.getDoB());
                        
                        System.out.println("    Pet Information   ");
                        System.out.println("Pet Name : " + pet.getName() + "         Pet Type   : " + pet.getType());
                        System.out.println("Pet Age  : " + pet.getAge()  + "         Pet Gender : " + pet.getSex());
                        System.out.println("Pet Blood Type : "+pet.getBloodtype());
                        
                        System.out.println("    Appointment Information   ");
                        System.out.println("Date and Time  : " + app[i].getDate()   + "          Day    : " + app[i].getDay());
                        System.out.println("--------------------------------------------------------------------------------");
                        
                    }
                }
            }

        }
    }
    public static int CustomerMenu(Scanner input){
        System.out.println("       Welcome Back ");
        while(true){
        System.out.println("       Choose one of the services:");
        System.out.println("            1.Book an appointment\n"
                + "            2.Reschedule your appointment " );
        System.out.println("            3.View prescription ");
        System.out.println("            4.delete an appointment ");
        System.out.println("            5.View record");
         System.out.println("           6.Exit  ");
        int select = input.nextInt();

        switch (select) {
            case 1:
                bookAppointment( input);
                break;

            case 2:
                 UpDateApp( input);
                break;
            case 3:
                 ((Customer)user).printMed();
                break;
            case 4:
               // GenerateAppointments(appointment, user, input);
                   deleteAppointment(input);
                break;
                case 5:
                  viewrecod(input);
               
                  break;
                case 6:
                    return 0;
                   
        }   

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
    //somthing wrong stuck in an infinite loop
    //this method print a menu for available appointments
    public static void appoitmentprint(){
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
    }
    public static void bookAppointment( Scanner input) {
       appoitmentprint();
        //takes the customer's choose
        int number = input.nextInt();
        int id = ((Customer) user).getID();
        //loop to get into the customer's appointments array
        //
        for (int i = 0; i < u.size(); i++) {
            if (id == u.get(i).ID) {
                int index = ((Customer) u.get(i)).Nullappointment();
                //bring back the index to save the appointment in customer file
                //if the index is 0 or greater then assgine the appointment
                if (index >= 0) {
                    //somthing wrong stuck in an infinite loop 
                    System.out.println("Please Enter Information Of Your Pet ");
                    System.out.print("Pet Name :");
                    String name = input.next();
                    System.out.print("Pet Type :");
                    String type = input.next();
                    System.out.print("Pet Age :");
                    int age = input.nextInt();
                    System.out.print("Pet Gender :");
                    String gender = input.next();
                    System.out.print("Pet Blood Type :");
                    String bloodtype = input.next();
                    Pets pet= new Pets(name,age,gender,(Customer) user,bloodtype,type);
                    //
                    appointment.get(number-1).setPet(pet);
                    
                    
                    ((Customer) u.get(i)).setApp(appointment.get(number - 1), index);
                    //mark the appointment booked
                    appointment.get(number - 1).setValid(false);
                    appointment.remove(number -1);
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
   /* public static void GenerateAppointments(ArrayList<Appointment> appointment, User user, Scanner input) {
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
                System.out.println("\n Doctor name   \n" + appointment.get(number - 1).getDoctor().getDectorName() + "\n Doctore ID  \n " + appointment.get(number - 1).getDoctor().getDectorID() + "\n Day   \n" + appointment.get(number - 1).getDay() + "\n Date  \n" + appointment.get(number - 1).getDate());

            }

        }

    }*/

    
    
    
      public static void deleteAppointment(Scanner input) {
        int index=  ((Customer)user).printAppointmentInfo();
                  if(index>=0){
           System.out.println("Enter your appointment number");
           int appnum = input.nextInt();
           Appointment app = ((Customer)user).getApp(appnum-1);
          ((Customer)user).setApp(null, appnum-1);
         appointment.add(app);
        System.out.println("Appointment deleted successfully");  
        
        }
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
            //check if the user is a Customer
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
   
    //needs checking
    public static void UpDateApp( Scanner input) {
        //printing user info
        //create a customer object
        Customer cus = (Customer) user;
       int check= cus.printAppointmentInfo();
       if(check>=0){
        System.out.println("Enter your appointment number");
        int r = input.nextInt();
        Appointment app =cus.getApp(r-1);
       
//           System.out.println("enter your app id");
//         int numapp=input.nextInt();
//             Appointment[] appp = cus.getApp();
//             for (int i=0;i<appp.length;i++){
//                if (appp[i].getAppId()==numapp){
//                    boolean name = appp[i]==null;
//                }
//             }
            appoitmentprint();
            System.out.println("Select your new appointment");
            int number = input.nextInt();
           cus.setApp(appointment.get(number-1), r-1);
           appointment.get(number-1).setValid(false);
           appointment.remove(number-1);
           appointment.add(app);
       }

    }
     public static void viewrecod( Scanner input) {
      System.out.println("      Print All info    ");
     
        System.out.print("You can generate report ,but first Enter vetenrinary ID : ");
        int ID = input.nextInt();      
        
        User vetenrainary = SearchVetenrinary(ID);
        
        System.out.println("-------------------- Report of "+vetenrainary.getName()+" --------------------");
        System.out.println("   Vetenrainary Information "); 
        System.out.println("Name   : "+ vetenrainary.getName() +   "          ID    : "+vetenrainary.getID());
        System.out.println("Email  : "+ vetenrainary.getEmail() +  "          Phone : "+vetenrainary.getPhone());
        System.out.println("Gender : "+ vetenrainary.getGender() );
        
        
        //Print all Appointments of vetenrainary 
        SearchInCustomerAppointment(vetenrainary);
        
        
        
        //Print the time and date of report 
        SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date d = new Date();
        System.out.println("Report of "+vetenrainary.getName()+ " written in "+f.format(d)); 
//        ((Customer)user).setMedication(medicine);
             //Medication medicine = new Medication();
        //((Customer)user).getMedication(medicine);

    
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
                int appid = input.nextInt();
                String day = input.next();
                // System.out.println(day);
                String time = input.next();

                String stringDate = input.next();
                Date date = new SimpleDateFormat("dd/MM").parse(stringDate);
                Appointment appointment1 = new Appointment(vet,  date,day, time,true,appid);
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
