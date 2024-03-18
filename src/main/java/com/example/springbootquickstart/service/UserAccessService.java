package com.example.springbootquickstart.service;


import com.example.springbootquickstart.pojo.UserAccess;

import java.time.LocalDateTime;

public interface UserAccessService {
    void recordUserAccess(UserAccess userAccess);
    int getAccessCountByTypeAndTime(String userType, LocalDateTime startTime, LocalDateTime endTime);
}