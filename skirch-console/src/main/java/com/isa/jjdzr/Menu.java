package com.isa.jjdzr;


import java.util.Scanner;

public class Menu {

    public void menu() {

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
}

