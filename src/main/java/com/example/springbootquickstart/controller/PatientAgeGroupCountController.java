package com.example.springbootquickstart.controller;

import com.example.springbootquickstart.pojo.PatientAgeGroupCount;
import com.example.springbootquickstart.service.PatientAgeGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/patientAgeGroupCount")
public class PatientAgeGroupCountController {
    @Autowired
    private PatientAgeGroupService personService;

    @GetMapping("/count")
    public List<PatientAgeGroupCount> getAgeGroupCounts() {
        return personService.getAgeGroupCounts();
    }
}

