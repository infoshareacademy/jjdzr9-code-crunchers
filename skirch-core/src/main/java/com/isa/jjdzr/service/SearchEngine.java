package com.isa.jjdzr.service;

import com.isa.jjdzr.model.Resort;
import org.geotools.referencing.GeodeticCalculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SearchEngine {

    public Optional<Resort> searchByName(String name) {
        return Database.getListOfResorts()
                .stream()
                .filter(s -> s.getData().getName().equalsIgnoreCase(name))
                .findFirst();
    }

    public List<Resort> searchByRegion(String region) {
        return Database.getListOfResorts()
                .stream()
                .filter(s -> s.getData().getRegion().equalsIgnoreCase(region))
                .toList();
    }

    public List<Resort> searchByCountry(String country) {
        return Database.getListOfResorts()
                .stream()
                .filter(s -> s.getData().getCountry().equalsIgnoreCase(country))
                .toList();
    }

    public List<Resort> searchByCoordinates(Double userLatitude, Double userLongitude, Double radius) {
        GeodeticCalculator calc = new GeodeticCalculator();
        calc.setStartingGeographicPoint(userLongitude, userLatitude);
        Double distanceToResort;
        List<Resort> resorts = Database.getListOfResorts();
        List<Resort> resortInRadius = new ArrayList<>();
        for (int i = 0; i < resorts.size(); i++) {
            calc.setDestinationGeographicPoint(resorts.get(i).getData().getLocation().getLongitude(),
                    resorts.get(i).getData().getLocation().getLatitude());
            distanceToResort = calc.getOrthodromicDistance() / 1000;
            if (distanceToResort <= radius) {
                resortInRadius.add(resorts.get(i));
            }
        }
        return resortInRadius;
    }


}
