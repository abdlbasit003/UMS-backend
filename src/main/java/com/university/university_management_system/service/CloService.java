package com.university.university_management_system.service;

import com.university.university_management_system.DTOs.CloDTO;
import com.university.university_management_system.exceptions.ApiException;
import com.university.university_management_system.model.CLOModel;
import com.university.university_management_system.repository.CLORepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CloService {
    @Autowired
    CLORepository cloRepository;
    public List<CloDTO> getAllCLOs(){
        List<CLOModel> cloModels = cloRepository.findAll();
        if(cloModels.isEmpty()){
            throw new ApiException("No CLO's Found", HttpStatus.NOT_FOUND);

        }
        return cloModels.stream().map(CloDTO::fromModel).toList();
    }

    public CloDTO getCLOById(int cloId){
        return CloDTO.fromModel(cloRepository.findById(cloId).orElseThrow(()->new ApiException("No CLO found for cloID: "+ cloId, HttpStatus.NOT_FOUND)));
    }

    public List<CloDTO> getCLOsByCourseCode(String courseCode){
        List<CLOModel> cloModels = cloRepository.getCLOsByCourseCode(courseCode);
        if (cloModels.isEmpty()){
            throw new ApiException("No CLO's found for courseCode: "+ courseCode, HttpStatus.NOT_FOUND);

        }
        return cloModels.stream().map(CloDTO::fromModel).toList();
    }
}
