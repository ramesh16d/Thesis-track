package com.app.thesis.repository;

import com.app.thesis.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Student findByEmail(String email);
}
