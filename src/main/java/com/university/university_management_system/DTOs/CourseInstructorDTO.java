package com.university.university_management_system.DTOs;

import com.university.university_management_system.model.CourseInstructorModel;

import java.util.HashMap;
import java.util.Map;

public class CourseInstructorDTO {
    private int courseInstructorId;
    private Map<String, Object> faculty;
    private Map<String, Object> course;

    public CourseInstructorDTO(int courseInstructorId, Map<String, Object> faculty, Map<String, Object> course) {
        this.courseInstructorId = courseInstructorId;
        this.faculty = faculty;
        this.course = course;
    }

    public int getCourseInstructorId() {
        return courseInstructorId;
    }

    public void setCourseInstructorId(int courseInstructorId) {
        this.courseInstructorId = courseInstructorId;
    }

    public Map<String, Object> getFaculty() {
        return faculty;
    }

    public void setFaculty(Map<String, Object> faculty) {
        this.faculty = faculty;
    }

    public Map<String, Object> getCourse() {
        return course;
    }

    public void setCourse(Map<String, Object> course) {
        this.course = course;
    }

    public static CourseInstructorDTO fromModel(CourseInstructorModel courseInstructorModel){
        HashMap <String, Object> faculty = new HashMap<>();
        faculty.put("facultyName", courseInstructorModel.getFaculty().getFacultyName());
        faculty.put("facultyUuid", courseInstructorModel.getFaculty().getUser().getUuid());
        faculty.put("designation", courseInstructorModel.getFaculty().getDesignation());
        HashMap <String, Object> course = new HashMap<>();
        course.put("courseCode", courseInstructorModel.getCourse().getCourseCode());
        course.put("courseName", courseInstructorModel.getCourse().getCourseName());
        return new CourseInstructorDTO(
                courseInstructorModel.getCourseInstructorId(),faculty, course
        );
    }
}


