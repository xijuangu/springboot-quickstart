package com.example.springbootquickstart.controller;

import com.example.springbootquickstart.pojo.SendPicture;
import com.example.springbootquickstart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sendPictures")
public class spController {

    @Autowired
    private UserService userService;

    // 通过ID找图片发送记录
    @GetMapping("/getSPByPid/{Pid}")
    public List<SendPicture> getSPByPid(@PathVariable String Pid) {
        return userService.findSPByPid(Pid);
    }

    @GetMapping("/getSPByDid/{Did}")
    public List<SendPicture> getSPByDid(@PathVariable String Did) {
        return userService.findSPByDid(Did);
    }

    // 添加图片发送记录
    @PostMapping("/add")
    public ResponseEntity<?> addSendPicture(@RequestBody SendPicture record) {
        userService.addSendPicture(record);
        return new ResponseEntity<>("图片发送记录已添加", HttpStatus.CREATED);
    }

    // 根据ID获取图片发送记录
    @GetMapping("/{sp_id}")
    public ResponseEntity<SendPicture> getSendPictureById(@PathVariable int sp_id) {
        SendPicture record = userService.getSendPictureById(sp_id);
        return new ResponseEntity<>(record, HttpStatus.OK);
    }

    // 获取所有图片发送记录
    @GetMapping("/all")
    public ResponseEntity<List<SendPicture>> getAllSendPictures() {
        List<SendPicture> records = userService.getAllSendPictures();
        return new ResponseEntity<>(records, HttpStatus.OK);
    }

    // 更新图片发送记录
    @PutMapping("/update")
    public ResponseEntity<?> updateSendPicture(@RequestBody SendPicture record) {
        userService.updateSendPicture(record);
        return new ResponseEntity<>("图片发送记录已更新", HttpStatus.OK);
    }

    // 删除图片发送记录
    @DeleteMapping("/delete/{sp_id}")
    public ResponseEntity<?> deleteSendPicture(@PathVariable int sp_id) {
        userService.deleteSendPicture(sp_id);
        return new ResponseEntity<>("图片发送记录已删除", HttpStatus.OK);
    }
}
