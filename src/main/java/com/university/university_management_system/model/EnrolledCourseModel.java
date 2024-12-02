package com.university.university_management_system.model;

import jakarta.persistence.*;

@Entity
@Table(name = "enrolled_course")
public class EnrolledCourseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "enrolled_course_id")
    private int enrolledCourseId;

    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "student_id")
    private StudentModel student;

    @ManyToOne
    @JoinColumn(name = "course_code", referencedColumnName = "course_code")
    private CourseModel course;


    public int getEnrolledCourseId() {
        return enrolledCourseId;
    }

    public StudentModel getStudent() {
        return student;
    }

    public CourseModel getCourse() {
        return course;
    }


}
