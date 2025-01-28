package com.university.university_management_system.DTOs;

import com.university.university_management_system.model.SemesterModel;
import com.university.university_management_system.model.StudentModel;

public class StudentDTO {


    private String uuid;
    private String studentId;
    private String studentName;
    private String departmentName;
    private String enrollmentYear;
    private SemesterModel semester;
    private double CGPA;


    public StudentDTO(String uuid, String studentId, String studentName, String departmentName, String enrollmentYear,SemesterModel semester, double CGPA) {
        this.uuid = uuid;
        this.studentId = studentId;
        this.studentName = studentName;
        this.departmentName = departmentName;
        this.enrollmentYear = enrollmentYear;
        this.semester = semester;
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

    public SemesterModel getSemester() {
        return semester;
    }

    public void setSemester(SemesterModel semester) {
        this.semester = semester;
    }

    public static StudentDTO fromModel(StudentModel studentModel){
        return new StudentDTO(
                studentModel.getUser().getUuid(),
                studentModel.getStudentId(),
                studentModel.getStudentName(),
                studentModel.getDepartment().getDepartmentName(),
                studentModel.getStudentEnrollmentYear(),
                studentModel.getSemester(),
                studentModel.getStudentCgpa()
        );
    }
}
