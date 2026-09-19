package com.placementprep.controller;

import java.io.IOException;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class ResumeController {

    // ==========================
    // Resume Page
    // ==========================
    @GetMapping("/resume")
    public String resumePage(Model model) {

        // Default Overleaf Resume Template
        model.addAttribute(
                "overleafLink",
                "https://www.overleaf.com/latex/templates/jakes-resume/syzfjbzwjncs"
        );

        return "resume";
    }

    // ==========================
    // Resume Builder (Overleaf)
    // ==========================
    @GetMapping("/resumeBuilder")
    public String resumeBuilder(Model model) {

        model.addAttribute(
                "overleafLink",
                "https://www.overleaf.com/latex/templates/jakes-resume/syzfjbzwjncs"
        );

        return "resume";
    }

    // ==========================
    // Resume Analyzer
    // ==========================
    @PostMapping("/analyzeResume")
    public String analyzeResume(
            @RequestParam("resumeFile") MultipartFile file,
            Model model) throws IOException {

        // Resume Builder link again send
        model.addAttribute(
                "overleafLink",
                "https://www.overleaf.com/latex/templates/jakes-resume/syzfjbzwjncs"
        );

        // Empty File Check
        if (file.isEmpty()) {
            model.addAttribute("message", "Please upload a PDF Resume.");
            return "resume";
        }

        // Read PDF
        PDDocument document = Loader.loadPDF(file.getBytes());

        PDFTextStripper stripper = new PDFTextStripper();
        String text = stripper.getText(document);

        document.close();

        text = text.toLowerCase().trim();

        // Debug
        System.out.println("=================================");
        System.out.println("Resume Length : " + text.length());
        System.out.println(text);
        System.out.println("=================================");

        int score = 20;
        StringBuilder missingSkills = new StringBuilder();

        // ========= ATS Skill Detection =========

        if (text.contains("java")) score += 10;
        else missingSkills.append("• Java\n");

        if (text.contains("spring")) score += 10;
        else missingSkills.append("• Spring Boot\n");

        if (text.contains("mysql") || text.contains("sql")) score += 10;
        else missingSkills.append("• SQL / MySQL\n");

        if (text.contains("html")) score += 5;
        else missingSkills.append("• HTML\n");

        if (text.contains("css")) score += 5;
        else missingSkills.append("• CSS\n");

        if (text.contains("javascript")) score += 5;
        else missingSkills.append("• JavaScript\n");

        if (text.contains("react")) score += 5;
        else missingSkills.append("• React\n");

        if (text.contains("project")) score += 15;
        else missingSkills.append("• Projects Section\n");

        if (text.contains("github")) score += 10;
        else missingSkills.append("• GitHub Link\n");

        if (text.contains("internship") || text.contains("experience"))
            score += 10;
        else
            missingSkills.append("• Internship / Experience\n");

        if (text.contains("dsa") || text.contains("leetcode"))
            score += 10;
        else
            missingSkills.append("• DSA / LeetCode\n");

        if (score > 100)
            score = 100;

        // ========= Suggestion =========

        String suggestion;

        if (text.isEmpty()) {
            suggestion =
                    "Your PDF looks like a scanned image PDF. Export your resume as a text-based PDF from Microsoft Word or Overleaf.";
        } else if (score >= 90) {
            suggestion =
                    "Excellent Resume! ATS Friendly. Your resume is ready for placements.";
        } else if (score >= 80) {
            suggestion =
                    "Very Good Resume. Add 1-2 more projects and internship details for a stronger profile.";
        } else if (score >= 60) {
            suggestion =
                    "Good Resume. Add more technical skills, GitHub projects, achievements and DSA profile.";
        } else {
            suggestion =
                    "Resume needs improvement. Add Java, Spring Boot, SQL, React, Projects, GitHub and DSA/LeetCode profile.";
        }

        // ========= Send Data =========

        model.addAttribute("fileName", file.getOriginalFilename());
        model.addAttribute("score", score);
        model.addAttribute("suggestion", suggestion);
        model.addAttribute("missingSkills", missingSkills.toString());

        // Resume Builder Button
        model.addAttribute(
                "overleafLink",
                "https://www.overleaf.com/latex/templates/jakes-resume/syzfjbzwjncs"
        );

        return "resume-result";
    }
}