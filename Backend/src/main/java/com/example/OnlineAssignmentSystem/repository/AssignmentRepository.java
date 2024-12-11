package com.example.OnlineAssignmentSystem.repository;

import com.example.OnlineAssignmentSystem.model.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssignmentRepository extends JpaRepository<Assignment, Long> {
}
