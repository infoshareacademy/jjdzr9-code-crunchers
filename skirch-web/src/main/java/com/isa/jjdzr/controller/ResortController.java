package com.isa.jjdzr.controller;

import com.isa.jjdzr.model.SearchAttributes;
import com.isa.jjdzr.service.ResortService;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import static com.isa.jjdzr.constants.Endpoints.*;

@RequiredArgsConstructor
@Controller
@RequestMapping("/search")
public class ResortController {
    private final ResortService resortService;

    @GetMapping("/by-region")
    public String getFindByRegionForm(Model model) {
        model.addAttribute("searchAttributes", new SearchAttributes(Strings.EMPTY, BY_REGION_LIST));
        return "search";
    }

    @GetMapping(BY_REGION_LIST)
    public String getAllByRegion(@ModelAttribute("searchQuery") SearchAttributes searchAttributes, Model model) {
        model.addAttribute("resorts", resortService.searchByRegion(searchAttributes.getKeyword()));
        return "resorts-list";
    }

    //TODO póki co nie działa, bo w html już jest miejscami podpięty thymeleaf, po dopisaniu controllera jak dla /by-region powinno działać
    @GetMapping("/by-name")
    public String searchByName(Model model) {
        model.addAttribute("searchAttributes", new SearchAttributes(Strings.EMPTY, RESORT));
        return "search";
    }

    @GetMapping(RESORT)
    public String getByName(@ModelAttribute("searchQuery") SearchAttributes searchAttributes, Model model) {
        model.addAttribute("resort", resortService.searchByName(searchAttributes.getKeyword()));
        return "resort";
    }

    //TODO póki co nie działa, bo w html już jest miejscami podpięty thymeleaf, po dopisaniu controllera jak dla /by-region powinno działać
    @GetMapping("/by-country")
    public String searchByCountry(Model model) {
        model.addAttribute("searchAttributes", new SearchAttributes(Strings.EMPTY, BY_COUNTRY_LIST));
        return "search";
    }

    @GetMapping(BY_COUNTRY_LIST)
    public String getAllByCountry(@ModelAttribute("searchQuery") SearchAttributes searchAttributes, Model model) {
        model.addAttribute("resorts", resortService.searchByCountry(searchAttributes.getKeyword()));
        return "resorts-list";
    }

    @GetMapping("/by-coordinates")
    public String searchByCoordinates() {
        return "search";
    }

}
