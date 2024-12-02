package com.university.university_management_system.model;

import jakarta.persistence.*;

@Entity
@Table(name = "exam_mode")
public class ExamModeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exam_mode_id")
    private int examModeId;

    @Column(name = "exam_mode_name", nullable = false)
    private String examModeName;

    public int getExamModeId() {
        return examModeId;
    }

    public String getExamModeName() {
        return examModeName;
    }

}
