package com.placementprep.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.placementprep.entity.User;
import com.placementprep.repository.DSARepository;
import com.placementprep.repository.UserRepository;

@Controller
public class ProfileController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DSARepository dsaRepository;

    @GetMapping("/profile")
    public String profile(Model model) {

        // Temporary: First user ko profile me show karo
        User user = userRepository.findById(1).orElse(null);

        if (user == null) {
            return "redirect:/dashboard";
        }

        // DSA Progress
        long total = dsaRepository.count();

        long completed = dsaRepository.findAll()
                .stream()
                .filter(q -> q.getCompleted())
                .count();

        int dsaProgress = 0;
        if (total > 0) {
            dsaProgress = (int) ((completed * 100) / total);
        }

        // Temporary Scores
        int aptitudeScore = 65;
        int resumeScore = 80;
        int interviewScore = 70;

        int overall = (dsaProgress + aptitudeScore + resumeScore + interviewScore) / 4;

        model.addAttribute("user", user);
        model.addAttribute("dsaProgress", dsaProgress);
        model.addAttribute("aptitudeScore", aptitudeScore);
        model.addAttribute("resumeScore", resumeScore);
        model.addAttribute("interviewScore", interviewScore);
        model.addAttribute("overall", overall);

        return "profile";
    }
}