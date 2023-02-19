package com.isa.jjdzr;

import java.io.IOException;


public class App {
    public static void main(String[] args) throws IOException {
        System.out.println(" ------- WITAMY W WYSZUKIWARCE DLA WIELBICIELI BIAŁEGO SZALEŃSTWA!!! ------- ");
        System.out.println();
        Menu menu = new Menu();
        menu.menu();
    }
}
