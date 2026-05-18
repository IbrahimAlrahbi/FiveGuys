package com.example.fiveguys;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {

    private List<Feedback> feedbackList = new ArrayList<>();

    private int nextId = 1;

    @PostMapping
    public ResponseEntity<Feedback> createFeedback(@RequestBody FeedbackRequest request) {
        Feedback feedback = new Feedback(nextId, request.getContent());
        feedbackList.add(feedback);
        nextId++;
        return ResponseEntity.status(201).body(feedback);
    }

}