package com.example.springbootquickstart.controller;

import com.example.springbootquickstart.pojo.communicationrecord;
import com.example.springbootquickstart.pojo.dinfo;
import com.example.springbootquickstart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/communicationRecords")
@CrossOrigin
public class crController {



    // 通过ID找聊天记录
    @GetMapping("/getCRByPid/{Pid}")
    public List<communicationrecord> getCRByPid(@PathVariable String Pid) {
        return userService.findCRByPid(Pid);
    }

    @GetMapping("/getCRByDid/{Did}")
    public List<communicationrecord> getCRByDid(@PathVariable String Did) {
        return userService.findCRByDid(Did);
    }




    @Autowired
    private UserService userService;

    // 添加通讯记录
    @PostMapping("/add")
    public ResponseEntity<?> addCommunicationRecord(@RequestBody communicationrecord record) {
        userService.addCommunicationRecord(record);
        return new ResponseEntity<>("通讯记录已添加", HttpStatus.CREATED);
    }

    // 根据ID获取通讯记录
    @GetMapping("/{crId}")
    public ResponseEntity<communicationrecord> getCommunicationRecordById(@PathVariable int crId) {
        communicationrecord record = userService.getCommunicationRecordById(crId);
        return new ResponseEntity<>(record, HttpStatus.OK);
    }

    // 获取所有通讯记录
    @GetMapping("/all")
    public ResponseEntity<List<communicationrecord>> getAllCommunicationRecords() {
        List<communicationrecord> records = userService.getAllCommunicationRecords();
        return new ResponseEntity<>(records, HttpStatus.OK);
    }

    // 更新通讯记录
    @PutMapping("/update")
    public ResponseEntity<?> updateCommunicationRecord(@RequestBody communicationrecord record) {
        userService.updateCommunicationRecord(record);
        return new ResponseEntity<>("通讯记录已更新", HttpStatus.OK);
    }

    // 删除通讯记录
    @DeleteMapping("/delete/{crId}")
    public ResponseEntity<?> deleteCommunicationRecord(@PathVariable int crId) {
        userService.deleteCommunicationRecord(crId);
        return new ResponseEntity<>("通讯记录已删除", HttpStatus.OK);
    }
}
