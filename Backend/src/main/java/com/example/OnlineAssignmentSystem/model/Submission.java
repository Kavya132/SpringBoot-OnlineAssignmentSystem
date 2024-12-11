package com.example.OnlineAssignmentSystem.model;


import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Submission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User student;

    @ManyToOne
    private Assignment assignment;

    @Lob
    private byte[] pdfFile;  // Assignment submission file (PDF)

    @Temporal(TemporalType.TIMESTAMP)
    private Date submissionDate;

    // Getters and Setters
}
