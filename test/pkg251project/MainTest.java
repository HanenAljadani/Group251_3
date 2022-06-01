/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg251project;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.Scanner;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 96653
 */
public class MainTest {
    
    public MainTest() {
        
        
    }

    @Test
    public void testMain() throws Exception {
                  
       Main m = new Main();
  
//       assertEquals(true, m.readfile());
    }
//    @Test
//    public void testVetenrinary() throws FileNotFoundException, ParseException {
//          Main m = new Main();
//          String line ="434 med 50.35";
//        assertEquals(true, m.readfile());
//        assertEquals(true, m.Vetenrinary(500,1234,line));
//   }


    @Test
    public void testBookAppointment() throws FileNotFoundException, ParseException {
       Scanner input = new Scanner(System.in);
       Main m = new Main();
       
      assertEquals(true, m.readfile());
       String line = "cat cat 2 F A";
       assertEquals(true,m.bookAppointment(line,2,1234));
    }

//    @Test
//    public void testDeleteAppointment() {
//         Main m = new Main();
//       assertEquals(true, m.deleteAppointment(1234, 1));
//        
//    }

//   @Test
//    public void testRegister() throws Exception {
//    String line= "huda ahmed g 5544433322 huda@gmai.com 0445 16/4/1995 huda huda1234";
//    Main m = new Main();
//    assertEquals(true, m.Register(line));
//   }
////
//   @Test
//    public void testLogin() throws FileNotFoundException, ParseException {
//        Main m = new Main();
//        assertEquals(true, m.readfile());
//        assertEquals(true, m.Login("nora", "nora1234"));
//    }

//    @Test
//    public void testUpDateApp() throws FileNotFoundException, ParseException {
//        Main m = new Main();
//     // assertEquals(true, m.readfile());
//       assertEquals(true, m.UpDateApp(1, 2,1234));
//    }

//    @Test
//    public void testViewrecod() throws FileNotFoundException, ParseException {
//        Main m = new Main();
//        assertEquals(true, m.readfile());
//        assertEquals(true, m.viewrecod(1234));
//    }
    @Test
      public void testAdminReport() throws FileNotFoundException, ParseException{
        Main m = new Main();
        assertEquals(true, m.readfile());
        assertEquals(true, m.AdminReport(500));
       
      }

    
}
