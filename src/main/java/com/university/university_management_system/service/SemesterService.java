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


    public List<SemesterModel> getAllSemesters(){
        return semesterRepository.findAll();
    }
    public SemesterModel getBySemesterId(int semesterId){
        return semesterRepository.findById(semesterId).orElseThrow(() -> new ApiException("Semester not found for " + semesterId, HttpStatus.NOT_FOUND));
    }
    public List<SemesterModel> getBySeasonId(int seasonId){
        List<SemesterModel> allSemesterModels = semesterRepository.findAll();
        List<SemesterModel> semesterModelsBySeasonId = new ArrayList<>();
        SeasonModel season = seasonRepository.findById(seasonId).orElseThrow(()-> new ApiException("Season with id: " + seasonId + " not found", HttpStatus.NOT_FOUND));

        if (allSemesterModels.isEmpty()){
            throw new ApiException("No Semesters in record", HttpStatus.NOT_FOUND);
        }

        for(SemesterModel sm : allSemesterModels){
            if(seasonId == sm.getSeasonModel().getSeasonId()){
                semesterModelsBySeasonId.add(sm);
            }
        }
        return semesterModelsBySeasonId;
    }
    public List<SemesterModel> getBySemesterYear (int semesterYear){
        List<SemesterModel> allSemesterModels = semesterRepository.findAll();
        List<SemesterModel> semesterModelsBySemesterYear = new ArrayList<>();

        if (allSemesterModels.isEmpty()){
            throw new ApiException("No Semesters in record", HttpStatus.NOT_FOUND);
        }

        for(SemesterModel sm : allSemesterModels){
            if(semesterYear == sm.getSemesterYear()){
                semesterModelsBySemesterYear.add(sm);
            }
        }
        return semesterModelsBySemesterYear;

    }
    public List<SemesterModel> getByStartDate(Date startDate){
        List<SemesterModel> allSemesterModels = semesterRepository.findAll();
        List<SemesterModel> semesterModelsByStartDate = new ArrayList<>();

        if (allSemesterModels.isEmpty()){
            throw new ApiException("No Semesters in record", HttpStatus.NOT_FOUND);
        }

        for(SemesterModel sm : allSemesterModels){
            if(startDate.equals(sm.getStartDate())){
                semesterModelsByStartDate.add(sm);
            }
        }
        return semesterModelsByStartDate;
    }
    public List<SemesterModel> getByEndDate(Date endDate){
        List<SemesterModel> allSemesterModels = semesterRepository.findAll();
        List<SemesterModel> semesterModelsByEndDate = new ArrayList<>();

        if (allSemesterModels.isEmpty()){
            throw new ApiException("No Semesters in record", HttpStatus.NOT_FOUND);
        }

        for(SemesterModel sm : allSemesterModels){
            if(endDate.equals(sm.getEndDate())){
                semesterModelsByEndDate.add(sm);
            }
        }
        return semesterModelsByEndDate;
    }



}
