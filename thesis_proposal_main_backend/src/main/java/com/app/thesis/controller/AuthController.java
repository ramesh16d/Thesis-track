package com.app.thesis.controller;

import com.app.thesis.model.Student;
import com.app.thesis.model.Professor;
import com.app.thesis.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register/student")
    public Student registerStudent(@RequestBody Student student) {
        return authService.registerStudent(student);
    }

    @PostMapping("/register/professor")
    public Professor registerProfessor(@RequestBody Professor professor) {
        return authService.registerProfessor(professor);
    }
}
