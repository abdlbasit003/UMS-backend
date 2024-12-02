package com.university.university_management_system.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HealthCheck {



    @GetMapping("/ok")
    public String healthCheck(){
        return "OK";
    }


}
