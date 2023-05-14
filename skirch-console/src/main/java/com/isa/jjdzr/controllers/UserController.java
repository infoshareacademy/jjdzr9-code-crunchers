package com.isa.jjdzr.controllers;

import com.isa.jjdzr.model.User;
import com.isa.jjdzr.service.UserService;

import java.util.Scanner;
import java.util.UUID;

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
        String name = scanner.nextLine();

        System.out.println("Podaj email.");
        String email = scanner.nextLine();

        System.out.println("Podaj hasło.");
        String password = scanner.nextLine();

        saveUser(name, email, password);
    }

    private void saveUser(String name, String email, String password) {
        User user = new User(name, email, password, UUID.randomUUID().toString());
        userService.saveUser(user);
    }
}


