package com.university.university_management_system.model;

import jakarta.persistence.*;

@Entity
@Table(name = "course_instructor")
public class CourseInstructorModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_instructor_id")
    private int courseInstructorId;

    @ManyToOne
    @JoinColumn(name = "faculty_id", referencedColumnName = "faculty_id")
    private FacultyModel faculty;

    @ManyToOne
    @JoinColumn(name = "course_code", referencedColumnName = "course_code")
    private CourseModel course;


    public int getCourseInstructorId() {
        return courseInstructorId;
    }

    public FacultyModel getFaculty() {
        return faculty;
    }

    public CourseModel getCourse() {
        return course;
    }


}
