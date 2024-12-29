package com.university.university_management_system.controller;

import com.university.university_management_system.DTOs.CourseResultDTO;
import com.university.university_management_system.model.CourseResultModel;
import com.university.university_management_system.repository.CourseResultRepository;
import com.university.university_management_system.service.CourseResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class CourseResultController {

    @Autowired
    CourseResultService courseResultService;

    @GetMapping("/courseresults")
    public List<CourseResultDTO> getAllCourseResults() {
        return courseResultService.getAllResults();
    }
    @GetMapping("/courseresults/{courseResultId}")
    public CourseResultDTO getCourseResultById(@PathVariable int courseResultId) {
        return courseResultService.getById(courseResultId);
    }
}
