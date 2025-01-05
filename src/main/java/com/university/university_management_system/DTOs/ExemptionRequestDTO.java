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

    public ExemptionRequestDTO(int requestId, StudentDTO student, ExamDTO exam, HashMap<String, String> requestType, HashMap<String, String> requestStatus, LocalDateTime submittedOn, UserModel reviewedBy, LocalDateTime reviewedOn) {
        this.requestId = requestId;
        this.student = student;
        this.exam = exam;
        this.requestType = requestType;
        this.requestStatus = requestStatus;
        this.submittedOn = submittedOn;
        this.reviewedBy = reviewedBy;
        this.reviewedOn = reviewedOn;
    }

    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public StudentDTO getStudent() {
        return student;
    }

    public void setStudent(StudentDTO student) {
        this.student = student;
    }

    public ExamDTO getExam() {
        return exam;
    }

    public void setExam(ExamDTO exam) {
        this.exam = exam;
    }

    public HashMap<String, String> getRequestType() {
        return requestType;
    }

    public void setRequestType(HashMap<String, String> requestType) {
        this.requestType = requestType;
    }

    public HashMap<String, String> getRequestStatus() {
        return requestStatus;
    }

    public void setRequestStatus(HashMap<String, String> requestStatus) {
        this.requestStatus = requestStatus;
    }

    public LocalDateTime getSubmittedOn() {
        return submittedOn;
    }

    public void setSubmittedOn(LocalDateTime submittedOn) {
        this.submittedOn = submittedOn;
    }

    public UserModel getReviewedBy() {
        return reviewedBy;
    }

    public void setReviewedBy(UserModel reviewedBy) {
        this.reviewedBy = reviewedBy;
    }

    public LocalDateTime getReviewedOn() {
        return reviewedOn;
    }

    public void setReviewedOn(LocalDateTime reviewedOn) {
        this.reviewedOn = reviewedOn;
    }

    public static ExemptionRequestDTO fromModel(ExemptionRequestModel model) {
        HashMap<String,String> requestType = new HashMap<>();
        requestType.put("requestId", String.valueOf(model.getExemptionRequestType().getRequestTypeId()));
        requestType.put("requestType", model.getExemptionRequestType().getName());
        HashMap<String,String> requestStatus = new HashMap<>();
        requestStatus.put("requestStatusId", String.valueOf(model.getStatus().getStatusId()));
        requestStatus.put("requestStatus", model.getStatus().getStatusName());
        return new ExemptionRequestDTO(
                model.getRequestId(),
                StudentDTO.fromModel(model.getStudent()),
                ExamDTO.fromModel(model.getExam()),
                requestType,
                requestStatus,
                model.getDateSubmittedOn(),
                model.getReviewedBy(),
                model.getDateReviewedOn()
        );
    }

}
