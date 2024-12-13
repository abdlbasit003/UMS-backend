package com.university.university_management_system.service;

import com.university.university_management_system.DTOs.EnrolledCourseDTO;
import com.university.university_management_system.exceptions.ApiException;
import com.university.university_management_system.model.EnrolledCourseModel;
import com.university.university_management_system.repository.EnrolledCourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


public class EnrolledCourseService {



    @Autowired
    EnrolledCourseRepository enrolledCourseRepository;



    public List<EnrolledCourseDTO> getAllEnrolledCourses(String studentId){
        List<EnrolledCourseModel> allCourses = enrolledCourseRepository.getAllEnrolledCoursesByStudent(studentId);
        List<EnrolledCourseDTO> allCoursesDtos = new ArrayList<>();
        for (EnrolledCourseModel ecm : allCourses){
           allCoursesDtos.add(EnrolledCourseDTO.fromModel(ecm));
        }
        return allCoursesDtos;

    }

    public EnrolledCourseDTO getEnrolledCourseById(int enrolledCourseId){
        return EnrolledCourseDTO.fromModel(enrolledCourseRepository.findById(enrolledCourseId).orElseThrow());

    }








}
