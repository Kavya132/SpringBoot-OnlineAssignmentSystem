package com.example.OnlineAssignmentSystem.repository;

import com.example.OnlineAssignmentSystem.model.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
}
