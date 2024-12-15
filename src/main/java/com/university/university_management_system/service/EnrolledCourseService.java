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

    /**
     * Constructor for EnrolledCourseService.
     * @param enrolledCourseRepository the repository to manage enrolled courses.
     */
    public EnrolledCourseService(EnrolledCourseRepository enrolledCourseRepository) {
        this.enrolledCourseRepository = enrolledCourseRepository;
    }

    /**
     * Retrieves all enrolled courses.
     * @return a list of all EnrolledCourseDTO entries.
     */
    public List<EnrolledCourseDTO> getAllEnrolledCourses() {
        System.out.println("i return enrolledcourserepository.findall from enrolled course service");
        return enrolledCourseRepository.findAll().stream()
                .map(EnrolledCourseDTO::fromModel)
                .collect(Collectors.toList());
    }

    /**
     * Retrieves a specific enrolled course by its ID.
     * @param enrolledCourseId the ID of the enrolled course to retrieve.
     * @return the corresponding EnrolledCourseDTO.
     */
    public EnrolledCourseDTO getEnrolledCourseById(int enrolledCourseId) {
        EnrolledCourseModel model = enrolledCourseRepository.findById(enrolledCourseId)
                .orElseThrow(() -> new RuntimeException("Enrolled course not found with ID: " + enrolledCourseId));
        System.out.println("i return enrolledcourseDTO from enrolledcourse service");
        return EnrolledCourseDTO.fromModel(model);
    }

    /**
     * Retrieves enrolled courses by student ID.
     * @param studentId the ID of the student.
     * @return a list of EnrolledCourseDTO entries where the StudentModel matches the given studentId.
     */
    public List<EnrolledCourseDTO> getCoursesByStudentId(int studentId) {
        System.out.println("i work here at service");
        return enrolledCourseRepository.findAll().stream()
                .filter(course -> Integer.parseInt(course.getStudent().getStudentId()) == studentId) // Convert studentId to int
                .map(EnrolledCourseDTO::fromModel)
                .collect(Collectors.toList());
    }

    /**
     * Retrieves students by course code.
     * @param courseCode the code of the course.
     * @return a list of EnrolledCourseDTO entries where the CourseModel matches the given courseCode.
     */
    public List<EnrolledCourseDTO> getStudentsByCourseCode(String courseCode) {
        System.out.println("i return enrolledCourseRepository from enrolledcourserepository");
        return enrolledCourseRepository.findAll().stream()
                .filter(course -> course.getCourse().getCourseCode().equals(courseCode))
                .map(EnrolledCourseDTO::fromModel)
                .collect(Collectors.toList());
    }
}
