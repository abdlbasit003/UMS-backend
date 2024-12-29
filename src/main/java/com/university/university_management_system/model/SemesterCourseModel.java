package com.university.university_management_system.model;

import jakarta.persistence.*;

@Entity
@Table(name = "semester_course")
public class SemesterCourseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "semester_course_id")
    private int semesterCourseId;

    @OneToOne
    @JoinColumn(name = "semester_id", referencedColumnName = "semester_id")
    private SemesterModel semester;

    @OneToOne()
    @JoinColumn(name = "course_code", referencedColumnName = "course_code")
    private CourseModel course;



    public int getSemesterCourseId() {
        return semesterCourseId;
    }

    public void setSemesterCourseId(int semesterCourseId) {
        this.semesterCourseId = semesterCourseId;
    }

    public SemesterModel getSemester() {
        return semester;
    }

    public void setSemester(SemesterModel semester) {
        this.semester = semester;
    }

    public CourseModel getCourseCode() {
        return course;
    }

    public void setCourseCode(CourseModel courseCode) {
        this.course = courseCode;
    }
}
