package com.university.university_management_system.service;

import com.university.university_management_system.DTOs.ExamDTO;
import com.university.university_management_system.model.ExamModel;
import com.university.university_management_system.repository.ExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExamService {
    @Autowired
    ExamRepository examRepository;


    public List<ExamDTO> getAllExams(){
        List<ExamDTO> allExamDTOs= new ArrayList<>();
        List<ExamModel> allExams = examRepository.findAll();
        for (ExamModel exam: allExams ){
            ExamDTO examDTO = ExamDTO.fromModel(exam);
            allExamDTOs.add(examDTO);
        }
        return allExamDTOs;
    }


    public ExamDTO getExamById(int examId){
        ExamModel examModel = examRepository.findById(examId).orElseThrow();

        return ExamDTO.fromModel(examModel);

    }

    public List<ExamDTO> getExamsByCourseCode(String courseCode) {
        List<ExamModel> examsByCourse = examRepository.getExamsByCourseCode(courseCode);
        if (examsByCourse.isEmpty()) {
            throw new IllegalArgumentException("No exams found for course code: " + courseCode);
        }
        List<ExamDTO> examDTOs = new ArrayList<>();
        for (ExamModel exam : examsByCourse) {
            examDTOs.add(ExamDTO.fromModel(exam));
        }
        return examDTOs;
    }

}
