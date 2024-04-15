package com.example.springbootquickstart.controller;

import com.example.springbootquickstart.mapper.UserMapper;
import com.example.springbootquickstart.pojo.predictfeedback;
import com.example.springbootquickstart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/predictFeedbacks")
@CrossOrigin
public class PredictFeedbackController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @PostMapping("/add")
    public ResponseEntity<?> addPredictFeedback(@RequestBody Map<String, String> requestMap) {
        // 从requestMap提取信息
        String predictFeedbackIdStr = requestMap.get("PredictFeedbackId");
        String imageTypeIdStr = requestMap.get("ImageTypeId");
        String stageIdStr = requestMap.get("StageId");
        String modelName = requestMap.get("ModelName");
        String predictFeedbackComment = requestMap.get("PredictFeedbackComment");
        String drIdStr = requestMap.get("drId");
        String modelResultStr = requestMap.get("ModelResult");

        // 基本验证
        if (predictFeedbackIdStr == null || imageTypeIdStr == null || stageIdStr == null || modelName == null || drIdStr == null || modelResultStr == null) {
            return new ResponseEntity<>("Missing fields in request", HttpStatus.BAD_REQUEST);
        }

        // 将字符串转换为整数
        int predictFeedbackId, imageTypeId, stageId, drId;
        boolean modelResult;
        try {
            predictFeedbackId = Integer.parseInt(predictFeedbackIdStr);
            imageTypeId = Integer.parseInt(imageTypeIdStr);
            stageId = Integer.parseInt(stageIdStr);
            drId = Integer.parseInt(drIdStr);
            modelResult = Integer.parseInt(modelResultStr) != 0; // 假设非0为true
        } catch (NumberFormatException e) {
            return new ResponseEntity<>("Invalid format for IDs or ModelResult", HttpStatus.BAD_REQUEST);
        }

        // 创建新的predictfeedback对象
        predictfeedback feedback = new predictfeedback();
        feedback.setPredictFeedbackId(predictFeedbackId);
        feedback.setImageTypeId(imageTypeId);
        feedback.setStageId(stageId);
        feedback.setModelName(modelName);
        feedback.setPredictFeedbackComment(predictFeedbackComment);
        feedback.setDrId(drId);
        feedback.setModelResult(modelResult);

        // 将新的predictfeedback添加到数据库
        userService.addPredictFeedback(feedback);

        return new ResponseEntity<>("Predict feedback added successfully", HttpStatus.CREATED);
    }

    @PostMapping("/generalComment/{PredictFeedbackId}/{generalComment}")
    public ResponseEntity<?> addGeneralComment(@PathVariable int PredictFeedbackId, @PathVariable int generalComment)
    {
        userService.updateGeneralComment(generalComment, PredictFeedbackId);
        return new ResponseEntity<>("GeneralComment updated successfully", HttpStatus.OK);
    }

    @PostMapping("/comment/{PredictFeedbackId}/{PredictFeedbackComment}")
    public ResponseEntity<?> addComment(@PathVariable int PredictFeedbackId, @PathVariable String PredictFeedbackComment)
    {
        userMapper.updateComment(PredictFeedbackComment, PredictFeedbackId);
        return new ResponseEntity<>("PredictFeedbackComment updated successfully", HttpStatus.OK);
    }


    @GetMapping("/{predictFeedbackIdStr}")
    public ResponseEntity<predictfeedback> getPredictFeedbackById(@PathVariable String predictFeedbackIdStr) {
        int predictFeedbackId;
        try {
            predictFeedbackId = Integer.parseInt(predictFeedbackIdStr);
        } catch (NumberFormatException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        predictfeedback feedback = userService.getPredictFeedbackById(predictFeedbackId);

        if (feedback == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(feedback, HttpStatus.OK);
    }


    @GetMapping("/getPredictFeedbackByDrId/{drId}")
    public ResponseEntity<predictfeedback> getPredictFeedbackByDrId(@PathVariable String drId) {
        int drID;
        try {
            drID = Integer.parseInt(drId);
        } catch (NumberFormatException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        predictfeedback feedback = userService.getPredictFeedbackByDrId(drID);

        if (feedback == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(feedback, HttpStatus.OK);
    }

}
