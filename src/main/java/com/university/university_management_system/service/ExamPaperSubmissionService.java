package com.university.university_management_system.service;

import com.university.university_management_system.DTOs.ExamSubmissionDTO;
import com.university.university_management_system.exceptions.ApiException;
import com.university.university_management_system.model.*;
import com.university.university_management_system.repository.ExamPaperStatusRepository;
import com.university.university_management_system.repository.ExamPaperSubmissionRepository;
import com.university.university_management_system.repository.ExamRepository;
import com.university.university_management_system.repository.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExamPaperSubmissionService {
    @Autowired
    ExamPaperSubmissionRepository examPaperSubmissionRepository;

    @Autowired
    ExamPaperStatusRepository examPaperStatusRepository;
    @Autowired
    ExamRepository examRepository;
    @Autowired
    FacultyRepository facultyRepository;

    public List<ExamSubmissionDTO> getAllExamPaperSubmissions() {
        List<ExamPaperSubmissionModel> allExamSubmissions = examPaperSubmissionRepository.findAll();
        if (allExamSubmissions.isEmpty()) {
            throw new ApiException("No Exam Submissions", HttpStatus.NOT_FOUND);
        }
        return allExamSubmissions.stream()
                .map(ExamSubmissionDTO::fromModel)
                .toList();
    }

    public List<ExamSubmissionDTO> getExamPaperSubmissionByExamId(int examId) {
        examRepository.findById(examId)
                .orElseThrow(() -> new ApiException("Invalid Exam ID", HttpStatus.NOT_FOUND));

        return examPaperSubmissionRepository.findAll().stream()
                .filter(eps -> examId == eps.getExam().getExamId())
                .map(ExamSubmissionDTO::fromModel)
                .toList();
    }

    public List<ExamSubmissionDTO> getExamPaperSubmissionsByFacultyId(int facultyId) {
        facultyRepository.findById(facultyId)
                .orElseThrow(() -> new ApiException("Invalid Faculty ID", HttpStatus.NOT_FOUND));

        return examPaperSubmissionRepository.findAll().stream()
                .filter(eps -> facultyId == eps.getSubmittedBy().getFacultyId())
                .map(ExamSubmissionDTO::fromModel)
                .toList();
    }


    public List<ExamSubmissionDTO> getPendingExamPaperSubmissionsByExamId(int examId) {
        examRepository.findById(examId)
                .orElseThrow(() -> new ApiException("Invalid Exam ID", HttpStatus.NOT_FOUND));

        return examPaperSubmissionRepository.findAll().stream()
                .filter(eps -> examId == eps.getExam().getExamId() && eps.getSubmittedOn() == null)
                .map(ExamSubmissionDTO::fromModel)
                .toList();
    }


    public List<ExamSubmissionDTO> getAllLateSubmissions() {
        List<ExamPaperSubmissionModel> allExamSubmissions = examPaperSubmissionRepository.findAll();
        if (allExamSubmissions.isEmpty()) {
            throw new ApiException("No Exam Submissions", HttpStatus.NOT_FOUND);
        }

        return allExamSubmissions.stream()
                .filter(eps -> eps.getSubmittedOn().isAfter(eps.getSubmissionDueDate()))
                .map(ExamSubmissionDTO::fromModel)
                .toList();
    }


    public List<ExamSubmissionDTO> getAllSubmissionsByStatusId(int statusId) {
        examPaperStatusRepository.findById(statusId)
                .orElseThrow(() -> new ApiException("Invalid Status ID", HttpStatus.NOT_FOUND));

        return examPaperSubmissionRepository.findAll().stream()
                .filter(eps -> statusId == eps.getStatus().getStatusId())
                .map(ExamSubmissionDTO::fromModel)
                .toList();
    }

    public List<ExamSubmissionDTO> getLateExamPaperSubmissionsByExamId(int examId) {
        examRepository.findById(examId)
                .orElseThrow(() -> new ApiException("Invalid Exam ID", HttpStatus.NOT_FOUND));

        return examPaperSubmissionRepository.findAll().stream()
                .filter(eps -> examId == eps.getExam().getExamId() &&
                        eps.getSubmittedOn() != null &&
                        eps.getSubmittedOn().isAfter(eps.getSubmissionDueDate()))
                .map(ExamSubmissionDTO::fromModel)
                .toList();
    }

    public List<ExamSubmissionDTO> getAllPendingSubmissionsByExamId(int examId) {
        examRepository.findById(examId)
                .orElseThrow(() -> new ApiException("Invalid Exam ID", HttpStatus.NOT_FOUND));

        return examPaperSubmissionRepository.findAll().stream()
                .filter(eps -> examId == eps.getExam().getExamId() && eps.getSubmittedOn() == null)
                .map(ExamSubmissionDTO::fromModel)
                .toList();
    }


    public List<ExamSubmissionDTO> getExamPaperSubmissionsByStatusId(int examId, int statusId) {
        examRepository.findById(examId)
                .orElseThrow(() -> new ApiException("Invalid Exam ID", HttpStatus.NOT_FOUND));
        examPaperStatusRepository.findById(statusId)
                .orElseThrow(() -> new ApiException("Invalid Status ID", HttpStatus.NOT_FOUND));

        return examPaperSubmissionRepository.findAll().stream()
                .filter(eps -> examId == eps.getExam().getExamId() && statusId == eps.getStatus().getStatusId())
                .map(ExamSubmissionDTO::fromModel)
                .toList();
    }



}
