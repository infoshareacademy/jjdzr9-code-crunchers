package com.isa.jjdzr.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.stereotype.Controller
@RequestMapping("/homepage")
public class HomeController {
    private final ResortService resortService;

    public HomeController(ResortService resortService) {
        this.resortService = resortService;
    }

    @GetMapping("/hello")
    public String homePage(Model model) {
        model.addAttribute("resort", resortService.resort());
        model.addAttribute("resorts", resortService.resortList());
        return "homepage";
    }
}
