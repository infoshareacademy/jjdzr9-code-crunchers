package com.isa.jjdzr.controller;

import com.isa.jjdzr.model.SearchQuery;
import com.isa.jjdzr.service.ResortService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
@RequestMapping("/resorts")
public class ResortController {
    private final ResortService resortService;

    @GetMapping("/by-region")
    public String getFindByRegionForm(Model model) {
        model.addAttribute("searchQuery", new SearchQuery());
        return "search-resorts";
    }

    @GetMapping("/by-region/all")
    public String getAllByRegion(@ModelAttribute("searchQuery") SearchQuery searchQuery, Model model) {
        model.addAttribute("resorts", resortService.searchByRegion(searchQuery.getKeyword()));
        return "resorts-list"; //tutaj ma się mapa wyświetlać
    }
}
