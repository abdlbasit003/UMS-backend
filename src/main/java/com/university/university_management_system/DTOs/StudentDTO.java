package com.university.university_management_system.DTOs;

import com.university.university_management_system.model.StudentModel;

public class StudentDTO {


    private String uuid;
    private String studentId;
    private String studentName;
    private String departmentName;
    private String enrollmentYear;
    private double CGPA;


    public StudentDTO(String uuid, String studentId, String studentName, String departmentName, String enrollmentYear, double CGPA) {
        this.uuid = uuid;
        this.studentId = studentId;
        this.studentName = studentName;
        this.departmentName = departmentName;
        this.enrollmentYear = enrollmentYear;
        this.CGPA = CGPA;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getEnrollmentYear() {
        return enrollmentYear;
    }

    public void setEnrollmentYear(String enrollmentYear) {
        this.enrollmentYear = enrollmentYear;
    }

    public double getCGPA() {
        return CGPA;
    }

    public void setCGPA(double CGPA) {
        this.CGPA = CGPA;
    }


    public static StudentDTO fromModel(StudentModel studentModel){
        return new StudentDTO(
                studentModel.getUser().getUuid(),
                studentModel.getStudentId(),
                studentModel.getStudentName(),
                studentModel.getDepartment().getDepartmentName(),
                studentModel.getStudentEnrollmentYear(),
                studentModel.getStudentCgpa()
        );
    }


}
