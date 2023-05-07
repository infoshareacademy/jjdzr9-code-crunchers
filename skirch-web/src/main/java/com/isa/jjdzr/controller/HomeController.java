package com.isa.jjdzr.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
@RequestMapping()
public class HomeController {

    @GetMapping("/")
    public String mainPage() {
        return "main-page";
    }

    @GetMapping("/login")
    public String userLogin() {
        return "user-login";
    }

    @GetMapping("/registration")
    public String userRegistration() {
        return "user-registration";
    }


}
