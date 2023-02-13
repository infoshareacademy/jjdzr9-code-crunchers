package com.isa.jjdzr;

import com.isa.jjdzr.deserializer.Resort;

import java.util.List;
import java.util.stream.Collectors;

public class SearchEngine {

    public void searchByName(String name, List<Resort> resorts) {
        Resort resort = resorts
                .stream()
                .filter(s -> s.getData().getName().equals(name))
                .findFirst()
                .get();
        printResort(resort);
        System.out.println();
    }

    public void searchByRegion(String region, List<Resort> resorts) {
        List<Resort> resortsInRegion = resorts
                .stream()
                .filter(s -> s.getData().getRegion().equals(region))
                .collect(Collectors.toList());
        for (int i = 0; i < resortsInRegion.size(); i++) {
            printResort(resortsInRegion.get(i));
            System.out.println();
        }
    }

    private void printResort(Resort resort) {
        System.out.println("Nazwa: " + resort.getData().getName());
        System.out.println("Kraj, województwo: " + resort.getData().getCountry() + ", " + resort.getData().getRegion());
        System.out.println("Współrzędne geograficzne: " + resort.getData().getLocation().getLatitude() + ", " + resort.getData().getLocation().getLongitude());
        System.out.println("Strona internetowa: " + resort.getData().getHref());
        System.out.println("Liczba działających obecnie wyciągów: " + resort.getData().getLifts().getStats().getOpen().shortValue());
    }

}
