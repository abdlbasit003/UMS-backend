package com.university.university_management_system.controller;
import com.university.university_management_system.service.ExamQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag (name = "Exam Questions", description = "Exam Questions endpoints" )

@RequestMapping("/exams/{examId}/questions")
public class ExamQuestionsController {

    @Autowired
    public ExamQuestionService examQuestionsService;

    @GetMapping("")
    public ResponseEntity<?> getAllExamQuestions(@PathVariable int examId) {
        return ResponseEntity.ok().body(examQuestionsService.getQuestionsByExamId(examId));
    }

    @GetMapping("/{examQuestionId}")
    public ResponseEntity<?> getExamQuestionById(@PathVariable Integer examQuestionId) {
        return ResponseEntity.ok().body(examQuestionsService.getExamQuestionById(examQuestionId));
    }


    public ResponseEntity<?> getQuestionsByExamId(@PathVariable Integer examId) {
        return ResponseEntity.ok().body(examQuestionsService.getQuestionsByExamId(examId));
    }


    public ResponseEntity<?> getExamsByQuestionId(@PathVariable Integer questionId) {
        return ResponseEntity.ok().body(examQuestionsService.getExamsByQuestionId(questionId));
    }
}
