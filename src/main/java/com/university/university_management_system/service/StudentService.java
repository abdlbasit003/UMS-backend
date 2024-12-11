package com.university.university_management_system.service;

import com.university.university_management_system.DTOs.StudentDTO;
import com.university.university_management_system.model.StudentModel;
import com.university.university_management_system.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {


    @Autowired
    StudentRepository studentRepository;


    public static StudentDTO fromModel(StudentModel studentModel){
        return new StudentDTO(
                studentModel.getUser().getUuid(),
                studentModel.getStudentId(),
                studentModel.getStudentName(),
                studentModel.getDepartment().getDepartmentName(),
                studentModel.getStudentEnrollmentYear(),
                studentModel.getStudentCgpa()
        );
    }

    public StudentDTO getStudentById(String studentId){
        StudentModel studentModel = studentRepository.getById(studentId);
        return StudentService.fromModel(studentModel);
    }





}
