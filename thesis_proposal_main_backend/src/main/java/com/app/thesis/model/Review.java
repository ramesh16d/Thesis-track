package com.app.thesis.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewId;

    @ManyToOne
    @JoinColumn(name = "submission_id")
    private Submission submission;

    @ManyToOne
    @JoinColumn(name = "professor_id")
    private Professor professor;

    @Lob
    private String comments;

    private String decision; // Approved / Rejected / Needs Revision

    private LocalDateTime reviewedAt;
}
