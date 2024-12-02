package com.university.university_management_system.model;

import jakarta.persistence.*;

@Entity
@Table(name = "course")
public class CourseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_code")
    private String courseCode;

    @Column(name = "course_name", nullable = false)
    private String courseName;

    @ManyToOne
    @JoinColumn(name = "department_id", referencedColumnName = "department_id", nullable = false)
    private DepartmentModel department;

    @Column(name = "course_credit_hours", nullable = false)
    private int courseCreditHours;

    @Column(name = "course_pre_requisite")
    private String coursePreRequisite;

    @ManyToOne
    @JoinColumn(name = "faculty_id", referencedColumnName = "faculty_id", nullable = false)
    private FacultyModel faculty;


    public String getCourseCode() {
        return courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public DepartmentModel getDepartment() {
        return department;
    }

    public int getCourseCreditHours() {
        return courseCreditHours;
    }

    public String getCoursePreRequisite() {
        return coursePreRequisite;
    }

    public FacultyModel getFaculty() {
        return faculty;
    }


}
