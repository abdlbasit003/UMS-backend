package com.university.university_management_system.repository;

import com.university.university_management_system.model.SeasonModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeasonRepository extends JpaRepository<SeasonModel,Integer> {
}
