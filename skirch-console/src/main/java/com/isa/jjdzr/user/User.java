package com.isa.jjdzr.user;

public class User {
    private final String firstname;
    private final String lastname;
    private final String email;
    private final String username;
    //TODO: Tymczasowe rozwiązanie
    private final String password;
    public User(String firstname, String lastname, String email, String username, String password) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.username = username;
        this.password = password;
        UserService userService = new UserService();
        userService.saveUser(this);
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
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
}
