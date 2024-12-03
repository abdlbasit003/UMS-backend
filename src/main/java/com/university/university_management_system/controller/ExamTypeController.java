package com.university.university_management_system.controller;

import com.university.university_management_system.model.ExamTypeModel;
import com.university.university_management_system.repository.ExamTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ExamTypeController {
    @Autowired
    ExamTypeRepository repository;

    public List<ExamTypeModel> getAllExamTypes() {
        return repository.findAll();
    }

    public ExamTypeModel getExamTypeById(int id) {return repository.findById(id).orElseThrow();}
}