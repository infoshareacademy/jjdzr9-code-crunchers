package com.isa.jjdzr.service;

import com.isa.jjdzr.model.ResortExternalDto;
import org.geotools.referencing.GeodeticCalculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SearchEngine {

    public Optional<ResortExternalDto> searchByName(String name) {
        return Database.getListOfResorts()
                .stream()
                .filter(s -> s.getData().getName().equalsIgnoreCase(name))
                .findFirst();
    }

    public List<ResortExternalDto> searchByRegion(String region) {
        return Database.getListOfResorts()
                .stream()
                .filter(s -> s.getData().getRegion().equalsIgnoreCase(region))
                .toList();
    }

    public List<ResortExternalDto> searchByCountry(String country) {
        return Database.getListOfResorts()
                .stream()
                .filter(s -> s.getData().getCountry().equalsIgnoreCase(country))
                .toList();
    }

    public List<ResortExternalDto> searchByCoordinates(Double userLatitude, Double userLongitude, Double radius) {
        GeodeticCalculator calc = new GeodeticCalculator();
        calc.setStartingGeographicPoint(userLongitude, userLatitude);
        Double distanceToResort;
        List<ResortExternalDto> resortExternalDtos = Database.getListOfResorts();
        List<ResortExternalDto> resortExternalDtoInRadii = new ArrayList<>();
        for (int i = 0; i < resortExternalDtos.size(); i++) {
            calc.setDestinationGeographicPoint(resortExternalDtos.get(i).getData().getLocation().getLongitude(),
                    resortExternalDtos.get(i).getData().getLocation().getLatitude());
            distanceToResort = calc.getOrthodromicDistance() / 1000;
            if (distanceToResort <= radius) {
                resortExternalDtoInRadii.add(resortExternalDtos.get(i));
            }
        }
        return resortExternalDtoInRadii;
    }


}
