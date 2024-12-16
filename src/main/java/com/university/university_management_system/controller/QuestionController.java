package com.university.university_management_system.controller;

import com.university.university_management_system.DTOs.QuestionDTO;
import com.university.university_management_system.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class QuestionController {
    @Autowired
    QuestionService questionService;
    public List<QuestionDTO> getAllQuestions(){
        return questionService.getAllQuestions();
    }


    public QuestionDTO getQuestionById(int id) {
        return questionService.getQuestionById(id);
    }
    public List<QuestionDTO> getQuestionsByTypeId(int questionTypeId) {
        return questionService.getQuestionsByTypeId(questionTypeId);
    }
    public List<QuestionDTO> getQuestionsByCloId(int cloId) {
        return questionService.getQuestionsByCloId(cloId);
    }


}
