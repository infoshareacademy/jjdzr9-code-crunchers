package com.isa.jjdzr.model;

import java.util.UUID;

public class User {
    private String name;
    private String email;
    private String password;
    private String id;

    public User() {
    }

    public User(String name, String email, String password, String id) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.id = UUID.randomUUID().toString();
    }

    public String getId(){
        return id;
    }
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setId(String id){
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}