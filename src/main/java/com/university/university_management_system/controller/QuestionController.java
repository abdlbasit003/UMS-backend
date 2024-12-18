package com.university.university_management_system.controller;

import com.university.university_management_system.DTOs.QuestionDTO;
import com.university.university_management_system.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/questions")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @GetMapping("")
    public List<QuestionDTO> getAllQuestions(){
        return questionService.getAllQuestions();
    }

    @GetMapping("/{questionId}")
    public QuestionDTO getQuestionById(@PathVariable int questionId) {
        return questionService.getQuestionById(questionId);
    }

    @GetMapping("/type/{questionTypeId}")
    public List<QuestionDTO> getQuestionsByTypeId(@PathVariable int questionTypeId) {
        return questionService.getQuestionsByTypeId(questionTypeId);
    }


    public List<QuestionDTO> getQuestionsByCloId(@PathVariable int cloId) {
        return questionService.getQuestionsByCloId(cloId);
    }


}
