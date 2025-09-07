package com.app.thesis.controller;

import com.app.thesis.model.Submission;
import com.app.thesis.service.AIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ai")
public class AIController {

    @Autowired
    private AIService aiService;

    @PostMapping("/summary/{id}")
    public Submission generateSummary(@PathVariable Long id) {
        return aiService.generateSummary(id);
    }

    @PostMapping("/categorize/{id}")
    public Submission categorize(@PathVariable Long id) {
        return aiService.categorize(id);
    }

    @PostMapping("/feedback/{id}")
    public Submission generateFeedback(@PathVariable Long id) {
        return aiService.generateFeedback(id);
    }
}
