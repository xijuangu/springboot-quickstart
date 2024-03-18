package com.example.springbootquickstart.controller;

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

    @GetMapping("/{predictFeedbackIdStr}")
    public ResponseEntity<predictfeedback> getPredictFeedbackById(@PathVariable String predictFeedbackIdStr) {
        // 尝试将predictFeedbackId字符串转换为int
        int predictFeedbackId;
        try {
            predictFeedbackId = Integer.parseInt(predictFeedbackIdStr);
        } catch (NumberFormatException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        // 使用服务层方法根据PredictFeedbackId获取predictfeedback对象
        predictfeedback feedback = userService.getPredictFeedbackById(predictFeedbackId);

        // 检查是否找到记录
        if (feedback == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        // 返回找到的predictfeedback记录
        return new ResponseEntity<>(feedback, HttpStatus.OK);
    }

}
