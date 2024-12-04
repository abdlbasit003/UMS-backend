package com.university.university_management_system.controller;

import com.university.university_management_system.model.CourseInstructorModel;
import com.university.university_management_system.repository.CourseInstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/courseinstructors")
public class CourseInstructorController {
    @Autowired
    CourseInstructorRepository courseInstructorRepository;
    @GetMapping("")
    public List<CourseInstructorModel> getAllCourseInstructor(){
        return courseInstructorRepository.findAll();
    }
    @GetMapping("/{courseInstructorId}")
    public CourseInstructorModel getCourseInstructorbyID(@PathVariable int courseInstructorId){
        return courseInstructorRepository.findById(courseInstructorId).orElseThrow();
    }
}
