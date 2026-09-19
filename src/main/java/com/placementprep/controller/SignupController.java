package com.placementprep.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.placementprep.entity.User;
import com.placementprep.repository.UserRepository;

@Controller
public class SignupController {

    @Autowired
    private UserRepository userRepository;

    // Signup page
    @GetMapping("/signup")
    public String signupPage() {
        return "signup";
    }

    // Create Account
    @PostMapping("/signup")
    public String signup(User user) {

        // Email already exists
        if (userRepository.findByEmail(user.getEmail()) != null) {
            return "redirect:/signup";
        }

        // Save user in database
        userRepository.save(user);

        // Redirect to login page
        return "redirect:/";
    }
}