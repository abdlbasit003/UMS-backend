package com.university.university_management_system.controller;

import com.university.university_management_system.model.InvigilatorModel;
import com.university.university_management_system.repository.InvigilatorRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class InvigilatorController {

    @Autowired
    InvigilatorRepository invigilatorRepository;

    public List<InvigilatorModel> GetAllInvigilator() {
        return invigilatorRepository.findAll();
    }

    public InvigilatorModel GetInvigilatorbyid(int id) {
        return invigilatorRepository.findById(id).orElseThrow();

    }
}
