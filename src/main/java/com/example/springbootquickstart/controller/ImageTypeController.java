package com.example.springbootquickstart.controller;

import com.example.springbootquickstart.pojo.imagetype;
import com.example.springbootquickstart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/imageTypes")
@CrossOrigin
public class ImageTypeController {


    @GetMapping("/getImageTypeByPage")
    public List<imagetype> getImageTypeByPage(@RequestParam("page") int page,
                                              @RequestParam("size") int size,
                                              @RequestParam(required = false) String typeName) {
        return userService.getImageTypeByPage(page, size, typeName);
    }


    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public ResponseEntity<Void> createImageType(@RequestBody Map<String, String> imageTypeMap) {
        // 尝试从Map中获取ImageTypeId和ImageTypeName
        String imageTypeIdStr = imageTypeMap.get("ImageTypeId");
        String imageTypeName = imageTypeMap.get("ImageTypeName");

        // 验证获取到的值是否有效
        if (imageTypeIdStr == null || imageTypeIdStr.isEmpty() || imageTypeName == null || imageTypeName.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        // 尝试将ImageTypeId字符串转换为int
        int imageTypeId;
        try {
            imageTypeId = Integer.parseInt(imageTypeIdStr);
        } catch (NumberFormatException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        // 创建新的imagetype对象并设置属性
        imagetype newImageType = new imagetype();
        newImageType.setImageTypeId(imageTypeId);
        newImageType.setImageTypeName(imageTypeName);

        // 调用服务层添加imagetype到数据库
        userService.addImageType(newImageType);

        // 返回响应实体
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{imageTypeId}")
    public ResponseEntity<?> getImageTypeById(@PathVariable("imageTypeId") String imageTypeIdStr) {
        int imageTypeId;
        try {
            imageTypeId = Integer.parseInt(imageTypeIdStr);
        } catch (NumberFormatException e) {
            return new ResponseEntity<>("Invalid format for ImageTypeId", HttpStatus.BAD_REQUEST);
        }

        imagetype foundImageType = userService.getImageTypeById(imageTypeId);
        if (foundImageType == null) {
            return new ResponseEntity<>("ImageType not found", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(foundImageType, HttpStatus.OK);
    }
}
