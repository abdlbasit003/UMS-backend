package com.university.university_management_system.controller;

import com.university.university_management_system.DTOs.QuestionDTO;
import com.university.university_management_system.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@Tag (name = "Question", description = "Question endpoints" )

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

    @GetMapping("/type/{questionType}")
    public List<QuestionDTO> getQuestionsByTypeId(@PathVariable int questionTypeId) {
        return questionService.getQuestionsByTypeId(questionTypeId);
    }
    @GetMapping("/type/clo/{cloId}")
    public List<QuestionDTO> getQuestionsByCloId(@PathVariable int cloId) {
        return questionService.getQuestionsByCloId(cloId);
    }
    @PostMapping("/create")
    public ResponseEntity<QuestionDTO> createNewQuestion(@RequestBody Map<String, Object> body) {
        QuestionDTO contentDTO = questionService.createNewQuestion(body);
        return new ResponseEntity<>(contentDTO, HttpStatus.CREATED);
    }


}
