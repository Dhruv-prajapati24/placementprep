package com.placementprep.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.placementprep.entity.Question;
import com.placementprep.entity.QuizResult;
import com.placementprep.entity.User;
import com.placementprep.repository.QuestionRepository;
import com.placementprep.repository.QuizResultRepository;
import com.placementprep.repository.UserRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class DashboardController {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private QuizResultRepository quizResultRepository;

    @Autowired
    private UserRepository userRepository;

    // ================= Dashboard =================
    @GetMapping("/dashboard")
    public String dashboard(HttpSession session, Model model) {

        String username = (String) session.getAttribute("username");

        if (username == null) {
            return "redirect:/";
        }

        model.addAttribute("username", username);

        return "dashboard";
    }

    // ================= Aptitude Page =================
    @GetMapping("/aptitude")
    public String aptitude(HttpSession session, Model model) {

        if (session.getAttribute("userId") == null) {
            return "redirect:/";
        }

        model.addAttribute("questions", questionRepository.findAll());

        return "aptitude";
    }

    // ================= Submit Quiz =================
    @PostMapping("/submitQuiz")
    public String submitQuiz(@RequestParam Map<String, String> answers,
                             HttpSession session,
                             Model model) {

        Integer userId = (Integer) session.getAttribute("userId");

        if (userId == null) {
            return "redirect:/";
        }

        int score = 0;

        for (Question q : questionRepository.findAll()) {

            String userAnswer = answers.get("q" + q.getId());

            if (userAnswer != null &&
                    userAnswer.equals(q.getCorrectAnswer())) {
                score++;
            }
        }

        // Logged-in user
        User user = userRepository.findById(userId).orElse(null);

        if (user != null) {
            QuizResult result = new QuizResult();
            result.setUserEmail(user.getEmail());
            result.setScore(score);
            result.setTotal((int) questionRepository.count());

            quizResultRepository.save(result);

            // Save aptitude score in users table
            int aptitudePercentage = (score * 100) / (int) questionRepository.count();
            user.setAptitudeScore(aptitudePercentage);
            userRepository.save(user);
        }

        model.addAttribute("score", score);
        model.addAttribute("total", questionRepository.count());

        return "result";
    }
}