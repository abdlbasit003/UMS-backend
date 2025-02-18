package com.university.university_management_system.service;

import com.university.university_management_system.DTOs.ExamDTO;
import com.university.university_management_system.exceptions.ApiException;
import com.university.university_management_system.model.ExamModel;
import com.university.university_management_system.model.ExamTypeModel;
import com.university.university_management_system.repository.CourseRepository;
import com.university.university_management_system.repository.ExamModeRepository;
import com.university.university_management_system.repository.ExamRepository;
import com.university.university_management_system.repository.ExamTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ExamService {
    @Autowired
    ExamRepository examRepository;
    @Autowired
    CourseRepository courseRepository;
    @Autowired
    ExamTypeRepository examTypeRepository;
    @Autowired
    ExamModeRepository examModeRepository;
    @Autowired
    ExamPaperSubmissionService examPaperSubmissionService;

    public List<ExamDTO> getAllExams() {
        List<ExamModel> allExams = examRepository.findAll();
        if (allExams.isEmpty()) {
            throw new ApiException("No exams Found", HttpStatus.NOT_FOUND);
        }
        return allExams.stream()
                .map(ExamDTO::fromModel)
                .toList();
    }

    public ExamDTO getExamById(int examId) {
        ExamModel examModel = examRepository.findById(examId)
                .orElseThrow(() -> new ApiException("No exam found for examId: " + examId, HttpStatus.NOT_FOUND));
        return ExamDTO.fromModel(examModel);
    }

    public List<ExamDTO> getExamsByCourseCode(String courseCode) {
        if (courseCode == null) {
            throw new ApiException("No course Code Found", HttpStatus.NOT_FOUND);
        }
        List<ExamModel> examsByCourse = examRepository.getExamsByCourseCode(courseCode);
        if (examsByCourse.isEmpty()) {
            throw new ApiException("No exams found for course code: " + courseCode, HttpStatus.NOT_FOUND);
        }
        return examsByCourse.stream()
                .map(ExamDTO::fromModel)
                .toList();
    }

    public List<ExamDTO> getExamsByExamTypeId(int examTypeId) {
        List<ExamModel> examsByExamTypeId = examRepository.getExamsByExamTypeId(examTypeId);
        if (examsByExamTypeId.isEmpty()) {
            throw new ApiException("No exams found for examTypeId: " + examTypeId, HttpStatus.NOT_FOUND);
        }
        return examsByExamTypeId.stream()
                .map(ExamDTO::fromModel)
                .toList();
    }

    public List<ExamDTO> getExamsByExamModeId(int examModeId) {
        List<ExamModel> examsByExamModeId = examRepository.getExamsByExamModeId(examModeId);
        if (examsByExamModeId.isEmpty()) {
            throw new ApiException("No exams found for examModeId: " + examModeId, HttpStatus.NOT_FOUND);
        }
        return examsByExamModeId.stream()
                .map(ExamDTO::fromModel)
                .toList();
    }

    public List<ExamDTO> getExamsByDate(LocalDate examDate) {
        List<ExamModel> examsByDate = examRepository.getExamsByDate(examDate);
        if (examsByDate.isEmpty()) {
            throw new ApiException("No exams found for Date: " + examDate, HttpStatus.NOT_FOUND);
        }
        return examsByDate.stream()
                .map(ExamDTO::fromModel)
                .toList();
    }

    public List<ExamDTO> getExamsByTimeSlot(LocalTime examStartTime, LocalTime examEndTime) {
        List<ExamModel> examsByTimeSlot = examRepository.getExamsByTimeSlot(examStartTime, examEndTime);
        if (examsByTimeSlot.isEmpty()) {
            throw new ApiException("No exams found for time slot: " + examStartTime + " / " + examEndTime, HttpStatus.NOT_FOUND);
        }
        return examsByTimeSlot.stream()
                .map(ExamDTO::fromModel)
                .toList();
    }

    public ExamDTO createNewExam(Map<String, Object> examBody) {
        ExamModel examModel = new ExamModel();
        try {
            examModel.setCourse(courseRepository.findById(String.valueOf(examBody.get("courseCode")))
                    .orElseThrow(() -> new ApiException("No course found for courseCode: " + examBody.get("courseCode"), HttpStatus.NOT_FOUND)));
            examModel.setExamType(examTypeRepository.findById(Integer.parseInt(String.valueOf(examBody.get("examType"))))
                    .orElseThrow(() -> new ApiException("No examType found for examTypeId: " + examBody.get("examType"), HttpStatus.NOT_FOUND)));
            examModel.setExamDate(LocalDate.parse(String.valueOf(examBody.get("examDate"))));
            examModel.setExamStartTime(LocalTime.parse(String.valueOf(examBody.get("examStartTime"))));
            examModel.setExamEndTime(LocalTime.parse(String.valueOf(examBody.get("examEndTime"))));
            examModel.setExamMode(examModeRepository.findById(Integer.parseInt(String.valueOf(examBody.get("examMode"))))
                    .orElseThrow(() -> new ApiException("No examMode found for examModeId: " + examBody.get("examMode"), HttpStatus.NOT_FOUND)));
        } catch (ApiException e) {
            throw new ApiException("Error creating new Exam", HttpStatus.BAD_REQUEST);
        }
        try {
            Map<String,Object> submissionBody = new HashMap<>();
            submissionBody.put("exam",examModel);
            submissionBody.put("dueDate","02-03-2025");
            submissionBody.put("submittedBy",examBody.get("submittedBy"));
            examRepository.save(examModel);
            examPaperSubmissionService.createExamSubmission(submissionBody);

        } catch (ApiException e) {
            throw new ApiException("Error creating new Exam", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ExamDTO.fromModel(examModel);
    }


}
