package com.university.university_management_system.controller;

import com.university.university_management_system.DTOs.CourseInstructorDTO;
import com.university.university_management_system.model.CourseInstructorModel;
import com.university.university_management_system.repository.CourseInstructorRepository;
import com.university.university_management_system.service.CourseInstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/courseinstructors")
public class CourseInstructorController {
    @Autowired
    CourseInstructorService courseInstructorService;
    @GetMapping("")
    public ResponseEntity <List<CourseInstructorDTO>> getAllCourseInstructors(){
        return ResponseEntity.ok(courseInstructorService.getAllCourseInstructors());
    }
    @GetMapping("/{courseInstructorId}")
    public ResponseEntity <CourseInstructorDTO> getCourseInstructorById(@PathVariable int courseInstructorId){
        return ResponseEntity.ok(courseInstructorService.getCourseInstructorbyId(courseInstructorId));
    }
    @GetMapping("/{courseCode}")
    public ResponseEntity <List<CourseInstructorDTO>> getCourseInstructorsByCourseCode(@PathVariable String courseCode){
        return ResponseEntity.ok(courseInstructorService.getCourseInstructorByCourseCode(courseCode));
    }

    @GetMapping("/{facultyId}")
    public ResponseEntity <List<CourseInstructorDTO>> getInstructorsByFacultyId(@PathVariable int facultyId) {
        return ResponseEntity.ok(courseInstructorService.getInstructorsByFacultyId(facultyId));
    }
    @GetMapping("/{facultyId}")
    public ResponseEntity <List<CourseInstructorDTO>> getCoursesByInstructorId(@PathVariable int facultyId) {
        return ResponseEntity.ok(courseInstructorService.getCoursesByInstructorId(facultyId));
    }

}
