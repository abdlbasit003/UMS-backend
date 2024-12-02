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

    @ManyToOne
    @JoinColumn(name = "exam_hall_id", referencedColumnName = "exam_hall_id")
    private ExamHallModel examHall;

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

    public ExamHallModel getExamHall() {
        return examHall;
    }

    public ExamModeModel getExamMode() {
        return examMode;
    }

}
