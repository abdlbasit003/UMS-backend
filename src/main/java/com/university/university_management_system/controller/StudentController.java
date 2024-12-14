package com.university.university_management_system.controller;

import com.university.university_management_system.DTOs.StudentDTO;
import com.university.university_management_system.exceptions.ApiException;
import com.university.university_management_system.model.StudentModel;
import com.university.university_management_system.repository.StudentRepository;
import com.university.university_management_system.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    StudentRepository studentRepository;

    @Autowired
    StudentService studentService;

    @GetMapping("")
    public List<StudentModel> getAllStudents(){
        return studentRepository.getAllStudents();
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<?> getStudentById(@PathVariable String studentId){
       return ResponseEntity.ok(studentService.getStudentById(studentId));


    }

}
