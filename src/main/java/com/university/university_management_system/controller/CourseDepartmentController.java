package com.university.university_management_system.controller;

import com.university.university_management_system.DTOs.CourseDepartmentDTO;
import com.university.university_management_system.service.CourseDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseDepartmentController {

    @Autowired
    public CourseDepartmentService courseDepartmentService;

    @GetMapping("/departments/{departmentId}/courses")
    public ResponseEntity<?> getAllCourseDepartments(@PathVariable int departmentId) {
        return ResponseEntity.ok().body(courseDepartmentService.getCoursesByDepartmentId(departmentId));
    }

    @GetMapping("/departments/{departmentId}/courses/{courseDepartmentId}")
    public ResponseEntity<?> getCourseDepartmentById(@PathVariable Integer courseDepartmentId) {
        return ResponseEntity.ok().body(courseDepartmentService.getDepartmentCourseById(courseDepartmentId));
    }

    @GetMapping("/course/{courseCode}/departments")
    public ResponseEntity<?> getDepartmentsByCourseCode(@PathVariable String courseCode) {
        return ResponseEntity.ok().body(courseDepartmentService.getDepartmentsByCourseCode(courseCode));
    }

//    @GetMapping("/coursesInDepartment/{departmentName}")
//    public ResponseEntity<?> getAllCoursesInDepartment(@PathVariable String departmentName) {
//        return ResponseEntity.ok().body(courseDepartmentService.getAllCoursesInDepartment(departmentName));
//    }
}
