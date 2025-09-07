package com.app.thesis.service;

import com.app.thesis.model.Student;
import com.app.thesis.model.Professor;
import com.app.thesis.repository.StudentRepository;
import com.app.thesis.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ProfessorRepository professorRepository;

    public Student registerStudent(Student student) {
        // TODO: Hash password (JWT integration placeholder)
        return studentRepository.save(student);
    }

    public Professor registerProfessor(Professor professor) {
        // TODO: Hash password (JWT integration placeholder)
        return professorRepository.save(professor);
    }
}
