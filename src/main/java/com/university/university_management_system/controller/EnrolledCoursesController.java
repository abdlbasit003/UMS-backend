package com.university.university_management_system.controller;

import com.university.university_management_system.DTOs.EnrolledCourseDTO;
import com.university.university_management_system.service.EnrolledCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EnrolledCoursesController {

    @Autowired
    EnrolledCourseService enrolledCourseService;

    @GetMapping("/enrolledcourses")
    public List<EnrolledCourseDTO> getAllEnrolledCourses(@PathVariable String studentId) {
        return enrolledCourseService.getCoursesByStudentId(studentId);
    }

    @GetMapping("/enrolledcourses//{enrolledCourseId}")
    public EnrolledCourseDTO getEnrolledCourseById(@PathVariable int enrolledCourseId) {
        return enrolledCourseService.getEnrolledCourseById(enrolledCourseId);
    }

    @GetMapping("/courses/{courseCode}/students")   
    public List<EnrolledCourseDTO> getStudentsByCourseCode(@PathVariable String courseCode) {
        return enrolledCourseService.getStudentsByCourseCode(courseCode);
    }
}
