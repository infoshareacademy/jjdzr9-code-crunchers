package com.isa.jjdzr;

import com.isa.jjdzr.deserializer.JsonDeserializer;
import com.isa.jjdzr.deserializer.Resort;

import javax.naming.Name;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;


public class App {
    public static void main(String[] args) throws IOException {
        System.out.println(" ------- WITAMY W WYSZUKIWARCE DLA WIELBICIELI BIAŁEGO SZALEŃSTWA!!! ------- ");
        System.out.println();
        Menu menu = new Menu();
        menu.menu();
    }
}
