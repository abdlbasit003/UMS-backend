package com.university.university_management_system.controller;

import com.university.university_management_system.DTOs.ExamDTO;
import com.university.university_management_system.model.ExamModel;
import com.university.university_management_system.repository.ExamRepository;
import com.university.university_management_system.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/exams")
public class ExamController {
    @Autowired
    ExamService examService;

    @GetMapping("")
    public List<ExamDTO> getAllExams() {
        return examService.getAllExams();
    }
    @GetMapping("/{examId}")
    public ExamDTO getExamById(@PathVariable int examId) {
        return examService.getExamById(examId);
    }

    @GetMapping("/{courseCode}")
    public List<ExamDTO> getExamsByCourseCode(@PathVariable String courseCode) {
        return examService.getExamsByCourseCode(courseCode);
    }
}
