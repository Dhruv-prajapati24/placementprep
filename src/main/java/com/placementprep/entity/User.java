package com.placementprep.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    private String college;

    private String branch;

    // ================= Resume Builder =================
    @Column(name = "overleaf_link")
    private String overleafLink;

    // ================= Profile Scores =================
    @Column(name = "aptitude_score")
    private Integer aptitudeScore = 0;

    @Column(name = "resume_score")
    private Integer resumeScore = 0;

    @Column(name = "interview_score")
    private Integer interviewScore = 0;

    // ================= Constructors =================

    public User() {
    }

    public User(String name, String email, String password,
                String college, String branch, String overleafLink,
                Integer aptitudeScore, Integer resumeScore, Integer interviewScore) {

        this.name = name;
        this.email = email;
        this.password = password;
        this.college = college;
        this.branch = branch;
        this.overleafLink = overleafLink;
        this.aptitudeScore = aptitudeScore;
        this.resumeScore = resumeScore;
        this.interviewScore = interviewScore;
    }

    // ================= Getters & Setters =================

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    // ================= Overleaf Resume Builder =================

    public String getOverleafLink() {
        return overleafLink;
    }

    public void setOverleafLink(String overleafLink) {
        this.overleafLink = overleafLink;
    }

    // ================= Aptitude Score =================

    public Integer getAptitudeScore() {
        return aptitudeScore;
    }

    public void setAptitudeScore(Integer aptitudeScore) {
        this.aptitudeScore = aptitudeScore;
    }

    // ================= Resume Score =================

    public Integer getResumeScore() {
        return resumeScore;
    }

    public void setResumeScore(Integer resumeScore) {
        this.resumeScore = resumeScore;
    }

    // ================= Interview Score =================

    public Integer getInterviewScore() {
        return interviewScore;
    }

    public void setInterviewScore(Integer interviewScore) {
        this.interviewScore = interviewScore;
    }

    // ================= toString =================

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", college='" + college + '\'' +
                ", branch='" + branch + '\'' +
                ", overleafLink='" + overleafLink + '\'' +
                ", aptitudeScore=" + aptitudeScore +
                ", resumeScore=" + resumeScore +
                ", interviewScore=" + interviewScore +
                '}';
    }
}