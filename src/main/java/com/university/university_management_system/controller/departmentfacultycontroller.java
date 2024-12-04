package com.university.university_management_system.controller;
import java.util.*;

import com.university.university_management_system.model.DepartmentFacultyModel;
import com.university.university_management_system.repository.DepartmentFacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/departmentfaculty")
public class DepartmentFacultyController {
    @Autowired
    DepartmentFacultyRepository departmentFacultyRepository;

    @GetMapping("")
    public List<DepartmentFacultyModel> getall(){
        return departmentFacultyRepository.findAll();
    }
    @GetMapping("/{departmentFacultyId}")
    public DepartmentFacultyModel getbyid(@PathVariable int departmentFacultyId){
        return departmentFacultyRepository.findById(departmentFacultyId).orElseThrow();
    }
}
