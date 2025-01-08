package com.university.university_management_system.service;

import com.university.university_management_system.DTOs.QuestionDTO;
import com.university.university_management_system.exceptions.ApiException;
import com.university.university_management_system.model.QuestionModel;
import com.university.university_management_system.repository.CLORepository;
import com.university.university_management_system.repository.QuestionRepository;
import com.university.university_management_system.repository.QuestionTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private CLORepository cloRepository;
    @Autowired
    QuestionTypeRepository questionTypeRepository;


    public List<QuestionDTO> getAllQuestions() {
        List<QuestionModel> questionModels = questionRepository.findAll();
        if (questionModels.isEmpty()) {
            throw new ApiException("No questions found.", HttpStatus.NOT_FOUND);
        }
        return questionModels.stream()
                .map(QuestionDTO::fromModel)
                .toList();
    }

    public QuestionDTO getQuestionById(int questionId) {
        QuestionModel model = questionRepository.findById(questionId)
                .orElseThrow(() -> new ApiException("Question not found with the ID", HttpStatus.NOT_FOUND));
        return QuestionDTO.fromModel(model);
    }

    public List<QuestionDTO> getQuestionsByTypeId(int questionTypeId) {
        List<QuestionModel> questionModels = questionRepository.findAll();
        List<QuestionDTO> questionDTOs = questionModels.stream()
                .filter(model -> model.getQuestionTypeId().getTypeId() == questionTypeId)
                .map(QuestionDTO::fromModel)
                .toList();

        if (questionDTOs.isEmpty()) {
            throw new ApiException("No questions found for Question Type ID: " + questionTypeId, HttpStatus.NOT_FOUND);
        }

        return questionDTOs;
    }

    public List<QuestionDTO> getQuestionsByCloId(int cloId) {
        List<QuestionModel> questionModels = questionRepository.findAll();
        List<QuestionDTO> questionDTOs = questionModels.stream()
                .filter(model -> model.getClo().getCloId() == cloId)
                .map(QuestionDTO::fromModel)
                .toList();

        if (questionDTOs.isEmpty()) {
            throw new ApiException("No questions found for CLO ID: " + cloId, HttpStatus.NOT_FOUND);
        }

        return questionDTOs;
    }

    public QuestionDTO createNewQuestion(Map<String, Object> questionBody) {
        QuestionModel questionModel = new QuestionModel();
        try {
            questionModel.setQuestionTitle(String.valueOf(questionBody.get("title")));
            questionModel.setDescription((String) questionBody.get("description"));
            questionModel.setMarks(Integer.parseInt(String.valueOf(questionBody.get("marks"))));
            questionModel.setClo(cloRepository.findById(Integer.parseInt(String.valueOf(questionBody.get("cloID"))))
                    .orElseThrow(() -> new ApiException("Question not found", HttpStatus.NOT_FOUND)));
            questionModel.setQuestionTypeId(questionTypeRepository.findById(Integer.parseInt(String.valueOf(questionBody.get("questionType"))))
                    .orElseThrow(() -> new ApiException("Question not found", HttpStatus.NOT_FOUND)));
        } catch (ApiException e) {
            throw new ApiException("Error creating questions", HttpStatus.BAD_REQUEST);
        }
        try {
            questionRepository.save(questionModel);
        } catch (ApiException e) {
            throw new ApiException("Error creating questions", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return QuestionDTO.fromModel(questionModel);
    }

}