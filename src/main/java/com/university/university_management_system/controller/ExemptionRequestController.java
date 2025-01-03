package com.university.university_management_system.controller;

import com.university.university_management_system.DTOs.ExemptionRequestDTO;
import com.university.university_management_system.service.ExemptionRequestService;
import java.util.List;

public class ExemptionRequestController {

    private ExemptionRequestService service;

    public List<ExemptionRequestDTO> getAllExemptionRequests() {
        return service.getAllExemptionRequests();
    }

    public ExemptionRequestDTO getExemptionRequestById(int id) {
        return service.getExemptionRequestById(id);
    }

    public List<ExemptionRequestDTO> getByStudent(String studentId) {
        return service.getByStudent(studentId);
    }

    public List<ExemptionRequestDTO> getByExam(int examId) {
        return service.getByExam(examId);
    }

    public List<ExemptionRequestDTO> getByCourse(String courseCode) {
        return service.getByCourse(courseCode);
    }

    public List<ExemptionRequestDTO> getByStatus(int statusId) {
        return service.getByStatus(statusId);
    }

    public List<ExemptionRequestDTO> getByExemptionType(int requestTypeId) {
        return service.getByExemptionType(requestTypeId);
    }
}
