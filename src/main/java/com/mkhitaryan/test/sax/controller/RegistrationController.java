package com.mkhitaryan.test.sax.controller;

import com.mkhitaryan.test.sax.dto.UserDTO;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.context.request.WebRequest;

public class RegistrationController {
    @GetMapping("/user/registration")
    public String showRegistrationForm(WebRequest request, Model model) {
        UserDTO userDto = new UserDTO();
        model.addAttribute("user", userDto);
        return "registration";
    }
}
