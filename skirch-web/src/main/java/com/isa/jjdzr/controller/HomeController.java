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
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RequiredArgsConstructor
@Controller
@RequestMapping("/")
@Slf4j
public class HomeController {

    private final UserServiceCore userServiceCore;
    private final UserDetailsService userDetailsService;

     @RequestMapping(path = "/", method = {RequestMethod.GET, RequestMethod.POST})
    public String mainPage() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if ((authentication instanceof AnonymousAuthenticationToken)) {
            return "main-page";
        } else {
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
        if (bindingResult.hasErrors()) {
            model.addAttribute("userDto", userDto);
            return "user-registration";
        }
        userServiceCore.saveUser(userDto);
        return "redirect:/login";
    }


    @PostMapping("/favorites/{id}")
    public String addToFavorites(@PathVariable Integer id, UserDto userDto, Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        userDto.setEmail(authentication.getName());
        userServiceCore.addToFavorites(id, userDto);
        model.addAttribute("resorts", userServiceCore.getFavorites(userDto));
        return "favorites";
    }

    @GetMapping("/favorites")
    public String showFavorites(UserDto userDto, Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        userDto.setEmail(authentication.getName());
        model.addAttribute("resorts", userServiceCore.getFavorites(userDto));
        return "favorites";
    }

}
