package com.university.university_management_system.service;

import com.university.university_management_system.model.SemesterModel;
import com.university.university_management_system.repository.SemesterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SemesterService {

    @Autowired
    SemesterRepository semesterRepository;


    public List<SemesterModel> getAllSemesters(){
        return semesterRepository.findAll();
    }



}
