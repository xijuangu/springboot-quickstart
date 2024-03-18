package com.example.springbootquickstart.controller;

import com.example.springbootquickstart.pojo.UserAccess;
import com.example.springbootquickstart.service.UserAccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;


@RestController
@RequestMapping("/access")
public class UserAccessController {

    @Autowired
    private UserAccessService userAccessService;

    @PostMapping("/record")
    public ResponseEntity<?> recordAccess(@RequestBody UserAccess userAccess) {
        userAccessService.recordUserAccess(userAccess);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/count")
    public ResponseEntity<?> getAccessCount(
            @RequestParam String userType,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startTime,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endTime) {
        int count = userAccessService.getAccessCountByTypeAndTime(userType, startTime, endTime);
        return ResponseEntity.ok(count);
    }
}
