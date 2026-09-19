package com.placementprep.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class InterviewController {

    // ===============================
    // PAGE 1 : Interview Welcome Page
    // ===============================
    @GetMapping("/interview")
    public String interviewStart(Model model) {

        model.addAttribute("candidateName", "PlacementPrep User");
        model.addAttribute("questions", 5);
        model.addAttribute("duration", "10 Minutes");

        return "interview-start";
    }

    // ===============================
    // PAGE 2 : Interview Questions
    // ===============================
    @GetMapping("/interview/questions")
    public String interviewQuestions() {
        return "interview";
    }

    // ===============================
    // PAGE 3 : Interview Result
    // ===============================
    @PostMapping("/submitInterview")
    public String submitInterview(

            @RequestParam String q1,
            @RequestParam String q2,
            @RequestParam String q3,
            @RequestParam String q4,
            @RequestParam String q5,
            Model model) {

        int score = 0;

        // Convert answers to lowercase
        String ans1 = q1.toLowerCase();
        String ans2 = q2.toLowerCase();
        String ans3 = q3.toLowerCase();
        String ans4 = q4.toLowerCase();
        String ans5 = q5.toLowerCase();

        // ===============================
        // Q1 : Tell me about yourself
        // ===============================
        if (ans1.length() >= 50)
            score += 10;
        if (ans1.contains("java"))
            score += 5;
        if (ans1.contains("student"))
            score += 5;

        // ===============================
        // Q2 : Final Year Project
        // ===============================
        if (ans2.length() >= 60)
            score += 5;
        if (ans2.contains("project"))
            score += 5;
        if (ans2.contains("spring"))
            score += 5;
        if (ans2.contains("mysql") || ans2.contains("sql"))
            score += 5;
        if (ans2.contains("html"))
            score += 2;
        if (ans2.contains("css"))
            score += 2;
        if (ans2.contains("javascript"))
            score += 3;

        // ===============================
        // Q3 : Why do you want to join company
        // ===============================
        if (ans3.length() >= 40)
            score += 5;
        if (ans3.contains("learn"))
            score += 5;
        if (ans3.contains("growth"))
            score += 5;
        if (ans3.contains("career"))
            score += 5;

        // ===============================
        // Q4 : Strengths
        // ===============================
        if (ans4.length() >= 40)
            score += 5;
        if (ans4.contains("team"))
            score += 5;
        if (ans4.contains("problem"))
            score += 5;
        if (ans4.contains("communication"))
            score += 5;

        // ===============================
        // Q5 : Spring Boot
        // ===============================
        if (ans5.length() >= 40)
            score += 5;
        if (ans5.contains("spring boot"))
            score += 5;
        if (ans5.contains("java"))
            score += 5;
        if (ans5.contains("rest"))
            score += 5;
        if (ans5.contains("api"))
            score += 5;

        // Limit score to 100
        if (score > 100) {
            score = 100;
        }

        // ===============================
        // Feedback
        // ===============================
        String feedback;

        if (score >= 80) {
            feedback = "Excellent Interview Performance! You are placement ready.";
        } else if (score >= 60) {
            feedback = "Good Performance. Improve technical explanation and confidence.";
        } else if (score >= 40) {
            feedback = "Average Performance. Add more technical keywords and explain your project clearly.";
        } else {
            feedback = "Need more practice. Give detailed answers with technical keywords.";
        }

        // ===============================
        // Strengths Detected
        // ===============================
        StringBuilder strengths = new StringBuilder();

        if (ans1.contains("java"))
            strengths.append("✔ Java\n");

        if (ans2.contains("spring"))
            strengths.append("✔ Spring Boot\n");

        if (ans2.contains("mysql") || ans2.contains("sql"))
            strengths.append("✔ SQL / MySQL\n");

        if (ans2.contains("html"))
            strengths.append("✔ HTML\n");

        if (ans2.contains("css"))
            strengths.append("✔ CSS\n");

        if (ans2.contains("javascript"))
            strengths.append("✔ JavaScript\n");

        if (ans4.contains("team"))
            strengths.append("✔ Teamwork\n");

        if (ans4.contains("communication"))
            strengths.append("✔ Communication Skills\n");

        if (strengths.length() == 0) {
            strengths.append("No major technical strengths detected.");
        }

        // ===============================
        // Improvement Suggestions
        // ===============================
        StringBuilder improvement = new StringBuilder();

        if (!ans2.contains("project"))
            improvement.append("• Explain your project clearly.\n");

        if (!ans2.contains("spring"))
            improvement.append("• Mention Spring Boot usage in your project.\n");

        if (!ans2.contains("mysql") && !ans2.contains("sql"))
            improvement.append("• Mention SQL / MySQL database.\n");

        if (!ans5.contains("rest"))
            improvement.append("• Explain REST APIs with Spring Boot.\n");

        if (!ans4.contains("communication"))
            improvement.append("• Mention communication skills and teamwork examples.\n");

        if (improvement.length() == 0) {
            improvement.append("Great! Very few improvement areas detected.");
        }

        // ===============================
        // Send Data to Result Page
        // ===============================
        model.addAttribute("score", score);
        model.addAttribute("feedback", feedback);
        model.addAttribute("strengths", strengths.toString());
        model.addAttribute("improvement", improvement.toString());

        return "interview-result";
    }
}