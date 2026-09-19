package com.placementprep.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.placementprep.entity.JobApplication;
import com.placementprep.repository.JobApplicationRepository;

@Controller
public class JobController {

    private final JobApplicationRepository jobRepository;

    // Constructor Injection
    public JobController(JobApplicationRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    // ==========================
    // Open Job Recommendation Page
    // ==========================
    @GetMapping("/jobs")
    public String jobPage() {
        return "job";
    }

    // ==========================
    // Analyze Skills & Recommend Jobs
    // ==========================
    @PostMapping("/recommendJobs")
    public String recommendJobs(

            @RequestParam(required = false) String java,
            @RequestParam(required = false) String spring,
            @RequestParam(required = false) String mysql,
            @RequestParam(required = false) String html,
            @RequestParam(required = false) String css,
            @RequestParam(required = false) String javascript,
            @RequestParam(required = false) String react,
            @RequestParam(required = false) String github,
            @RequestParam(required = false) String dsa,

            Model model) {

        List<String> jobs = new ArrayList<>();

        int matchScore = 20;

        if (java != null) matchScore += 10;
        if (spring != null) matchScore += 10;
        if (mysql != null) matchScore += 10;
        if (html != null) matchScore += 8;
        if (css != null) matchScore += 8;
        if (javascript != null) matchScore += 8;
        if (react != null) matchScore += 8;
        if (github != null) matchScore += 8;
        if (dsa != null) matchScore += 10;

        if (matchScore > 100) {
            matchScore = 100;
        }

        // Backend Jobs
        if (java != null && spring != null && mysql != null) {
            jobs.add("Java Spring Boot Developer - Infosys");
            jobs.add("Backend Developer - TCS");
            jobs.add("Java Full Stack Developer - Cognizant");
        }

        // Frontend Jobs
        if (html != null && css != null && javascript != null) {
            jobs.add("Frontend Developer - Wipro");
            jobs.add("Web Developer - Accenture");
        }

        // React Jobs
        if (react != null && javascript != null) {
            jobs.add("React Developer - Capgemini");
            jobs.add("Frontend Engineer - Deloitte");
        }

        // DSA Strong Jobs
        if (dsa != null && java != null) {
            jobs.add("Software Engineer - Amazon");
            jobs.add("Software Engineer - Microsoft");
        }

        // Default Jobs
        if (jobs.isEmpty()) {
            jobs.add("Internship - Java Trainee");
            jobs.add("Graduate Engineer Trainee");
        }

        model.addAttribute("matchScore", matchScore);
        model.addAttribute("jobs", jobs);

        return "job-result";
    }

    // ==========================
    // Apply Job (Save in MySQL)
    // ==========================
    @PostMapping("/applyJob")
    public String applyJob(

            @RequestParam String company,
            @RequestParam String role,
            @RequestParam String location,
            @RequestParam String salary,

            Model model) {

        JobApplication application = new JobApplication();

        application.setCompany(company);
        application.setRole(role);
        application.setLocation(location);
        application.setSalary(salary);

        // Save into MySQL
        jobRepository.save(application);

        model.addAttribute("company", company);
        model.addAttribute("role", role);
        model.addAttribute("location", location);
        model.addAttribute("salary", salary);

        return "job-success";
    }

    // ==========================
    // View All Applied Jobs (Optional)
    // URL: /appliedJobs
    // ==========================
    @GetMapping("/appliedJobs")
    public String appliedJobs(Model model) {

        List<JobApplication> applications = jobRepository.findAll();

        model.addAttribute("applications", applications);

        return "applied-jobs";
    }
}