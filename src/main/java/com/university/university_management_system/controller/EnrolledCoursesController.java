package com.university.university_management_system.controller;

import com.university.university_management_system.DTOs.EnrolledCourseDTO;
import com.university.university_management_system.model.EnrolledCourseModel;
import com.university.university_management_system.repository.EnrolledCourseRepository;
import com.university.university_management_system.service.EnrolledCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("students/{studentId}/enrolledcourses")
public class EnrolledCoursesController {
    @Autowired
    EnrolledCourseService enrolledCourseService;


    @GetMapping("")
    public ResponseEntity<?> getAllEnrolledCourses(@PathVariable String studentId){
        return ResponseEntity.ok().body(enrolledCourseService.getAllEnrolledCourses(studentId));
    }

    @GetMapping("/{enrolledCourseId}")
    public ResponseEntity<?> getEnrolledCourseByID(@PathVariable int enrolledCourseId){
        return ResponseEntity.ok(enrolledCourseService.getEnrolledCourseById(enrolledCourseId));
    }



}
