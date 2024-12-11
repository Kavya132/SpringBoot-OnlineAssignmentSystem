package com.example.OnlineAssignmentSystem.repository;

import com.example.OnlineAssignmentSystem.model.Grade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GradeRepository extends JpaRepository<Grade, Long> {
}
