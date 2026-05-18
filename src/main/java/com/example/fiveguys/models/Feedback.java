package com.example.fiveguys.models;

public class Feedback {
    // Unique ID for each feedback
    private int id;

    // Feedback message
    private String content;

    // Constructor to initialize feedback object
    public Feedback(int id, String content) {
        this.id = id;
        this.content = content;
    }

    // Returns feedback ID
    public int getId() {
        return id;
    }

    // Returns feedback content
    public String getContent() {
        return content;
    }
}