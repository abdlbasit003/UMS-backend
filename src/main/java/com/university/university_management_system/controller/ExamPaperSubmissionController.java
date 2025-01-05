package com.university.university_management_system.controller;

import com.university.university_management_system.DTOs.ExamDTO;
import com.university.university_management_system.DTOs.ExamSubmissionDTO;
import com.university.university_management_system.service.ExamPaperSubmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class ExamPaperSubmissionController {

    @Autowired
    ExamPaperSubmissionService examPaperSubmissionService;

    @GetMapping("/exampapersubmissions")
    public ResponseEntity<List<ExamSubmissionDTO>> getAllExamSubmissions(){
        return ResponseEntity.ok(examPaperSubmissionService.getAllExamPaperSubmissions());
    }
    @GetMapping("/exam/{examId}/examsubmissions")
    public ResponseEntity<List<ExamSubmissionDTO>> getExamPaperSubmissionByExamId(@PathVariable int examId){
        return ResponseEntity.ok(examPaperSubmissionService.getExamPaperSubmissionByExamId(examId));
    }
    @GetMapping("/faculty/{facultyId}/examsubmissions")
    public ResponseEntity<List<ExamSubmissionDTO>> getExamPaperSubmissionsByFacultyId(@PathVariable int facultyId){
        return ResponseEntity.ok(examPaperSubmissionService.getExamPaperSubmissionsByFacultyId(facultyId));
    }
    @GetMapping("/exam/{examId}/examsubmissions/pending")
    public ResponseEntity<List<ExamSubmissionDTO>> getPendingExamPaperSubmissionsByExamId(@PathVariable int examId){
        return ResponseEntity.ok(examPaperSubmissionService.getPendingExamPaperSubmissionsByExamId(examId));
    }
    @GetMapping("/exam/{examId}/examsubmissions/late")
    public ResponseEntity<List<ExamSubmissionDTO>> getLateExamPaperSubmissionsByExamId(@PathVariable int examId){
        return ResponseEntity.ok(examPaperSubmissionService.getLateExamPaperSubmissionsByExamId(examId));
    }
    @GetMapping("/exampapersubmissions/status/{statusId}")
    public ResponseEntity<List<ExamSubmissionDTO>> getExamPaperSubmissionsByStatusId(@PathVariable int statusId){
        return ResponseEntity.ok(examPaperSubmissionService.getExamPaperSubmissionsByStatusId(statusId));
    }

    @PostMapping("/exampapersubmissions/create")
    public ResponseEntity<ExamSubmissionDTO> createNewExam(@RequestBody Map<String, Object> data){
        ExamSubmissionDTO submissionDTO = examPaperSubmissionService.createExamSubmission(data);
        return new ResponseEntity<>(submissionDTO, HttpStatus.CREATED);
    }




}
