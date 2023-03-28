package com.isa.jjdzr.controllers;


import com.isa.jjdzr.service.Database;
import com.isa.jjdzr.service.JsonMapper;
import com.isa.jjdzr.service.SearchEngine;

import java.util.List;

public class Menu {

    private final UserController userController = new UserController();
    private final List<String> options = List.of("1. Wyszukaj ośrodki narciarskie po nazwie", "2. Wyszukaj ośrodki narciarskie w podanej odległości",
            "3. Wyszukaj ośrodki narciarskie po kraju", "4. Wyszukaj ośrodki narciarskie po regionie", "5. Zaloguj", "6. Utwórz użytkownika");

    public void menu() {
        SearchEngine searchEngine = new SearchEngine();
        ResortController resortController = new ResortController();
        sleep();
        displayOptions();
        sleep();
        System.out.println();
        System.out.println("Podaj, którą opcję menu wybierasz:");
        int direction = resortController.menuOptions();
        switch (direction) {
            case 1 -> {
                searchEngine.searchByName(resortController.name(), Database.getListOfResorts());
                resortController.ifSearchAgain();
            }
            case 2 -> {
                searchEngine.searchByCoordinates(resortController.latitude(), resortController.longitude(), resortController.radius(), Database.getListOfResorts());
                resortController.ifSearchAgain();
            }
            case 3 -> {
                searchEngine.searchByCountry(resortController.country(), Database.getListOfResorts());
                resortController.ifSearchAgain();
            }
            case 4 -> {
                searchEngine.searchByRegion(resortController.region(), Database.getListOfResorts());
                resortController.ifSearchAgain();
            }
            case 5 -> {
                System.out.println("Obecnie niedostępne");
                resortController.ifSearchAgain();
            }
            case 6 -> {
                userController.createUser();
            }
        }
        System.out.flush();
    }

    public void displayOptions() {
        options.forEach(options -> System.out.println(options));
    }

    private void sleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

