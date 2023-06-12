package com.isa.jjdzr.controller;

import com.isa.jjdzr.dto.UserDto;
import com.isa.jjdzr.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@RequiredArgsConstructor
@Controller
@RequestMapping("/")
public class UserController {
    @Autowired
    private final UserService userService;

    @GetMapping("/login")
    public String userLogin(Model model, UserDto userDto) {
        model.addAttribute("user", userDto);
        UserDto loggedUser = userService.findByEmail(userDto.getEmail());
        // coś tu jeszcze trzeba dopisać
        return "user-login";
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
        model.addAttribute("userDto", userDto);
        userService.saveUser(userDto);
        return "main-page_signed-in";
    }

}
