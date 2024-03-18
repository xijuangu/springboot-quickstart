package com.example.springbootquickstart.controller;

import com.example.springbootquickstart.pojo.patientfeedback;
import com.example.springbootquickstart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@RestController
@RequestMapping("/patientFeedbacks")
@CrossOrigin
public class PatientFeedbackController {

    @Autowired
    private UserService patientFeedbackService;

    @PostMapping("/add")
    public ResponseEntity<?> addPatientFeedback(@RequestBody Map<String, String> requestMap) {
        String patientFeedbackId = requestMap.get("PatientFeedbackId");
        String pIDCard = requestMap.get("pIDCard");
        String pfTimeStr = requestMap.get("pfTime"); // 接收时间字符串
        String patientFeedbackComment = requestMap.get("PatientFeedbackComment");
        String pfLikesCountStr = requestMap.get("pfLikesCount");
        String pfCommentText = requestMap.get("pfCommentText");

        if (patientFeedbackId == null || pIDCard == null || pfTimeStr == null || patientFeedbackComment == null || pfLikesCountStr == null || pfCommentText == null) {
            return new ResponseEntity<>("Missing fields in request", HttpStatus.BAD_REQUEST);
        }

        int pfLikesCount;
        try {
            pfLikesCount = Integer.parseInt(pfLikesCountStr);
        } catch (NumberFormatException e) {
            return new ResponseEntity<>("Invalid format for pfLikesCount", HttpStatus.BAD_REQUEST);
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date pfTime;
        try {
            pfTime = dateFormat.parse(pfTimeStr); // 将字符串转换为Date
        } catch (ParseException e) {
            return new ResponseEntity<>("Invalid format for pfTime", HttpStatus.BAD_REQUEST);
        }

        patientfeedback patientFeedback = new patientfeedback();
        patientFeedback.setPatientFeedbackId(patientFeedbackId);
        patientFeedback.setPIDCard(pIDCard);
        patientFeedback.setPfTime(pfTime);
        patientFeedback.setPatientFeedbackComment(patientFeedbackComment);
        patientFeedback.setPfLikesCount(pfLikesCount);
        patientFeedback.setPfComentText(pfCommentText);

        patientFeedbackService.addPatientFeedback(patientFeedback);

        return new ResponseEntity<>("Patient feedback added successfully", HttpStatus.CREATED);
    }

    @GetMapping("/{patientFeedbackId}")
    public ResponseEntity<patientfeedback> getPatientFeedbackById(@PathVariable String patientFeedbackId) {
        patientfeedback patientFeedback = patientFeedbackService.getPatientFeedbackById(patientFeedbackId);

        if (patientFeedback == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(patientFeedback, HttpStatus.OK);
    }
}
