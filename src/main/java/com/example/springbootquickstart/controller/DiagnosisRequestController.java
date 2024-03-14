package com.example.springbootquickstart.controller;

import com.example.springbootquickstart.pojo.diagnosisrequest;
import com.example.springbootquickstart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/diagnosisRequests")
@CrossOrigin
public class DiagnosisRequestController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public ResponseEntity<?> addDiagnosisRequest(@RequestBody Map<String, String> requestMap) {
        // Extracting information from requestMap
        String drIdStr = requestMap.get("drId"); // 获取drId
        String dId = requestMap.get("dId");
        String imageTypeIdStr = requestMap.get("ImageTypeId");
        String stageIdStr = requestMap.get("StageId");
        String image = requestMap.get("Image");

        // Basic validation
        if (drIdStr == null || drIdStr.isEmpty() || dId == null || dId.isEmpty() || imageTypeIdStr == null || stageIdStr == null || image == null) {
            return new ResponseEntity<>("Missing fields in request", HttpStatus.BAD_REQUEST);
        }

        System.out.println("Before conversion - drIdStr: " + drIdStr + ", ImageTypeIdStr: " + imageTypeIdStr + ", StageIdStr: " + stageIdStr);

        // Converting String to Integer
        int drId, imageTypeId, stageId;
        try {
            drId = Integer.parseInt(drIdStr); // 转换drId
            imageTypeId = Integer.parseInt(imageTypeIdStr);
            stageId = Integer.parseInt(stageIdStr);
        } catch (NumberFormatException e) {
            return new ResponseEntity<>("Invalid format for drId, ImageTypeId or StageId", HttpStatus.BAD_REQUEST);
        }

        System.out.println("After conversion - drId: " + drId + ", ImageTypeId: " + imageTypeId + ", StageId: " + stageId);

        // Creating a new diagnosisrequest object
        diagnosisrequest newRequest = new diagnosisrequest();
        newRequest.setDrId(drId); // 设置drId
        newRequest.setDId(dId);
        newRequest.setImageTypeId(imageTypeId);
        newRequest.setStageId(stageId);
        newRequest.setImage(image);

        // Adding the new diagnosisrequest to the database
        userService.addDiagnosisRequest(newRequest);

        return new ResponseEntity<>("Diagnosis request added successfully", HttpStatus.CREATED);
    }


    @GetMapping("/{drIdStr}")
    public ResponseEntity<diagnosisrequest> getDiagnosisRequestById(@PathVariable String drIdStr) {
        // 尝试将drId字符串转换为int
        int drId;
        try {
            drId = Integer.parseInt(drIdStr);
        } catch (NumberFormatException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        // 使用服务层方法根据drId获取diagnosisrequest对象
        diagnosisrequest request = userService.getDiagnosisRequestById(drId);

        // 检查是否找到记录
        if (request == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        // 返回找到的diagnosisrequest记录
        return new ResponseEntity<>(request, HttpStatus.OK);
    }


}
