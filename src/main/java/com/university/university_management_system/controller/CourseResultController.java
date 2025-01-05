package com.university.university_management_system.controller;

import com.university.university_management_system.DTOs.CourseResultDTO;
import com.university.university_management_system.service.CourseResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/courseresults")
public class CourseResultController {

    @Autowired
    private CourseResultService courseResultService;

    @GetMapping
    public List<CourseResultDTO> getAllCourseResults() {
        return courseResultService.getAll();
    }

    @GetMapping("/{courseResultId}")
    public CourseResultDTO getCourseResultById(@PathVariable int courseResultId) {
        return courseResultService.getByCourseResultId(courseResultId);
    }

    @GetMapping("/student/{studentId}")
    public List<CourseResultDTO> getCourseResultsByStudentId(@PathVariable int studentId) {
        return courseResultService.getByStudentId(studentId);
    }

    @GetMapping("/course/{courseCode}")
    public List<CourseResultDTO> getCourseResultsByCourseCode(@PathVariable String courseCode) {
        return courseResultService.getByCourseCode(courseCode);
    }

    @GetMapping("/exam/{examId}")
    public List<CourseResultDTO> getCourseResultsByExamId(@PathVariable int examId) {
        return courseResultService.getByExamId(examId);
    }

    @GetMapping("/semester/{studentId}/{semesterId}")
    public List<CourseResultDTO> getCourseResultsBySemesterId(@PathVariable String studentId, @PathVariable int semesterId) {
        return courseResultService.getBySemesterId(studentId, semesterId);
    }
}