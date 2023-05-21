package com.isa.jjdzr.controller;

import com.isa.jjdzr.model.User;
import com.isa.jjdzr.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;


@RequiredArgsConstructor
@Controller
@RequestMapping()
public class HomeController {

    UserService userService;

    @GetMapping("/")
    public String mainPage() {
        return "main-page";
    }

//    @GetMapping("/")
//    public String mainPageForUsers() {
//        return "main-page_login";
//    }




}
