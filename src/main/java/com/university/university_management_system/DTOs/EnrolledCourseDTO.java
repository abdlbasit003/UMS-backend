package com.university.university_management_system.DTOs;

import com.university.university_management_system.model.EnrolledCourseModel;

import java.util.HashMap;


public class EnrolledCourseDTO {


    private int enrolledCourseId;
    private StudentDTO studentDTO;
    private HashMap<String,Object> course;


    public EnrolledCourseDTO(int enrolledCourseId, StudentDTO studentDTO, HashMap<String, Object> course) {
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

    public StudentDTO getStudent() {
        return studentDTO;
    }

    public void setStudentDTO(StudentDTO studentDTO) {
        this.studentDTO = studentDTO;
    }

    public HashMap<String, Object> getCourse() {
        return course;
    }

    public void setCourse(HashMap<String, Object> course) {
        this.course = course;
    }

    public static EnrolledCourseDTO fromModel(EnrolledCourseModel enrolledCourseModel){
        HashMap<String,Object> course = new HashMap<>();
        course.put("courseCode", enrolledCourseModel.getCourse().getCourseCode());
        course.put("courseName", enrolledCourseModel.getCourse().getCourseName());
        return new EnrolledCourseDTO(
                enrolledCourseModel.getEnrolledCourseId(),
                StudentDTO.fromModel(enrolledCourseModel.getStudent()),
                course
        );
    }


}
