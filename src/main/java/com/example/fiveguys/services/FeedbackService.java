package com.example.fiveguys.services;

import com.example.fiveguys.models.Feedback;

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

    // locate the feedback using id
//    public Feedback feedbackLocater(int id){
//        for (Feedback neededFeedback : feedbackList){
//            if (neededFeedback.getId() == id){
//                return neededFeedback;
//            }
//        }
//        return null;
//    }
}