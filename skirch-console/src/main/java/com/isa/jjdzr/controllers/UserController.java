package com.isa.jjdzr.controllers;

import com.isa.jjdzr.dto.UserDto;
import com.isa.jjdzr.service.UserService;
import lombok.RequiredArgsConstructor;

import java.util.Scanner;
@RequiredArgsConstructor
public class UserController {
    private final Scanner scanner;
    private final UserService userService;

    public void createUser() {
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
        UserDto userDto = new UserDto(null, name, email, password);
        userService.saveUser(userDto);
    }
}


