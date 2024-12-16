package com.university.university_management_system.repository;

import com.university.university_management_system.model.FacultyModel;
import com.university.university_management_system.model.StudentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FacultyRepository extends JpaRepository<FacultyModel, Integer> {

    @Query("SELECT f FROM FacultyModel f JOIN FETCH f.user")
    List<FacultyModel> getAllFaculty();

}
