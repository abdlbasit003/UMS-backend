package com.university.university_management_system.DTOs;


import com.university.university_management_system.model.ExamModel;

import java.util.HashMap;
import java.util.Map;
import java.time.LocalDate;
import java.time.LocalTime;

public class ExamDTO {
    public int examId;
    public Map<String, Object> course;

    public String examTypeName;
    public String examModeName;
    public LocalTime examStartTime;
    public LocalTime examEndTime;

    public LocalDate examDate;

    public ExamDTO(int examId, Map<String, Object> course,  String examTypeName, String examModeName, LocalTime examStartTime, LocalTime examEndTime, LocalDate examDate) {
        this.examId = examId;
        this.course = course;

        this.examTypeName = examTypeName;
        this.examModeName = examModeName;
        this.examEndTime = examEndTime;
        this.examStartTime = examStartTime;
        this.examDate = examDate;
    }

    public int getExamId() {
        return examId;
    }

    public void setExamId(int examId) {
        this.examId = examId;
    }

    public Map<String, Object> getCourse() {
        return course;
    }

    public void setCourse(Map<String, Object> course) {
        this.course = course;
    }


    public String getExamTypeName() {
        return examTypeName;
    }

    public void setExamTypeName(String examTypeName) {
        this.examTypeName = examTypeName;
    }

    public String getExamModeName() {
        return examModeName;
    }

    public void setExamModeName(String examModeName) {
        this.examModeName = examModeName;
    }

    public LocalTime getExamStartTime() {
        return examStartTime;
    }

    public void setExamStartTime(LocalTime examStartTime) {
        this.examStartTime = examStartTime;
    }

    public LocalTime getExamEndTime() {
        return examEndTime;
    }

    public void setExamEndTime(LocalTime examEndTime) {
        this.examEndTime = examEndTime;
    }

    public LocalDate getExamDate() {
        return examDate;
    }

    public void setExamDate(LocalDate examDate) {
        this.examDate = examDate;
    }

    public static ExamDTO fromModel(ExamModel examModel){
         Map<String, Object> course = new HashMap<>();
         course.put("courseCode",  examModel.getCourse().getCourseCode());
         course.put("courseName", examModel.getCourse().getCourseName());
        return new ExamDTO(examModel.getExamId(), course ,  examModel.getExamType().getExamTypeName(), examModel.getExamMode().getExamModeName(), examModel.getExamStartTime(), examModel.getExamEndTime(),examModel.getExamDate());
    }
}
