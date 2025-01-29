package com.university.university_management_system.controller;

import com.university.university_management_system.model.QuestionTypeModel;
import com.university.university_management_system.model.SeasonModel;
import com.university.university_management_system.repository.SeasonRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/seasons")
@Tag(name = "Semester Seasons")
public class SeasonController {


    @Autowired
    SeasonRepository seasonRepository;

    @GetMapping("")
    public List<SeasonModel> getAll() {
        return seasonRepository.findAll();
    }

    @GetMapping("/{id}")
    public SeasonModel getById(int id) {
        return seasonRepository.findById(id).orElseThrow();

    }


}
