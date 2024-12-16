package com.university.university_management_system.repository;

import com.university.university_management_system.model.ExamModel;
import com.university.university_management_system.model.ExamTypeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Repository
public interface ExamRepository extends JpaRepository<ExamModel, Integer> {

    @Query("SELECT e FROM ExamModel e WHERE e.course.courseCode = :courseCode")
    List<ExamModel> getExamsByCourseCode(@Param("courseCode") String courseCode);

    @Query("SELECT e FROM ExamModel e WHERE e.examType.examTypeId = :examTypeId")
    List<ExamModel> getExamsByExamTypeId(@Param("examTypeId") int examTypeId);

    @Query("SELECT e FROM ExamModel e WHERE e.examHall.examHallId = :examHallId")
    List<ExamModel> getExamsByExamHallId(@Param("examHallId") int examHallId);

    @Query("SELECT e FROM ExamModel e WHERE e.examMode.examModeId = :examModeId")
    List<ExamModel> getExamsByExamModeId(@Param("examModeId") int examModeId);

    @Query("SELECT e FROM ExamModel e WHERE e.examDate = :examDate")
    List<ExamModel> getExamsByDate(@Param("examDate") LocalDate examDate);

    @Query("SELECT e FROM ExamModel e WHERE e.examStartTime = :examStartTime AND e.examEndTime = :examEndTime")
    List<ExamModel> getExamsByTimeSlot(@Param("examStartTime") LocalTime startTime, @Param("examEndTime") LocalTime endTime);


}