package com.university.university_management_system.service;

import com.university.university_management_system.exceptions.ApiException;
import com.university.university_management_system.model.SeasonModel;
import com.university.university_management_system.model.SemesterModel;
import com.university.university_management_system.repository.SeasonRepository;
import com.university.university_management_system.repository.SemesterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class SemesterService {

    @Autowired
    SemesterRepository semesterRepository;
    @Autowired
    SeasonRepository seasonRepository;


    public List<SemesterModel> getAllSemesters() {
        return semesterRepository.findAll();
    }

    public SemesterModel getBySemesterId(int semesterId) {
        return semesterRepository.findById(semesterId)
                .orElseThrow(() -> new ApiException("Semester not found for " + semesterId, HttpStatus.NOT_FOUND));
    }

    public List<SemesterModel> getBySeasonId(int seasonId) {
        SeasonModel season = seasonRepository.findById(seasonId)
                .orElseThrow(() -> new ApiException("Season with id: " + seasonId + " not found", HttpStatus.NOT_FOUND));

        return semesterRepository.findAll().stream()
                .filter(sm -> sm.getSeasonModel().getSeasonId() == seasonId)
                .toList();
    }

    public List<SemesterModel> getBySemesterYear(int semesterYear) {
        return semesterRepository.findAll().stream()
                .filter(sm -> sm.getSemesterYear() == semesterYear)
                .toList();
    }

    public List<SemesterModel> getByStartDate(Date startDate) {
        return semesterRepository.findAll().stream()
                .filter(sm -> startDate.equals(sm.getStartDate()))
                .toList();
    }

    public List<SemesterModel> getByEndDate(Date endDate) {
        return semesterRepository.findAll().stream()
                .filter(sm -> endDate.equals(sm.getEndDate()))
                .toList();
    }




}
