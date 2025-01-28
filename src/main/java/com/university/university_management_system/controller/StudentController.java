package com.university.university_management_system.controller;

import com.university.university_management_system.DTOs.StudentDTO;
import com.university.university_management_system.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@Tag (name = "Student", description = "Student endpoints" )

@RequestMapping("/students")
public class StudentController {

    @Autowired
    StudentService studentService;


    @GetMapping("")
    public ResponseEntity<List<StudentDTO>> getAllStudents(){
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<?> getStudentById(@PathVariable String studentId){
       return ResponseEntity.ok(studentService.getStudentById(studentId));


    }
    @GetMapping("/uid/{uuid}")
    public ResponseEntity<?> getStudentByUuid(@PathVariable String uuid){
        return ResponseEntity.ok(studentService.getStudentByUUid(uuid));


    }


}
