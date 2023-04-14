package com.isa.jjdzr.utils;

import com.isa.jjdzr.model.Resort;
import org.geotools.referencing.GeodeticCalculator;

import java.util.List;

public class PrinterUtils {

    public void printSearchByRegion(List<Resort> resortsInRegion) {
        for (int i = 0; i < resortsInRegion.size(); i++) {
            printResort(resortsInRegion.get(i));
            System.out.println();
        }
        if (resortsInRegion.size() == 0) {
            System.out.println("Nie znaleziono ośrodka w podanym regionie.");
        }
    }

    public void printSearchByCountry(List<Resort> resortsInCountry) {
        for (int i = 0; i < resortsInCountry.size(); i++) {
            printResort(resortsInCountry.get(i));
            System.out.println();
        }
        if (resortsInCountry.size() == 0) {
            System.out.println("Nie znaleziono ośrodka w podanym kraju.");
        }
    }

    public void printSearchByName(Resort resort) {
        if (resort != null) {
            printResort(resort);
            System.out.println();
        } else {
            System.out.println("Nie odnaleziono ośrodka o podanej nazwie.");
        }
    }

    public void printSearchByCoordinates(List<Resort> resortsByCoordinates, Double radius) {
        GeodeticCalculator calc = new GeodeticCalculator();
        for (int i = 0; i < resortsByCoordinates.size(); i++) {
            calc.setDestinationGeographicPoint(resortsByCoordinates.get(i).getData().getLocation().getLongitude(),
                    resortsByCoordinates.get(i).getData().getLocation().getLatitude());
            Double distanceToResort;
            distanceToResort = calc.getOrthodromicDistance() / 1000;
            printResort(resortsByCoordinates.get(i));
            System.out.println("Odległość do ośrodka: " + distanceToResort.shortValue() + " km");
            System.out.println();
        }
        if (resortsByCoordinates.size() == 0) {
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
