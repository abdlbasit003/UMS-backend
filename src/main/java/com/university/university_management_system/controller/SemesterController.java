package com.university.university_management_system.controller;
import io.swagger.v3.oas.annotations.tags.Tag;

import com.university.university_management_system.model.SemesterModel;
import com.university.university_management_system.service.SemesterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@Tag (name = "Semester", description = "Semester endpoints" )

@RequestMapping("/semesters")
public class SemesterController {

    @Autowired
    SemesterService semesterService;

    @GetMapping("")
    public List<SemesterModel> getSemesters(){
        return semesterService.getAllSemesters();
    }
    @GetMapping("/{semesterId}")
    public SemesterModel getBySemesterId(@PathVariable int semesterId) {
        return semesterService.getBySemesterId(semesterId);
    }
    @GetMapping("/season/{seasonId}")
    public List<SemesterModel> getBySeasonId(@PathVariable int seasonId) {
        return semesterService.getBySeasonId(seasonId);
    }

    @GetMapping("/year/{semesterYear}")
    public List<SemesterModel> getBySemesterYear (@PathVariable int semesterYear){
        return semesterService.getBySemesterYear(semesterYear);
    }
    @GetMapping("/start/{startDate}")
    public List<SemesterModel> getByStartDate(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate){
        return semesterService.getByStartDate(startDate);
    }
    @GetMapping("/end/{endDate}")
    public List<SemesterModel> getByEndDate(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate){
        return semesterService.getByEndDate(endDate);
    }
}

