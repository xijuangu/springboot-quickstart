package com.example.springbootquickstart.controller;

import com.example.springbootquickstart.pojo.PatientFeedbackDetail;
import com.example.springbootquickstart.pojo.patientfeedback;
import com.example.springbootquickstart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/patientFeedbacks")
@CrossOrigin
public class PatientFeedbackController {

    @Autowired
    private UserService patientFeedbackService;

    @GetMapping("/getPatientFeedbackByDid")
    public List<PatientFeedbackDetail> getPatientFeedbackByDname(@RequestParam("dID") String dID) {
        return patientFeedbackService.getPatientFeedbackByDid(dID);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addPatientFeedback(@RequestBody Map<String, String> requestMap) {
        String pIDCard = requestMap.get("pIDCard");
        String pfTimeStr = requestMap.get("pfTime"); // 接收时间字符串
        String patientFeedbackComment = requestMap.get("PatientFeedbackComment");
        String pfLikesCountStr = requestMap.get("pfLikesCount");
        String pfCommentText = requestMap.get("pfCommentText");
        String dID = requestMap.get("dID");

        // 现在不检查patientFeedbackId，因为它是自增的
        /*if (dID == null || pIDCard == null || pfTimeStr == null || patientFeedbackComment == null || pfLikesCountStr == null || pfCommentText == null) {
            return new ResponseEntity<>("请求中缺少字段", HttpStatus.BAD_REQUEST);
        }*/

        int pfLikesCount;
        try {
            pfLikesCount = Integer.parseInt(pfLikesCountStr);
        } catch (NumberFormatException e) {
            return new ResponseEntity<>("pfLikesCount格式无效", HttpStatus.BAD_REQUEST);
        }

        Date pfTime;
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            pfTime = dateFormat.parse(pfTimeStr);
        } catch (ParseException e) {
            return new ResponseEntity<>("pfTime格式无效", HttpStatus.BAD_REQUEST);
        }

        patientfeedback patientFeedback = new patientfeedback();
        patientFeedback.setDID(dID);
        patientFeedback.setPIDCard(pIDCard);
        patientFeedback.setPfTime(pfTime);
        patientFeedback.setPatientFeedbackComment(patientFeedbackComment);
        patientFeedback.setPfLikesCount(pfLikesCount);
        patientFeedback.setPfComentText(pfCommentText);

        patientFeedbackService.addPatientFeedback(patientFeedback);

        return new ResponseEntity<>("病人反馈成功添加", HttpStatus.CREATED);
    }


    @GetMapping("/{patientFeedbackId}")
    public ResponseEntity<patientfeedback> getPatientFeedbackById(@PathVariable int patientFeedbackId) {
        patientfeedback patientFeedback = patientFeedbackService.getPatientFeedbackById(patientFeedbackId);

        if (patientFeedback == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(patientFeedback, HttpStatus.OK);
    }
}
