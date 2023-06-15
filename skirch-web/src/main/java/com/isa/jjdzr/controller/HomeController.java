package com.isa.jjdzr.controller;

import com.isa.jjdzr.service.UserServiceCore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@RequiredArgsConstructor
@Controller
@RequestMapping()
public class HomeController {

    UserServiceCore userServiceCore;

    @GetMapping("/")
    public String mainPage() {
        return "main-page";
    }

//    @GetMapping("/")
//    public String mainPageForUsers() {
//        return "main-page_login";
//    }




}
