package com.university.university_management_system.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "student")
public class StudentModel{

    @Id
    @Column(name = "student_id")
    private String studentId;

    @Column(name = "student_name")
    private String studentName;

    @ManyToOne
    @JoinColumn(name = "department_id", referencedColumnName = "department_id")
    private DepartmentModel department;

    @Column(name = "student_cgpa")
    private double studentCgpa;

    @Column(name = "student_enrollment_year")
    private int studentEnrollmentYear;

    @OneToOne
    @JoinColumn(name="student_uuid",referencedColumnName = "uuid")
    private UserModel user;


    public String getStudentId() {
        return studentId;
    }


    public String getStudentName() {
        return studentName;
    }

    public DepartmentModel getDepartment() {
        return department;
    }

    public double getStudentCgpa() {
        return studentCgpa;
    }

    public int getStudentEnrollmentYear() {
        return studentEnrollmentYear;
    }


    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }
}
