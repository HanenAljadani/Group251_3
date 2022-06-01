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
//test hind
    //test hanen
    //test nora
    static ArrayList<User> u = new ArrayList<User>();
    static ArrayList<Appointment> appointment = new ArrayList<Appointment>();
    static User user;
    static Main m = new Main();
    File file = new File("input.txt");
    File appointmentFile = new File("Appointment.txt");

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException, FileNotFoundException {
        Scanner input = new Scanner(System.in);
        m.readfile();

        while (true) {
            System.out.println("--------------------------------------\n");
            System.out.println("        Welcome to Pet clinic\n");
            System.out.println("--------------------------------------");
            System.out.println("            1.Sign up ");
            System.out.println("            2.Login   ");
            System.out.println("       Please Enter a number:");
            int num = input.nextInt();

            if (num == 1) {

                System.out.println("--------------------------------");
                System.out.println("Please enter all the information");
                System.out.println("--------------------------------");

                System.out.println("----First name: ");
                String Fname = input.next();
                System.out.println("----Last name: ");
                String Lname = input.next();
                System.out.println("----Gender: ");
                char g = input.next().charAt(0);
                System.out.println("----Phone number: ");
                String phone = input.next();
                System.out.println("----Email: ");
                String email = input.next();;
                System.out.println("----ID: ");
                String id = input.next();
                System.out.println("----Date of birth in this format(dd/MM/yyyy): ");
                String date = input.next();
                Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(date);
                System.out.println("----User name: ");
                String userName = input.next();
                System.out.println("----Password: ");
                String password = input.next();
                String info = Fname + " " + Lname + " " + g + " " + phone + " " + email + " " + id + " " + date + " " + userName + " " + password;
                m.Register(info);

                //continue;
            } else if (num == 2) {
                System.out.print("Enter Username: ");
                String username = input.next();
                System.out.print("Enter Password: ");
                String password = input.next();
                boolean checking = m.Login(username, password);

                if (checking == false) {
                    System.out.println("The user password or Username is incorrect");
                    System.out.println("Please try Again");

                    //continue;
                }
            } else if (num == 3) {
                System.exit(0);
            }
            if (user instanceof Customer) {
                Customer cus = ((Customer) user);
                System.out.println("       Welcome Back ");
                boolean loop = true;
                while (loop) {
                    System.out.println("       Choose one of the services:");
                    System.out.println("            1.Book an appointment\n"
                            + "            2.Reschedule your appointment ");
                    System.out.println("            3.View prescription ");
                    System.out.println("            4.delete an appointment ");
                    System.out.println("            5.View record");
                    System.out.println("            6.Log Out  ");
                    int select = input.nextInt();

                    switch (select) {
                        case 1:
                            appoitmentprint();
                            int choose = input.nextInt();

                            System.out.println("Please Enter Information Of Your Pet ");
                            System.out.print("Pet Name : ");
                            String name = input.next();
                            System.out.print("Pet Type : ");
                            String type = input.next();
                            System.out.print("Pet Age : ");
                            int age = input.nextInt();
                            System.out.print("Pet Gender : ");
                            String gender = input.next();
                            System.out.print("Pet Blood Type : ");
                            String bloodtype = input.next();
                            String line = name + " " + type + " " + age + " " + gender + " " + bloodtype;

                            m.bookAppointment(line, choose - 1, cus.getID());
                            break;

                        case 2:

                            int check = cus.printAppointmentInfo();
                            if (check >= 0) {
                                System.out.print("Select your appointment : ");
                                int r = input.nextInt();

                                appoitmentprint();
                                System.out.print("Select your new appointment : ");
                                int appnum = input.nextInt();
                                m.UpDateApp(r - 1, appnum, cus.getID());
                            }
                            break;
                        case 3:
                            ((Customer) user).printMed();
                            break;
                        case 4:
                            int index = cus.printAppointmentInfo();
                            if (index >= 0) {
                                System.out.print("Select your appointment :  ");
                                int appnum = input.nextInt();

                                m.deleteAppointment(cus.getID(), appnum);
                            }
                            break;

                        case 5:

                            m.viewrecod(cus.getID());
                            break;
                        case 6:
                            loop = false;
                            user = null;
                            break;

                    }

                }
            }
            if (user instanceof Vetenrinary) {
                Vetenrinary vet = ((Vetenrinary) user);
                System.out.println("Welcome back Vetenrinary : " + vet.getDectorName());

                System.out.print("Enter the Customer ID : ");
                int custid = input.nextInt();
                Customer cust = SearchCustomer(custid);
                System.out.println("You can add medicine to : " + cust.getName());
                System.out.print("Write the medicine code (Numbers) : ");
                int code = input.nextInt();
                System.out.print("Write the name of medicine : ");
                String name = input.next();
                System.out.print("Write the price of medicine : ");
                double price = input.nextDouble();
                String info = code + "-" + name + "-" + price;
                m.Vetenrinary(vet.getDectorID(), custid, info);
            }
            if (user instanceof Admin) {

                Admin ad = ((Admin) user);
                System.out.println(" Welcome back Admin : " + ad.getName());
                System.out.println("You can generate report ,but first Enter vetenrinary ID : ");
                int vetid = input.nextInt();

                m.AdminReport(vetid);
            }
        }
    }

    public File getAppointmentFile() {
        return appointmentFile;
    }

    public File getFile() {
        return file;
    }

    public boolean readfile() throws FileNotFoundException, ParseException {

        StartingUp();

        readAppointment(m.getAppointmentFile());
//        //file of medication
        return true;
    }

    //get back to it
    public boolean AdminReport(int ID) {

        User vetenrainary = SearchVetenrinary(ID);
        if (vetenrainary == null) {
            return false;
        } else {
            System.out.println("-------------------- Report of :" + vetenrainary.getName() + " --------------------");
            System.out.println("   Vetenrainary Information ");
            System.out.println("Name   : " + vetenrainary.getName() + "          ID    : " + vetenrainary.getID());
            System.out.println("Email  : " + vetenrainary.getEmail() + "          Phone : " + vetenrainary.getPhone());
            System.out.println("Gender : " + vetenrainary.getGender() + "          Date of Birth : " + vetenrainary.getDoB());

            //Print all Appointments of vetenrainary 
            SearchInCustomerAppointment(vetenrainary);

            //Print the time and date of report 
            SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
            Date d = new Date();
            System.out.println("Report of " + vetenrainary.getName() + " written in " + f.format(d));
            return true;
        }

    }

    public static User SearchAdmin(int id) {

        //for loop 
        for (User vet : u) {
            //check if the user is a vetenrinary
            if (vet instanceof Admin) {
                if (((Admin) vet).getId() == id) {
                    return vet;
                }
            }

        }
        return null;
    }

    public boolean SearchInCustomerAppointment(User Veten) {

        //for loop 
        Appointment[] app = null;
        Pets pet = null;
        int m = 1;
        for (User cust : u) {
            //check if the user is a vetenrinary
            if (cust instanceof Customer) {
                app = ((Customer) cust).getAppArray();
                for (int i = 0; i < app.length; i++) {
                    if (app[i] != null && app[i].getDoctor() == Veten) {
                        pet = app[i].getPet();

                        System.out.println("   " + m + " Appointment");
                        m++;

                        System.out.println("    Customer Information   ");
                        System.out.println("Name   : " + cust.getName() + "          ID    : " + cust.getID());
                        System.out.println("Email  : " + cust.getEmail() + "          Phone : " + cust.getPhone());
                        System.out.println("Gender : " + cust.getGender() + "          Date of Birth : " + cust.getDoB());

                        System.out.println("    Pet Information   ");
                        System.out.println("Pet Name : " + pet.getName() + "         Pet Type   : " + pet.getType());
                        System.out.println("Pet Age  : " + pet.getAge() + "         Pet Gender : " + pet.getSex());
                        System.out.println("Pet Blood Type : " + pet.getBloodtype());

                        System.out.println("    Appointment Information   ");
                        System.out.println("Date and Time  : " + app[i].getDate() + "          Day    : " + app[i].getDay());
                        System.out.println("--------------------------------------------------------------------------------");
                        return true;
                    }
                }
            }

        }
        return false;

    }
