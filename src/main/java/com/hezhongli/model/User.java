package com.hezhongli.model;

import java.util.Date;

public class User {
    private int id;
    private String username;
    private String password;
    private String Email;
    private String gander;
    private java.util.Date birthdate;

    //constructor
    public User() {

    }

    //full
    public User(int id, String username, String password, String email, String gander, Date birthdate) {
        this.id = id;
        this.username = username;
        this.password = password;
        Email = email;
        this.gander = gander;
        this.birthdate = birthdate;
    }

    //getter and setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getGander() {
        return gander;
    }

    public void setGander(String gander) {
        this.gander = gander;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }


    //to string
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", Email='" + Email + '\'' +
                ", gander='" + gander + '\'' +
                ", birthdate=" + birthdate +
                '}';
    }
}
