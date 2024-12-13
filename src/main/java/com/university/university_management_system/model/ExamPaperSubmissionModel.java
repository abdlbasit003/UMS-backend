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
}
