package com.university.university_management_system.controller;

import com.university.university_management_system.model.ExamContentTypeModel;
import com.university.university_management_system.model.ExamPaperStatus;
import com.university.university_management_system.repository.ExamPaperStatusRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/exampaperstatus")
@Tag(name = "Exam Paper Statuses")
public class ExamPaperStatusController {

    @Autowired
    ExamPaperStatusRepository examPaperStatusRepository;
    @GetMapping("")
    public List<ExamPaperStatus> getStatuses() {
        return examPaperStatusRepository.findAll();
    }
    @GetMapping("/{id}")
    public ExamPaperStatus getStatusById(int id) {
        return examPaperStatusRepository.findById(id).orElseThrow();

    }


}










