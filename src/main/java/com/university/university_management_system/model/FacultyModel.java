package com.university.university_management_system.model;

import jakarta.persistence.*;

@Entity
@Table(name = "faculty")
public class FacultyModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "faculty_id")
    private int facultyId;

    @Column(name = "faculty_name", nullable = false)
    private String facultyName;


    @OneToOne
    @JoinColumn(name = "designation_id", referencedColumnName = "designation_id")
    private DesignationModel designation;

    @Column(name = "faculty_arrival_time", nullable = false)
    private String facultyArrivalTime;

    @Column(name = "faculty_off_time", nullable = false)
    private String facultyOffTime;


    @OneToOne
    @JoinColumn(name="faculty_uuid",referencedColumnName = "uuid")
    private UserModel user;

    public int getFacultyId() {
        return facultyId;
    }

    public String getFacultyName() {
        return facultyName;
    }


    public DesignationModel getDesignation() {
        return designation;
    }


    public String getFacultyArrivalTime() {
        return facultyArrivalTime;
    }


    public String getFacultyOffTime() {
        return facultyOffTime;
    }


    public UserModel getUuid() {
        return user;
    }

    public void setUuid(UserModel user) {
        this.user = user;
    }
}
