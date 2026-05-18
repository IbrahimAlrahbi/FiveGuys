package com.example.fiveguys.services;

public class FeedbackService {
    // Stores feedback text from client request
    private String content;

    // Returns feedback content
    public String getContent() {
        return content;
    }

    // Updates feedback content
    public void setContent(String content) {
        this.content = content;
    }
}