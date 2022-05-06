/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg251project;

/**
 *
 * @author 96653
 */
//jamela hadi 
public class Pets {

    String name;
    int age;
    String sex;
    Customer petOwnerId;
     String ill;
     String bloodtype;
    String type;

    public Pets(String name, int age, String sex, Customer petOwnerId, String bloodtype, String type) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.petOwnerId = petOwnerId;
        this.bloodtype = bloodtype;
        this.type = type;
    }

    public void inianimalInfo(String name, String type, String sex, int age, String desc, Customer username) {
        this.petOwnerId = username;
        this.name = name;
        this.type = type;
        this.sex = sex;
        this.age = age;
         
     }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Customer getPetOwnerId() {
        return petOwnerId;
    }

    public void setPetOwnerId(Customer petOwnerId) {
        this.petOwnerId = petOwnerId;
    }

    public String getIll() {
        return ill;
    }

    public void setIll(String ill) {
        this.ill = ill;
    }

    public String getBloodtype() {
        return bloodtype;
    }

    public void setBloodtype(String bloodtype) {
        this.bloodtype = bloodtype;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
