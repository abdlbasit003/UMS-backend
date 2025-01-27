package com.university.university_management_system.controller;

import com.university.university_management_system.DTOs.ExamSubmissionDTO;
import com.university.university_management_system.service.ExamPaperSubmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Tag (name = "Exam Paper Submission", description = "Exam Paper Submission endpoints" )

@RequestMapping("/exampapersubmissions")
public class ExamPaperSubmissionController {
    @Autowired
    ExamPaperSubmissionService examPaperSubmissionService;
    @GetMapping("")
    public ResponseEntity<List<ExamSubmissionDTO>> getAllExamSubmissions(){
        return ResponseEntity.ok(examPaperSubmissionService.getAllExamPaperSubmissions());
    }
    @GetMapping("/exam/{examId}")
    public ResponseEntity<List<ExamSubmissionDTO>> getExamPaperSubmissionByExamId(@PathVariable int examId){
        return ResponseEntity.ok(examPaperSubmissionService.getExamPaperSubmissionByExamId(examId));
    }
    @GetMapping("/faculty/{facultyId}")
    public ResponseEntity<List<ExamSubmissionDTO>> getExamPaperSubmissionsByFacultyId(@PathVariable int facultyId){
        return ResponseEntity.ok(examPaperSubmissionService.getExamPaperSubmissionsByFacultyId(facultyId));
    }
    @GetMapping("/exam/{examId}/pending")
    public ResponseEntity<List<ExamSubmissionDTO>> getPendingExamPaperSubmissionsByExamId(@PathVariable int examId){
        return ResponseEntity.ok(examPaperSubmissionService.getPendingExamPaperSubmissionsByExamId(examId));
    }
    @GetMapping("/late")
    public ResponseEntity<List<ExamSubmissionDTO>> getLateExamPaperSubmissionsByExamId(@PathVariable int examId){
        return ResponseEntity.ok(examPaperSubmissionService.getLateExamPaperSubmissionsByExamId(examId));
    }
    @GetMapping("/status/{statusId}")
    public ResponseEntity<List<ExamSubmissionDTO>> getExamPaperSubmissionsByStatusId(@PathVariable int examId,@PathVariable int statusId){
        return ResponseEntity.ok(examPaperSubmissionService.getExamPaperSubmissionsByStatusId(examId,statusId));
    }





}
