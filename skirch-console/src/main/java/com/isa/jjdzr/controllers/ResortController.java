package com.isa.jjdzr.controllers;

import java.util.Scanner;

public class ResortController {
    public String name() {
        System.out.println("Podaj nazwe ośrodka:");
        Scanner scanner = new Scanner(System.in);
        String name;
        try {
            name = scanner.next();
        } catch (Exception ignored) {
            System.out.println("Podano niepoprawna nazwę");
            return name();
        }
        return name;
    }

    public String country() {
        System.out.println("Podaj kraj:");
        Scanner scanner = new Scanner(System.in);
        String country;
        try {
            country = scanner.next();
        } catch (Exception ignored) {
            System.out.println("Podano niepoprawna nazwę");
            return country();
        }
        return country;
    }

    public String region() {
        System.out.println("Podaj region jaki Cie interesuje:");
        Scanner scanner = new Scanner(System.in);
        String region;
        try {
            region = scanner.next();
        } catch (Exception ignored) {
            System.out.println("Podano niepoprawną nazwę");
            return region();
        }
        return region;
    }

    public Double radius() {
        System.out.println("Podaj w jakiej odległości max wyszukiwać:");
        Scanner scanner = new Scanner(System.in);
        double radius;
        try {
            radius = scanner.nextDouble();
        } catch (Exception ignored) {
            System.out.println("Podaj wartość liczbową");
            return radius();
        }
        return radius;
    }

    public Double latitude() {
        System.out.println("Podaj szerokość geograficzną:");
        Scanner scanner = new Scanner(System.in);
        double userLatitude;
        try {
            userLatitude = scanner.nextDouble();
        } catch (Exception ignored) {
            System.out.println("Podaj wartość liczbową");
            return latitude();
        }
        return userLatitude;
    }

    public Double longitude() {
        System.out.println("Podaj długość geograficzną:");
        Scanner scanner = new Scanner(System.in);
        double userLongitude;
        try {
            userLongitude = scanner.nextDouble();
        } catch (Exception ignored) {
            System.out.println("Podaj wartość liczbową");
            return longitude();
        }
        return userLongitude;
    }

    public int menuOptions() {
        int menuOption = 0;
        boolean isNumberIncorrect = true;
        Scanner scanner = new Scanner(System.in);
        while (isNumberIncorrect) {
            try {
                menuOption = scanner.nextInt();
                if (menuOption > 6 && menuOption <= 0) {
                    System.out.println("Wybierz wśród podanych opcji");
                } else {
                    isNumberIncorrect = false;
                }
            } catch (Exception ignored) {
                System.out.println("Podaj liczbę całkowitą od 1 do 6");
                return menuOptions();
            }
        }
        return menuOption;
    }

    public void ifSearchAgain() {
        Menu menu = new Menu();
        boolean inputIncorrect = true;
        System.out.println("Czy chcesz ponownie wyszukać ośrodek? [T/N]");
        Scanner scanner = new Scanner(System.in);
        while (inputIncorrect) {
            try {
                String userDecision = scanner.nextLine();
                String yes = "T";
                String no = "N";
                if (userDecision.equals(yes)){
                    menu.menu();
                    inputIncorrect = false;
                } else if (userDecision.equals(no)){
                    System.out.println("Dziękujemy za skorzystanie z wyszukiwarki i zapraszamy ponownie! :)");
                    inputIncorrect = false;
                } else {
                    System.out.println("Podane błędne dane.");
                }
            } catch (Exception e) {
                System.out.println("Podane błędne dane.");
            }
        }
    }


}

