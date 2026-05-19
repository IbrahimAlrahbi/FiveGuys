package com.example.fiveguys.controllers;

import com.example.fiveguys.models.Feedback;
import com.example.fiveguys.services.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

// Marks this class as a REST API controller
@RestController

// Base URL for all feedback endpoints
@RequestMapping("/feedback")
public class FeedbackController {
    @Autowired
    public FeedbackService feedbackService;

//=====================================================================================
    //ADDING feedbacks
    // Handles POST requests to create new feedback
    @PostMapping
    public ResponseEntity<Feedback> createFeedback(@RequestBody Feedback incomingFeedback) {
        return ResponseEntity.status(HttpStatus.CREATED).body(feedbackService.createFeedback(incomingFeedback));
    }

    @GetMapping
    public ResponseEntity<List<Feedback>> getAllFeedback() {
        return ResponseEntity.ok(feedbackService.getAllFeedbacks());
    }
//=====================================================================================
    //GET all feedbacks annotation
    @GetMapping(path = "/{id}")
    public ResponseEntity<Feedback> getSpecificFeedback(@PathVariable int id) {
        Feedback feedback = feedbackService.getFeedback(id);

        if (feedback == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(feedback);
    }

//=====================================================================================
    //MODIFYING annotation
    // locate the feedback using id
    @PutMapping("/{id}")
    public ResponseEntity<Feedback> feedbackLocater(@PathVariable int id, @RequestBody Feedback updateFeedback){
        Feedback feedback = feedbackService.updateFeedback(id, updateFeedback);
        if (feedback == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(feedback);
    }
//=====================================================================================
    //DELETE annotation
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Feedback> feedbackDelete(@PathVariable int id) {
        Feedback feedback = feedbackService.deleteFeedback(id);

        if (feedback == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(feedback);
    }
}