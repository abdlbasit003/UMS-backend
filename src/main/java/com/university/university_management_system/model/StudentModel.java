package com.university.university_management_system.model;

import jakarta.persistence.*;

@Entity
@Table(name = "student")
public class StudentModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private int studentId;

    @Column(name = "student_name", nullable = false)
    private String studentName;

    @Column(name = "student_email", nullable = false, unique = true)
    private String studentEmail;

    @Column(name = "student_phone_number", nullable = false)
    private String studentPhoneNumber;

    @ManyToOne
    @JoinColumn(name = "department_id", referencedColumnName = "department_id", nullable = false)
    private DepartmentModel department;

    @Column(name = "student_cgpa")
    private double studentCgpa;

    @Column(name = "student_enrollment_year", nullable = false)
    private int studentEnrollmentYear;


    public int getStudentId() {
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
