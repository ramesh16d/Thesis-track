package com.app.thesis.service;

import com.app.thesis.model.Submission;
import com.app.thesis.model.Student;
import com.app.thesis.model.Professor;
import com.app.thesis.repository.SubmissionRepository;
import com.app.thesis.repository.StudentRepository;
import com.app.thesis.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubmissionService {

    @Autowired
    private SubmissionRepository submissionRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ProfessorRepository professorRepository;

    public Submission submitIdea(Long studentId, String title, String description) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        Submission submission = Submission.builder()
                .title(title)
                .description(description)
                .student(student)
                .status("Pending")
                .build();

        return submissionRepository.save(submission);
    }

    public List<Submission> getSubmissionsForProfessor(Long professorId) {
        Professor professor = professorRepository.findById(professorId)
                .orElseThrow(() -> new RuntimeException("Professor not found"));

        return submissionRepository.findAll()
                .stream()
                .filter(sub -> sub.getProfessor() != null && sub.getProfessor().getProfessorId().equals(professorId))
                .toList();
    }

    public Submission reviewIdea(Long submissionId, String decision, String comments, Long professorId) {
        Submission submission = submissionRepository.findById(submissionId)
                .orElseThrow(() -> new RuntimeException("Submission not found"));

        Professor professor = professorRepository.findById(professorId)
                .orElseThrow(() -> new RuntimeException("Professor not found"));

        submission.setStatus(decision);
        submission.setProfessor(professor);
        // In real app: Save review entity too

        return submissionRepository.save(submission);
    }
}
