package com.university.university_management_system.controller;

import com.university.university_management_system.DTOs.ExamDTO;
import com.university.university_management_system.model.ExamModel;
import com.university.university_management_system.repository.ExamRepository;
import com.university.university_management_system.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;
@RestController
@RequestMapping("/exams")
public class ExamController {

    @Autowired
    ExamService examService;


    @GetMapping("")
    public ResponseEntity<List<ExamDTO>> getAllExams() {
        return ResponseEntity.ok(examService.getAllExams());
    }

    @GetMapping("/id/{examId}")
    public ResponseEntity<ExamDTO> getExamById(@PathVariable int examId) {
        return ResponseEntity.ok(examService.getExamById(examId));
    }

    @GetMapping("/course/{courseCode}")
    public ResponseEntity<List<ExamDTO>> getExamsByCourseCode(@PathVariable String courseCode) {
        return ResponseEntity.ok(examService.getExamsByCourseCode(courseCode));
    }

    @GetMapping("/type/{examTypeId}")
    public ResponseEntity<List<ExamDTO>> getExamsByExamTypeId(@PathVariable int examTypeId) {
        return ResponseEntity.ok(examService.getExamsByExamTypeId(examTypeId));
    }

   /* @GetMapping("/rooms/{examinationRoomId}")
    public ResponseEntity<List<ExamDTO>> getExamsByExaminationRoomId(@PathVariable int examinationRoomId) {
        return ResponseEntity.ok(examService.getExamsByExaminationRoomId(examinationRoomId));
    }
*/
    @GetMapping("/mode/{examModeId}")
    public ResponseEntity<List<ExamDTO>> getExamsByExamModeId(@PathVariable int examModeId){
        return ResponseEntity.ok(examService.getExamsByExamModeId(examModeId));
    }

    @GetMapping("/date/{examDate}")
    public ResponseEntity<List<ExamDTO>> getExamsByDate(@PathVariable LocalDate examDate){
        return ResponseEntity.ok(examService.getExamsByDate(examDate));
    }

    @GetMapping("/time")
    public ResponseEntity<List<ExamDTO>> getExamsByTimeSlot(@RequestParam String examStartTime,@RequestParam String examEndTime){
    return ResponseEntity.ok(examService.getExamsByTimeSlot(LocalTime.parse(examStartTime), LocalTime.parse(examEndTime)));
    }
    @PostMapping("/create")
    public ResponseEntity<ExamDTO> createNewExam(@RequestBody Map<String, Object> examBody){
        ExamDTO examDTO = examService.createNewExam(examBody);
        return new ResponseEntity<>(examDTO, HttpStatus.CREATED);


    }
}
