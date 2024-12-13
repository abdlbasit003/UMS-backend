package com.university.university_management_system.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "exam_paper_submission")
public class ExamPaperSubmissionModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "submission_id")
    private int submissionId;

    @ManyToOne
    @JoinColumn(name = "exam_id", nullable = false)
    private ExamModel exam;

    @ManyToOne
    @JoinColumn(name = "status_id", nullable = false)
    private ExamPaperStatus status;

    @Column(name = "submission_due_date", nullable = false)
    private LocalDateTime submissionDueDate;

    @Column(name = "submitted_on")
    private LocalDateTime submittedOn;

    @ManyToOne
    @JoinColumn(name = "submitted_by", nullable = false)
    private StudentModel submittedBy;


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

    public StudentModel getSubmittedBy() {
        return submittedBy;
    }
}
