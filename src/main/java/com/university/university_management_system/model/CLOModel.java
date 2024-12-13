package com.university.university_management_system.model;
import jakarta.persistence.*;

@Entity
@Table(name = "course_learning_objectives")
public class CLOModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "clo_id")
    public int cloId;

    @Column(name = "description", nullable = false)
    public String description;

    @ManyToOne
    @JoinColumn(name = "course_code", referencedColumnName = "course_code", nullable = false)
    public CourseModel course;

    public CLOModel(String description, CourseModel course) {
        this.description = description;
        this.course = course;
    }

    public int getCloId() {
        return cloId;
    }

    public void setCloId(int cloId) {
        this.cloId = cloId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CourseModel getCourse() {
        return course;
    }

    public void setCourse(CourseModel course) {
        this.course = course;
    }
}
