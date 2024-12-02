package com.university.university_management_system.model;

import jakarta.persistence.*;

@Entity
@Table(name = "course_result")
public class CourseResultModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_result_id")
    private int courseResultId;

    @Column(name = "marks_obtained", nullable = false)
    private int marksObtained;

    @Column(name = "grade", nullable = false)
    private String grade;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id", referencedColumnName = "student_id", nullable = false)
    private StudentModel student;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_code", referencedColumnName = "course_code", nullable = false)
    private CourseModel course;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "exam_id", referencedColumnName = "exam_id", nullable = false)
    private ExamModel exam;


    public int getCourseResultId() {
        return courseResultId;
    }

    public int getMarksObtained() {
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
