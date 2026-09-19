package com.placementprep.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    // Login page open
    @GetMapping("/")
    public String home() {
        return "login";   // login.html open hoga
    }

}