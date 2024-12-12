package com.university.university_management_system.repository;
import com.university.university_management_system.model.ExamPaperStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface ExamPaperStatusRepository extends JpaRepository<ExamPaperStatus, Integer> {
    ExamPaperStatus findByStatusName(String statusName);
    ExamPaperStatus findByStatusId(int statusId);
}
