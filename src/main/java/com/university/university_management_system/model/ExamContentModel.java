package com.university.university_management_system.model;

import jakarta.persistence.*;

@Entity
public class ExamContentModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exam_content_id")
    private int examContentId;

    @Column(name = "exam_content_title", nullable = false)
    private String examContentTitle;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "content_type_id", referencedColumnName = "type_id", nullable = false)
    private ExamContentTypeModel contentType;

    @ManyToOne
    @JoinColumn(name = "question_id", referencedColumnName = "question_id", nullable = false)
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
}
