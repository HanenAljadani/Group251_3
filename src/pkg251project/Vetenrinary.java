/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg251project;

/**
 *
 * @author noha
 */
public class Vetenrinary {
    int DectorID;
   String DectorName;
   int DectorRoom;
   String Dectorphone;

    public Vetenrinary() {
    }

    public Vetenrinary(int DectorID, String DectorName, int DectorRoom, String Dectorphone) {
        this.DectorID = DectorID;
        this.DectorName = DectorName;
        this.DectorRoom = DectorRoom;
        this.Dectorphone = Dectorphone;
    }

    public int getDectorID() {
        return DectorID;
    }

    public void setDectorID(int DectorID) {
        this.DectorID = DectorID;
    }

    public String getDectorName() {
        return DectorName;
    }

    public void setDectorName(String DectorName) {
        this.DectorName = DectorName;
    }

    public int getDectorRoom() {
        return DectorRoom;
    }

    public void setDectorRoom(int DectorRoom) {
        this.DectorRoom = DectorRoom;
    }

    public String getDectorphone() {
        return Dectorphone;
    }

    public void setDectorphone(String Dectorphone) {
        this.Dectorphone = Dectorphone;
    }

    @Override
    public String toString() {
        return "Vetenrinary{" + "DectorID=" + DectorID + ", DectorName=" + DectorName + ", DectorRoom=" + DectorRoom + ", Dectorphone=" + Dectorphone + '}';
    }
    
   
}
