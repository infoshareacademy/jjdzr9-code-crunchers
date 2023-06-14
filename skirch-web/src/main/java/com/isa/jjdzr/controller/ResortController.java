package com.isa.jjdzr.controller;

import com.isa.jjdzr.constants.SearchAttributesEnum;
import com.isa.jjdzr.model.SearchAttributes;
import com.isa.jjdzr.service.ResortService;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import static com.isa.jjdzr.constants.Endpoints.RESORT;

@RequiredArgsConstructor
@Controller
@RequestMapping("/search")
public class ResortController {
    private final ResortService resortService;

    @GetMapping("/by-region")
    public String getFindByRegionForm(Model model) {
        model.addAttribute("searchAttributes", new SearchAttributes(Strings.EMPTY, SearchAttributesEnum.BY_REGION));
        return "search";
    }
    @GetMapping("/list")
    public String getResorts(@ModelAttribute("searchAttributes") SearchAttributes searchAttributes, Model model) {
        switch (searchAttributes.getAttribute()) {
            case BY_REGION:
                model.addAttribute("resorts", resortService.searchByRegion(searchAttributes.getKeyword()));
                return "resorts-list";
            case BY_NAME:
                model.addAttribute("resorts", resortService.searchByName(searchAttributes.getKeyword()));
                return "resort";
            case BY_COUNTRY:
                model.addAttribute("resorts", resortService.searchByCountry(searchAttributes.getKeyword()));
                return "resorts-list";
            case BY_COORDINATES:
                model.addAttribute("resorts", resortService.searchByCoordinates(searchAttributes.getKeyword()));
                return "resorts-list";
            default:    // TODO do wypełnienia @Piotr Olszewski
                return "main-page";
        }
    }

    @GetMapping("/by-name")
    public String searchByName(Model model) {
        model.addAttribute("searchAttributes", new SearchAttributes(Strings.EMPTY, SearchAttributesEnum.BY_NAME));
        return "search";
    }

    @GetMapping(RESORT)
    public String getByName(@ModelAttribute("searchQuery") SearchAttributes searchAttributes, Model model) {
        model.addAttribute("resort", resortService.searchByName(searchAttributes.getKeyword()));
        return "resort";
    }

    @GetMapping("/by-country")
    public String searchByCountry(Model model) {
        model.addAttribute("searchAttributes", new SearchAttributes(Strings.EMPTY, SearchAttributesEnum.BY_COUNTRY));
        return "search";
    }


    @GetMapping("/by-coordinates")
    public String searchByCoordinates(@ModelAttribute("searchQuery") SearchAttributes searchAttributes, Model model) {
        model.addAttribute("searchAttributes", new SearchAttributes(Strings.EMPTY, SearchAttributesEnum.BY_COORDINATES));
        return "search";
    }
}
