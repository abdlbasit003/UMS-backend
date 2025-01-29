package com.university.university_management_system.controller;

import com.university.university_management_system.DTOs.ExamScheduleDTO;
import com.university.university_management_system.service.ExamScheduleService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/examschedules")
@Tag(name = "Exam Schedules")
public class ExamScheduleController {

    @Autowired
    private ExamScheduleService examScheduleService;

    @GetMapping
    public List<ExamScheduleDTO> getAll() {
        return examScheduleService.getAll();
    }

    @GetMapping("/{scheduleId}")
    public ExamScheduleDTO getByScheduleId(@PathVariable int scheduleId) {
        return examScheduleService.getByScheduleId(scheduleId);
    }

    @GetMapping("/exam/{examId}")
    public List<ExamScheduleDTO> getByExamId(@PathVariable int examId) {
        return examScheduleService.getByExamId(examId);
    }

    @GetMapping("/room/{roomId}")
    public List<ExamScheduleDTO> getByExaminationRoomId(@PathVariable int roomId) {
        return examScheduleService.getByExaminationRoomId(roomId);
    }

    @GetMapping("/starttime")
    public List<ExamScheduleDTO> getByStartTime(@RequestParam LocalTime startTime) {
        return examScheduleService.getByStartTime(startTime);
    }

    @GetMapping("/endtime")
    public List<ExamScheduleDTO> getByEndTime(@RequestParam LocalTime endTime) {
        return examScheduleService.getByEndTime(endTime);
    }

    @GetMapping("/date")
    public List<ExamScheduleDTO> getByExamDate(@RequestParam LocalDate examDate) {
        return examScheduleService.getByExamDate(examDate);
    }

    @GetMapping("/department/{departmentId}")
    public List<ExamScheduleDTO> getCompleteScheduleOfDepartment(@PathVariable int departmentId) {
        return examScheduleService.getCompleteScheduleOfDepartment(departmentId);
    }

    @GetMapping("/student/{studentId}")
    public List<ExamScheduleDTO> getCompleteScheduleOfStudent(@PathVariable String studentId) {
        return examScheduleService.getCompleteScheduleOfStudent(studentId);
    }

    @GetMapping("/course/{courseCode}")
    public List<ExamScheduleDTO> getByCourse(@PathVariable String courseCode) {
        return examScheduleService.getByCourse(courseCode);
    }
}
