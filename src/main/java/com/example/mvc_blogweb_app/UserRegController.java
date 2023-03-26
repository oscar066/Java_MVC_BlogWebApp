package com.example.mvc_blogweb_app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@Controller
@RequestMapping("/register")
public class UserRegController {

    @Autowired
    private UserRegistrationRepository userRepository;

    @GetMapping
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new UserRegistration());
        return "registration";
    }

    @PostMapping
    public String processRegistrationForm(@Valid UserRegistration user, BindingResult result) {
        if (result.hasErrors()) {
            return "registration";
        }
        userRepository.save(user);
        return "redirect:/login";
    }
}
