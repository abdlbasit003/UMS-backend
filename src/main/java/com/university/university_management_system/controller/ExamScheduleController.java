package com.university.university_management_system.controller;

import com.university.university_management_system.DTOs.ExamScheduleDTO;
import com.university.university_management_system.service.ExamScheduleService;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class ExamScheduleController {
    @Autowired
    private ExamScheduleService examScheduleService;


    public List<ExamScheduleDTO> getAll(){
        return examScheduleService.getAll();
    }

    public ExamScheduleDTO getByScheduleId(int scheduleId){
        return examScheduleService.getByScheduleId(scheduleId);
    }
    public List<ExamScheduleDTO> getByExamId(int examId){
        return examScheduleService.getByExamId(examId);
    }

    public List<ExamScheduleDTO>  getByExaminationRoomId(int roomId){
        return examScheduleService.getByExaminationRoomId(roomId);
    }
    public List<ExamScheduleDTO> getByStartTime(LocalTime startTime){
        return examScheduleService.getByStartTime(startTime);
    }
    public List<ExamScheduleDTO> getByEndTime(LocalTime endTime){
        return examScheduleService.getByEndTime(endTime);
    }
    public List<ExamScheduleDTO> getByExamDate(LocalDate examDate){
        return examScheduleService.getByExamDate(examDate);
    }
    public List<ExamScheduleDTO> getCompleteScheduleOfDepartment(int departmentId){
        return examScheduleService.getCompleteScheduleOfDepartment(departmentId);
    }
    public List<ExamScheduleDTO> getCompleteScheduleOfStudent(String studentId){
        return examScheduleService.getCompleteScheduleOfStudent(studentId);
    }
    public List<ExamScheduleDTO> getByCourse(String courseCode){
        return examScheduleService.getByCourse(courseCode);
    }

}
