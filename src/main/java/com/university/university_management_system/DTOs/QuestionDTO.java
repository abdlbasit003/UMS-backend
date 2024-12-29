package com.university.university_management_system.DTOs;

import com.university.university_management_system.model.QuestionModel;

import java.util.HashMap;
import java.util.Map;

public class QuestionDTO {
    public int questionId;
    public String questionTitle;
    public String description;
    public String questionType;
    public int marks;
    public Map<String, Object> clo;

    public QuestionDTO(int questionId,String questionTitle,String description,String questionType,Map<String,Object> clo,int marks) {
        this.questionId = questionId;
        this.questionTitle = questionTitle;
        this.description = description;
        this.questionType = questionType;
        this.clo=clo;
        this.marks=marks;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getQuestionTitle() {
        return questionTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setQuestionTitle(String questionTitle) {
        this.questionTitle = questionTitle;
    }

    public String getQuestionType() {
        return questionType;
    }

    public void setQuestionType(String questionType) {
        this.questionType = questionType;
    }

    public Map<String, Object> getClo() {
        return clo;
    }

    public void setClo(Map<String, Object> clo) {
        this.clo = clo;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public static QuestionDTO fromModel(QuestionModel questionModel){
        Map<String, Object> clo = new HashMap<>();
        clo.put("title",questionModel.getClo().getTitle());
        clo.put("description",questionModel.getClo().getDescription());
        return new QuestionDTO(questionModel.getQuestionId(),questionModel.getQuestionTitle(),questionModel.getDescription(),questionModel.getQuestionTypeId().getName(),clo,questionModel.getMarks());

    }
}
