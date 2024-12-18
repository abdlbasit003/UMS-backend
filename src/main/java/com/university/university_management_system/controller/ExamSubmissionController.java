package com.university.university_management_system.controller;

import com.university.university_management_system.DTOs.CourseInstructorDTO;
import com.university.university_management_system.DTOs.ExamSubmissionDTO;
import com.university.university_management_system.service.ExamSubmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/exampapersubmissions")
public class ExamSubmissionController {
    @Autowired
    ExamSubmissionService examSubmissionService;
    @GetMapping("")
    public ResponseEntity<List<ExamSubmissionDTO>> getAllExamSubmissions(){
        return ResponseEntity.ok(examSubmissionService.getAllExamPaperSubmissions());
    }
    @GetMapping("/exam/{examId}")
    public ResponseEntity<List<ExamSubmissionDTO>> getExamPaperSubmissionByExamId(@PathVariable int examId){
        return ResponseEntity.ok(examSubmissionService.getExamPaperSubmissionByExamId(examId));
    }
    @GetMapping("/faculty/{facultyId}")
    public ResponseEntity<List<ExamSubmissionDTO>> getExamPaperSubmissionsByFacultyId(@PathVariable int facultyId){
        return ResponseEntity.ok(examSubmissionService.getExamPaperSubmissionsByFacultyId(facultyId));
    }
    @GetMapping("/exam/{examId}/pending")
    public ResponseEntity<List<ExamSubmissionDTO>> getPendingExamPaperSubmissionsByExamId(@PathVariable int examId){
        return ResponseEntity.ok(examSubmissionService.getPendingExamPaperSubmissionsByExamId(examId));
    }
    @GetMapping("/exam/{examId}/late")
    public ResponseEntity<List<ExamSubmissionDTO>> getLateExamPaperSubmissionsByExamId(@PathVariable int examId){
        return ResponseEntity.ok(examSubmissionService.getLateExamPaperSubmissionsByExamId(examId));
    }
    @GetMapping("/status/{statusId}")
    public ResponseEntity<List<ExamSubmissionDTO>> getExamPaperSubmissionsByStatusId(@PathVariable int statusId){
        return ResponseEntity.ok(examSubmissionService.getExamPaperSubmissionsByStatusId(statusId));
    }



}
