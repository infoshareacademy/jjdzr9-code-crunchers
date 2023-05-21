package com.isa.jjdzr.controllers;

import com.isa.jjdzr.model.User;
import com.isa.jjdzr.service.UserService;

import java.util.Scanner;

public class UserController {
    private final Scanner scanner;
    private final UserService userService;

    public UserController() {
        scanner = new Scanner(System.in);
        userService = new UserService();
    }

    public void createUser(){
        System.out.println("Dzień Dobry.");
        System.out.println("Proszę podać dane użytkownika");
        System.out.println("Podaj imię.");
        String username = scanner.nextLine();

        System.out.println("Podaj email.");
        String email = scanner.nextLine();

        System.out.println("Podaj hasło.");
        String password = scanner.nextLine();

        saveUser(username, email, password);
    }

    private void saveUser(String username, String email, String password) {
        User user = new User(username, email, password);
        userService.saveUser(user);
    }
}


