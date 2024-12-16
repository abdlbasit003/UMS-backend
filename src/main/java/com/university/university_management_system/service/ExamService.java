package com.university.university_management_system.service;

import com.university.university_management_system.DTOs.ExamDTO;
import com.university.university_management_system.exceptions.ApiException;
import com.university.university_management_system.model.ExamModel;
import com.university.university_management_system.model.ExamTypeModel;
import com.university.university_management_system.repository.ExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ExamService {
    @Autowired
    ExamRepository examRepository;


    public List<ExamDTO> getAllExams(){

        List<ExamModel> allExams = examRepository.findAll();

        if (allExams.isEmpty()){
            throw new ApiException("No exams Found", HttpStatus.NOT_FOUND );
        }
        List<ExamDTO> allExamDTOs= new ArrayList<>();
        for (ExamModel exam: allExams ){
            ExamDTO examDTO = ExamDTO.fromModel(exam);
            allExamDTOs.add(examDTO);
        }
        return allExamDTOs;
    }


    public ExamDTO getExamById(int examId){

        ExamModel examModel = examRepository.findById(examId).orElseThrow(()->new ApiException("No exam found for examId: "+ examId, HttpStatus.NOT_FOUND));

        return ExamDTO.fromModel(examModel);

    }

    public List<ExamDTO> getExamsByCourseCode(String courseCode) {

        if (courseCode == null ){
            throw new ApiException("No course Code Found", HttpStatus.NOT_FOUND);
        }
        List<ExamModel> examsByCourse = examRepository.getExamsByCourseCode(courseCode);
        if (examsByCourse.isEmpty()) {
            throw new ApiException("No exams found for course code: " + courseCode, HttpStatus.NOT_FOUND);
        }
        List<ExamDTO> examDTOs = new ArrayList<>();
        for (ExamModel exam : examsByCourse) {
            examDTOs.add(ExamDTO.fromModel(exam));
        }
        return examDTOs;
    }

    public List<ExamDTO> getExamsByExamTypeId(int examTypeId){
        List<ExamModel> examsByExamTypeId= examRepository.getExamsByExamTypeId(examTypeId);
        if(examsByExamTypeId.isEmpty()){
            throw new ApiException("No exams found for examTypeId: " + examTypeId, HttpStatus.NOT_FOUND);
        }
        List<ExamDTO> examDTOS = new ArrayList<>();
        for(ExamModel exam: examsByExamTypeId){
            examDTOS.add(ExamDTO.fromModel(exam));
        }
        return examDTOS;
    }
    public List<ExamDTO> getExamsByExamHallId(int examHallId){
        List<ExamModel> examsByExamHallId= examRepository.getExamsByExamHallId(examHallId);
        if(examsByExamHallId.isEmpty()){
            throw new ApiException("No exams found for examHallId: " + examHallId, HttpStatus.NOT_FOUND);
        }
        List<ExamDTO> examDTOS = new ArrayList<>();
        for(ExamModel exam: examsByExamHallId){
            examDTOS.add(ExamDTO.fromModel(exam));
        }
        return examDTOS;
    }
    public List<ExamDTO> getExamsByExamModeId(int examModeId){
        List<ExamModel> examsByExamModeId = examRepository.getExamsByExamModeId(examModeId);
        if (examsByExamModeId.isEmpty()){
            throw new ApiException("No exams found for examModeId: " + examModeId, HttpStatus.NOT_FOUND);
        }
        List<ExamDTO> examDTOS = new ArrayList<>();
        for (ExamModel exam: examsByExamModeId){
            examDTOS.add(ExamDTO.fromModel(exam));
        }
        return examDTOS;

    }
    public List<ExamDTO> getExamsByDate(LocalDate examDate){
        List<ExamModel> examsByDate = examRepository.getExamsByDate(examDate);
        if (examsByDate.isEmpty()){
            throw new ApiException("No exams found for Date: "+ examDate, HttpStatus.NOT_FOUND);
        }
        List<ExamDTO> examDTOS = new ArrayList<>();
        for (ExamModel exam: examsByDate){
            examDTOS.add(ExamDTO.fromModel(exam));
        }
        return examDTOS;

    }
    public List<ExamDTO> getExamsByTimeSlot(LocalTime examStartTime, LocalTime examEndTime){


            List<ExamModel> examsByTimeSlot = examRepository.getExamsByTimeSlot(examStartTime, examEndTime);

        if (examsByTimeSlot.isEmpty()){
            throw new ApiException("No exams found for time slot: "+ examStartTime + " / " + examEndTime , HttpStatus.NOT_FOUND);
        }
        List<ExamDTO> examDTOS = new ArrayList<>();
        for (ExamModel exam: examsByTimeSlot){
            examDTOS.add(ExamDTO.fromModel(exam));
        }
        return examDTOS;
    }

}
