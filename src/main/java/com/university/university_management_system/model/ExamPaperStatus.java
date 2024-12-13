package com.university.university_management_system.model;
import jakarta.persistence.*;

@Entity
@Table (name = "exam_paper_status")
public class ExamPaperStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exam_paper_status_id")
    public int statusId;

    @Column(name = "exam_paper_status_name", nullable = false)
    public String statusName;


    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }
}