package com.university.university_management_system.DTOs;

import com.university.university_management_system.DTOs.StudentDTO;
import com.university.university_management_system.model.EnrolledCourseModel;
import com.university.university_management_system.service.StudentService;

import java.util.HashMap;
import java.util.Map;

public class EnrolledCourseDTO {

    private int enrolledCourseId;
    private StudentDTO studentDTO;
    private Map<String, Object> course;

    public EnrolledCourseDTO(Map<String, Object> course, StudentDTO studentDTO, int enrolledCourseId) {
        this.course = course;
        this.studentDTO = studentDTO;
        this.enrolledCourseId = enrolledCourseId;
    }

    public int getEnrolledCourseId() {
        return enrolledCourseId;
    }

    public StudentDTO getStudent() {
        return studentDTO;
    }

    public Map<String, Object> getCourse() {
        return course;
    }

    public void setEnrolledCourseId(int enrolledCourseId) {
        this.enrolledCourseId = enrolledCourseId;
    }

    public void setStudent(StudentDTO studentDTO) {
        this.studentDTO = studentDTO;
    }

    public void setCourse(Map<String, Object> course) {
        this.course = course;
    }

    public static EnrolledCourseDTO fromModel(EnrolledCourseModel model) {
        Map<String, Object> courseMap = new HashMap<>();
        courseMap.put("courseCode", model.getCourse().getCourseCode());
        courseMap.put("courseName", model.getCourse().getCourseName());

        return new EnrolledCourseDTO(courseMap, StudentDTO.fromModel(model.getStudent()), model.getEnrolledCourseId());
    }
}