package com.university.university_management_system.controller;

import com.university.university_management_system.DTOs.CourseInstructorDTO;
import com.university.university_management_system.model.CourseModel;
import com.university.university_management_system.service.CourseInstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Tag (name = "Course Instructor", description = "Course Instructor endpoints" )

public class CourseInstructorController {
    @Autowired
    CourseInstructorService courseInstructorService;

    @GetMapping("/courseinstructors")
    public ResponseEntity <List<CourseInstructorDTO>> getAllCourseInstructors(){
        return ResponseEntity.ok(courseInstructorService.getAllCourseInstructors());
    }
    @GetMapping("/courseinstructors/{courseInstructorId}")
    public CourseInstructorDTO getCourseInstructorById(@PathVariable int courseInstructorId){
        return courseInstructorService.getCourseInstructorbyId(courseInstructorId);
    }
    @GetMapping("/courses/{courseCode}/instructors")
    public ResponseEntity <List<CourseInstructorDTO>> getCourseInstructorsByCourseCode(@PathVariable String courseCode){
        return ResponseEntity.ok(courseInstructorService.getCourseInstructorByCourseCode(courseCode));
    }
    @GetMapping("/faculty/{instructorId}/courses")
    public ResponseEntity <List<CourseModel>> getCoursesByInstructorId(@PathVariable int instructorId) {
        return ResponseEntity.ok(courseInstructorService.getCoursesByInstructorId(instructorId));
    }

}
