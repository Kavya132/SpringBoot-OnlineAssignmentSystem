package com.example.OnlineAssignmentSystem.service;

import com.example.OnlineAssignmentSystem.model.Feedback;
import com.example.OnlineAssignmentSystem.repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeedbackService {

    @Autowired
    private FeedbackRepository feedbackRepository;

    public Feedback giveFeedback(Feedback feedback) {
        return feedbackRepository.save(feedback);
    }
}
