package com.university.university_management_system.repository;

import com.university.university_management_system.model.InvigilatorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvigilatorRepository extends JpaRepository<InvigilatorModel, Integer> {
}
