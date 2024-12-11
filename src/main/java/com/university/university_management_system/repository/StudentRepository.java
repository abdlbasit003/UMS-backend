package com.university.university_management_system.repository;

import com.university.university_management_system.model.StudentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import jakarta.persistence.*;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<StudentModel, String> {

    @Query("SELECT s FROM StudentModel s JOIN FETCH s.user")
    List<StudentModel> getAllStudents();


    @Query("""
    SELECT s FROM StudentModel s
    JOIN FETCH s.user
    WHERE s.studentId = :studentId
""")
    StudentModel getById(@Param("studentId") String studentId);

    @Query("""
    SELECT s FROM StudentModel s
    WHERE s.user.uuid = :uuid
""")
    StudentModel getByUuid(@Param("uuid") String uuid);



}
