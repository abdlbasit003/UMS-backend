package com.university.university_management_system.controller;

import com.university.university_management_system.DTOs.ExamContentDTO;
import com.university.university_management_system.service.ExamContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController

public class ExamContentController {

    @Autowired
    private ExamContentService examContentService;

    @GetMapping("/exam-contents")
    public List<ExamContentDTO> getAllExamContents() {
        return examContentService.getAllExamContents();
    }

    @GetMapping("/exam-contents/{id}")
    public ExamContentDTO getExamContentById(@PathVariable int id) {
        return examContentService.getExamContentById(id);
    }

    @GetMapping("/content-type/{contentTypeId}/exam-contents")
    public List<ExamContentDTO> getExamContentsByContentTypeId(@PathVariable int contentTypeId) {
        return examContentService.getExamContentsByContentTypeId(contentTypeId);
    }

    @GetMapping("/question/{questionId}/exam-contents")
    public List<ExamContentDTO> getExamContentsByQuestionId(@PathVariable int questionId) {
        return examContentService.getExamContentsByQuestionId(questionId);
    }

    @PostMapping("/create")
    public ResponseEntity<ExamContentDTO> createNewExamContents(@RequestBody Map<String, Object> body) {
        ExamContentDTO contentDTO = examContentService.createNewExamContents(body);
        return new ResponseEntity<>(contentDTO, HttpStatus.CREATED);
    }
}
