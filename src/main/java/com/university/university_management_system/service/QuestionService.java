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
            if (model.getQuestionTypeId().getTypeId() == questionTypeId) {
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
    public QuestionDTO createNewQuestion(Map<String, Object> questionBody) {
        QuestionModel questionModel = new QuestionModel();
        try {
            questionModel.setQuestionTitle(String.valueOf(questionBody.get("title")));
            questionModel.setDescription((String) questionBody.get("description"));
            questionModel.setMarks(Integer.parseInt(String.valueOf(questionBody.get("marks"))));
            questionModel.setClo(cloRepository.findById(Integer.parseInt(String.valueOf(questionBody.get("cloID")))).orElseThrow(() -> new ApiException("Question not found", HttpStatus.NOT_FOUND)));
            questionModel.setQuestionTypeId(questionTypeRepository.findById(Integer.parseInt(String.valueOf(questionBody.get("questionType")))).orElseThrow(() -> new ApiException("Question not found", HttpStatus.NOT_FOUND)));
        }
        catch (ApiException e) {
            throw new ApiException("Error creating questions", HttpStatus.BAD_REQUEST);
        }
        try {
            questionRepository.save(questionModel);
        }
        catch (ApiException e) {
            throw new ApiException("Error creating questions", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return QuestionDTO.fromModel(questionModel);
    }
}