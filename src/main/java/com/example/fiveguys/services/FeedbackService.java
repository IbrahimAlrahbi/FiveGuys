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

    public Feedback createFeedback(Feedback incomingFeedback) {
        Feedback feedback = new Feedback(nextId, incomingFeedback.getContent());
        feedbackList.add(feedback);
        nextId++;
        return feedback;
    }

    public Feedback updateFeedback(int id, Feedback updateFeedback) {
        for (Feedback neededFeedback : feedbackList) {
            if (neededFeedback.getId() == id) {
                neededFeedback.setContent(updateFeedback.getContent());
                return neededFeedback;
            }
        }
        return null;
    }

    public Feedback deleteFeedback(int id) {
        for (int i = 0; i < feedbackList.size(); i++) {
            Feedback feedback = feedbackList.get(i);
            if (feedback.getId() == id) {
                feedbackList.remove(i);
                return feedback;
            }
        }
        return null;
    }
}


