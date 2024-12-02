package com.university.university_management_system.repository;

import com.university.university_management_system.model.ExamModeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamModeRepository extends JpaRepository<ExamModeModel, Integer> {
}
