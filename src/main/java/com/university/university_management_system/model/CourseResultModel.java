package com.university.university_management_system.model;

import jakarta.persistence.*;

@Entity
@Table(name = "course_result")
public class CourseResultModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_result_id")
    private int courseResultId;

    @Column(name = "marks_obtained")
    private double marksObtained;

    @Column(name = "grade")
    private String grade;

    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "student_id")
    private StudentModel student;

    @ManyToOne
    @JoinColumn(name = "course_code", referencedColumnName = "course_code")
    private CourseModel course;

    @OneToOne
    @JoinColumn(name = "exam_id", referencedColumnName = "exam_id")
    private ExamModel exam;


    public int getCourseResultId() {
        return courseResultId;
    }

    public double getMarksObtained() {
        return marksObtained;
    }

    public String getGrade() {
        return grade;
    }


    public StudentModel getStudent() {
        return student;
    }


    public CourseModel getCourse() {
        return course;
    }


    public ExamModel getExam() {
        return exam;
    }

}
