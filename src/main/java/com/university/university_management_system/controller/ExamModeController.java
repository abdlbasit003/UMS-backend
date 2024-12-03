package com.university.university_management_system.controller;

import com.university.university_management_system.model.ExamModeModel;
import com.university.university_management_system.repository.ExamModeRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ExamModeController {
    @Autowired
    ExamModeRepository repository;

    public List<ExamModeModel> getAllExamTypes() {return repository.findAll();}

    public ExamModeModel getExamTypeById(int id) {return repository.findById(id).orElseThrow();}
}