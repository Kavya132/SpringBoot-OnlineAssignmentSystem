package com.example.OnlineAssignmentSystem.controller;

import com.example.OnlineAssignmentSystem.model.Submission;
import com.example.OnlineAssignmentSystem.service.SubmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/submissions")
public class SubmissionController {

    @Autowired
    private SubmissionService submissionService;

    @PostMapping("/submit")
    public Submission submitAssignment(@RequestBody Submission submission) {
        return submissionService.submitAssignment(submission);
    }

    @GetMapping("/{id}")
    public Submission getSubmissionById(@PathVariable Long id) {
        return submissionService.getSubmissionById(id);
    }
}
