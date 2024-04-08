package com.example.springbootquickstart.controller;

import com.example.springbootquickstart.pojo.diagnosisrequest;
import com.example.springbootquickstart.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/diagnosisRequests")
@CrossOrigin
public class DiagnosisRequestController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public ResponseEntity<?> addDiagnosisRequest(@RequestBody Map<String, Object> requestMap) {
        // 从请求映射中提取字段
        String dId = (String) requestMap.get("dId");
        //  String imageTypeIdStr = (String) requestMap.get("ImageTypeId");
        String ModelName = (String) requestMap.get("ModelName");
        //  int operationFlag = (int) requestMap.get("operationFlag");
        // 此处处理Image字段时，需要正确处理它是一个Map的情况
        Object imageObject = requestMap.get("Image");
        String pIDCard = (String) requestMap.get("pIDCard");

        // 基本验证省略

        // 转换ImageTypeId为整数
//        int imageTypeId;
//        try {
//            imageTypeId = Integer.parseInt(imageTypeIdStr);
//        } catch (NumberFormatException e) {
//            return new ResponseEntity<>("Invalid format for ImageTypeId", HttpStatus.BAD_REQUEST);
//        }

        // 将Image对象转换为JSON字符串
        ObjectMapper objectMapper = new ObjectMapper();
        String imageJson = null;
        try {
            imageJson = objectMapper.writeValueAsString(imageObject);
        } catch (JsonProcessingException e) {
            return new ResponseEntity<>("Error processing image JSON", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        // 创建新的diagnosisrequest对象并设置字段
        diagnosisrequest newRequest = new diagnosisrequest();
        newRequest.setDId(dId);
        newRequest.setModelName(ModelName);
        //  newRequest.setoperationFlag(operationFlag);
        newRequest.setImage(imageJson); // 使用转换后的JSON字符串设置Image字段
        newRequest.setPIDCard(pIDCard);

        // 添加到数据库的逻辑不变
        userService.addDiagnosisRequest(newRequest);

        return new ResponseEntity<>("Diagnosis request added successfully", HttpStatus.CREATED);
    }

    @GetMapping("/{drIdStr}")
    public ResponseEntity<diagnosisrequest> getDiagnosisRequestById(@PathVariable String drIdStr) {
        int drId;
        try {
            drId = Integer.parseInt(drIdStr);
        } catch (NumberFormatException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        diagnosisrequest request = userService.getDiagnosisRequestById(drId);
        if (request == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(request, HttpStatus.OK);
    }

    @GetMapping("/getByPIDCard/{pIDCard}")
    public ResponseEntity<List<diagnosisrequest>> getDiagnosisRequestsByPIDCard(@PathVariable String pIDCard) {
        List<diagnosisrequest> requests = userService.getDiagnosisRequestsByPIDCard(pIDCard);
        if (requests.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(requests, HttpStatus.OK);
    }

    @GetMapping("/imagesByPIDCard/{pIDCard}")
    public ResponseEntity<List<Map<String, Object>>> getImagesByPIDCard(@PathVariable String pIDCard) {
        List<Map<String, Object>> images = userService.getImagesByPIDCard(pIDCard);
        if (images.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(images, HttpStatus.OK);
    }
}
