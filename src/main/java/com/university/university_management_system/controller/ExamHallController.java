package com.university.university_management_system.controller;

import com.university.university_management_system.model.ExamHallModel;
import com.university.university_management_system.repository.ExamHallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Tag (name = "Exam Hall", description = "Exam Hall endpoints" )

@RequestMapping("/examhalls")
public class ExamHallController {
    @Autowired
    ExamHallRepository examHallRepository;

    @GetMapping("")
    public List<ExamHallModel> getAllExamHalls(){
        return examHallRepository.findAll();
    }
    @GetMapping("/{examHallId}")
    public ExamHallModel getExamHallID(@PathVariable int examHallId){
        return examHallRepository.findById(examHallId).orElseThrow();

    }
}
