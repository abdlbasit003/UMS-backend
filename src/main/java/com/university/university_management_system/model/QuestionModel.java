package com.university.university_management_system.model;
import jakarta.persistence.*;

@Entity
@Table(name = "question")
public class QuestionModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_id")
    public int questionId;

    @Column(name = "question_title")
    public String questionTitle;

    @Column(name = "description")
    public String description;

    @ManyToOne
    @JoinColumn(name = "question_type_id", referencedColumnName = "question_type_id")
    public QuestionTypeModel questionTypeId;

    @Column(name = "marks")
    public int marks;

    @ManyToOne
    @JoinColumn(name = "clo_id", referencedColumnName = "clo_id")
    public CLOModel cloId;

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getQuestionTitle() {
        return questionTitle;
    }

    public void setQuestionTitle(String questionTitle) {
        this.questionTitle = questionTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public QuestionTypeModel getQuestionTypeId() {
        return questionTypeId;
    }

    public void setQuestionTypeId(QuestionTypeModel questionTypeId) {
        this.questionTypeId = questionTypeId;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public CLOModel getClo() {
        return cloId;
    }

    public void setClo(CLOModel clo) {
        this.cloId = clo;
    }
}
