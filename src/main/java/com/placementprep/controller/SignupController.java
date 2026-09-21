package com.placementprep.controller;

import com.placementprep.entity.User;
import com.placementprep.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SignupController {

    @Autowired
    private UserRepository userRepository;

    // Signup Page
    @GetMapping("/signup")
    public String signupPage() {
        return "signup";
    }

    // Create Account
    @PostMapping("/signup")
    public String createAccount(User user) {

        // Email already exists
        if (userRepository.findByEmail(user.getEmail()) != null) {
            return "redirect:/signup?exists";
        }

        userRepository.save(user);

        // Login page par bhejo
        return "redirect:/";
    }
}