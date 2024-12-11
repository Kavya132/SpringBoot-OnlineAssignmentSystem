package com.example.OnlineAssignmentSystem.service;

import com.example.OnlineAssignmentSystem.model.Grade;
import com.example.OnlineAssignmentSystem.repository.GradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GradeService {

    @Autowired
    private GradeRepository gradeRepository;

    public Grade giveGrade(Grade grade) {
        return gradeRepository.save(grade);
    }
}
