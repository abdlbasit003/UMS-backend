package com.university.university_management_system.DTOs;
import com.university.university_management_system.model.ExamQuestionsModel;

public class ExamQuestionsDTO {
    public int examQuestionId;
    public ExamDTO exam;
    public QuestionDTO question;

    public ExamQuestionsDTO(int examQuestionId, ExamDTO examDTO, QuestionDTO questionDTO) {
        this.examQuestionId = examQuestionId;
        this.exam = examDTO;
        this.question = questionDTO;
    }

    public int getExamQuestionId() {
        return examQuestionId;
    }

    public void setExamQuestionId(int examQuestionId) {
        this.examQuestionId = examQuestionId;
    }

    public ExamDTO getExam() {
        return exam;
    }

    public void setExam(ExamDTO examDTO) {
        this.exam = examDTO;
    }

    public QuestionDTO getQuestion() {
        return question;
    }

    public void setQuestion(QuestionDTO questionDTO) {
        this.question = questionDTO;
    }

    public static ExamQuestionsDTO fromModel(ExamQuestionsModel model) {
        ExamDTO exam = ExamDTO.fromModel(model.getExam());
        QuestionDTO question = QuestionDTO.fromModel(model.getQuestion());
        return new ExamQuestionsDTO(model.getExamQuestionId(), exam, question);
    }
}
