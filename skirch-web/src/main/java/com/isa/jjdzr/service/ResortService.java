package com.isa.jjdzr.service;

import com.isa.jjdzr.model.ResortExternalDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ResortService {
    private final SearchEngine searchEngine;

    public List<ResortExternalDto> searchByRegion(String region) {
        return searchEngine.searchByRegion(region);
    }

    public Optional<ResortExternalDto> searchByName(String name) {
        return searchEngine.searchByName(name);
    }

    public List<ResortExternalDto> searchByCountry(String country) {
        return searchEngine.searchByCountry(country);
    }

    public List<ResortExternalDto> searchByCoordinates(String keyword) {
        return Collections.emptyList();// TODO do wypełnienia @Piotr Olszewski
    }
}
