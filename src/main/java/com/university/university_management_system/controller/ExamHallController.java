package com.university.university_management_system.controller;

import com.university.university_management_system.model.ExamHallModel;
import com.university.university_management_system.repository.ExamHallRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ExamHallController {
    @Autowired
    ExamHallRepository examHallRepository;

    public List<ExamHallModel> getAllExamHalls(){
        return examHallRepository.findAll();
    }
    public ExamHallModel getExamHallID(int id){
        return examHallRepository.findById(id).orElseThrow();

    }
}
