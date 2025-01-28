package com.university.university_management_system.controller;

import com.university.university_management_system.DTOs.CourseDepartmentDTO;
import com.university.university_management_system.service.CourseDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag (name = "CourseDepartment", description = "CourseDepartment endpoints" )

public class CourseDepartmentController {

    @Autowired
    public CourseDepartmentService courseDepartmentService;

    @GetMapping("/departments/{departmentId}/courses")
    public ResponseEntity<?> getAllCourseDepartments(@PathVariable int departmentId) {
        return ResponseEntity.ok().body(courseDepartmentService.getCoursesByDepartmentId(departmentId));
    }



    @GetMapping("/courses/{courseCode}/departments")
    public ResponseEntity<?> getDepartmentsByCourseCode(@PathVariable String courseCode) {
        return ResponseEntity.ok().body(courseDepartmentService.getDepartmentsByCourseCode(courseCode));
    }


}
