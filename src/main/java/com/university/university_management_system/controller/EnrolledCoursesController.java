package com.university.university_management_system.controller;

import com.university.university_management_system.model.EnrolledCourseModel;
import com.university.university_management_system.repository.EnrolledCourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/enrolledcourses")
public class EnrolledCoursesController {
    @Autowired
    EnrolledCourseRepository enrolledCourseRepository;


    @GetMapping("")
    public List<EnrolledCourseModel> getAllEnrolledCourses(){
        return enrolledCourseRepository.findAll();
    }

    @GetMapping("/{id}")
    public EnrolledCourseModel getEnrolledCourseByID(@PathVariable int id){
        return enrolledCourseRepository.findById(id).orElseThrow();
    }

}
