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

    Vetenrinary doctor;
    Date date;
    String time;
    String day;
    boolean valid;
    int appId;

    public Appointment(Vetenrinary doctor, Date date, String time, String day, boolean valid, int appId) {
        this.doctor = doctor;
        this.date = date;
        this.time = time;
        this.day = day;
        this.valid = valid;
        this.appId = appId;
    }

    public int getAppId() {
        return appId;
    }

    public void setAppId(int appId) {
        this.appId = appId;
    }
    public Appointment() {
    }

    public Appointment(Vetenrinary doctor, String day, Date date, String time) {
        this.doctor = doctor;
        this.date = date;
        this.time = time;
        this.valid = true;
        this.day = day;
        this.appId=appId;
    }

    
    
    public void setDoctor(Vetenrinary doctor) {
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


    public void setTime(String time) {
        this.time = time;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public Vetenrinary getDoctor() {
       return this.doctor;
    }
    
@Override
    public String toString() {
        return "Appointment{" + "doctor=" + doctor + ", date=" + date + ", time=" + time + ", valid=" + valid + '}';
    }
}
