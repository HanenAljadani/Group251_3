/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg251project;

/**
 *
 * @author hp
 */
public class Medication {
    private int MedicineCode;
    private String Name;
    private double MedicinePrice;

    @Override
    public String toString() {
        return "Medication{" + "MedicineCode=" + MedicineCode + ", Name=" + Name + ", MedicinePrice=" + MedicinePrice + '}';
    }

    public Medication(int MedicineCode, String Name, double MedicinePrice) {
        this.MedicineCode = MedicineCode;
        this.Name = Name;
        this.MedicinePrice = MedicinePrice;
    }

    public int getMedicineCode() {
        return MedicineCode;
    }

    public void setMedicineCode(int MedicineCode) {
        this.MedicineCode = MedicineCode;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public double getMedicinePrice() {
        return MedicinePrice;
    }

    public void setMedicinePrice(double MedicinePrice) {
        this.MedicinePrice = MedicinePrice;
    }
}
