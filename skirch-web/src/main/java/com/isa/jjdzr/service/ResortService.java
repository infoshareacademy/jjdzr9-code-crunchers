package com.isa.jjdzr.service;

import com.isa.jjdzr.model.Resort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ResortService {
    private final SearchEngine searchEngine;

    public List<Resort> searchByRegion(String region) {
        return searchEngine.searchByRegion(region);
    }

    public Resort searchByName(String name) {
        return searchEngine.searchByName(name)
                .orElseThrow(() -> new RuntimeException("Resort not found"));
    }

    public List<Resort> searchByCountry(String country) {
        return searchEngine.searchByCountry(country);
    }
}
