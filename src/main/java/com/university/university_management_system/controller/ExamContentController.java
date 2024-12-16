package com.university.university_management_system.controller;

import com.university.university_management_system.DTOs.ExamContentDTO;
import com.university.university_management_system.service.ExamContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exam-contents")
public class ExamContentController {

    @Autowired
    private ExamContentService examContentService;

    @GetMapping
    public List<ExamContentDTO> getAllExamContents() {
        return examContentService.getAllExamContents();
    }

    @GetMapping("/{id}")
    public ExamContentDTO getExamContentById(@PathVariable int id) {
        return examContentService.getExamContentById(id);
    }

    @GetMapping("/content-type/{contentTypeId}")
    public List<ExamContentDTO> getExamContentsByContentTypeId(@PathVariable int contentTypeId) {
        return examContentService.getExamContentsByContentTypeId(contentTypeId);
    }

    @GetMapping("/question/{questionId}")
    public List<ExamContentDTO> getExamContentsByQuestionId(@PathVariable int questionId) {
        return examContentService.getExamContentsByQuestionId(questionId);
    }
}
