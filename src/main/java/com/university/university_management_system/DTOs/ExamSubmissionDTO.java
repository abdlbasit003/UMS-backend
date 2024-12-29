package com.university.university_management_system.DTOs;

import com.university.university_management_system.model.ExamPaperSubmissionModel;
import com.university.university_management_system.utils.Constants;
import org.apache.tomcat.util.bcel.Const;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ExamSubmissionDTO {
    private int submissionId;
    private LocalDateTime submissionDueDate;
    private LocalDateTime submittedOn;
    private Map<String, Object> submittedBy;
    private Map<String, Object> status;
    private ExamDTO exam;
    private Map<String, Object> approvedBy;
    private Map<String, Object> rejectedBy;
    private Map<String, Object> publishedBy;
    private Map<String, Object> archivedBy;


    public ExamSubmissionDTO(int submissionId,
                             LocalDateTime submissionDueDate,
                             LocalDateTime submittedOn,
                             Map<String, Object> status,
                             ExamDTO exam,
                             Map<String, Object> submittedBy,
                             Map<String, Object> approvedBy,
                             Map<String, Object> rejectedBy,
                             Map<String, Object> publishedBy,
                             Map<String, Object> archivedBy) {
        this.submissionId = submissionId;
        this.submissionDueDate = submissionDueDate;
        this.submittedOn = submittedOn;
        this.submittedBy = submittedBy;
        this.status = status;
        this.exam = exam;
        this.approvedBy = approvedBy;
        this.rejectedBy = rejectedBy;
        this.publishedBy = publishedBy;
        this.archivedBy = archivedBy;
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

    public Map<String, Object> getStatus() {
        return status;
    }

    public void setStatus(Map<String, Object> status) {
        this.status = status;
    }

    public ExamDTO getExam() {
        return exam;
    }


    public void setExam(ExamDTO exam) {
        this.exam = exam;
    }

    public Map<String, Object> getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(Map<String, Object> approvedBy) {
        this.approvedBy = approvedBy;
    }

    public Map<String, Object> getRejectedBy() {
        return rejectedBy;
    }

    public void setRejectedBy(Map<String, Object> rejectedBy) {
        this.rejectedBy = rejectedBy;
    }

    public Map<String, Object> getPublishedBy() {
        return publishedBy;
    }

    public void setPublishedBy(Map<String, Object> publishedBy) {
        this.publishedBy = publishedBy;
    }

    public Map<String, Object> getArchivedBy() {
        return archivedBy;
    }

    public void setArchivedBy(Map<String, Object> archivedBy) {
        this.archivedBy = archivedBy;
    }

    public static ExamSubmissionDTO fromModel(ExamPaperSubmissionModel examPaperSubmissionModel){
        ExamDTO exam = ExamDTO.fromModel(examPaperSubmissionModel.getExam());
        String status = examPaperSubmissionModel.getStatus().getStatusName();
        HashMap<String, Object> submittedBy = new HashMap<>();
        HashMap<String, Object> publishedBy = new HashMap<>();
        HashMap<String, Object> rejectedBy = new HashMap<>();
        HashMap<String, Object> archivedBy = new HashMap<>();
        HashMap<String, Object> approvedBy = new HashMap<>();
        HashMap<String, Object> examStatus = new HashMap<>();
        examStatus.put("id",examPaperSubmissionModel.getStatus().getStatusId());
        examStatus.put("status",examPaperSubmissionModel.getStatus().getStatusName());
        submittedBy.put("facultyId", examPaperSubmissionModel.getSubmittedBy().getFacultyId());
        submittedBy.put("facultyName", examPaperSubmissionModel.getSubmittedBy().getFacultyName());

        switch (status) {
            case Constants.APPROVED -> {
                approvedBy.put("uuid", examPaperSubmissionModel.getApprovedBy().getUuid());
                approvedBy.put("name", examPaperSubmissionModel.getApprovedBy().getFullName());
            }
            case Constants.REJECTED -> {
                rejectedBy.put("uuid", examPaperSubmissionModel.getRejectedBy().getUuid());
                rejectedBy.put("name", examPaperSubmissionModel.getRejectedBy().getFullName());
            }
            case Constants.PUBLISHED -> {
                publishedBy.put("uuid", examPaperSubmissionModel.getPublishedBy().getUuid());
                publishedBy.put("name", examPaperSubmissionModel.getPublishedBy().getFullName());
            }
            case Constants.ARCHIVED -> {
                archivedBy.put("uuid", examPaperSubmissionModel.getArchivedBy().getUuid());
                archivedBy.put("name", examPaperSubmissionModel.getArchivedBy().getFullName());
            }
        }


        return new ExamSubmissionDTO(examPaperSubmissionModel.getSubmissionId(),
                examPaperSubmissionModel.getSubmissionDueDate(),
                examPaperSubmissionModel.getSubmittedOn(),
                examStatus,
                exam,
                submittedBy,
                approvedBy,
                rejectedBy,
                publishedBy,
                archivedBy
                );


    }
}
