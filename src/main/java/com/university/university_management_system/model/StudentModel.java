package com.university.university_management_system.model;

import jakarta.persistence.*;

@Entity
@Table(name = "student")
public class StudentModel {

    @Id
    @Column(name = "student_id")
    private String studentId;

    @Column(name = "student_name")
    private String studentName;

    @Column(name = "student_email")
    private String studentEmail;

    @Column(name = "student_phone_number")
    private String studentPhoneNumber;

    @ManyToOne
    @JoinColumn(name = "department_id", referencedColumnName = "department_id")
    private DepartmentModel department;

    @Column(name = "student_cgpa")
    private double studentCgpa;

    @Column(name = "student_enrollment_year")
    private int studentEnrollmentYear;


    public String getStudentId() {
        return studentId;
    }


    public String getStudentName() {
        return studentName;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public String getStudentPhoneNumber() {
        return studentPhoneNumber;
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


}
