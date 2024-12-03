package com.university.university_management_system.controller;

import com.university.university_management_system.model.DepartmentCourseModel;
import com.university.university_management_system.repository.DepartmentCourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/coursedepartments")
public class CourseDepartmentController {
    @Autowired
    DepartmentCourseRepository departmentCourseRepository;
    @GetMapping("")
    public List<DepartmentCourseModel> getAll(){
        return  departmentCourseRepository.findAll();
    }
    @GetMapping("/{courseDepartmentId}")
    public DepartmentCourseModel getbyid(@PathVariable int courseDepartmentId){
        return departmentCourseRepository.findById(courseDepartmentId).orElseThrow();
    }
}
