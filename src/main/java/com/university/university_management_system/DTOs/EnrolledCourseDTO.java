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


    public EnrolledCourseDTO(int enrolledCourseId, StudentDTO studentDTO, Map<String, Object> course) {
        this.enrolledCourseId = enrolledCourseId;
        this.studentDTO = studentDTO;
        this.course = course;
    }

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

    public Map<String, Object> getCourse() {
        return course;
    }

    public void setCourse(Map<String, Object> course) {
        this.course = course;
    }

    public static EnrolledCourseDTO fromModel(EnrolledCourseModel model) {
        Map<String, Object> courseMap = new HashMap<>();
        courseMap.put("courseCode", model.getCourse().getCourseCode());
        courseMap.put("courseName", model.getCourse().getCourseName());
        return new EnrolledCourseDTO(model.getEnrolledCourseId(),StudentService.fromModel(model.getStudent()),courseMap);
    }
}
