package com.isa.jjdzr.model;

import org.hibernate.validator.constraints.UUID;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class User {
//    @NotNull(message = "Pole nie może być puste!")
//    @Size(min=5, max=20, message = "Nazwa użytkownika musi zawierać pomiędzy 5 a 20 znaków.")
    private String username;
//    @NotNull(message = "Pole nie może być puste!")
//    @Pattern(regexp = "^(.+)@(.+)$")
    private String email;
//    @NotNull(message = "Pole nie może być puste!")
//    @Size(min=5, max=20, message = "Hasło musi zawierać pomiędzy 8 a 20 znaków.")
//    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=()])(?=\\\\S+$).{8,20}$", message = "Hasło musi zawierać przynajmniej jedną wielką i jedną mała literę, cyfrę oraz znak specjalny.")
    private String password;
    private String matchingPassword;
//    @UUID
    private int id;

    public User() {
    }

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public User(String username, String email, String password, String matchingPassword) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.matchingPassword = matchingPassword;
    }
    public User(String username, String email, String password, String matchingPassword, int id) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.matchingPassword = matchingPassword;
        this.id = id;
    }


    public int getId(){
        return id;
    }
    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setId(int id){
        this.id = id;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMatchingPassword() {
        return matchingPassword;
    }

    public void setMatchingPassword(String matchingPassword) {
        this.matchingPassword = matchingPassword;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                "name='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}