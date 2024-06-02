package com.pizzacreed.pizzacreed_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthenticationController {

    private static final String HARDCODED_USERNAME = "Mufli";
    private static final String HARDCODED_PASSWORD = "$2a$12$y6cdbznW/blTayF2qko5teKtW0DXDKb6QIx1c4XG1Xmcmn9NkVzjy";

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String login(String username, String password, Model model) {

        if (username.equals(HARDCODED_USERNAME) && passwordEncoder.matches(password, HARDCODED_PASSWORD)) {
            // Authentication successful
            model.addAttribute("username", username);
            return "redirect:/dashboard";
        } else {
            // Authentication failed
            model.addAttribute("error", "Invalid credentials");
            return "login";
        }
    }
}

