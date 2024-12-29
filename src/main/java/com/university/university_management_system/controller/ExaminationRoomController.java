package com.university.university_management_system.controller;

import com.university.university_management_system.DTOs.ExaminationRoomDTO;
import com.university.university_management_system.service.ExaminationRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/examrooms")
public class ExaminationRoomController {

    @Autowired
    public ExaminationRoomService examinationRoomService;


    @GetMapping("")
    public ResponseEntity<?> getAllExaminationRooms(){
        return ResponseEntity.ok().body(examinationRoomService.getAllExaminationRooms());
    }

    @GetMapping("/{examRoomId}")

    public ResponseEntity<?> getExaminationRoomById(@PathVariable Integer examRoomId) {
        return ResponseEntity.ok().body(examinationRoomService.getExaminationRoomById(examRoomId));
    }

    @GetMapping("/exam/{examId}")
    public ResponseEntity<?> getExaminationRoomsByExamId(@PathVariable Integer examId) {
        return ResponseEntity.ok().body(examinationRoomService.getExaminationRoomsByExamId(examId));
    }

    @GetMapping("/student/{studentId}")
    public ResponseEntity<?> getExaminationRoomsByStudentId(@PathVariable String studentId) {
        return ResponseEntity.ok().body(examinationRoomService.getExaminationRoomsByStudentId(studentId));
    }

    /*@GetMapping("/hall/{examHallId}")
    public ResponseEntity<?> getStudentsInExamHall(@PathVariable Integer examHallId) {
        return ResponseEntity.ok().body(examinationRoomService.getStudentsInExamHall(examHallId));
    }*/
}