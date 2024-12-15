package com.university.university_management_system.service;

import com.university.university_management_system.DTOs.EnrolledCourseDTO;
import com.university.university_management_system.DTOs.StudentDTO;
import com.university.university_management_system.model.EnrolledCourseModel;
import com.university.university_management_system.model.StudentModel;
import com.university.university_management_system.repository.EnrolledCourseRepository;

import java.util.ArrayList;
import java.util.List;

public class EnrolledCourseService {

    EnrolledCourseRepository enrolledCourseRepository;
    public EnrolledCourseService(EnrolledCourseRepository enrolledCourseRepository) {
        this.enrolledCourseRepository = enrolledCourseRepository;
    }

    public List<EnrolledCourseDTO> getAllEnrolledCourses(){
        List<EnrolledCourseDTO> enrolledCourses = new ArrayList<>();
        for (EnrolledCourseModel model : enrolledCourseRepository.findAll()) {
            enrolledCourses.add(EnrolledCourseDTO.fromModel(model));
        }
        return enrolledCourses;
    }

    public EnrolledCourseDTO getEnrolledCourseById(int enrolledCourseId){
        EnrolledCourseModel model = enrolledCourseRepository.findById(enrolledCourseId).orElse(null);
        if (model == null) {
            throw new RuntimeException("Enrolled Course not found with the ID: " + enrolledCourseId);
        }
        return EnrolledCourseDTO.fromModel(model);
    }

    public List<EnrolledCourseDTO> getCoursesByStudentId(int studentId) {
        List<EnrolledCourseDTO> courses = new ArrayList<>();
        for (EnrolledCourseModel model : enrolledCourseRepository.findAll()) {
            if (model.getStudent().getStudentId().equals(studentId)) {
                courses.add(EnrolledCourseDTO.fromModel(model));
            }
        }
        return courses;
    }


    public List<EnrolledCourseDTO> getStudentsByCourseCode(String courseCode) {
        List<EnrolledCourseDTO> students = new ArrayList<>();
        for (EnrolledCourseModel model : enrolledCourseRepository.findAll()) {
            if (model.getCourse() != null && model.getCourse().getCourseCode().equals(courseCode)) {
                students.add(EnrolledCourseDTO.fromModel(model));
            }
        }
        return students;
    }

}
