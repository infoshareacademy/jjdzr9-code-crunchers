package com.isa.jjdzr.service;

import com.isa.jjdzr.model.Resort;
import org.geotools.referencing.GeodeticCalculator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SearchEngine {

    public void searchByName(String name, List<Resort> resorts) {
        Resort resort = resorts.stream().filter(s -> s.getData().getName().equals(name)).findFirst().orElse(null);
        if (resort != null) {
            printResort(resort);
            System.out.println();
        } else {
            System.out.println("Nie odnaleziono ośrodka o podanej nazwie.");
        }
    }

    public List<Resort> searchByRegion(String region) {
        return Database.getListOfResorts()
                .stream()
                .filter(s -> s.getData().getRegion().equals(region))
                .toList();

    }

    public void searchByCountry(String country, List<Resort> resorts) {
        List<Resort> resortsInCountry = resorts.stream().filter(s -> s.getData().getCountry().equals(country)).collect(Collectors.toList());
        for (int i = 0; i < resortsInCountry.size(); i++) {
            printResort(resortsInCountry.get(i));
            System.out.println();
        }
        if (resortsInCountry.size() == 0) {
            System.out.println("Nie znaleziono ośrodka w podanym kraju.");
        }
    }

    public void searchByCoordinates(Double userLatitude, Double userLongitude, Double radius, List<Resort> resorts) {
        GeodeticCalculator calc = new GeodeticCalculator();
        calc.setStartingGeographicPoint(userLongitude, userLatitude);
        Double distanceToResort;
        List<Resort> resortInRadius = new ArrayList<>();
        System.out.println("Ośrodki w promieniu " + radius.shortValue() + " km: ");
        System.out.println();
        for (int i = 0; i < resorts.size(); i++) {
            calc.setDestinationGeographicPoint(resorts.get(i).getData().getLocation().getLongitude(), resorts.get(i).getData().getLocation().getLatitude());
            distanceToResort = calc.getOrthodromicDistance() / 1000;
            if (distanceToResort <= radius) {
                resortInRadius.add(resorts.get(i));
                printResort(resorts.get(i));
                System.out.println("Odległość do ośrodka: " + distanceToResort.shortValue() + " km");
                System.out.println();
            }
        }
        if (resortInRadius.size() == 0) {
            System.out.println("Brak ośrodków narciarskich w podanym promieniu km.");
        }
    }

    private void printResort(Resort resort) {
        System.out.println("Nazwa: " + resort.getData().getName());
        System.out.println("Kraj, region: " + resort.getData().getCountry() + ", " + resort.getData().getRegion());
        System.out.println("Współrzędne geograficzne: " + resort.getData().getLocation().getLatitude() + ", " + resort.getData().getLocation().getLongitude());
        System.out.println("Strona internetowa: " + resort.getData().getHref());
        System.out.println("Liczba działających obecnie wyciągów: " + resort.getData().getLifts().getStats().getOpen().shortValue());
    }

}
