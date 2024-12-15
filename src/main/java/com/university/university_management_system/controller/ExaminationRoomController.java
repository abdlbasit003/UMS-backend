package com.university.university_management_system.controller;
import com.university.university_management_system.DTOs.ExaminationRoomDTO;
import com.university.university_management_system.service.ExaminationRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/examrooms")
public class ExaminationRoomController {

    @Autowired
    ExaminationRoomService examinationRoomService;

    @GetMapping("")
    public List<ExaminationRoomDTO> getAllExaminationRooms(){
        return examinationRoomService.getAllExaminationRooms();
    }

    @GetMapping("/{examRoomId}")
    public ExaminationRoomDTO getExaminationRoomByID(@PathVariable Integer examRoomId){
        return examinationRoomService.getExaminationRoomById(examRoomId);
    }

    @GetMapping("/exam/{examId}")
    public List<ExaminationRoomDTO> getExaminationRoomsByExamId(@PathVariable Integer examId) {
        return examinationRoomService.getExaminationRoomsByExamId(examId);
    }

    @GetMapping("/student/{studentId}")
    public List<ExaminationRoomDTO> getExaminationRoomsByStudentId(@PathVariable String studentId) {
        return examinationRoomService.getExaminationRoomsByStudentId(studentId);
    }

    @GetMapping("/hall/{examHallId}")
    public List<ExaminationRoomDTO> getStudentsInExamHall(@PathVariable Integer examHallId) {
        return examinationRoomService.getStudentsInExamHall(examHallId);
    }
}
