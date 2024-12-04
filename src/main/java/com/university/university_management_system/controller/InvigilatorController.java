package com.university.university_management_system.controller;

import com.university.university_management_system.model.InvigilatorModel;
import com.university.university_management_system.repository.InvigilatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/invigilators")
public class InvigilatorController {

    @Autowired
    InvigilatorRepository invigilatorRepository;

    @GetMapping("")
    public List<InvigilatorModel> GetAllInvigilator() {
        return invigilatorRepository.findAll();
    }

    @GetMapping("/{invigilatorId}")
    public InvigilatorModel GetInvigilatorbyid(@PathVariable int invigilatorId) {
        return invigilatorRepository.findById(invigilatorId).orElseThrow();

    }
}
