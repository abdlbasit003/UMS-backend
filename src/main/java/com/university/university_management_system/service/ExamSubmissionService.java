package com.university.university_management_system.service;

import com.university.university_management_system.DTOs.ExamSubmissionDTO;
import com.university.university_management_system.exceptions.ApiException;
import com.university.university_management_system.model.ExamPaperSubmissionModel;
import com.university.university_management_system.repository.ExamPaperSubmissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExamSubmissionService {
    @Autowired
    ExamPaperSubmissionRepository examPaperSubmissionRepository;

    public List<ExamSubmissionDTO> getAllExamPaperSubmissions(){
        List<ExamPaperSubmissionModel> allExamSubmissions = examPaperSubmissionRepository.findAll();
        List <ExamSubmissionDTO> allExamSubmissionDtos = new ArrayList<>();

        if (allExamSubmissions.isEmpty()){
            throw new ApiException("No Exam Submissions", HttpStatus.NOT_FOUND);
        }

        for(ExamPaperSubmissionModel eps : allExamSubmissions){
            allExamSubmissionDtos.add(ExamSubmissionDTO.fromModel(eps));
        }

        return allExamSubmissionDtos;
    }
    public List<ExamSubmissionDTO> getExamPaperSubmissionByExamId(int examId){
        List<ExamPaperSubmissionModel> allExamSubmissions = examPaperSubmissionRepository.findAll();
        List <ExamSubmissionDTO> allExamSubmissionDtos = new ArrayList<>();

        if(allExamSubmissions.isEmpty()){
            throw new ApiException("No Exam Submissions", HttpStatus.NOT_FOUND);
        }
        for(ExamPaperSubmissionModel eps : allExamSubmissions){
            if(examId == eps.getExam().getExamId()){
                allExamSubmissionDtos.add(ExamSubmissionDTO.fromModel(eps));
            }
        }
        return allExamSubmissionDtos;
    }
    public List<ExamSubmissionDTO> getExamPaperSubmissionsByFacultyId (int facultyId){
        List<ExamPaperSubmissionModel> allExamSubmissions = examPaperSubmissionRepository.findAll();
        List <ExamSubmissionDTO> allExamSubmissionDtos = new ArrayList<>();

        if(allExamSubmissions.isEmpty()){
            throw new ApiException("No Exam Submissions", HttpStatus.NOT_FOUND);
        }
        for(ExamPaperSubmissionModel eps : allExamSubmissions){
            if(facultyId == eps.getSubmittedBy().getFacultyId()){
                allExamSubmissionDtos.add(ExamSubmissionDTO.fromModel(eps));
            }
        }
        return allExamSubmissionDtos;
    }

    public List<ExamSubmissionDTO> getPendingExamPaperSubmissionsByExamId(int examId){
        List<ExamPaperSubmissionModel> allExamSubmissions = examPaperSubmissionRepository.findAll();
        List <ExamSubmissionDTO> allExamSubmissionDtos = new ArrayList<>();

        if(allExamSubmissions.isEmpty()){
            throw new ApiException("No Exam Submissions", HttpStatus.NOT_FOUND);
        }
        for(ExamPaperSubmissionModel eps : allExamSubmissions){
            if(examId == eps.getExam().getExamId() && eps.getStatus().getStatusName().equalsIgnoreCase("Pending")){
                allExamSubmissionDtos.add(ExamSubmissionDTO.fromModel(eps));
            }
        }
        return allExamSubmissionDtos;
    }

    public List<ExamSubmissionDTO> getLateExamPaperSubmissionsByExamId(int examId){
        List<ExamPaperSubmissionModel> allExamSubmissions = examPaperSubmissionRepository.findAll();
        List <ExamSubmissionDTO> allExamSubmissionDtos = new ArrayList<>();

        if(allExamSubmissions.isEmpty()){
            throw new ApiException("No Exam Submissions", HttpStatus.NOT_FOUND);
        }
        for(ExamPaperSubmissionModel eps : allExamSubmissions){
            if(examId == eps.getExam().getExamId() && eps.getSubmittedOn().isAfter(eps.getSubmissionDueDate())){
                allExamSubmissionDtos.add(ExamSubmissionDTO.fromModel(eps));
            }
        }
        return allExamSubmissionDtos;
    }

    public List<ExamSubmissionDTO> getExamPaperSubmissionsByStatusId(int statusId){
        List<ExamPaperSubmissionModel> allExamSubmissions = examPaperSubmissionRepository.findAll();
        List <ExamSubmissionDTO> allExamSubmissionDtos = new ArrayList<>();

        if(allExamSubmissions.isEmpty()){
            throw new ApiException("No Exam Submissions", HttpStatus.NOT_FOUND);
        }
        for(ExamPaperSubmissionModel eps : allExamSubmissions){
            if(statusId == eps.getStatus().getStatusId()){
                allExamSubmissionDtos.add(ExamSubmissionDTO.fromModel(eps));
            }
        }
        return allExamSubmissionDtos;
    }



}
