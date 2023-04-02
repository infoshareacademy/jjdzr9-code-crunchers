package com.isa.jjdzr.service;

import com.isa.jjdzr.model.Resort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class ResortService {
    private final SearchEngine searchEngine;

    public List<Resort> searchByRegion(String region) {
        return searchEngine.searchByRegion(region);
    }
}
