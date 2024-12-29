package com.university.university_management_system.service;

import com.university.university_management_system.DTOs.QuestionDTO;
import com.university.university_management_system.exceptions.ApiException;
import com.university.university_management_system.model.QuestionModel;
import com.university.university_management_system.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;


    public List<QuestionDTO> getAllQuestions() {
        List<QuestionDTO> questionDTOs = new ArrayList<>();
        List<QuestionModel> questionModels = questionRepository.findAll();

        if (!questionModels.isEmpty()) {
            for (QuestionModel model : questionModels) {
                questionDTOs.add(QuestionDTO.fromModel(model));
            }
            return questionDTOs;
        } else {
            throw new ApiException("No questions found.", HttpStatus.NOT_FOUND);
        }
    }

    public QuestionDTO getQuestionById(int questionId) {
        QuestionModel model = questionRepository.findById(questionId).orElse(null);
        if (model == null) {
            throw new ApiException("Question not found with the ID ", HttpStatus.NOT_FOUND);
        }
        return QuestionDTO.fromModel(model);
    }

    public List<QuestionDTO> getQuestionsByTypeId(int questionTypeId) {
        List<QuestionDTO> questionDTOs = new ArrayList<>();
        List<QuestionModel> questionModels = questionRepository.findAll();

        for (QuestionModel model : questionModels) {
            if (model.getQuestionType().getTypeId() == questionTypeId) {
                questionDTOs.add(QuestionDTO.fromModel(model));
            }
        }

        if (questionDTOs.isEmpty()) {
            throw new ApiException("No questions found for Question Type ID: " + questionTypeId, HttpStatus.NOT_FOUND);
        }

        return questionDTOs;
    }

    public List<QuestionDTO> getQuestionsByCloId(int cloId) {
        List<QuestionDTO> questionDTOs = new ArrayList<>();
        List<QuestionModel> questionModels = questionRepository.findAll();

        for (QuestionModel model : questionModels) {
            if (model.getClo().getCloId() == cloId) {
                questionDTOs.add(QuestionDTO.fromModel(model));
            }
        }

        if (questionDTOs.isEmpty()) {
            throw new ApiException("No questions found for CLO ID: " + cloId, HttpStatus.NOT_FOUND);
        }

        return questionDTOs;
    }
}