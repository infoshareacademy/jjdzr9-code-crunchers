package com.isa.jjdzr;

import com.isa.jjdzr.deserializer.JsonDeserializer;
import com.isa.jjdzr.deserializer.Resort;

import java.util.List;

public class Menu {

    private final List<String> options = List.of("1. Wyszukaj ośrodki narciarskie po nazwie", "2. Wyszukaj ośrodki narciarskie w podanej odległości",
            "3. Wyszukaj ośrodki narciarskie po kraju", "4. Wyszukaj ośrodki narciarskie po regionie", "5. Zaloguj", "6. Utwórz użytkownika");

    public void menu() {

        List<Resort> resorts = JsonDeserializer.deserialize();
        SearchEngine searchEngine = new SearchEngine();
        SearchFields searchFields = new SearchFields();
        sleep();
        displayOptions();
        sleep();
        System.out.println();
        System.out.println("Podaj, którą opcję menu wybierasz:");
        int direction = searchFields.menuOptions();
        switch (direction) {
            case 1 -> searchEngine.searchByName(searchFields.name(), resorts);
            case 2 ->
                    searchEngine.searchByCoordinates(searchFields.latitude(), searchFields.longitude(), searchFields.radius(), resorts);
            case 3 -> searchEngine.searchByCountry(searchFields.country(), resorts);
            case 4 -> searchEngine.searchByRegion(searchFields.region(), resorts);
            case 5, 6 -> {
                System.out.println("Obecnie niedostępne");
                searchFields.ifSearchAgain();
            }
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

