package com.university.university_management_system.model;

import jakarta.persistence.*;

@Entity
@Table(name = "examination_room")
public class ExaminationRoomModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "examination_room_id")
    private int examinationRoomId;

    @ManyToOne
    @JoinColumn(name = "exam_hall_id", referencedColumnName = "exam_hall_id", nullable = false)
    private ExamHallModel examHall;

    @ManyToOne
    @JoinColumn(name = "exam_id", referencedColumnName = "exam_id", nullable = false)
    private ExamModel exam;

    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "student_id", nullable = false)
    private StudentModel student;


    public int getExaminationRoomId() {
        return examinationRoomId;
    }


    public ExamHallModel getExamHall() {
        return examHall;
    }


    public ExamModel getExam() {
        return exam;
    }


    public StudentModel getStudent() {
        return student;
    }


    public int getId() {
        return examinationRoomId;
    }
}
