package com.university.university_management_system.controller;

import com.university.university_management_system.DTOs.EnrolledCourseDTO;
import com.university.university_management_system.service.EnrolledCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("students/{studentId}/enrolledcourses")

public class EnrolledCoursesController {

    @Autowired
    EnrolledCourseService enrolledCourseService;

    public List<EnrolledCourseDTO> getAllEnrolledCourses() {
        return enrolledCourseService.getAllEnrolledCourses();
    }

    public EnrolledCourseDTO getEnrolledCourseById(int enrolledCourseId) {
        return enrolledCourseService.getEnrolledCourseById(enrolledCourseId);
    }

    public List<EnrolledCourseDTO> getCoursesByStudentId(int studentId) {
        return enrolledCourseService.getCoursesByStudentId(studentId);
    }
    public List<EnrolledCourseDTO> getStudentsByCourseCode(String courseCode) {
        return enrolledCourseService.getStudentsByCourseCode(courseCode);
    }


    }
