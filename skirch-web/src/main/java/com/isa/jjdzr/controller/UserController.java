package com.isa.jjdzr.controller;

import com.isa.jjdzr.model.User;
import com.isa.jjdzr.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
@RequestMapping("/user")
public class UserController {

    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String userLogin() {
        return "user-login";
    }

    @GetMapping("/registration")
    public String getRegistrationUserForm(Model model) {
        model.addAttribute("user", new User());
        return "user-registration";
    }

    @PostMapping("/registration")
    public String userRegistration(Model model, @ModelAttribute("user") User user) {
        model.addAttribute("user", userService.saveUser(user));
        return "main-page";
    }

//    @PostMapping("/registration")
//    public String createUserAccount(@ModelAttribute("user") @Valid User user, HttpServletRequest request, Errors errors) {
//        try {
//            userService.saveUser(user);
//        } catch (RuntimeException uaeEx) {
//            mav.addObject("message", "An account for that username/email already exists.");
//            return mav;
//        }
//    }
}
