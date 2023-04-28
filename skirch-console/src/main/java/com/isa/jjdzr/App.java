package com.isa.jjdzr;

import com.isa.jjdzr.controllers.Menu;
import com.isa.jjdzr.service.LoadDatabase;

import java.io.IOException;


public class App {
    public static void main(String[] args) throws IOException {
        LoadDatabase.loadDatabase();
        System.out.println(" ------- WITAMY W WYSZUKIWARCE DLA WIELBICIELI BIAŁEGO SZALEŃSTWA!!! ------- ");
        System.out.println();
        Menu menu = new Menu();
        menu.menu();
    }
}
