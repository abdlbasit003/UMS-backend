package com.university.university_management_system.controller;

import com.university.university_management_system.model.CourseResultModel;
import com.university.university_management_system.repository.CourseResultRepository;
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
    CourseResultRepository courseResultRepository;

    @GetMapping("")
    public List<CourseResultModel> getAllCourseResults() {
        return courseResultRepository.findAll();
    }
    @GetMapping("/{courseResultId}")
    public CourseResultModel getCourseResultById(@PathVariable int courseResultId) {
        return courseResultRepository.findById(courseResultId).orElseThrow();
    }
}
