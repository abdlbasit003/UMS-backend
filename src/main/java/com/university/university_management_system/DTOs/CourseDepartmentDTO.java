package com.university.university_management_system.DTOs;

import com.university.university_management_system.model.*;

import java.util.HashMap;
import java.util.Map;

public class CourseDepartmentDTO {

    private int courseDepartmentId;
    private Map<String, Object> department;
    private Map<String, Object> course;

    public CourseDepartmentDTO(int courseDepartmentId, Map<String, Object> department, Map<String, Object> course) {
        this.courseDepartmentId = courseDepartmentId;
        this.department = department;
        this.course = course;
    }

    public int getCourseDepartmentId() {
        return courseDepartmentId;
    }

    public void setCourseDepartmentId(int courseDepartmentId) {
        this.courseDepartmentId = courseDepartmentId;
    }

    public Map<String, Object> getDepartment() {
        return department;
    }

    public void setDepartment(Map<String, Object> department) {
        this.department = department;
    }

    public Map<String, Object> getCourse() {
        return course;
    }

    public void setCourse(Map<String, Object> course) {
        this.course = course;
    }

    public static CourseDepartmentDTO fromModel(DepartmentCourseModel model) {
        if (model == null || model.getDepartment() == null || model.getCourse() == null) {
            throw new IllegalArgumentException("Model and its fields cannot be null.");
        }

        Map<String, Object> departmentMap = new HashMap<>();
        DepartmentModel department = model.getDepartment();
        departmentMap.put("departmentId", department.getDepartmentId());
        departmentMap.put("departmentName", department.getDepartmentName());

        Map<String, Object> courseMap = new HashMap<>();
        CourseModel course = model.getCourse();
        courseMap.put("courseCode", course.getCourseCode());
        courseMap.put("courseName", course.getCourseName());

        return new CourseDepartmentDTO(model.getDepartmentCourseId(), departmentMap, courseMap);
    }
}
