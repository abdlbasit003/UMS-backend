package com.university.university_management_system.enums;

public enum FacultyDesignation {

    HEAD_OF_DEPARTMENT("Head of Department"),
    VISITING_LECTURER("Visiting Lecturer"),
    FULL_TIME_LECTURER("Full time Lecturer"),
    LAB_INSTRUCTOR("Lab Instructor"),
    TEACHER_ASSISTANT("Teacher's Assistant");

    private final String designation;

    FacultyDesignation(String designation) {
        this.designation = designation;
    }

    public String getDesignation() {
        return designation;
    }

}

