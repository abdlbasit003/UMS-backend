package com.university.university_management_system.service;

import com.university.university_management_system.DTOs.StudentDTO;
import com.university.university_management_system.model.StudentModel;
import com.university.university_management_system.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {


    @Autowired
    StudentRepository studentRepository;


    public List<StudentDTO> getAllStudents(){
        return studentRepository.getAllStudents().stream().map(StudentDTO::fromModel).collect(Collectors.toList());
    }

    public StudentDTO getStudentById(String studentId){
        StudentModel studentModel = studentRepository.getById(studentId);
        return StudentDTO.fromModel(studentModel);
    }





}
