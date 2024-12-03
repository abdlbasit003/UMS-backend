package com.university.university_management_system.controller;

import com.university.university_management_system.model.DepartmentCourseModel;
import com.university.university_management_system.repository.DepartmentCourseRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CourseDepartmentController {
    @Autowired
    DepartmentCourseRepository departmentCourseRepository;

    public List<DepartmentCourseModel> getAll(){
        return  departmentCourseRepository.findAll();
    }
    public DepartmentCourseModel getbyid(int id){
        return departmentCourseRepository.findById(id).orElseThrow();
    }
}
