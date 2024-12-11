package com.example.OnlineAssignmentSystem.repository;

import com.example.OnlineAssignmentSystem.model.Submission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubmissionRepository extends JpaRepository<Submission, Long> {
}
