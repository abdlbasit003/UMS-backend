package com.university.university_management_system.model;

import jakarta.persistence.*;

@Entity
@Table(name = "department_faculty")
public class DepartmentFacultyModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "department_faculty_id")
    private int departmentFacultyId;

    @ManyToOne
    @JoinColumn(name = "department_id", referencedColumnName = "department_id")
    private DepartmentModel department;

    @ManyToOne
    @JoinColumn(name = "faculty_id", referencedColumnName = "faculty_id")
    private FacultyModel faculty;


    public int getDepartmentFacultyId() {
        return departmentFacultyId;
    }



    public DepartmentModel getDepartment() {
        return department;
    }



    public FacultyModel getFaculty() {
        return faculty;
    }


}