//    public  int CustomerMenu(Scanner input,User use) throws FileNotFoundException, ParseException{
//       
//    }

    public boolean Vetenrinary(int vetid, int id, String line) {
        user = SearchVetenrinary(vetid);
        Vetenrinary vet = ((Vetenrinary) user);

        String[] s = line.split("-");

        Customer cust = SearchCustomer(id);
        if (cust == null) {
            System.out.println("Sorry, this customer not found");
            System.out.println("Try Again!");
            return false;
        } else {

            int code = Integer.valueOf(s[0]);

            String name = s[1];

            double price = Double.valueOf(s[2]);

            Medication medicine = new Medication(code, name, price);

            cust.setMedication(medicine);
            System.out.println("------------------------------------------");
            System.out.println(" The Medicine has been added Successfully  ");
            System.out.println("------------------------------------------");
            // System.out.println("Add another Medicine?");

//           if(choose.equalsIgnoreCase("yes")){
//               continue;
//           }else
//               break;
//        }
            return true;

        }
    }

    //somthing wrong stuck in an infinite loop
    //this method print a menu for available appointments
    public static void appoitmentprint() throws FileNotFoundException, ParseException {

        //print statetments
        System.out.println("       - Choose One Of The Available Appointments -     ");
        System.out.println("    Doctor     Day    Time ");
        System.out.println("--------------------------");
        //printing the menu
        for (int i = 0; i < appointment.size(); i++) {
            Appointment app = appointment.get(i);
            Vetenrinary us = app.getDoctor();
            System.out.println(i + 1 + ".     " + us.getDectorID() + "     " + app.getDay() + "     " + app.getDate() + "     " + app.getTime());

        }
    }

    public Boolean bookAppointment(String line, int number, int id) throws FileNotFoundException, ParseException {
        System.out.println(number);
        //takes the customer's choose
        String[] s = line.split(" ");

        //loop to get into the customer's appointments array
        //
        Customer cust = SearchCustomer(id);
        int index = cust.Nullappointment();

        for (int i = 0; i < u.size(); i++) {
            if (id == u.get(i).ID) {

                //bring back the index to save the appointment in customer file
                //if the index is 0 or greater then assgine the appointment
                if (index >= 0) {
                    //somthing wrong stuck in an infinite loop 

                    String name = s[0];

                    String type = s[1];

                    int age = Integer.valueOf(s[2]);

                    String gender = s[3];

                    String bloodtype = s[4];
                    Pets pet = new Pets(name, age, gender, (Customer) user, bloodtype, type);
                    //
                    appointment.get(number).setPet(pet);

                    cust.setApp(appointment.get(number), index);

                    ((Customer) u.get(i)).setApp(appointment.get(number), index);

                    //mark the appointment booked
                    appointment.get(number).setValid(false);

                    System.out.println("------------------------------------------------------------------------------------------------------------------------------");
                    System.out.println("You have successfully Booked an appointment with Vet." + appointment.get(number).getDoctor().getDectorName());
                    System.out.println("The total Bill: " + cust.getBill() + "$");
                    System.out.println("------------------------------------------------------------------------------------------------------------------------------");
                    appointment.remove(number);
                    return true;
                    //if the index is less than 0 that means the customer have 3 appointments 
                    //and can't book more than 3 till the customer goes to one and that appoitment will be deleted
                } else if (index < 0) {
                    System.out.println("------------------------------------------------------------------------------------------------------------------------------");
                    System.out.println("You reached the Limits for booking an appointments");
                    System.out.println("------------------------------------------------------------------------------------------------------------------------------");
                    return false;
                }
                
            }
        }return false;
    }
    
    
 public boolean deleteAppointment(int id, int appnum) {
        user = SearchCustomer(id);
        System.out.println(appnum);
        Appointment app = ((Customer) user).getApp(appnum - 1);
        ((Customer) user).setApp(null, appnum - 1);
        appointment.add(app);
        System.out.println("------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("       - Appointment deleted successfully -");
        System.out.println("------------------------------------------------------------------------------------------------------------------------------");
        return true;

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

    public static Customer SearchCustomer(int id) {

        //for loop 
        for (User cust : u) {
            //check if the user is a Customer
            if (cust instanceof Customer) {
                if (((Customer) cust).getID() == id) {
                    Customer customer = ((Customer) cust);
                    return customer;
                }
            }

        }
        return null;
    }

    //Signing up a new customer
    public boolean Register(String line) throws ParseException, FileNotFoundException {
        //ask customer to fill the required info

        String[] s = line.split(" ");

        String Fname = s[0];

        String Lname = s[1];

        char g = s[2].charAt(0);

        String phone = s[3];

        String email = s[4];

        int id = Integer.valueOf(s[5]);

        String date = s[6];
//        Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(date);

        String userName = s[7];

        String password = s[8];

        System.out.println("Successfully sign up ");
        Customer user = new Customer(Fname, Lname, phone, email, date, password, userName, id, g);
        addCust(user);
        u.add(user);
        this.user = user;

        return true;
    }

    public boolean addCust(Customer cust) throws FileNotFoundException {
        Scanner read = new Scanner(m.getFile());
        //to save all the information from input file
        ArrayList<String> line1 = new ArrayList<>();
        String readline;
        while (read.hasNextLine()) {
            readline = read.nextLine();
            line1.add(readline);
        }
        //print the information again with the new cusotmer info
        PrintWriter P2W = new PrintWriter(file);
        for (int i = 0; i < line1.size(); i++) {
            P2W.println(line1.get(i));
        }
        P2W.println("Add_Customer " + cust.ID + " " + cust.Name + " " + cust.Phone + " " + cust.Email + " " + cust.DoB + " " + cust.username + " " + cust.Password + " " + cust.getGender());
        P2W.close();
        return true;
    }

    // method login search for all system users if the user exist then the system 
    //will return the user's object if not then will return null
    public boolean Login(String username, String password) {

        //search for the user and return it
        for (int i = 0; i < u.size(); i++) {
            if (u.get(i).getPassword().equals(password) && u.get(i).getUsername().equals(username)) {
                this.user = u.get(i);
                return true;
            }
        }
        return false;
    }
    //

    //the checking part needs to be in the menu?
    public boolean UpDateApp(int r, int number, int id) throws FileNotFoundException, ParseException {
        //printing user info
        //create a customer object
        user = SearchCustomer(id);
        Customer cus = ((Customer) user);

//       
//          
        Appointment app = cus.getApp(r);
        Pets pet = app.getPet();
//           
//       
//            
        appointment.get(number - 1).setPet(pet);
        cus.setApp(appointment.get(number - 1), r);
        appointment.get(number - 1).setValid(true);
        appointment.remove(number - 1);
        appointment.add(app);
        System.out.println("------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("       - Your Appointment has been updated Successfully -");
        System.out.println("------------------------------------------------------------------------------------------------------------------------------");
        return true;

    }

    public Boolean viewrecod(int id) {

        user = SearchCustomer(id);

        if (user == null) {
            return false;
        } else {
            Customer cus = ((Customer) user);
            System.out.println("-------------------- Record of " + cus.getName() + " --------------------");
            System.out.println("   Customer Information ");
            System.out.println("Name   : " + cus.getName() + "          ID    : " + cus.getID());
            System.out.println("Email  : " + cus.getEmail() + "          Phone : " + cus.getPhone());
            System.out.println("Gender : " + cus.getGender());
            System.out.println("-------------------- Appointment of " + cus.getName() + " --------------------");
            cus.printAppointmentInfo();
            System.out.println();
            System.out.println("-------------------- Prescription  --------------------");
            cus.printMed();
            System.out.println("");
            return true;
        }

    }

    //read the available appointments from the file and save if in appointments array
    public static void readAppointment(File file1) throws FileNotFoundException, ParseException {
        Scanner input = new Scanner(file1);
        while (input.hasNext()) {
            int id = input.nextInt();
            Vetenrinary vet = (Vetenrinary) SearchVetenrinary(id);
            if (vet == null) {

                int appid = input.nextInt();
                String day = input.next();
                // System.out.println(day);
                String time = input.next();

                String stringDate = input.next();
            } else {
                int appid = input.nextInt();
                String day = input.next();
                // System.out.println(day);
                String time = input.next();

                String stringDate = input.next();
                Date date = new SimpleDateFormat("dd/MM").parse(stringDate);
                Appointment appointment1 = new Appointment(vet, date, time, day, true, appid);
                appointment.add(appointment1);
            }

        }
    }

    //reads and store all the users information from the input file 
    public static void StartingUp() throws FileNotFoundException, ParseException {

        //Scanner to read from the file
        Scanner readfile = new Scanner(m.getFile());
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
                String date = readfile.next();
                String Username = readfile.next();
                String Password = readfile.next();

                char g = readfile.next().charAt(0);
                double sal = readfile.nextDouble();
                // User user = new User(fname,lname,phone,email,date,Password, Username , id );//Extra
                Vetenrinary vet = new Vetenrinary(id, fname, lname, phone, email, date, Password, Username, room, g, sal);

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
                String date = readfile.next();
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
                String date = readfile.next();
                String Password = readfile.next();
                String Username = readfile.next();
                char g = readfile.next().charAt(0);
                User customer = new Customer(fname, lname, phone, email, date, Username, Password, id, g);
                u.add(customer);
            }
        }

    }

}
