package com.university.university_management_system.controller;
import java.util.*;

import com.university.university_management_system.model.FacultyModel;
import com.university.university_management_system.repository.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/faculty")
public class FacultyController {
    @Autowired
    FacultyRepository facultyRepository;

    @GetMapping("")
    public List<FacultyModel> getall(){
        return facultyRepository.getAllFaculty();
    }

    @GetMapping("/{facultyId}")
    public FacultyModel getbyid(@PathVariable int facultyId){
        return facultyRepository.findById(facultyId).orElseThrow();
    }
}
