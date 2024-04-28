package com.example.springbootquickstart.service;

import com.example.springbootquickstart.mapper.PatientAgeGroupCountMapper;
import com.example.springbootquickstart.pojo.PatientAgeGroupCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientAgeGroupService {
    @Autowired
    private PatientAgeGroupCountMapper patientAgeMapper;

    public List<PatientAgeGroupCount> getAgeGroupCounts() {
        return patientAgeMapper.countPeopleByAgeGroup();
    }
}
