package com.example.springbootquickstart.mapper;

import com.example.springbootquickstart.pojo.PatientAgeGroupCount;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PatientAgeGroupCountMapper {

    @Select("SELECT " +
            "CASE " +
            "WHEN pAge BETWEEN 0 AND 18 THEN '0~18' " +
            "WHEN pAge BETWEEN 19 AND 35 THEN '19~35' " +
            "WHEN pAge BETWEEN 36 AND 45 THEN '36~45' " +
            "WHEN pAge BETWEEN 46 AND 60 THEN '46~60' " +
            "ELSE '60+' " +
            "END as ageGroup, COUNT(*) as count " +
            "FROM pinfo " +
            "GROUP BY ageGroup")
    List<PatientAgeGroupCount> countPeopleByAgeGroup();

}
