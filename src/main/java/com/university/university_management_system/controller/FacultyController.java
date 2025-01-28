package com.university.university_management_system.controller;
import java.util.*;

import com.university.university_management_system.DTOs.FacultyDTO;
import com.university.university_management_system.exceptions.ApiException;
import com.university.university_management_system.model.FacultyModel;
import com.university.university_management_system.repository.FacultyRepository;
import com.university.university_management_system.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag (name = "Faculty", description = "Faculty endpoints" )

@RequestMapping("/faculty")
public class FacultyController {
    @Autowired
    FacultyService facultyService;

    @GetMapping("")
    public List<FacultyDTO> getAllFaculty(){
        return facultyService.getAllFaculty();
    }

    @GetMapping("/{facultyId}")
    public FacultyDTO getFacultyById(@PathVariable int facultyId){
        return facultyService.getFacultyById(facultyId);
    }


    @GetMapping("/search")
    public ResponseEntity<?> searchFaculty(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Integer designationId,
            @RequestParam(required = false) String uuid
    ){
        if (name!=null)return ResponseEntity.ok(facultyService.getFacultyByName(name));
        if (designationId!=null)return ResponseEntity.ok(facultyService.getFacultyByDesignation(designationId));
        if (uuid!=null)return ResponseEntity.ok(facultyService.getFacultyByUuid(uuid));
        throw new ApiException("No search parameter recieved", HttpStatus.BAD_REQUEST);
    }
}
