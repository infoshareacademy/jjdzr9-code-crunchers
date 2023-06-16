package com.isa.jjdzr.controller;

import com.isa.jjdzr.constants.SearchAttributesEnum;
import com.isa.jjdzr.dto.ResortExternalDto;
import com.isa.jjdzr.model.SearchAttributes;
import com.isa.jjdzr.service.ResortService;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.util.Strings;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import static com.isa.jjdzr.constants.Endpoints.*;

@RequiredArgsConstructor
@Controller
@RequestMapping("/search")
public class ResortSearchController {
    private final ResortService resortService;

    @GetMapping(BY_REGION_LIST)
    public String getFindByRegionForm(Model model) {
        model.addAttribute("searchAttributes", new SearchAttributes(Strings.EMPTY, SearchAttributesEnum.BY_REGION));
        model.addAttribute("text", "Wpisz region, z którego chcesz wyszukać ośrodki narciarskie:");
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if ((authentication instanceof AnonymousAuthenticationToken)) {
            return "search";
        } else {
            return "search_signed-in";
        }
    }

    @GetMapping("/list")
    public String getResorts(@ModelAttribute("searchAttributes") SearchAttributes searchAttributes, Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        switch (searchAttributes.getAttribute()) {
            case BY_REGION:
                model.addAttribute("resorts", resortService.searchByRegion(searchAttributes.getKeyword()));
                if ((authentication instanceof AnonymousAuthenticationToken)) {
                    return "resorts-list";
                }
                return "resorts-list_signed-in";
            case BY_NAME:
                model.addAttribute("resorts", resortService.searchByName(searchAttributes.getKeyword()));
                if ((authentication instanceof AnonymousAuthenticationToken)) {
                    return "resort";
                }
                return "resort_signed-in";
            case BY_COUNTRY:
                model.addAttribute("resorts", resortService.searchByCountry(searchAttributes.getKeyword()));
                if ((authentication instanceof AnonymousAuthenticationToken)) {
                    return "resorts-list";
                }
                return "resorts-list_signed-in";
            case BY_COORDINATES:
                model.addAttribute("resorts", resortService.searchByCoordinates(searchAttributes.getKeyword()));
                if ((authentication instanceof AnonymousAuthenticationToken)) {
                    return "resorts-list";
                }
                return "resorts-list_signed-in";
            default:    // TODO do wypełnienia @Piotr Olszewski
                return "main-page";
        }
    }

    @GetMapping(BY_NAME_LIST)
    public String searchByName(Model model) {
        model.addAttribute("searchAttributes", new SearchAttributes(Strings.EMPTY, SearchAttributesEnum.BY_NAME));
        model.addAttribute("text", "Podaj nazwę ośrodka:");
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if ((authentication instanceof AnonymousAuthenticationToken)) {
            return "search";
        } else {
            return "search_signed-in";
        }
    }

    @GetMapping(RESORT)
    public String getByName(SearchAttributes searchAttributes, Model model) {
        model.addAttribute("resort", resortService.searchByName(searchAttributes.getKeyword()));
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if ((authentication instanceof AnonymousAuthenticationToken)) {
            return "resort";
        } else {
            return "resort_signed-in";
        }
    }

    @PostMapping("/resort/{id}")
    public String showOneResort(@PathVariable Long id, ResortExternalDto resortExternalDto, Model model){
        resortExternalDto.getData().setId(id);
        System.out.println("----------------------------------");
        System.out.println("resort:" + resortExternalDto);
        System.out.println("----------------------------------");
        model.addAttribute("resort", resortExternalDto);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if ((authentication instanceof AnonymousAuthenticationToken)) {
            return "resort";
        } else {
            return "resort_signed-in";
        }
    }


    @GetMapping(BY_COUNTRY_LIST)
    public String searchByCountry(Model model) {
        model.addAttribute("searchAttributes", new SearchAttributes(Strings.EMPTY, SearchAttributesEnum.BY_COUNTRY));
        model.addAttribute("text", "Wpisz kraj, z którego chcesz wyszukać ośrodki narciarskie:");
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if ((authentication instanceof AnonymousAuthenticationToken)) {
            return "search";
        } else {
            return "search_signed-in";
        }
    }

    @GetMapping(BY_COORDINATES_LIST)
    public String searchByCoordinates(@ModelAttribute("searchQuery") SearchAttributes searchAttributes, Model model) {
        model.addAttribute("searchAttributes", new SearchAttributes(Strings.EMPTY, SearchAttributesEnum.BY_COORDINATES));
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if ((authentication instanceof AnonymousAuthenticationToken)) {
            return "search";
        } else {
            return "search_signed-in";
        }
    }

//    @GetMapping("/resort")
//    public String chooseOneResort(@RequestParam ResortExternalDto resort, Model model) {
//
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        if ((authentication instanceof AnonymousAuthenticationToken)) {
//            return "resort";
//        } else {
//            return "resort_signed-in";
//
//        }
//    }


}







