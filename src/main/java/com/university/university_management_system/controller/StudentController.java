package com.university.university_management_system.controller;

import com.university.university_management_system.model.StudentModel;
import com.university.university_management_system.model.UserModel;
import com.university.university_management_system.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.print.DocFlavor;
import java.util.*;
import java.util.UUID;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    StudentRepository studentRepository;

    @GetMapping("")
    public List<StudentModel> getAllStudents(){
        return studentRepository.getAllStudents();
    }

    @GetMapping("/{studentId}")
    public StudentModel getStudentById(@PathVariable String studentId){
       return studentRepository.getById(studentId);
    }

}
