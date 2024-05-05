package com.example.springbootquickstart.controller;

import com.example.springbootquickstart.pojo.diagnosisrequest;
import com.example.springbootquickstart.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
        // 从请求映射中提取字段并进行基本验证
        String dId = (String) requestMap.get("dId");
        String modelName = (String) requestMap.get("ModelName");
        Object imageObject = requestMap.get("Image");
        String pIDCard = (String) requestMap.get("pIDCard");
        String time = (String) requestMap.get("requestTime");

        // 检查关键字段是否为空
        if (dId == null || modelName == null || pIDCard == null || time == null) {
            return new ResponseEntity<>("Missing required fields", HttpStatus.BAD_REQUEST);
        }

        // 定义日期格式
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date requestTime;

        try {
            // 尝试解析日期字符串
            requestTime = formatter.parse(time);
        } catch (ParseException e) {
            // 日期字符串格式错误，返回详细的错误信息
            return new ResponseEntity<>("Invalid date format for requestTime, expected format: yyyy-MM-dd HH:mm:ss", HttpStatus.BAD_REQUEST);
        }

        // 将 Image 对象转换为 JSON 字符串
        ObjectMapper objectMapper = new ObjectMapper();
        String imageJson;
        try {
            imageJson = objectMapper.writeValueAsString(imageObject);
        } catch (JsonProcessingException e) {
            // JSON 处理出错，返回错误信息
            return new ResponseEntity<>("Error processing image JSON", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        // 创建新的 diagnosisrequest 对象并设置字段
        diagnosisrequest newRequest = new diagnosisrequest();
        newRequest.setDId(dId);
        newRequest.setModelName(modelName);
        newRequest.setImage(imageJson);
        newRequest.setPIDCard(pIDCard);
        newRequest.setRequestTime(requestTime);

        // 将新记录添加到数据库
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
