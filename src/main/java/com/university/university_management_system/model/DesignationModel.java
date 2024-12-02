package com.university.university_management_system.model;

import jakarta.persistence.*;

@Entity
@Table(name = "designation")
public class DesignationModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "designation_id")
    private int designationId;

    @Column(name = "designation_name", nullable = false)
    private String designationName;


    public int getDesignationId() {
        return designationId;
    }


    public String getDesignationName() {
        return designationName;
    }


}
