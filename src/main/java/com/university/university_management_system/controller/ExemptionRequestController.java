package com.university.university_management_system.controller;

import com.university.university_management_system.DTOs.ExemptionRequestDTO;
import com.university.university_management_system.service.ExemptionRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Tag (name = "Exemption Request", description = "Exemption Request endpoints" )

public class ExemptionRequestController {

    @Autowired
    private ExemptionRequestService service;

    @GetMapping("/exemptions")
    public List<ExemptionRequestDTO> getAllExemptionRequests() {
        return service.getAllExemptionRequests();
    }
    @GetMapping("/exemptions/{id}")
    public ExemptionRequestDTO getExemptionRequestById(@PathVariable int id) {
        return service.getExemptionRequestById(id);
    }
    @GetMapping("/students/{studentId}/exemptions")
    public List<ExemptionRequestDTO> getByStudent(@PathVariable String studentId) {
        return service.getByStudent(studentId);
    }
    @GetMapping("/exams/{examId}/exemptions")
    public List<ExemptionRequestDTO> getByExam(@PathVariable int examId) {
        return service.getByExam(examId);
    }
    @GetMapping("/courses/{courseCode}/exemptions")
    public List<ExemptionRequestDTO> getByCourse(@PathVariable String courseCode) {
        return service.getByCourse(courseCode);
    }

    @GetMapping("/exemptions/status/{statusId}")
    public List<ExemptionRequestDTO> getByStatus(@PathVariable int statusId) {
        return service.getByStatus(statusId);
    }

    @GetMapping("/exemptions/type/{requestTypeId}")
    public List<ExemptionRequestDTO> getByExemptionType(int requestTypeId) {
        return service.getByExemptionType(requestTypeId);
    }
}
