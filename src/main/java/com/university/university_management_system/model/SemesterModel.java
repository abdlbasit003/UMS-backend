package com.university.university_management_system.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "semester")
public class SemesterModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "semester_id")
    private int semesterId;

    @Column(name = "semester_name")
    private String semesterName;

    @ManyToOne
    @JoinColumn(name = "season_id", referencedColumnName = "season_id", insertable = false, updatable = false)
    private SeasonModel seasonModel;

    @Column(name = "semester_year")
    private int semesterYear;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    // Getters and Setters

    public int getSemesterId() {
        return semesterId;
    }

    public void setSemesterId(int semesterId) {
        this.semesterId = semesterId;
    }

    public String getSemesterName() {
        return semesterName;
    }



    public void setSemesterName(String semesterName) {
        this.semesterName = semesterName;
    }

    public SeasonModel getSeasonModel() {
        return seasonModel;
    }

    public void setSeasonModel(SeasonModel seasonModel) {
        this.seasonModel = seasonModel;
    }

    public int getSemesterYear() {
        return semesterYear;
    }

    public void setSemesterYear(int semesterYear) {
        this.semesterYear = semesterYear;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}

