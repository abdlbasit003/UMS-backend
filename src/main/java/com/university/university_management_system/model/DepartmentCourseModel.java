package com.university.university_management_system.model;

import jakarta.persistence.*;

@Entity
@Table(name = "department_course")
public class DepartmentCourseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "department_course_id")
    private int departmentCourseId;

    @ManyToOne
    @JoinColumn(name = "department_id", referencedColumnName = "department_id")
    private DepartmentModel department;

    @ManyToOne
    @JoinColumn(name = "course_code", referencedColumnName = "course_code")
    private CourseModel course;


    public int getDepartmentCourseId() {
        return departmentCourseId;
    }



    public DepartmentModel getDepartment() {
        return department;
    }


    public CourseModel getCourse() {
        return course;
    }


}
