package com.university.university_management_system.DTOs;

import com.university.university_management_system.model.FacultyModel;

import java.util.HashMap;
import java.util.Map;

public class FacultyDTO {
    private int facultyId;
    private String facultyName;
    private String designation;
    private String facultyArrivalTime;
    private String facultyOffTime;
    private String facultyUuid;

    // Constructors
    public FacultyDTO() {}

    public FacultyDTO(int facultyId, String facultyName, String designation, String facultyArrivalTime, String facultyOffTime, String facultyUuid) {
        this.facultyId = facultyId;
        this.facultyName = facultyName;
        this.designation = designation;
        this.facultyArrivalTime = facultyArrivalTime;
        this.facultyOffTime = facultyOffTime;
        this.facultyUuid = facultyUuid;
    }

    // Getters and Setters
    public int getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(int facultyId) {
        this.facultyId = facultyId;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getFacultyArrivalTime() {
        return facultyArrivalTime;
    }

    public void setFacultyArrivalTime(String facultyArrivalTime) {
        this.facultyArrivalTime = facultyArrivalTime;
    }

    public String getFacultyOffTime() {
        return facultyOffTime;
    }

    public void setFacultyOffTime(String facultyOffTime) {
        this.facultyOffTime = facultyOffTime;
    }

    public String getFacultyUuid() {
        return facultyUuid;
    }

    public void setFacultyUuid(String facultyUuid) {
        this.facultyUuid = facultyUuid;
    }

    // Static fromModel method
    public static FacultyDTO fromModel(FacultyModel facultyModel) {


        return new FacultyDTO(
                facultyModel.getFacultyId(),
                facultyModel.getFacultyName(),
                facultyModel.getDesignation().getDesignationName(),
                facultyModel.getFacultyArrivalTime(),
                facultyModel.getFacultyOffTime(),
                facultyModel.getUser().getUuid());
    }





}
