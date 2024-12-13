package com.university.university_management_system.model;
import jakarta.persistence.*;

@Entity
@Table(name = "clo")
public class CLOModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "clo_id")
    public int cloId;

    @Column(name = "description")
    public String description;

    @Column(name = "clo_title")
    public String title;

    @ManyToOne
    @JoinColumn(name = "course_code", referencedColumnName = "course_code")
    public CourseModel course;

    public int getCloId() {
        return cloId;
    }

    public void setCloId(int cloId) {
        this.cloId = cloId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
