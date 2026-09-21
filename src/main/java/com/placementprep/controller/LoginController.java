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

    @PostMapping("/login")
    public String loginUser(@RequestParam String email,
                            @RequestParam String password,
                            HttpSession session,
                            Model model) {

        // Sirf email se user nikalo
        User user = userRepository.findByEmail(email);

        if (user != null && user.getPassword().equals(password)) {

            session.setAttribute("userId", user.getId());
            session.setAttribute("username", user.getName());

            return "redirect:/dashboard";
        }

        model.addAttribute("error", "Wrong Email or Password!");
        return "login";
    }
}