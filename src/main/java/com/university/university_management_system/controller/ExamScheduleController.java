package com.university.university_management_system.controller;

import com.university.university_management_system.DTOs.ExamScheduleDTO;
import com.university.university_management_system.service.ExamScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class ExamScheduleController {
    @Autowired
    private ExamScheduleService examScheduleService;

    @GetMapping("/exam-schedules")
    public List<ExamScheduleDTO> getAll(){
        return examScheduleService.getAll();
    }

    @GetMapping("/{scheduleId}")
    public ExamScheduleDTO getByScheduleId(int scheduleId){
        return examScheduleService.getByScheduleId(scheduleId);
    }

    @GetMapping("/exam/{examId}")
    public List<ExamScheduleDTO> getByExamId(int examId){
        return examScheduleService.getByExamId(examId);
    }

    @GetMapping("/room/{roomId}")
    public List<ExamScheduleDTO>  getByExaminationRoomId(int roomId){
        return examScheduleService.getByExaminationRoomId(roomId);
    }

    @GetMapping("/start-time")
    public List<ExamScheduleDTO> getByStartTime(LocalTime startTime){
        return examScheduleService.getByStartTime(startTime);
    }
    @GetMapping("/end-time")
    public List<ExamScheduleDTO> getByEndTime(LocalTime endTime){
        return examScheduleService.getByEndTime(endTime);
    }

    @GetMapping("/date")
    public List<ExamScheduleDTO> getByExamDate(LocalDate examDate){
        return examScheduleService.getByExamDate(examDate);
    }
    @GetMapping("/department/{departmentId}")
    public List<ExamScheduleDTO> getCompleteScheduleOfDepartment(int departmentId){
        return examScheduleService.getCompleteScheduleOfDepartment(departmentId);
    }
    @GetMapping("/student/{studentId}")
    public List<ExamScheduleDTO> getCompleteScheduleOfStudent(String studentId){
        return examScheduleService.getCompleteScheduleOfStudent(studentId);
    }
    @GetMapping("/course")
    public List<ExamScheduleDTO> getByCourse(String courseCode){
        return examScheduleService.getByCourse(courseCode);
    }

}
