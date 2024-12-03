package com.university.university_management_system.controller;

import com.university.university_management_system.model.CourseInstructorModel;
import com.university.university_management_system.repository.CourseInstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CourseInstructorController {
    @Autowired
    CourseInstructorRepository courseInstructorRepository;

    public List<CourseInstructorModel> getAllCourseInstructor(){
        return courseInstructorRepository.findAll();
    }
    public CourseInstructorModel getCourseInstructorbyID(int id){
        return courseInstructorRepository.findById(id).orElseThrow();
    }
}
