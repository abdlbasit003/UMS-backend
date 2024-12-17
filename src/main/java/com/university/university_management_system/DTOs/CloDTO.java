package com.university.university_management_system.DTOs;

import com.university.university_management_system.model.CLOModel;

import java.util.HashMap;
import java.util.Map;

public class CloDTO {
    public int cloId;
    public String cloTitle;
    public String cloDescription;
    public Map<String, Object> course ;

    public CloDTO(int cloId, String cloTitle, String cloDescription, Map<String, Object> course) {
        this.cloId = cloId;
        this.cloTitle = cloTitle;
        this.cloDescription = cloDescription;
        this.course = course;
    }

    public int getCloId() {
        return cloId;
    }

    public void setCloId(int cloId) {
        this.cloId = cloId;
    }

    public String getCloTitle() {
        return cloTitle;
    }

    public void setCloTitle(String cloTitle) {
        this.cloTitle = cloTitle;
    }

    public String getCloDescription() {
        return cloDescription;
    }

    public void setCloDescription(String cloDescription) {
        this.cloDescription = cloDescription;
    }

    public Map<String, Object> getCourse() {
        return course;
    }

    public void setCourse(Map<String, Object> course) {
        this.course = course;
    }

    public static CloDTO fromModel(CLOModel cloModel){
        Map<String , Object> course = new HashMap<>();
        course.put("courseCode", cloModel.getCourse().getCourseCode());
        course.put("courseName", cloModel.getCourse().getCourseName());
        return new CloDTO(cloModel.getCloId(), cloModel.getTitle(), cloModel.getDescription(),course );
    }
}
