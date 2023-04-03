package com.isa.jjdzr.controller;

import com.isa.jjdzr.service.ResortService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
@RequestMapping("/resorts")
public class ResortController {
    private final ResortService resortService;

    @GetMapping("/by-region")
    public String getByFindRegionForm() {
        return "search-resorts";
    }

    @GetMapping("/by-region/all")
    public String getAllByRegion(String region, Model model) {
        model.addAttribute("resorts", resortService.searchByRegion(region));
        return "search-resorts"; //tutaj ma się mapa wyświetlać
    }
}
