package com.university.university_management_system.service;

import com.university.university_management_system.DTOs.ExemptionRequestDTO;
import com.university.university_management_system.model.ExemptionRequestModel;
import com.university.university_management_system.repository.ExemptionRequestRepository;
import com.university.university_management_system.exceptions.ApiException;
import org.springframework.http.HttpStatus;


import java.util.ArrayList;
import java.util.List;

public class ExemptionRequestService {

    private ExemptionRequestRepository repository;

    public List<ExemptionRequestDTO> getAllExemptionRequests() {
        List<ExemptionRequestModel> models = repository.findAll();
        List<ExemptionRequestDTO> DTOs = new ArrayList<>();

        for (ExemptionRequestModel model : models) {
            DTOs.add(ExemptionRequestDTO.fromModel(model));
        }
        return DTOs;
    }

    public ExemptionRequestDTO getExemptionRequestById(int id) {
        ExemptionRequestModel model = repository.findById(id).orElse(null);

        if (model == null) {
            throw new ApiException("Exception request not found", HttpStatus.NOT_FOUND);
        }return ExemptionRequestDTO.fromModel(model);
    }

    public List<ExemptionRequestDTO> getByStudent(String studentId) {
        List<ExemptionRequestModel> models = repository.findAll();
        List<ExemptionRequestDTO> DTOs = new ArrayList<>();

        for (ExemptionRequestModel model : models) {
            if (model.getStudent().getStudentId().equals(studentId)) {
                DTOs.add(ExemptionRequestDTO.fromModel(model));
            }
        }
        return DTOs;
    }

    public List<ExemptionRequestDTO> getByExam(int examId) {
        List<ExemptionRequestModel> models = repository.findAll();
        List<ExemptionRequestDTO> DTOs = new ArrayList<>();

        for (ExemptionRequestModel model : models) {
            if (model.getExam().getExamId() == examId) {
                DTOs.add(ExemptionRequestDTO.fromModel(model));
            }
        }
        return DTOs;
    }

    public List<ExemptionRequestDTO> getByCourse(String courseCode) {
        List<ExemptionRequestModel> models = repository.findAll();
        List<ExemptionRequestDTO> DTOs = new ArrayList<>();

        for (ExemptionRequestModel model : models) {
            if (model.getExam().getCourse().getCourseCode().equals(courseCode)) {
                DTOs.add(ExemptionRequestDTO.fromModel(model));
            }
        }
        return DTOs;
    }

    public List<ExemptionRequestDTO> getByStatus(int statusId) {
        List<ExemptionRequestModel> models = repository.findAll();
        List<ExemptionRequestDTO> DTOs = new ArrayList<>();

        for (ExemptionRequestModel model : models) {
            if (model.getStatus().getStatusId() == statusId) {
                DTOs.add(ExemptionRequestDTO.fromModel(model));
            }
        }
        return DTOs;
    }

    public List<ExemptionRequestDTO> getByExemptionType(int requestTypeId) {
        List<ExemptionRequestModel> models = repository.findAll();
        List<ExemptionRequestDTO> DTOs = new ArrayList<>();

        for (ExemptionRequestModel model : models) {
            if (model.getExemptionRequestType().getRequestTypeId() == requestTypeId) {
                DTOs.add(ExemptionRequestDTO.fromModel(model));
            }
        }
        return DTOs;
    }
}
