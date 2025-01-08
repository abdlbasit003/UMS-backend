package com.university.university_management_system.service;

import com.university.university_management_system.DTOs.EnrolledCourseDTO;
import com.university.university_management_system.exceptions.ApiException;
import com.university.university_management_system.model.EnrolledCourseModel;
import com.university.university_management_system.repository.EnrolledCourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EnrolledCourseService {

    @Autowired
    EnrolledCourseRepository enrolledCourseRepository;

    public EnrolledCourseDTO getEnrolledCourseById(int enrolledCourseId) {
        return EnrolledCourseDTO.fromModel(enrolledCourseRepository.findById(enrolledCourseId).orElseThrow(()->new ApiException("Enrolled Course not found", HttpStatus.NOT_FOUND)));



    }

    public List<EnrolledCourseDTO> getCoursesByStudentId(String studentId) {

        return enrolledCourseRepository.findAll()
                .stream().filter(ecr->ecr.getStudent().getStudentId().equals(studentId))
                .map(EnrolledCourseDTO::fromModel)
                .toList();
    }

    public List<EnrolledCourseDTO> getStudentsByCourseCode(String courseCode) {
        return enrolledCourseRepository.findAll().stream()
                    .filter(model -> Optional.ofNullable(model.getCourse())
                            .map(course -> course.getCourseCode().equals(courseCode))
                            .orElseThrow(()->new ApiException("No students enrolled in this course",HttpStatus.NOT_FOUND)))
                    .map(EnrolledCourseDTO::fromModel)
                    .toList();

    }


}
