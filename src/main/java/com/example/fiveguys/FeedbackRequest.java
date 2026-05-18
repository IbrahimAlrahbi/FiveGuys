package com.example.fiveguys;

public class FeedbackRequest {
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