package com.university.university_management_system.controller;

import com.university.university_management_system.model.ExamModel;
import com.university.university_management_system.repository.ExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController

public class ExamController {
    @Autowired
    ExamRepository examRepository;

    @GetMapping("/exams")
    public List<ExamModel> getAllExams() {
        return examRepository.findAll();
    }
    @GetMapping("/exams/{examId}")
    public ExamModel getExamById(@PathVariable int examId) {
        return examRepository.findById(examId).orElseThrow();
    }

}
