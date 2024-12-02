package com.university.university_management_system.model;

import jakarta.persistence.*;

@Entity
@Table(name = "department")
public class DepartmentModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "department_id")
    private int departmentId;

    @Column(name = "department_name")
    private String departmentName;

    @OneToOne
    @JoinColumn(name = "department_head_id", referencedColumnName = "faculty_id")
    private FacultyModel departmentHead;


    public int getDepartmentId() {
        return departmentId;
    }



    public String getDepartmentName() {
        return departmentName;
    }



    public FacultyModel getDepartmentHead() {
        return departmentHead;
    }


}
