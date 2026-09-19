package com.placementprep.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.placementprep.entity.DSAQuestion;
import com.placementprep.repository.DSARepository;

@Controller
public class DSAController {

    private final DSARepository dsaRepository;

    // Constructor Injection
    public DSAController(DSARepository dsaRepository) {
        this.dsaRepository = dsaRepository;
    }

    // ==========================================================
    // DSA Sheet Page with Topic & Difficulty Filters
    // URL Examples:
    // http://localhost:8081/dsa
    // http://localhost:8081/dsa?difficulty=Easy
    // http://localhost:8081/dsa?topic=Arrays
    // http://localhost:8081/dsa?topic=Arrays&difficulty=Medium
    // ==========================================================
    @GetMapping("/dsa")
    public String dsaPage(
            @RequestParam(required = false) String topic,
            @RequestParam(required = false) String difficulty,
            Model model) {

        List<DSAQuestion> questions;

        // ---------- Filter Logic ----------
        if (topic != null && difficulty != null) {
            questions = dsaRepository.findByTopicAndDifficulty(topic, difficulty);

        } else if (topic != null) {
            questions = dsaRepository.findByTopic(topic);

        } else if (difficulty != null) {
            questions = dsaRepository.findByDifficulty(difficulty);

        } else {
            questions = dsaRepository.findAll();
        }

        // ---------- Overall Progress ----------
        List<DSAQuestion> allQuestions = dsaRepository.findAll();

        long completed = allQuestions.stream()
                .filter(DSAQuestion::getCompleted)
                .count();

        int total = allQuestions.size();

        int progress = 0;
        if (total > 0) {
            progress = (int) ((completed * 100) / total);
        }

        // ---------- Send Data to Thymeleaf ----------
        model.addAttribute("questions", questions);
        model.addAttribute("completed", completed);
        model.addAttribute("total", total);
        model.addAttribute("progress", progress);

        // Selected filters (highlight/show current filter)
        model.addAttribute("selectedTopic", topic);
        model.addAttribute("selectedDifficulty", difficulty);

        return "dsa";
    }

    // ==========================================================
    // Mark Question as Completed
    // ==========================================================
    @PostMapping("/completeQuestion")
    public String completeQuestion(@RequestParam Integer id) {

        DSAQuestion question = dsaRepository.findById(id).orElse(null);

        if (question != null && !question.getCompleted()) {
            question.setCompleted(true);
            dsaRepository.save(question);
        }

        return "redirect:/dsa";
    }

    // ==========================================================
    // Reset All DSA Progress
    // ==========================================================
    @PostMapping("/resetDSA")
    public String resetDSA() {

        List<DSAQuestion> questions = dsaRepository.findAll();

        for (DSAQuestion question : questions) {
            question.setCompleted(false);
        }

        dsaRepository.saveAll(questions);

        return "redirect:/dsa";
    }

}