package com.university.university_management_system.DTOs;

import com.university.university_management_system.model.SemesterCourseModel;

import java.util.HashMap;
import java.util.Map;

public class SemesterCourseDTO {
   public int semesterCourseId;
   public Map<String, Object> semester;
   public Map<String, Object> course;

    public SemesterCourseDTO(int semesterCourseId, Map<String, Object> semester, Map<String, Object> course) {
        this.semesterCourseId = semesterCourseId;
        this.semester = semester;
        this.course = course;
    }

    public int getSemesterCourseId() {
        return this.semesterCourseId;
    }

    public void setSemesterCourseId(int semesterCourseId) {
        this.semesterCourseId = semesterCourseId;
    }

    public Map<String, Object> getSemester() {
        return this.semester;
    }

    public void setSemester(Map<String, Object> semester) {
        this.semester = semester;
    }

    public Map<String, Object> getCourse() {
        return this.course;
    }

    public void setCourse(Map<String, Object> course) {
        this.course = course;
    }
    public static SemesterCourseDTO fromModel(SemesterCourseModel scm){
        Map<String, Object> semester = new HashMap<>();
        semester.put("semesterId", scm.getSemester().getSemesterId());
        semester.put("semesterName", scm.getSemester().getSemesterName());

        Map<String, Object> course = new HashMap<>();
        course.put("courseCode", scm.getCourseCode().getCourseCode() );
        course.put("courseName",scm.getCourseCode().getCourseName() );
        return new SemesterCourseDTO(scm.getSemesterCourseId(),semester,course);
    }
}
