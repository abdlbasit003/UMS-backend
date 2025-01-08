package com.university.university_management_system.service;
import com.university.university_management_system.DTOs.ExamDTO;
import com.university.university_management_system.DTOs.ExamQuestionsDTO;
import com.university.university_management_system.DTOs.QuestionDTO;
import com.university.university_management_system.exceptions.ApiException;
import com.university.university_management_system.model.ExamQuestionsModel;
import com.university.university_management_system.model.ExamModel;
import com.university.university_management_system.model.QuestionModel;
import com.university.university_management_system.repository.ExamQuestionsRepository;
import com.university.university_management_system.repository.ExamRepository;
import com.university.university_management_system.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class ExamQuestionService {

    @Autowired
    private ExamQuestionsRepository examQuestionsRepository;

    @Autowired
    private ExamRepository examRepository;

    @Autowired
    private QuestionRepository questionRepository;

    public List<ExamQuestionsDTO> getAllExamQuestions() {
        List<ExamQuestionsModel> examQuestions = examQuestionsRepository.findAll();
        if (examQuestions.isEmpty()) {
            throw new ApiException("No questions found", HttpStatus.NOT_FOUND);
        }
        return examQuestions.stream()
                .map(ExamQuestionsDTO::fromModel)
                .toList();
    }


    public ExamQuestionsDTO getExamQuestionById(int examQuestionId) {
        ExamQuestionsModel examQuestion = examQuestionsRepository.findById(examQuestionId)
                .orElseThrow(() -> new ApiException("Question not found", HttpStatus.NOT_FOUND));
        return ExamQuestionsDTO.fromModel(examQuestion);
    }


    public List<QuestionDTO> getQuestionsByExamId(int examId) {
        examRepository.findById(examId)
                .orElseThrow(() -> new ApiException("No question found", HttpStatus.NOT_FOUND));

        return examQuestionsRepository.findAll().stream()
                .filter(examQuestion -> examQuestion.getExam().getExamId() == examId)
                .map(examQuestion -> QuestionDTO.fromModel(examQuestion.getQuestion()))
                .toList();
    }


    public List<ExamDTO> getExamsByQuestionId(int questionId) {
        questionRepository.findById(questionId)
                .orElseThrow(() -> new ApiException("No exams found for this question", HttpStatus.NOT_FOUND));

        return examQuestionsRepository.findAll().stream()
                .filter(examQuestion -> examQuestion.getQuestion().getQuestionId() == questionId)
                .map(examQuestion -> ExamDTO.fromModel(examQuestion.getExam()))
                .toList();
    }

}