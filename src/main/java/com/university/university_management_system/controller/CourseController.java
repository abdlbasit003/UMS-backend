package com.university.university_management_system.controller;
import io.swagger.v3.oas.annotations.tags.Tag;
import com.university.university_management_system.model.CourseModel;
import com.university.university_management_system.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag (name = "Course", description = "Course endpoints" )

@RequestMapping("/courses")
public class CourseController {
    @Autowired
    CourseRepository courseRepository;
    @GetMapping("")
    public List<CourseModel> getAllCourses(){
        return courseRepository.findAll();
    }
    @GetMapping("/{courseCode}")
    public CourseModel getbyIDCourse(@PathVariable String courseCode){
        return courseRepository.findById(courseCode).orElseThrow();
    }
}
