package com.example.fiveguys.controllers;

import com.example.fiveguys.models.Feedback;
import com.example.fiveguys.services.FeedbackService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

// Marks this class as a REST API controller
@RestController

// Base URL for all feedback endpoints
@RequestMapping("/feedback")
public class FeedbackController {
    // Stores feedback entries temporarily in memory
    private List<Feedback> feedbackList = new ArrayList<>();

    // Generates unique IDs for feedback entries
    private int nextId = 1;

    // Handles POST requests to create new feedback
    @PostMapping
    public ResponseEntity<Feedback> createFeedback(@RequestBody FeedbackService request) {
        Feedback feedback = new Feedback(nextId, request.getContent());
        feedbackList.add(feedback);
        nextId++;
        // Return HTTP 201 Created with feedback data
        return ResponseEntity.status(201).body(feedback);
    }
}