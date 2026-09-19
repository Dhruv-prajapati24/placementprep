package com.placementprep.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "dsa_questions")
public class DSAQuestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String topic;

    @Column(nullable = false)
    private String question;

    @Column(nullable = false)
    private String difficulty;

    @Column(nullable = false)
    private Boolean completed = false;

    // ================= LeetCode Link =================
    @Column(name = "leetcode_link", length = 255)
    private String leetcodeLink;

    // ================= Notes =================
    @Column(columnDefinition = "TEXT")
    private String notes;

    // ================= YouTube Solution Link =================
    @Column(name = "youtube_link", length = 255)
    private String youtubeLink;

    // ================= Constructors =================

    public DSAQuestion() {
    }

    public DSAQuestion(String topic, String question, String difficulty,
                       Boolean completed, String leetcodeLink,
                       String notes, String youtubeLink) {
        this.topic = topic;
        this.question = question;
        this.difficulty = difficulty;
        this.completed = completed;
        this.leetcodeLink = leetcodeLink;
        this.notes = notes;
        this.youtubeLink = youtubeLink;
    }

    // ================= Getters & Setters =================

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public String getLeetcodeLink() {
        return leetcodeLink;
    }

    public void setLeetcodeLink(String leetcodeLink) {
        this.leetcodeLink = leetcodeLink;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getYoutubeLink() {
        return youtubeLink;
    }

    public void setYoutubeLink(String youtubeLink) {
        this.youtubeLink = youtubeLink;
    }

    // ================= toString =================

    @Override
    public String toString() {
        return "DSAQuestion{" +
                "id=" + id +
                ", topic='" + topic + '\'' +
                ", question='" + question + '\'' +
                ", difficulty='" + difficulty + '\'' +
                ", completed=" + completed +
                ", leetcodeLink='" + leetcodeLink + '\'' +
                ", notes='" + notes + '\'' +
                ", youtubeLink='" + youtubeLink + '\'' +
                '}';
    }
}