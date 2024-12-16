package com.university.university_management_system.DTOs;

import com.university.university_management_system.model.*;

import java.util.HashMap;
import java.util.Map;

public class CourseDepartmentDTO {

    private int courseInstructorId;
    private Map<String, Object> faculty;
    private Map<String, Object> course;

    public CourseDepartmentDTO(int courseInstructorId, Map<String, Object> faculty, Map<String, Object> course) {
        this.courseInstructorId = courseInstructorId;
        this.faculty = faculty;
        this.course = course;
    }

    public int getCourseInstructorId() {
        return courseInstructorId;
    }

    public Map<String, Object> getFaculty() {
        return faculty;
    }

    public Map<String, Object> getCourse() {
        return course;
    }

    public void setCourseInstructorId(int courseInstructorId) {
        this.courseInstructorId = courseInstructorId;
    }

    public void setFaculty(Map<String, Object> faculty) {
        this.faculty = faculty;
    }

    public void setCourse(Map<String, Object> course) {
        this.course = course;
    }

    public static CourseDepartmentDTO fromModel(DepartmentCourseModel model) {
        Map<String, Object> facultyMap = new HashMap<>();
        FacultyModel facultyModel = new FacultyModel();
        UserModel userModel = new UserModel();
        facultyMap.put("facultyName", facultyModel.getFacultyName());
        facultyMap.put("facultyUuid", userModel.getUuid());
        facultyMap.put("designation", facultyModel.getDesignation());

        Map<String, Object> courseMap = new HashMap<>();
        courseMap.put("courseCode", model.getCourse().getCourseCode());
        courseMap.put("courseName", model.getCourse().getCourseName());

        CourseInstructorModel courseInstructorModel = new CourseInstructorModel();


        return new CourseDepartmentDTO(
                courseInstructorModel.getCourseInstructorId(),
                facultyMap,
                courseMap
        );
    }
}
