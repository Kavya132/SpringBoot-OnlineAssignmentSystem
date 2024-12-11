package com.example.OnlineAssignmentSystem.controller;

import com.example.OnlineAssignmentSystem.model.Feedback;
import com.example.OnlineAssignmentSystem.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/feedbacks")
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    @PostMapping("/give")
    public Feedback giveFeedback(@RequestBody Feedback feedback) {
        return feedbackService.giveFeedback(feedback);
    }
}
