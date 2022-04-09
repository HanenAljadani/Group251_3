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
public class Appointment {

    User doctor;
    Date date;
    Date time;
    String day;
    boolean valid;

    public Appointment() {
    }

    public Appointment(User doctor, String day, Date date, Date time) {
        this.doctor = doctor;
        this.date = date;
        this.time = time;
        this.valid = true;
        this.day = day;
    }

    public void setDoctor(User doctor) {
        this.doctor = doctor;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getDay() {
        return day;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    public void setTime(Date time) {
        this.time = time;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public User getDoctor() {
        return doctor;
    }

    public Date getTime() {
        return time;
    }

    public boolean isValid() {
        return valid;
    }

    @Override
    public String toString() {
        return "Appointment{" + "doctor=" + doctor + ", date=" + date + ", time=" + time + ", valid=" + valid + '}';
    }

}
