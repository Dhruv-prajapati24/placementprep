package com.placementprep.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.placementprep.entity.User;
import com.placementprep.repository.UserRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    // ================= LOGIN VALIDATION =================
    @PostMapping("/login")
    public String loginUser(@RequestParam String email,
                            @RequestParam String password,
                            HttpSession session,
                            Model model) {

        User user = userRepository.findByEmailAndPassword(email, password);

        if (user != null) {

            // Save user session
            session.setAttribute("userId", user.getId());
            session.setAttribute("username", user.getName());

            // Go to Dashboard
            return "redirect:/dashboard";
        }

        // Wrong Email or Password
        model.addAttribute("error", "Wrong Email or Password!");

        // Stay on Login Page
        return "login";
    }
}