package com.university.university_management_system.repository;

import com.university.university_management_system.model.StudentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import jakarta.persistence.*;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<StudentModel, String> {

    @Query("SELECT s FROM StudentModel s JOIN FETCH s.user")
    List<StudentModel> getAllStudents();

}
