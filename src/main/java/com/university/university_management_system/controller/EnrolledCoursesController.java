package com.university.university_management_system.controller;
import io.swagger.v3.oas.annotations.tags.Tag;
import com.university.university_management_system.DTOs.EnrolledCourseDTO;
import com.university.university_management_system.service.EnrolledCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag (name = "Enrolled Courses", description = "Enrolled Courses endpoints" )

@RequestMapping("students/{studentId}/enrolledcourses")
public class EnrolledCoursesController {

    @Autowired
    EnrolledCourseService enrolledCourseService;

    @GetMapping("")
    public List<EnrolledCourseDTO> getAllEnrolledCourses(@PathVariable String studentId) {
        return enrolledCourseService.getCoursesByStudentId(studentId);
    }

    @GetMapping("/{enrolledCourseId}")
    public EnrolledCourseDTO getEnrolledCourseById(@PathVariable int enrolledCourseId) {
        return enrolledCourseService.getEnrolledCourseById(enrolledCourseId);
    }

    @GetMapping("/bycourse/{courseCode}")
    public List<EnrolledCourseDTO> getStudentsByCourseCode(@PathVariable String courseCode) {
        return enrolledCourseService.getStudentsByCourseCode(courseCode);
    }
}
