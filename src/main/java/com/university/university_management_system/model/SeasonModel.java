package com.university.university_management_system.model;

import jakarta.persistence.*;



@Entity
@Table(name = "season")
public class SeasonModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "season_id")
    private int seasonId;

    @Column(name = "season_name")
    private String seasonName;



    public int getSeasonId() {
        return seasonId;
    }

    public void setSeasonId(int seasonId) {
        this.seasonId = seasonId;
    }

    public String getSeasonName() {
        return seasonName;
    }

    public void setSeasonName(String seasonName) {
        this.seasonName = seasonName;
    }
}
