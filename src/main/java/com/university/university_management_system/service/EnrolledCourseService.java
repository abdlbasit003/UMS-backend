package com.university.university_management_system.service;

import com.university.university_management_system.DTOs.EnrolledCourseDTO;
import com.university.university_management_system.model.EnrolledCourseModel;
import com.university.university_management_system.repository.EnrolledCourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EnrolledCourseService {

    @Autowired
    EnrolledCourseRepository enrolledCourseRepository;

    public EnrolledCourseDTO getEnrolledCourseById(int enrolledCourseId) {
        try {
            EnrolledCourseModel model = enrolledCourseRepository.findById(enrolledCourseId).orElse(null);
            if (model == null) {
                throw new RuntimeException("Enrolled Course not found with the ID: " + enrolledCourseId);
            }
            return EnrolledCourseDTO.fromModel(model);
        } catch (Exception e) {
            throw new RuntimeException("Error fetching enrolled course by ID: " + enrolledCourseId, e);
        }
    }

    public List<EnrolledCourseDTO> getCoursesByStudentId(String studentId) {
        List<EnrolledCourseDTO> courses = new ArrayList<>();
        try {
            for (EnrolledCourseModel model : enrolledCourseRepository.findAll()) {
                if (model.getStudent().getStudentId().equals(studentId)) {
                    courses.add(EnrolledCourseDTO.fromModel(model));
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Error fetching courses for student ID: " + studentId, e);
        }
        return courses;
    }

    public List<EnrolledCourseDTO> getStudentsByCourseCode(String courseCode) {
        List<EnrolledCourseDTO> students = new ArrayList<>();
        try {
            for (EnrolledCourseModel model : enrolledCourseRepository.findAll()) {
                if (model.getCourse() != null && model.getCourse().getCourseCode().equals(courseCode)) {
                    students.add(EnrolledCourseDTO.fromModel(model));
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Error fetching students for course code: " + courseCode, e);
        }
        return students;
    }

}
