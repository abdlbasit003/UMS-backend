package com.university.university_management_system.model;

import jakarta.persistence.*;

@Entity
@Table(name = "course")
public class CourseModel {

    @Id
    @Column(name = "course_code")
    private String courseCode;

    @Column(name = "course_name", nullable = false)
    private String courseName;

    @Column(name = "course_credit_hours", nullable = false)
    private int courseCreditHours;

    @Column(name = "course_pre_requisite")
    private String coursePreRequisite;

    @Column(name = "course_co_requisite")
    private String courseCoRequisite;

    public String getCourseCoRequisite() {
        return courseCoRequisite;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getCourseName() {
        return courseName;
    }



    public int getCourseCreditHours() {
        return courseCreditHours;
    }

    public String getCoursePreRequisite() {
        return coursePreRequisite;
    }



}
