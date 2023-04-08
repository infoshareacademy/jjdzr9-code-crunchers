package com.isa.jjdzr.controllers;

import com.isa.jjdzr.service.SearchEngine;
import com.isa.jjdzr.utils.PrinterUtils;

import java.util.List;

public class Menu {

    private final UserController userController = new UserController();
    private final List<String> options = List.of("1. Wyszukaj ośrodki narciarskie po nazwie", "2. Wyszukaj ośrodki narciarskie w podanej odległości",
            "3. Wyszukaj ośrodki narciarskie po kraju", "4. Wyszukaj ośrodki narciarskie po regionie", "5. Zaloguj", "6. Utwórz użytkownika");

    public void menu() {
        SearchEngine searchEngine = new SearchEngine();
        ResortController resortController = new ResortController();
        PrinterUtils printerUtils = new PrinterUtils();
        sleep();
        displayOptions();
        sleep();
        System.out.println();
        System.out.println("Podaj, którą opcję menu wybierasz:");
        int direction = resortController.menuOptions();
        switch (direction) {
            case 1 -> {
                printerUtils.printSearchByName
                        (searchEngine.searchByName(resortController.name()));
                resortController.ifSearchAgain();
            }
            case 2 -> {
                printerUtils.printSearchByCoordinates
                        (searchEngine.searchByCoordinates
                                (resortController.latitude(),resortController.longitude(),resortController.radius()),
                                resortController.radius());
                resortController.ifSearchAgain();
            }
            case 3 -> {
                printerUtils.printSearchByCountry
                        (searchEngine.searchByCountry(resortController.country()));
                resortController.ifSearchAgain();
            }
            case 4 -> {
                printerUtils.printSearchByRegion
                        (searchEngine.searchByRegion(resortController.region()));
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

