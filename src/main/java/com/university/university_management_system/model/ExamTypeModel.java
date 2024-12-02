package com.university.university_management_system.model;

import jakarta.persistence.*;

@Entity
@Table(name = "exam_type")
public class ExamTypeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exam_type_id")
    private int examTypeId;

    @Column(name = "exam_type_name", nullable = false)
    private String examTypeName;


    public int getExamTypeId() {
        return examTypeId;
    }

    public String getExamTypeName() {
        return examTypeName;
    }

}
