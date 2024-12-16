package com.university.university_management_system.DTOs;

import com.university.university_management_system.model.ExamContentModel;

public class ExamContentDTO {
    private int examContentId;
    private String examContentTitle;
    private String description;
    private String contentType; // Name of content type
    private QuestionDTO question;

    public ExamContentDTO(int examContentId, String examContentTitle, String description, String contentType, QuestionDTO question) {
        this.examContentId = examContentId;
        this.examContentTitle = examContentTitle;
        this.description = description;
        this.contentType = contentType;
        this.question = question;
    }

    public int getExamContentId() {
        return examContentId;
    }

    public void setExamContentId(int examContentId) {
        this.examContentId = examContentId;
    }

    public String getExamContentTitle() {
        return examContentTitle;
    }

    public void setExamContentTitle(String examContentTitle) {
        this.examContentTitle = examContentTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public QuestionDTO getQuestion() {
        return question;
    }

    public void setQuestion(QuestionDTO question) {
        this.question = question;
    }

    public static ExamContentDTO fromModel(ExamContentModel model) {
        return new ExamContentDTO(
                model.getExamContentId(),
                model.getExamContentTitle(),
                model.getDescription(),
                model.getContentType().getType(),
                QuestionDTO.fromModel(model.getQuestion())
        );
    }
}
