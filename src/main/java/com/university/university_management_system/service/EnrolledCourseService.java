package com.university.university_management_system.service;

import com.university.university_management_system.DTOs.EnrolledCourseDTO;
import com.university.university_management_system.model.EnrolledCourseModel;
import com.university.university_management_system.model.StudentModel;
import com.university.university_management_system.model.CourseModel;
import com.university.university_management_system.repository.EnrolledCourseRepository;

import java.util.List;
import java.util.stream.Collectors;

public class EnrolledCourseService {

    private final EnrolledCourseRepository enrolledCourseRepository;


    public EnrolledCourseService(EnrolledCourseRepository enrolledCourseRepository) {
        this.enrolledCourseRepository = enrolledCourseRepository;
    }


    public List<EnrolledCourseDTO> getAllEnrolledCourses() {
        System.out.println("i return enrolledcourserepository.findall from enrolled course service");
        return enrolledCourseRepository.findAll().stream()
                .map(EnrolledCourseDTO::fromModel)
                .collect(Collectors.toList());
    }


    public EnrolledCourseDTO getEnrolledCourseById(int enrolledCourseId) {
        EnrolledCourseModel model = enrolledCourseRepository.findById(enrolledCourseId)
                .orElseThrow(() -> new RuntimeException("Enrolled course not found with ID: " + enrolledCourseId));
        System.out.println("i return enrolledcourseDTO from enrolledcourse service");
        return EnrolledCourseDTO.fromModel(model);
    }


    public List<EnrolledCourseDTO> getCoursesByStudentId(int studentId) {
        System.out.println("i work here at service");
        return enrolledCourseRepository.findAll().stream()
                .filter(course -> Integer.parseInt(course.getStudent().getStudentId()) == studentId) // Convert studentId to int
                .map(EnrolledCourseDTO::fromModel)
                .collect(Collectors.toList());
    }

    public List<EnrolledCourseDTO> getStudentsByCourseCode(String courseCode) {
        System.out.println("i return enrolledCourseRepository from enrolledcourserepository");
        return enrolledCourseRepository.findAll().stream()
                .filter(course -> course.getCourse().getCourseCode().equals(courseCode))
                .map(EnrolledCourseDTO::fromModel)
                .collect(Collectors.toList());
    }
}
