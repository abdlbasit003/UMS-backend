package com.university.university_management_system.controller;
import io.swagger.v3.oas.annotations.tags.Tag;
import com.university.university_management_system.model.ExamTypeModel;
import com.university.university_management_system.repository.ExamTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Tag (name = "Exam Type", description = "Exam Type endpoints" )

@RequestMapping("/examtypes")
public class ExamTypeController {
    @Autowired
    ExamTypeRepository examTypeRepository;

    @GetMapping("")
    public List<ExamTypeModel> getAllExamTypes() {
        return examTypeRepository.findAll();
    }

    @GetMapping("/{examTypeId}")
    public ExamTypeModel getExamTypeById(@PathVariable int examTypeId) {return examTypeRepository.findById(examTypeId).orElseThrow();}
}