package com.university.university_management_system.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

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
    private String studentEnrollmentYear;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="student_uuid",referencedColumnName = "uuid")
    private UserModel user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="semester_id",referencedColumnName = "semester_id")
    private SemesterModel semester;


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

    public String getStudentEnrollmentYear() {
        return studentEnrollmentYear;
    }

    public SemesterModel getSemester() {
        return semester;
    }

    public void setSemester(SemesterModel semester) {
        this.semester = semester;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    public static Map<String,Object> toJson(StudentModel studentModel){
        Map<String,Object> studentJson = new HashMap<>();
        studentJson.put("studentId",studentModel.getStudentId());
        studentJson.put("studentName",studentModel.getStudentName());
        studentJson.put("studentDepartment",studentModel.getDepartment());
        studentJson.put("studentEnrollmentYear",studentModel.getStudentEnrollmentYear());
        return studentJson;
    }
}
