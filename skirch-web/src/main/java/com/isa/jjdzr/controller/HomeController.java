package com.isa.jjdzr.controller;

import com.isa.jjdzr.dto.UserDto;
import com.isa.jjdzr.security.UserDetailsService;
import com.isa.jjdzr.service.UserServiceCore;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;


@RequiredArgsConstructor
@Controller
@RequestMapping("/")
@Slf4j
public class HomeController {

    private final UserServiceCore userServiceCore;
    private final UserDetailsService userDetailsService;

    @GetMapping("/")
    public String mainPage() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if ((authentication instanceof AnonymousAuthenticationToken)) {
            return "main-page";
        } else {
            return "main-page_signed-in";
        }
    }

    @GetMapping("/login")
    public String getUserLoginForm(Model model, UserDto userDto) {
        model.addAttribute("userDto", userDto);
        System.out.println("=====================================");
        System.out.println("REDIRECT 1");
        return "user-login";
    }

    @PostMapping("/login")
    public String loginUser(Model model, UserDto userDto) {
        model.addAttribute("userDto", userDto);
        System.out.println("=====================================");
        System.out.println("REDIRECT 666");
        userServiceCore.findByEmail(userDto.getEmail());
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if ((authentication instanceof AnonymousAuthenticationToken)) {
            System.out.println("=====================================");
            System.out.println("REDIRECT 2");
            return "user-login";
        } else {
            System.out.println("=====================================");
            System.out.println("REDIRECT 4");
            return "main-page_signed-in";
        }
    }

    @GetMapping("/registration")
    public String getRegistrationUserForm(Model model) {
        model.addAttribute("userDto", new UserDto());
        return "user-registration";
    }

    @PostMapping("/registration")
    public String userRegistration(@Valid UserDto userDto, BindingResult bindingResult, Model model) {
        UserDto savedUser = userServiceCore.saveUser(userDto);
        if (bindingResult.hasErrors()) {
            model.addAttribute("userDto", userDto);
            return "user-registration";
        }
        model.addAttribute("userDto", savedUser);
        return "user-login";
    }

    @PostMapping("/favorite-resorts/{id}")
    public String addToFavorites(@PathVariable Integer id, UserDto userDto) {
        userServiceCore.addToFavorites(id, userDto);
        return "favourites";
    }

}
