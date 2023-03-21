package com.example.mvc_blogweb_app;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ContactController {

    @GetMapping("/contact")
    public String showContactForm(Model model) {
        model.addAttribute("message", new Message());
        return "contact";
    }

    @PostMapping("/contact")
    public String submitContactForm(@ModelAttribute Message message, Model model) {
        // Here you can write code to process the contact form submission,
        // such as sending an email or storing the message in a database
        model.addAttribute("success", true);
        return "contact";
    }
}

