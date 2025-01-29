package com.university.university_management_system.controller;

import com.university.university_management_system.model.ExamPaperStatus;
import com.university.university_management_system.model.QuestionTypeModel;
import com.university.university_management_system.repository.QuestionTypeRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/questiontypes")
@Tag(name = "Question Types")
public class QuestionTypeController {
    @Autowired
    QuestionTypeRepository questionTypeRepository;

    @GetMapping("")
    public List<QuestionTypeModel> getQuestionTypes() {
        return questionTypeRepository.findAll();
    }

    @GetMapping("/{id}")
    public QuestionTypeModel getQuestionTypeById(int id) {
        return questionTypeRepository.findById(id).orElseThrow();

    }
}


