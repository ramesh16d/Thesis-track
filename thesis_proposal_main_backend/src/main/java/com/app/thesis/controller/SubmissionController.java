package com.app.thesis.controller;

import com.app.thesis.model.Submission;
import com.app.thesis.service.SubmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SubmissionController {

    @Autowired
    private SubmissionService submissionService;

    @PostMapping("/submitIdea")
    public Submission submitIdea(@RequestParam Long studentId,
                                 @RequestParam String title,
                                 @RequestParam String description) {
        return submissionService.submitIdea(studentId, title, description);
    }

    @GetMapping("/getSubmissions")
    public List<Submission> getSubmissions(@RequestParam Long professorId) {
        return submissionService.getSubmissionsForProfessor(professorId);
    }

    @PostMapping("/reviewIdea/{id}")
    public Submission reviewIdea(@PathVariable Long id,
                                 @RequestParam String decision,
                                 @RequestParam String comments,
                                 @RequestParam Long professorId) {
        return submissionService.reviewIdea(id, decision, comments, professorId);
    }
}
