package com.university.university_management_system.service;

import com.university.university_management_system.DTOs.CourseResultDTO;
import com.university.university_management_system.exceptions.ApiException;
import com.university.university_management_system.model.CourseResultModel;
import com.university.university_management_system.repository.CourseResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseResultService {


    @Autowired
    CourseResultRepository courseResultRepository;


    public List<CourseResultDTO> getAllResults(){
        List<CourseResultDTO> getAll = new ArrayList<>();
        courseResultRepository.findAll().forEach(courseResultModel -> {
            getAll.add(CourseResultDTO.fromModel(courseResultModel));
        });
        return getAll;
    }

    public CourseResultDTO getById(int id){
        return CourseResultDTO.fromModel(courseResultRepository.findById(id).orElseThrow(()-> new ApiException("Cant find the result by this id", HttpStatus.NOT_FOUND)));
    }




}
