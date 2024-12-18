package com.university.university_management_system.DTOs;

import com.university.university_management_system.model.ExamPaperSubmissionModel;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ExamSubmissionDTO {
    private int submissionId;
    private LocalDateTime submissionDueDate;
    private LocalDateTime submittedOn;
    private Map<String, Object> submittedBy;
    private String status;
    private ExamDTO exam;

    public ExamSubmissionDTO(int submissionId, LocalDateTime submissionDueDate, LocalDateTime submittedOn, Map<String, Object> submittedBy, String status, ExamDTO exam) {
        this.submissionId = submissionId;
        this.submissionDueDate = submissionDueDate;
        this.submittedOn = submittedOn;
        this.submittedBy = submittedBy;
        this.status = status;
        this.exam = exam;
    }

    public int getSubmissionId() {
        return submissionId;
    }

    public void setSubmissionId(int submissionId) {
        this.submissionId = submissionId;
    }

    public LocalDateTime getSubmissionDueDate() {
        return submissionDueDate;
    }

    public void setSubmissionDueDate(LocalDateTime submissionDueDate) {
        this.submissionDueDate = submissionDueDate;
    }

    public LocalDateTime getSubmittedOn() {
        return submittedOn;
    }

    public void setSubmittedOn(LocalDateTime submittedOn) {
        this.submittedOn = submittedOn;
    }

    public Map<String, Object> getSubmittedBy() {
        return submittedBy;
    }

    public void setSubmittedBy(Map<String, Object> submittedBy) {
        this.submittedBy = submittedBy;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ExamDTO getExam() {
        return exam;
    }

    public void setExam(ExamDTO exam) {
        this.exam = exam;
    }
    public static ExamSubmissionDTO fromModel(ExamPaperSubmissionModel examPaperSubmissionModel){
        ExamDTO exam = ExamDTO.fromModel(examPaperSubmissionModel.getExam());
        HashMap<String, Object> submittedBy = new HashMap<>();
        submittedBy.put("facultyId", examPaperSubmissionModel.getSubmittedBy().getFacultyId());
        submittedBy.put("facultyName", examPaperSubmissionModel.getSubmittedBy().getFacultyName());

        return new ExamSubmissionDTO(
                examPaperSubmissionModel.getSubmissionId(), examPaperSubmissionModel.getSubmissionDueDate(),
                examPaperSubmissionModel.getSubmittedOn(), submittedBy, examPaperSubmissionModel.getStatus().getStatusName(),
                exam
        );

    }
}
