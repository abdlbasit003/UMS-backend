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
public class ExamSubmissionService {
    @Autowired
    ExamPaperSubmissionRepository examPaperSubmissionRepository;

    @Autowired
    ExamPaperStatusRepository examPaperStatusRepository;
    @Autowired
    ExamRepository examRepository;
    @Autowired
    FacultyRepository facultyRepository;

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
        ExamModel examModel = examRepository.findById(examId).orElseThrow(()-> new ApiException("Invalid Exam ID", HttpStatus.NOT_FOUND));

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
        FacultyModel facultyModel = facultyRepository.findById(facultyId).orElseThrow(()-> new ApiException("Invalid Faculty ID", HttpStatus.NOT_FOUND));


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
        ExamModel examModel = examRepository.findById(examId).orElseThrow(()-> new ApiException("Invalid Exam ID", HttpStatus.NOT_FOUND));

        if(allExamSubmissions.isEmpty()){
            throw new ApiException("No Exam Submissions", HttpStatus.NOT_FOUND);
        }
        for(ExamPaperSubmissionModel eps : allExamSubmissions){
            if(examId == eps.getExam().getExamId() && eps.getSubmittedOn() == null ){
                allExamSubmissionDtos.add(ExamSubmissionDTO.fromModel(eps));
            }
        }
        return allExamSubmissionDtos;
    }

    public List<ExamSubmissionDTO> getLateExamPaperSubmissionsByExamId(){
        List<ExamPaperSubmissionModel> allExamSubmissions = examPaperSubmissionRepository.findAll();
        List <ExamSubmissionDTO> allExamSubmissionDtos = new ArrayList<>();

        if(allExamSubmissions.isEmpty()){
            throw new ApiException("No Exam Submissions", HttpStatus.NOT_FOUND);
        }
        for(ExamPaperSubmissionModel eps : allExamSubmissions){
            if(eps.getSubmittedOn().isAfter(eps.getSubmissionDueDate())){
                allExamSubmissionDtos.add(ExamSubmissionDTO.fromModel(eps));
            }
        }
        return allExamSubmissionDtos;
    }

    public List<ExamSubmissionDTO> getExamPaperSubmissionsByStatusId(int statusId){
        List<ExamPaperSubmissionModel> allExamSubmissions = examPaperSubmissionRepository.findAll();
        List <ExamSubmissionDTO> allExamSubmissionDtos = new ArrayList<>();
        ExamPaperStatus examPaperSubmissionModel = examPaperStatusRepository.findById(statusId).orElseThrow(()->new ApiException("Invalid Status ID", HttpStatus.NOT_FOUND));


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
