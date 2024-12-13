package com.university.university_management_system.repository;

import com.university.university_management_system.model.ExamContentTypeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamContentTypeRepository extends JpaRepository<ExamContentTypeModel, Integer> {
   
}
