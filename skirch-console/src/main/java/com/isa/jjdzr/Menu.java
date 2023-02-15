package com.isa.jjdzr;


import java.util.List;
import java.util.Scanner;

public class Menu {

    private final List<String> options = List.of("1. Wyszukaj po nazwie", "2. Wyszukaj po koordynatach",
            "3. Wyszukaj po kraju", "4. Wyszukaj po regionie", "5. Zaloguj", "6. Utwórz użytkownika");

    public void menu() {
        System.out.println(" ------- WITAMY W WYSZUKIWARCE DLA WIELBICIELI BIAŁEGO SZALEŃSTWA!!! ------- ");
        sleep();
        displayOptions();

        Scanner scanner = new Scanner(System.in);

        int direction = scanner.nextInt();
        switch (direction) {
            case 1 -> System.out.println("1");
            case 2 -> System.out.println("2");
            case 3 -> System.out.println("3");
            case 4 -> System.out.println("4");
            case 5 -> System.out.println("5");
            default -> System.out.println("0!");
        }
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

