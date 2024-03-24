package com.example.springbootquickstart.controller;

import com.example.springbootquickstart.pojo.stage;
import com.example.springbootquickstart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/stages")
@CrossOrigin
public class StageController {

    @GetMapping("/getStageByPage")
    public List<stage> getStageByPage(@RequestParam("page") int page,
                                      @RequestParam("size") int size,
                                      @RequestParam(required = false) String stageName) {
        return userService.getStageByPage(page, size, stageName);
    }

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public ResponseEntity<?> addStage(@RequestBody Map<String, String> stageMap) {
        // 尝试从Map中获取StageId和StageName
        String stageIdStr = stageMap.get("StageId");
        String stageName = stageMap.get("StageName");

        // 验证获取到的值是否有效
        if (stageIdStr == null || stageIdStr.isEmpty() || stageName == null || stageName.isEmpty()) {
            return new ResponseEntity<>("Missing or invalid fields in request", HttpStatus.BAD_REQUEST);
        }

        // 尝试将StageId字符串转换为int
        int stageId;
        try {
            stageId = Integer.parseInt(stageIdStr);
        } catch (NumberFormatException e) {
            return new ResponseEntity<>("Invalid format for StageId", HttpStatus.BAD_REQUEST);
        }

        // 创建新的stage对象并设置属性
        stage newStage = new stage();
        newStage.setStageId(stageId);
        newStage.setStageName(stageName);

        // 调用服务层添加stage到数据库
        userService.addStage(newStage);

        // 返回响应实体
        return new ResponseEntity<>("Stage added successfully", HttpStatus.CREATED);
    }

    @GetMapping("/{stageId}")
    public ResponseEntity<?> getStageById(@PathVariable("stageId") String stageIdStr) {
        int stageId;
        try {
            stageId = Integer.parseInt(stageIdStr);
        } catch (NumberFormatException e) {
            return new ResponseEntity<>("Invalid format for StageId", HttpStatus.BAD_REQUEST);
        }

        stage foundStage = userService.getStageById(stageId);
        if (foundStage == null) {
            return new ResponseEntity<>("Stage not found", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(foundStage, HttpStatus.OK);
    }
}
