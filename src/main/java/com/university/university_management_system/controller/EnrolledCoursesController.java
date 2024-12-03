package com.university.university_management_system.controller;

import com.university.university_management_system.model.EnrolledCourseModel;
import com.university.university_management_system.repository.EnrolledCourseRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class EnrolledCoursesController {
    @Autowired
    EnrolledCourseRepository enrolledCourseRepository;


    public List<EnrolledCourseModel> getAllEnrolledCourses(){
        return enrolledCourseRepository.findAll();
    }

    public EnrolledCourseModel getEnrolledCourseByID(Integer id){
        return enrolledCourseRepository.findById(id).orElseThrow();
    }

}
