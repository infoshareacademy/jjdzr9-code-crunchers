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
@RequestMapping("/search")
public class ResortController {
    private final ResortService resortService;

    @GetMapping("/by-region")
    public String getFindByRegionForm(Model model) {
        model.addAttribute("searchQuery", new SearchQuery());
        return "search-region";
    }

    @GetMapping("/by-region/all")
    public String getAllByRegion(@ModelAttribute("searchQuery") SearchQuery searchQuery, Model model) {
        model.addAttribute("resorts", resortService.searchByRegion(searchQuery.getKeyword()));
        return "resorts-list"; //tutaj ma się mapa wyświetlać
    }

    //TODO póki co nie działa, bo w html już jest miejscami podpięty thymeleaf, po dopisaniu controllera jak dla /by-region powinno działać
    @GetMapping("/by-name")
    public String searchByName() {
        return "search-name";
    }

    //TODO póki co nie działa, bo w html już jest miejscami podpięty thymeleaf, po dopisaniu controllera jak dla /by-region powinno działać
    @GetMapping("/by-country")
    public String searchByCountry(Model model) {
        model.addAttribute("searchQuery", new SearchQuery());
        return "search-country";
    }

    @GetMapping("/by-coordinates")
    public String searchByCoordinates() {
        return "search-coordinates";
    }

}
