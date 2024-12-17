package com.university.university_management_system.controller;

import com.university.university_management_system.DTOs.CourseDepartmentDTO;
import com.university.university_management_system.service.CourseDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/coursedepartments")
public class CourseDepartmentController {

    @Autowired
    public CourseDepartmentService courseDepartmentService;

    @GetMapping("")
    public ResponseEntity<?> getAllCourseDepartments() {
        return ResponseEntity.ok().body(courseDepartmentService.getAllDepartmentCourses());
    }

    @GetMapping("/{courseDepartmentId}")
    public ResponseEntity<?> getCourseDepartmentById(@PathVariable Integer courseDepartmentId) {
        return ResponseEntity.ok().body(courseDepartmentService.getDepartmentCourseById(courseDepartmentId));
    }

    @GetMapping("/department/{departmentId}")
    public ResponseEntity<?> getCoursesByDepartmentId(@PathVariable Integer departmentId) {
        return ResponseEntity.ok().body(courseDepartmentService.getCoursesByDepartmentId(departmentId));
    }

    @GetMapping("/course/{courseCode}")
    public ResponseEntity<?> getDepartmentsByCourseCode(@PathVariable String courseCode) {
        return ResponseEntity.ok().body(courseDepartmentService.getDepartmentsByCourseCode(courseCode));
    }

    @GetMapping("/coursesInDepartment/{departmentName}")
    public ResponseEntity<?> getAllCoursesInDepartment(@PathVariable String departmentName) {
        return ResponseEntity.ok().body(courseDepartmentService.getAllCoursesInDepartment(departmentName));
    }
}
