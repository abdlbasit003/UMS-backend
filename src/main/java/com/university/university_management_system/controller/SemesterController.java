package com.university.university_management_system.controller;


import com.university.university_management_system.model.SemesterModel;
import com.university.university_management_system.service.SemesterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/semesters")
public class SemesterController {

    @Autowired
    SemesterService semesterService;

    @GetMapping("")
    public List<SemesterModel> getSemesters(){
        return semesterService.getAllSemesters();
    }

}

