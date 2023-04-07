package com.isa.jjdzr.controller;

import com.isa.jjdzr.service.ResortService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
@RequestMapping("/homepage")
public class HomeController {
    private final ResortService resortService;

    @GetMapping("/hello")
    public String homePage(Model model) {
        return "homepage";
    }
}
