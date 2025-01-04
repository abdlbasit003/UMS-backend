package com.university.university_management_system.controller;

import com.university.university_management_system.DTOs.ExamDTO;
import com.university.university_management_system.DTOs.SemesterCourseDTO;
import com.university.university_management_system.service.SemesterCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/semester_courses")
public class SemesterCourseController {
    @Autowired
    SemesterCourseService semesterCourseService;
    @GetMapping("")
    public ResponseEntity<List<SemesterCourseDTO>> getAll(){
        return ResponseEntity.ok(semesterCourseService.getAll());
    }

    @GetMapping("/{semesterCourseId}")
    public  ResponseEntity<SemesterCourseDTO> getBySemesterCourseId(@PathVariable int semesterCourseId){
        return ResponseEntity.ok(semesterCourseService.getBySemesterCourseId(semesterCourseId));
    }
    @GetMapping("/semester/{semesterId}")
    public ResponseEntity<List<SemesterCourseDTO>> getBySemesterId(@PathVariable int semesterId){
        return ResponseEntity.ok(semesterCourseService.getBySemesterId(semesterId));
    }
    @GetMapping("/course/{courseCode}")
    public ResponseEntity<List<SemesterCourseDTO>> getByCourseCode(@PathVariable String courseCode) {
    return ResponseEntity.ok(semesterCourseService.getByCourseCode(courseCode));

    }
    }

