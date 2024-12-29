package com.university.university_management_system.controller;

import com.university.university_management_system.DTOs.CloDTO;
import com.university.university_management_system.service.CloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class CLOController {
    @Autowired
    CloService cloService;


    @GetMapping("clos/{cloId}")
    public ResponseEntity<CloDTO> getCLOById(@PathVariable int cloId){
        return ResponseEntity.ok(cloService.getCLOById(cloId));
    }

    @GetMapping("/courses/{courseCode}/clos")
    public ResponseEntity<List<CloDTO>> getCLOsByCourseCode(@PathVariable String courseCode){

        return ResponseEntity.ok(cloService.getCLOsByCourseCode(courseCode));
    }

}
