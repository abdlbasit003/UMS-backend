package com.university.university_management_system.model;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "exemption_request")
public class ExemptionRequestModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exemption_request_id")
    private int requestId;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private StudentModel student;

    @ManyToOne
    @JoinColumn(name = "exam_id")
    private ExamModel exam;

    @ManyToOne
    @JoinColumn(name = "request_type_id")
    private ExemptionRequestTypeModel exemptionRequestType;

    @ManyToOne
    @JoinColumn(name = "request_status_id")
    private ExamPaperStatus status;

    @Column(name = "submitted_on")
    private LocalDateTime dateSubmittedOn;

    @ManyToOne
    @JoinColumn(name = "reviewed_by")
    private UserModel reviewedBy;

    @Column(name = "reviewed_on")
    private LocalDateTime dateReviewedOn;

    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public StudentModel getStudent() {
        return student;
    }

    public void setStudent(StudentModel student) {
        this.student = student;
    }

    public ExamModel getExam() {
        return exam;
    }

    public void setExam(ExamModel exam) {
        this.exam = exam;
    }

    public ExemptionRequestTypeModel getExemptionRequestType() {
        return exemptionRequestType;
    }

    public void setExemptionRequestType(ExemptionRequestTypeModel exemptionRequestType) {
        this.exemptionRequestType = exemptionRequestType;
    }

    public ExamPaperStatus getStatus() {
        return status;
    }

    public void setStatus(ExamPaperStatus status) {
        this.status = status;
    }

    public LocalDateTime getDateSubmittedOn() {
        return dateSubmittedOn;
    }

    public void setDateSubmittedOn(LocalDateTime dateSubmittedOn) {
        this.dateSubmittedOn = dateSubmittedOn;
    }

    public UserModel getReviewedBy() {
        return reviewedBy;
    }

    public void setReviewedBy(UserModel reviewedBy) {
        this.reviewedBy = reviewedBy;
    }

    public LocalDateTime getDateReviewedOn() {
        return dateReviewedOn;
    }

    public void setDateReviewedOn(LocalDateTime dateReviewedOn) {
        this.dateReviewedOn = dateReviewedOn;
    }
}
