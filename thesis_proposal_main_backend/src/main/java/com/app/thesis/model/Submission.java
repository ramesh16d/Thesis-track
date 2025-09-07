package com.app.thesis.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Submission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long submissionId;

    private String title;

    @Column(length = 2000)
    private String description;

    private String status; // Pending, Approved, Rejected

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "professor_id")
    private Professor professor;

    @Lob
    private String aiSummary;

    private String aiCategory;

    @Lob
    private String aiFeedback;
}
