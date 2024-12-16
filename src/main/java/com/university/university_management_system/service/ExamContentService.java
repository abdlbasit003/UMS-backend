package com.university.university_management_system.service;

import com.university.university_management_system.DTOs.ExamContentDTO;
import com.university.university_management_system.model.ExamContentModel;
import com.university.university_management_system.repository.ExamContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExamContentService {

    @Autowired
    private ExamContentRepository examContentRepository;

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
}
