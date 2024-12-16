package com.university.university_management_system.service;

import com.university.university_management_system.DTOs.QuestionDTO;
import com.university.university_management_system.model.QuestionModel;
import com.university.university_management_system.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    /**
     * Fetch all questions and convert them to DTOs.
     *
     * @return List<QuestionDTO>
     */
    public List<QuestionDTO> getAllQuestions() {
        List<QuestionDTO> questionDTOs = new ArrayList<>();
        for (QuestionModel model : questionRepository.findAll()) {
            questionDTOs.add(QuestionDTO.fromModel(model));
        }
        return questionDTOs;
    }
    /**
     * Fetch a single question by its ID.
     *
     * @param questionId The ID of the question.
     * @return QuestionDTO
     * @throws RuntimeException if the question is not found.
     */
    public QuestionDTO getQuestionById(int questionId) {
        QuestionModel model = questionRepository.findById(questionId).orElse(null);
        if (model == null) {
            throw new RuntimeException("Question not found with the ID: " + questionId);
        }
        return QuestionDTO.fromModel(model);
    }
    /**
     * Fetch questions filtered by questionTypeId.
     *
     * @param questionTypeId The ID of the question type.
     * @return List<QuestionDTO>
     */
    public List<QuestionDTO> getQuestionsByTypeId(int questionTypeId) {
        List<QuestionDTO> questionDTOs = new ArrayList<>();
        for (QuestionModel model : questionRepository.findAll()) {
            if (model.getQuestionTypeId().getTypeId() == questionTypeId) {
                questionDTOs.add(QuestionDTO.fromModel(model));
            }
        }
        return questionDTOs;
    }
    /**
     * Fetch questions filtered by cloId.
     *
     * @param cloId The ID of the CLO.
     * @return List<QuestionDTO>
     */
    public List<QuestionDTO> getQuestionsByCloId(int cloId) {
        List<QuestionDTO> questionDTOs = new ArrayList<>();
        for (QuestionModel model : questionRepository.findAll()) {
            if (model.getClo().getCloId() == cloId) {
                questionDTOs.add(QuestionDTO.fromModel(model));
            }
        }
        return questionDTOs;
    }
}