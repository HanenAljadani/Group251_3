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
    String docter;
    Date date;
    int RoomNum;
    int time;

    public Appointment() {
    }

    public Appointment(String docter, Date date, int RoomNum, int time) {
        this.docter = docter;
        this.date = date;
        this.RoomNum = RoomNum;
        this.time = time;
    }

    public String getDocter() {
        return docter;
    }

    public void setDocter(String docter) {
        this.docter = docter;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getRoomNum() {
        return RoomNum;
    }

    public void setRoomNum(int RoomNum) {
        this.RoomNum = RoomNum;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Appointment{" + "docter=" + docter + ", date=" + date + ", RoomNum=" + RoomNum + ", time=" + time + '}';
    }
     
    
}
