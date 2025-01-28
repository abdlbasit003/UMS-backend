package com.university.university_management_system.controller;
import io.swagger.v3.oas.annotations.tags.Tag;
import com.university.university_management_system.model.ExamModeModel;
import com.university.university_management_system.repository.ExamModeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Tag (name = "Exam Mode", description = "Exam Mode endpoints" )

@RequestMapping("/exammodes")
public class ExamModeController {
    @Autowired
    ExamModeRepository examModeRepository;

    @GetMapping("")
    public List<ExamModeModel> getAllExamTypes() {return examModeRepository.findAll();}

    @GetMapping("/{examModeId}")
    public ExamModeModel getExamTypeById(@PathVariable int examModeId) {return examModeRepository.findById(examModeId).orElseThrow();}
}