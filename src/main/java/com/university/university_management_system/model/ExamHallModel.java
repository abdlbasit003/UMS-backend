package com.university.university_management_system.model;

import jakarta.persistence.*;

@Entity
@Table(name = "exam_hall")
public class ExamHallModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exam_hall_id")
    private int examHallId;

    @Column(name = "exam_hall_name", nullable = false)
    private String examHallName;

    @Column(name = "number_of_seats", nullable = false)
    private int numberOfSeats;


    public int getExamHallId() {
        return examHallId;
    }

    public String getExamHallName() {
        return examHallName;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }


}
