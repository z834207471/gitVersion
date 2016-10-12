package com.example.tianan.db;

/**
 * Created by 瑞 on 2016/8/13.
 */
public class User {
    private int phonenum;
    private String email;
    private String password;
    private String name;
    private String type;
    private String are;
    private String adress;
    private String time;
    private String nature;
    private String cus;

    public int getPhonenum() {
        return phonenum;
    }

    public void setPhonenum(int phonenum) {
        this.phonenum = phonenum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAre() {
        return are;
    }

    public void setAre(String are) {
        this.are = are;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature;
    }

    public String getCus() {
        return cus;
    }

    public void setCus(String cus) {
        this.cus = cus;
    }
}
