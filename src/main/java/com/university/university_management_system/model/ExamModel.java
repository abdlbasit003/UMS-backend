package com.university.university_management_system.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "exam")
public class ExamModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exam_id")
    private int examId;

    @ManyToOne
    @JoinColumn(name = "course_code", referencedColumnName = "course_code")
    private CourseModel course;

    @OneToOne
    @JoinColumn(name = "exam_type_id", referencedColumnName = "exam_type_id")
    private ExamTypeModel examType;

    @Column(name = "exam_start_time")
    private LocalTime examStartTime;

    @Column(name = "exam_end_time")
    private LocalTime examEndTime;

    @Column(name = "exam_date")
    private LocalDate examDate;

    @Column(name = "weightage")
    private String weightage;

    @OneToOne
    @JoinColumn(name = "exam_mode_id", referencedColumnName = "exam_mode_id")
    private ExamModeModel examMode;


    public int getExamId() {
        return examId;
    }

    public CourseModel getCourse() {
        return course;
    }

    public ExamTypeModel getExamType() {
        return examType;
    }

    public LocalTime getExamStartTime() {
        return examStartTime;
    }

    public LocalTime getExamEndTime() {
        return examEndTime;
    }

    public LocalDate getExamDate() {
        return examDate;
    }



    public ExamModeModel getExamMode() {
        return examMode;
    }

    public void setCourse(CourseModel course) {
        this.course = course;
    }

    public void setExamType(ExamTypeModel examType) {
        this.examType = examType;
    }

    public void setExamStartTime(LocalTime examStartTime) {
        this.examStartTime = examStartTime;
    }

    public void setExamEndTime(LocalTime examEndTime) {
        this.examEndTime = examEndTime;
    }

    public void setExamDate(LocalDate examDate) {
        this.examDate = examDate;
    }


    public void setExamMode(ExamModeModel examMode) {
        this.examMode = examMode;
    }

    public String getWeightage() {
        return weightage;
    }

    public void setWeightage(String weightage) {
        this.weightage = weightage;
    }
}
