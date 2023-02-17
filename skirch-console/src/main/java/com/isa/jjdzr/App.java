package com.isa.jjdzr;

import com.isa.jjdzr.deserializer.JsonDeserializer;
import com.isa.jjdzr.deserializer.Resort;

import javax.naming.Name;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;


public class App {
    public static void main(String[] args) throws IOException {
        System.out.println("Code crunchers");
        System.out.println();
//      Menu menu = new Menu();
//      menu.menu();
        new SearchFields().Radius();
//        new SearchFields().Region();
//        new SearchFields().Name();

        List<Resort> resorts = JsonDeserializer.deserialize();
        SearchEngine sE = new SearchEngine();

        // wyszukiwanie po nazwie, w miejsce stringa wskoczy to co poda użytkownik
        sE.searchByName("Wieżyca Koszałkowo", resorts);
        // wyszukiwanie po województwie, w miejsce stringa wskoczy to co poda użytkownik
        sE.searchByRegion("śląskie", resorts);
        // wyszukiwanie po kraju, w miejsce stringa wskoczy to co poda użytkownik
        sE.searchByCountry("PL", resorts);
        // wyszukiwanie w promieniu podanych kilometrów od danego punktu,
        // w miejsce dwóch pierwszych parametrów wskakują współrzędne od użytkownika, w trzecią promień wyszukiwania
        sE.searchByCoordinates(54.3785887091789, 18.60158028024147, 400.0, resorts);

    }
}
