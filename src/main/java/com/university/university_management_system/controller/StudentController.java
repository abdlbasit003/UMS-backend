package com.university.university_management_system.controller;

import com.university.university_management_system.model.StudentModel;
import com.university.university_management_system.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class StudentController {
    @Autowired
    StudentRepository studentRepository;


    public List<StudentModel> getAllStudents(){
        return studentRepository.findAll();

    }
    public StudentModel getStudentById(String studentId){
       return studentRepository.findById(studentId).orElseThrow();

    }
}
