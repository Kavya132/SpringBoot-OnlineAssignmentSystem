package com.example.OnlineAssignmentSystem.service;

import com.example.OnlineAssignmentSystem.model.Submission;
import com.example.OnlineAssignmentSystem.repository.SubmissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubmissionService {

    @Autowired
    private SubmissionRepository submissionRepository;

    public Submission submitAssignment(Submission submission) {
        return submissionRepository.save(submission);
    }

    public Submission getSubmissionById(Long id) {
        return submissionRepository.findById(id).orElse(null);
    }
}
