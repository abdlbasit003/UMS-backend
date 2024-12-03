package com.university.university_management_system.controller;

import com.university.university_management_system.model.CourseModel;
import com.university.university_management_system.model.StudentModel;
import com.university.university_management_system.repository.CourseRepository;
import com.university.university_management_system.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class Coursecontroller {
    @Autowired
    CourseRepository courseRepository;
    public List<CourseModel> getAllCourses(){
        return courseRepository.findAll();
    }
    public CourseModel getbyIDCourse(String id){
        return courseRepository.findById(id).orElseThrow();
    }
}
