package com.app.thesis.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long professorId;

    private String name;
    private String email;
    private String dept;
    private String passwordHash; // Placeholder for hashed password
}
