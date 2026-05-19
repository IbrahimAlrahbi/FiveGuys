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


    // Handles POST requests to create new feedback
    @PostMapping
    public ResponseEntity<Feedback> createFeedback(@RequestBody Feedback incomingFeedback) {
        return ResponseEntity.status(HttpStatus.CREATED).body(feedbackService.createFeedback(incomingFeedback));
    }

    @GetMapping
    public ResponseEntity<List<Feedback>> getAllFeedback() {
        return ResponseEntity.ok(feedbackService.getAllFeedbacks());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Feedback> getSpecificFeedback(@PathVariable int id) {
        Feedback feedback = feedbackService.getFeedback(id);

        if (feedback == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(feedback);
    }


    // locate the feedback using id
    @PutMapping("/{id}")
    public ResponseEntity<Feedback> feedbackLocater(@PathVariable int id, @RequestBody Feedback updateFeedback){
        for (Feedback neededFeedback : feedbackList){
            if (neededFeedback.getId() == id){
                //update
                neededFeedback.setContent(updateFeedback.getContent());
                return ResponseEntity.ok(neededFeedback);
            }
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Feedback> feedbackDelete(@PathVariable int id){
        for (Feedback deleteThisFeedback : feedbackList){
            if (deleteThisFeedback.getId() == id){
                feedbackList.remove(deleteThisFeedback);
                return ResponseEntity.ok(deleteThisFeedback);
            }
        }
        return ResponseEntity.notFound().build();
    }
}