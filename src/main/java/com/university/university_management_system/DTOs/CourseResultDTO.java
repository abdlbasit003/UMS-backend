package com.university.university_management_system.DTOs;

import com.university.university_management_system.model.CourseResultModel;

import java.util.HashMap;
import java.util.Map;

public class CourseResultDTO {


    private int courseResultId;
    private double marksObtained;
    private String grade;
    private StudentDTO student;
    private Map<String,Object> course;
    private ExamDTO exam;

    public CourseResultDTO(int courseResultId, double marksObtained, String grade, StudentDTO student, Map<String, Object> course, ExamDTO exam) {
        this.courseResultId = courseResultId;
        this.marksObtained = marksObtained;
        this.grade = grade;
        this.student = student;
        this.course = course;
        this.exam = exam;
    }

    public int getCourseResultId() {
        return courseResultId;
    }

    public void setCourseResultId(int courseResultId) {
        this.courseResultId = courseResultId;
    }

    public double getMarksObtained() {
        return marksObtained;
    }

    public void setMarksObtained(double marksObtained) {
        this.marksObtained = marksObtained;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public StudentDTO getStudent() {
        return student;
    }

    public void setStudent(StudentDTO student) {
        this.student = student;
    }

    public Map<String, Object> getCourse() {
        return course;
    }

    public void setCourse(Map<String, Object> course) {
        this.course = course;
    }

    public ExamDTO getExam() {
        return exam;
    }

    public void setExam(ExamDTO exam) {
        this.exam = exam;
    }


    public static CourseResultDTO fromModel(CourseResultModel courseResultModel) {
        Map<String, Object> course = new HashMap<>();
        course.put("courseCode", courseResultModel.getCourse().getCourseCode());
        course.put("course", courseResultModel.getCourse().getCourseName());

        return new CourseResultDTO(courseResultModel.getCourseResultId(), courseResultModel.getMarksObtained(),
                courseResultModel.getGrade(), StudentDTO.fromModel(courseResultModel.getStudent()), course, ExamDTO.fromModel(courseResultModel.getExam()));
    }



}
