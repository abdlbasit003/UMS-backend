package com.university.university_management_system.model;

import jakarta.persistence.*;

@Entity
@Table(name="exam_questions")
public class ExamQuestionsModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exam_question_id")
    private int examQuestionId;

    @ManyToOne
    @JoinColumn(name = "exam_id", referencedColumnName = "exam_id")
    private ExamModel exam;

    @ManyToOne
    @JoinColumn(name = "question_id", referencedColumnName = "question_id")
    private QuestionModel question;


    public int getExamQuestionId() {
        return examQuestionId;
    }

    public ExamModel getExam() {
        return exam;
    }

    public QuestionModel getQuestion() {
        return question;
    }



    public void setExamQuestionId(int examQuestionId) {
        this.examQuestionId = examQuestionId;
    }

    public void setExam(ExamModel exam) {
        this.exam = exam;
    }

    public void setQuestion(QuestionModel question) {
        this.question = question;
    }


}
