package com.isa.jjdzr.controller;

import com.isa.jjdzr.CustomUserDetailsService;
import com.isa.jjdzr.dto.UserDto;
import com.isa.jjdzr.service.UserServiceCore;
import lombok.RequiredArgsConstructor;
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
public class UserController {
    @Autowired
    private final UserServiceCore userServiceCore;
    private final UserService userService;

    private final CustomUserDetailsService customUserDetailsService;

    @GetMapping("/login")
    public String getUserLoginForm(Model model) {
        model.addAttribute("userDto", new UserDto());
        return "user-login";
    }

    @GetMapping("/registration")
    public String getRegistrationUserForm(Model model) {
        model.addAttribute("userDto", new UserDto());
        return "user-registration";
    }

    @PostMapping("/registration")
    public String userRegistration(@Valid UserDto userDto, BindingResult bindingResult, Model model) {
        UserDto savedUser = userService.saveUser(userDto);
        if (bindingResult.hasErrors()) {
            model.addAttribute("userDto", userDto);
            return "user-registration";
        }
        model.addAttribute("userDto", savedUser);
        return "user-login";
    }

    @PostMapping("/favorite-resorts/{id}")
    public String addToFavorites(@PathVariable Integer id) {
        userServiceCore.addToFavorites(id);
        return "main-page_signed-in";
    }

}
