package com.university.university_management_system.DTOs;

import com.university.university_management_system.model.InvigilatorModel;
import java.util.HashMap;
import java.util.Map;

public class InvigilatorDTO {
    private int invigilatorId;
    private Map<String, Object> faculty;
    private Map<String, Object> examHall;

    public InvigilatorDTO(){}

    public InvigilatorDTO(int invigilatorId, Map<String, Object> faculty, Map<String, Object> examHall) {
        this.invigilatorId = invigilatorId;
        this.faculty = faculty;
        this.examHall = examHall;
    }

    public int getInvigilatorId() {
        return invigilatorId;
    }

    public void setInvigilatorId(int invigilatorId) {
        this.invigilatorId = invigilatorId;
    }

    public Map<String, Object> getFaculty() {
        return faculty;
    }

    public void setFaculty(Map<String, Object> faculty) {
        this.faculty = faculty;
    }

    public Map<String, Object> getExamHall() {
        return examHall;
    }

    public void setExamHall(Map<String, Object> examHall) {
        this.examHall = examHall;
    }

    public static InvigilatorDTO fromModel(InvigilatorModel model) {
        Map<String, Object> faculty = new HashMap<>();
        faculty.put("facultyUuid", model.getFaculty().getFacultyId());
        faculty.put("facultyName", model.getFaculty().getFacultyName());
        faculty.put("designation", model.getFaculty().getDesignation());

        Map<String, Object> examHall = new HashMap<>();
        examHall.put("examHallId", model.getExamHall().getExamHallId());
        examHall.put("examHallName", model.getExamHall().getExamHallName());

        return new InvigilatorDTO(model.getInvigilatorId(), faculty, examHall);
    }
}
