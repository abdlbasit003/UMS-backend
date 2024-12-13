package com.university.university_management_system.model;

import jakarta.persistence.*;

@Entity
public class ExamContentTypeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "type_id")
    private int typeId;

    @Column(name = "type", nullable = false)
    private String type;

    public int getTypeId() {
        return typeId;
    }

    public String getType() {
        return type;
    }
}
