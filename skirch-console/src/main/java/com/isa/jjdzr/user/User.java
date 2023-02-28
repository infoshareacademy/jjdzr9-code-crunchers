package com.isa.jjdzr.user;

public class User {

    private final String firstname;
    private final String lastname;
    private final String email;
    //TODO: Tymczasowe rozwiązanie
    private final String password;
    public User(String firstname, String lastname, String email, String password) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
