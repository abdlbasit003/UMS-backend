package com.university.university_management_system.controller;
import java.util.*;

import com.university.university_management_system.DTOs.FacultyDTO;
import com.university.university_management_system.model.FacultyModel;
import com.university.university_management_system.repository.FacultyRepository;
import com.university.university_management_system.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/faculty")
public class FacultyController {
    @Autowired
    FacultyService facultyService;

    @GetMapping("")
    public List<FacultyDTO> getAllFaculty(){
        return facultyService.getAllFaculty();
    }

    @GetMapping("/{facultyId}")
    public FacultyDTO getFacultyById( int facultyId){
        return facultyService.getFacultyById(facultyId);
    }
    public FacultyDTO getFacultyByName( String name){
        return (FacultyDTO) facultyService.getFacultyByName(name);
    }

    public FacultyDTO getFacultyByDesignation( String facultydesignation){
        return (FacultyDTO) facultyService.getFacultyByDesignation(facultydesignation);
    }
    public FacultyDTO getFacultyByUuid(String id){
        return  facultyService.getFacultyByUuid(id);
    }
}
