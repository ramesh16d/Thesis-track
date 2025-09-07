package com.app.thesis.service;

import com.app.thesis.model.Submission;
import com.app.thesis.repository.SubmissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AIService {

    @Autowired
    private SubmissionRepository submissionRepository;

    private final String AI_API_URL = "http://localhost:5000/ai"; // Flask/FastAPI wrapper for LLM

    public Submission generateSummary(Long submissionId) {
        Submission sub = submissionRepository.findById(submissionId)
                .orElseThrow(() -> new RuntimeException("Submission not found"));

        RestTemplate restTemplate = new RestTemplate();
        String summary = restTemplate.postForObject(
                AI_API_URL + "/summary",
                sub.getDescription(),
                String.class
        );

        sub.setAiSummary(summary);
        return submissionRepository.save(sub);
    }

    public Submission categorize(Long submissionId) {
        Submission sub = submissionRepository.findById(submissionId)
                .orElseThrow(() -> new RuntimeException("Submission not found"));

        RestTemplate restTemplate = new RestTemplate();
        String category = restTemplate.postForObject(
                AI_API_URL + "/categorize",
                sub.getDescription(),
                String.class
        );

        sub.setAiCategory(category);
        return submissionRepository.save(sub);
    }

    public Submission generateFeedback(Long submissionId) {
        Submission sub = submissionRepository.findById(submissionId)
                .orElseThrow(() -> new RuntimeException("Submission not found"));

        RestTemplate restTemplate = new RestTemplate();
        String feedback = restTemplate.postForObject(
                AI_API_URL + "/feedback",
                sub.getDescription(),
                String.class
        );

        sub.setAiFeedback(feedback);
        return submissionRepository.save(sub);
    }
}
