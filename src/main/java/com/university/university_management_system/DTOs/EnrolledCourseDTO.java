package com.university.university_management_system.dto;

import com.university.university_management_system.DTOs.StudentDTO;
import com.university.university_management_system.model.EnrolledCourseModel;

import java.util.HashMap;
import java.util.Map;

public class EnrolledCourseDTO {

    private int enrolledCourseId;
    private StudentDTO studentDTO;
    private Map<String, String> course;

    /**
     * Default constructor.
     */
    public EnrolledCourseDTO() {
        this.course = new HashMap<>();
    }

    /**
     * Parameterized constructor.
     * @param enrolledCourseId the ID of the enrolled course.
     * @param studentDTO the student DTO associated with the enrolled course.
     * @param course the course details as a map.
     */
    public EnrolledCourseDTO(int enrolledCourseId, StudentDTO studentDTO, Map<String, String> course) {
        this.enrolledCourseId = enrolledCourseId;
        this.studentDTO = studentDTO;
        this.course = course;
    }

    // Getters and Setters

    public int getEnrolledCourseId() {
        return enrolledCourseId;
    }

    public void setEnrolledCourseId(int enrolledCourseId) {
        this.enrolledCourseId = enrolledCourseId;
    }

    public StudentDTO getStudentDTO() {
        return studentDTO;
    }

    public void setStudentDTO(StudentDTO studentDTO) {
        this.studentDTO = studentDTO;
    }

    public Map<String, String> getCourse() {
        return course;
    }

    public void setCourse(Map<String, String> course) {
        this.course = course;
    }

    /**
     * Static method to convert EnrolledCourseModel to EnrolledCourseDTO.
     * @param model the EnrolledCourseModel to convert.
     * @return an EnrolledCourseDTO representation of the model.
     */
    public static EnrolledCourseDTO fromModel(EnrolledCourseModel model) {
        EnrolledCourseDTO dto = new EnrolledCourseDTO();
        dto.setEnrolledCourseId(model.getEnrolledCourseId());
        dto.setStudentDTO(StudentDTO.fromModel(model.getStudent()));

        Map<String, String> courseMap = new HashMap<>();
        courseMap.put("courseCode", model.getCourse().getCourseCode());
        courseMap.put("courseName", model.getCourse().getCourseName());
        dto.setCourse(courseMap);

        return dto;
    }
}
