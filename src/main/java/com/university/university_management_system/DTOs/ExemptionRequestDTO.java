package com.university.university_management_system.DTOs;

import com.university.university_management_system.model.ExemptionRequestModel;
import com.university.university_management_system.model.UserModel;

import java.time.LocalDateTime;
import java.util.HashMap;

public class ExemptionRequestDTO {
    private int requestId;
    private StudentDTO student;
    private ExamDTO exam;
    private HashMap<String, String> requestType;
    private HashMap<String, String> requestStatus;
    private LocalDateTime submittedOn;
    private UserModel reviewedBy;
    private LocalDateTime reviewedOn;

    public static ExemptionRequestDTO fromModel(ExemptionRequestModel model) {
        ExemptionRequestDTO DTO = new ExemptionRequestDTO();
        DTO.requestId = model.getRequestId();
        DTO.student = StudentDTO.fromModel(model.getStudent());
        DTO.exam = ExamDTO.fromModel(model.getExam());

        DTO.requestType = new HashMap<>();
        DTO.requestType.put("requestId", String.valueOf(model.getExemptionRequestType().getRequestTypeId()));
        DTO.requestType.put("requestType", model.getExemptionRequestType().getName());

        DTO.requestStatus = new HashMap<>();
        DTO.requestStatus.put("requestStatusId", String.valueOf(model.getStatus().getStatusId()));
        DTO.requestStatus.put("requestStatus", model.getStatus().getStatusName());

        DTO.submittedOn = model.getDateSubmittedOn();

        if (model.getReviewedBy() != null) {
            DTO.reviewedBy = model.getReviewedBy();
        }else {
            DTO.reviewedBy = null;
        }

        DTO.reviewedOn = model.getDateReviewedOn();
        return DTO;
    }

}
