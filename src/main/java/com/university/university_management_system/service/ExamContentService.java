package com.university.university_management_system.service;

import com.university.university_management_system.DTOs.ExamContentDTO;
import com.university.university_management_system.exceptions.ApiException;
import com.university.university_management_system.model.ExamContentModel;
import com.university.university_management_system.repository.ExamContentRepository;
import com.university.university_management_system.repository.ExamContentTypeRepository;
import com.university.university_management_system.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ExamContentService {

    @Autowired
    private ExamContentRepository examContentRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private ExamContentTypeRepository examContentTypeRepository;

    public List<ExamContentDTO> getAllExamContents() {
        return examContentRepository.findAll()
                .stream()
                .map(ExamContentDTO::fromModel)
                .collect(Collectors.toList());
    }

    public ExamContentDTO getExamContentById(int examContentId) {
        ExamContentModel model = examContentRepository.findById(examContentId)
                .orElseThrow(() -> new RuntimeException("Exam Content not found with ID: " + examContentId));
        return ExamContentDTO.fromModel(model);
    }

    public List<ExamContentDTO> getExamContentsByContentTypeId(int contentTypeId) {
        return examContentRepository.findAll()
                .stream()
                .filter(model -> model.getContentType().getTypeId() == contentTypeId)
                .map(ExamContentDTO::fromModel)
                .collect(Collectors.toList());
    }

    public List<ExamContentDTO> getExamContentsByQuestionId(int questionId) {
        return examContentRepository.findAll()
                .stream()
                .filter(model -> model.getQuestion().getQuestionId() == questionId)
                .map(ExamContentDTO::fromModel)
                .collect(Collectors.toList());
    }

    public ExamContentDTO createNewExamContents(Map<String, Object> examContentBody) {
        ExamContentModel examContentModel = new ExamContentModel();
        try {
            examContentModel.setDescription(String.valueOf(examContentBody.get("description")));
            examContentModel.setExamContentTitle(String.valueOf(examContentBody.get("title")));
            examContentModel.setQuestion(questionRepository.findById(Integer.parseInt(String.valueOf(examContentBody.get("questionID")))).orElseThrow(() -> new ApiException("Question not found", HttpStatus.NOT_FOUND)));
            examContentModel.setContentType(examContentTypeRepository.findById(Integer.parseInt(String.valueOf(examContentBody.get("contentType")))).orElseThrow(() -> new ApiException("Exam content not found", HttpStatus.NOT_FOUND)));
        }
        catch (ApiException e) {
            throw new ApiException("Error adding exam contents", HttpStatus.BAD_GATEWAY);
        }
        try {
            examContentRepository.save(examContentModel);
        }
        catch (Exception e) {
            throw new ApiException("Error adding exam contents", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ExamContentDTO.fromModel(examContentModel);
    }
}
