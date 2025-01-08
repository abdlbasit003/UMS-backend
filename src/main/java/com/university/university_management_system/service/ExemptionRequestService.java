package com.university.university_management_system.service;

import com.university.university_management_system.DTOs.ExemptionRequestDTO;
import com.university.university_management_system.model.ExemptionRequestModel;
import com.university.university_management_system.repository.ExemptionRequestRepository;
import com.university.university_management_system.exceptions.ApiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class ExemptionRequestService {

    @Autowired
    private ExemptionRequestRepository repository;

    public List<ExemptionRequestDTO> getAllExemptionRequests() {
        return repository.findAll().stream()
                .map(ExemptionRequestDTO::fromModel)
                .toList();
    }

    public ExemptionRequestDTO getExemptionRequestById(int id) {
        ExemptionRequestModel model = repository.findById(id)
                .orElseThrow(() -> new ApiException("Exception request not found", HttpStatus.NOT_FOUND));
        return ExemptionRequestDTO.fromModel(model);
    }

    public List<ExemptionRequestDTO> getByStudent(String studentId) {
        return repository.findAll().stream()
                .filter(model -> model.getStudent().getStudentId().equals(studentId))
                .map(ExemptionRequestDTO::fromModel)
                .toList();
    }

    public List<ExemptionRequestDTO> getByExam(int examId) {
        return repository.findAll().stream()
                .filter(model -> model.getExam().getExamId() == examId)
                .map(ExemptionRequestDTO::fromModel)
                .toList();
    }

    public List<ExemptionRequestDTO> getByCourse(String courseCode) {
        return repository.findAll().stream()
                .filter(model -> model.getExam().getCourse().getCourseCode().equals(courseCode))
                .map(ExemptionRequestDTO::fromModel)
                .toList();
    }

    public List<ExemptionRequestDTO> getByStatus(int statusId) {
        return repository.findAll().stream()
                .filter(model -> model.getStatus().getStatusId() == statusId)
                .map(ExemptionRequestDTO::fromModel)
                .toList();
    }

    public List<ExemptionRequestDTO> getByExemptionType(int requestTypeId) {
        return repository.findAll().stream()
                .filter(model -> model.getExemptionRequestType().getRequestTypeId() == requestTypeId)
                .map(ExemptionRequestDTO::fromModel)
                .toList();
    }

}
