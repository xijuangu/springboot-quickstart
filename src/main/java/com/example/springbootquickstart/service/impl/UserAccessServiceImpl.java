package com.example.springbootquickstart.service.impl;

import com.example.springbootquickstart.mapper.UserAccessMapper;
import com.example.springbootquickstart.pojo.UserAccess;
import com.example.springbootquickstart.service.UserAccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class UserAccessServiceImpl implements UserAccessService {

    @Autowired
    private UserAccessMapper userAccessMapper;

    @Override
    public void recordUserAccess(UserAccess userAccess) {
        userAccessMapper.insertAccessRecord(userAccess);
    }

    @Override
    public int getAccessCountByTypeAndTime(String userType, LocalDateTime startTime, LocalDateTime endTime) {
        return userAccessMapper.countAccessByUserTypeAndTime(userType, startTime, endTime);
    }
}
