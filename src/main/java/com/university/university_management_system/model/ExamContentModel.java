package com.university.university_management_system.model;

import jakarta.persistence.*;

@Entity
@Table(name = "exam_content")
public class ExamContentModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exam_content_id")
    private int examContentId;

    @Column(name = "exam_content_title")
    private String examContentTitle;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "content_type_id", referencedColumnName = "content_type_id")
    private ExamContentTypeModel contentType;

    @ManyToOne
    @JoinColumn(name = "question_id", referencedColumnName = "question_id")
    private QuestionModel question;


    public int getExamContentId() {
        return examContentId;
    }

    public String getExamContentTitle() {
        return examContentTitle;
    }

    public String getDescription() {
        return description;
    }

    public ExamContentTypeModel getContentType() {
        return contentType;
    }

    public QuestionModel getQuestion() {
        return question;
    }

    public void setExamContentTitle(String examContentTitle) {
        this.examContentTitle = examContentTitle;
    }

    public void setContentType(ExamContentTypeModel contentType) {
        this.contentType = contentType;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setQuestion(QuestionModel question) {
        this.question = question;
    }
}
