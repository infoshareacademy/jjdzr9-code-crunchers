package com.isa.jjdzr.service;

import com.isa.jjdzr.model.Resort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ResortService {
    private final SearchEngine searchEngine;

    public List<Resort> searchByRegion(String region) {
        return searchEngine.searchByRegion(region);
    }

    public Optional<Resort> searchByName(String name) {
        return searchEngine.searchByName(name);
    }

    public List<Resort> searchByCountry(String country) {
        return searchEngine.searchByCountry(country);
    }

    public List<Resort> searchByCoordinates(String keyword) {
        return Collections.emptyList();// TODO do wypełnienia @Piotr Olszewski
    }
}
