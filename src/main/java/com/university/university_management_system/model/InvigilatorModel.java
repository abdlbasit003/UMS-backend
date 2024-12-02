package com.university.university_management_system.model;

import jakarta.persistence.*;

@Entity
@Table(name = "invigilator")
public class InvigilatorModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "invigilator_id")
    private int invigilatorId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "faculty_id", referencedColumnName = "faculty_id", nullable = false)
    private FacultyModel faculty;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "exam_hall_id", referencedColumnName = "exam_hall_id", nullable = false)
    private ExamHallModel examHall;


    public int getInvigilatorId() {
        return invigilatorId;
    }



    public FacultyModel getFaculty() {
        return faculty;
    }


    public ExamHallModel getExamHall() {
        return examHall;
    }


}
