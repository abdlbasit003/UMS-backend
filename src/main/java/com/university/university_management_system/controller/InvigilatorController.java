package com.university.university_management_system.controller;
import io.swagger.v3.oas.annotations.tags.Tag;
import com.university.university_management_system.DTOs.InvigilatorDTO;
import com.university.university_management_system.service.InvigilatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag (name = "Invigilator", description = "Invigilator endpoints" )

@RequestMapping("/invigilators")
public class InvigilatorController {

    @Autowired
    private InvigilatorService invigilatorService;

    @GetMapping("")
    public List<InvigilatorDTO> getAllInvigilators() {
        return invigilatorService.getAllInvigilators();
    }

    @GetMapping("/{invigilatorId}")
    public InvigilatorDTO getInvigilatorById(@PathVariable int invigilatorId) {
        return invigilatorService.getInvigilatorById(invigilatorId);
    }

    @GetMapping("/faculty/{facultyId}")
    public List<InvigilatorDTO> getInvigilatorsByFacultyId(@PathVariable int facultyId) {
        return invigilatorService.getInvigilatorsByFacultyId(facultyId);
    }

    @GetMapping("/examhall/{examHallId}")
    public List<InvigilatorDTO> getInvigilatorsByExamHallId(@PathVariable int examHallId) {
        return invigilatorService.getInvigilatorsByExamHallId(examHallId);
    }
}
