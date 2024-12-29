package com.university.university_management_system.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "exam_paper_submission")
public class ExamPaperSubmissionModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exam_paper_submission_id")
    private int submissionId;

    @ManyToOne
    @JoinColumn(name = "exam_id", referencedColumnName = "exam_id")
    private ExamModel exam;

    @ManyToOne
    @JoinColumn(name = "exam_paper_status_id", referencedColumnName = "exam_paper_status_id")
    private ExamPaperStatus status;

    @Column(name = "submission_due_date")
    private LocalDateTime submissionDueDate;

    @Column(name = "submitted_on")
    private LocalDateTime submittedOn;

    @ManyToOne
    @JoinColumn(name = "submitted_by" , referencedColumnName = "faculty_id")
    private FacultyModel submittedBy;

    @OneToOne
    @JoinColumn(name = "approved_by" , referencedColumnName = "uuid")
    private UserModel approvedBy;

    @OneToOne
    @JoinColumn(name = "rejected_by" , referencedColumnName = "uuid")
    private UserModel rejectedBy;

    @OneToOne
    @JoinColumn(name = "published_by" , referencedColumnName = "uuid")
    private UserModel publishedBy;

    @OneToOne
    @JoinColumn(name = "archived_by" , referencedColumnName = "uuid")
    private UserModel archivedBy;


    public int getSubmissionId() {
        return submissionId;
    }

    public ExamModel getExam() {
        return exam;
    }

    public ExamPaperStatus getStatus() {
        return status;
    }

    public LocalDateTime getSubmissionDueDate() {
        return submissionDueDate;
    }

    public LocalDateTime getSubmittedOn() {
        return submittedOn;
    }

    public FacultyModel getSubmittedBy() {
        return submittedBy;
    }

    public void setExam(ExamModel exam) {
        this.exam = exam;
    }

    public void setStatus(ExamPaperStatus status) {
        this.status = status;
    }

    public void setSubmissionDueDate(LocalDateTime submissionDueDate) {
        this.submissionDueDate = submissionDueDate;
    }

    public void setSubmittedOn(LocalDateTime submittedOn) {
        this.submittedOn = submittedOn;
    }

    public void setSubmittedBy(FacultyModel submittedBy) {
        this.submittedBy = submittedBy;
    }

    public UserModel getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(UserModel approvedBy) {
        this.approvedBy = approvedBy;
    }

    public UserModel getRejectedBy() {
        return rejectedBy;
    }

    public void setRejectedBy(UserModel rejectedBy) {
        this.rejectedBy = rejectedBy;
    }

    public UserModel getPublishedBy() {
        return publishedBy;
    }

    public void setPublishedBy(UserModel publishedBy) {
        this.publishedBy = publishedBy;
    }

    public UserModel getArchivedBy() {
        return archivedBy;
    }

    public void setArchivedBy(UserModel archivedBy) {
        this.archivedBy = archivedBy;
    }
}
