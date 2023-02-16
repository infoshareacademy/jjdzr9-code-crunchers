package com.isa.jjdzr;

import com.isa.jjdzr.deserializer.Location;
import com.isa.jjdzr.deserializer.Resort;
import org.geotools.referencing.GeodeticCalculator;

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

    public void searchByCountry(String country, List<Resort> resorts) {
        List<Resort> resortsInCountry = resorts
                .stream()
                .filter(s -> s.getData().getCountry().equals(country))
                .collect(Collectors.toList());
        for (int i = 0; i < resortsInCountry.size(); i++) {
            printResort(resortsInCountry.get(i));
            System.out.println();
        }
    }

   public void searchByCoordinates(Double userLatitude, Double userLongitude, Double distance, List<Resort> resorts) {
        GeodeticCalculator calc = new GeodeticCalculator();
        calc.setStartingGeographicPoint(userLongitude, userLatitude);
        Double distanceToResort;
        System.out.println("Ośrodki w promieniu " + distance.shortValue() + " km: ");
        System.out.println();
        for (int i = 0; i < resorts.size(); i++) {
            calc.setDestinationGeographicPoint(resorts.get(i).getData().getLocation().getLongitude(), resorts.get(i).getData().getLocation().getLatitude());
            distanceToResort = calc.getOrthodromicDistance()/1000;
            if (distanceToResort <= distance){
                printResort(resorts.get(i));
                System.out.println("Odległość do ośrodka: " + distanceToResort.shortValue() + " km");
                System.out.println();
            }
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
