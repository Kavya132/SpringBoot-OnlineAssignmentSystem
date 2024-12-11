package com.example.OnlineAssignmentSystem.controller;

import com.example.OnlineAssignmentSystem.model.Grade;
import com.example.OnlineAssignmentSystem.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/grades")
public class GradeController {

    @Autowired
    private GradeService gradeService;

    @PostMapping("/assign")
    public Grade assignGrade(@RequestBody Grade grade) {
        return gradeService.giveGrade(grade);
    }
}
