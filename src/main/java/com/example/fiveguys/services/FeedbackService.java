package com.example.fiveguys.services;

import com.example.fiveguys.models.Feedback;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class FeedbackService {
    // Stores feedback text from client request
    private final List<Feedback> feedbackList = new ArrayList<>();

    // Returns feedback content
    // Generates unique IDs for feedback entries
    private int nextId = 1;

    public List<Feedback> getAllFeedbacks() {
        return feedbackList;
    }

    public Feedback getFeedback(int id) {
        for (Feedback feedback : feedbackList) {
            if (feedback.getId() == id) {
                return feedback;
            }
        }
        return null;
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