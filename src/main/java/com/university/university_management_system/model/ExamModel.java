package com.university.university_management_system.model;

import com.university.university_management_system.DTOs.ExamDTO;
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

    public ExamModeModel getExamMode() {
        return examMode;
    }

    public void setCourse(CourseModel course) {
        this.course = course;
    }

    public void setExamType(ExamTypeModel examType) {
        this.examType = examType;
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
