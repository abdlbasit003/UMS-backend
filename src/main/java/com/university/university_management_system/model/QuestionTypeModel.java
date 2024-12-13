package com.university.university_management_system.model;
import jakarta.persistence.*;

@Entity
@Table(name = "question_type")
public class QuestionTypeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_type_id")
    public int typeId;

    @Column(name = "question_type_name")
    public String name;

    public QuestionTypeModel(String name) {
        this.name = name;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
