package com.university.university_management_system.repository;

import com.university.university_management_system.model.ExaminationRoomModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExaminationRoomRepository extends JpaRepository<ExaminationRoomModel, Integer> {
}
