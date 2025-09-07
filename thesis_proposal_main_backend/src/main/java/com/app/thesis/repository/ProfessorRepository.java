package com.app.thesis.repository;

import com.app.thesis.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
    Professor findByEmail(String email);
}
