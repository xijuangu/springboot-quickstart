package com.example.springbootquickstart.controller;

import com.example.springbootquickstart.pojo.model;
import com.example.springbootquickstart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/models")
@CrossOrigin
public class ModelController {

    @GetMapping("/getModelByPage")
    public List<model> getModelByPage(@RequestParam("page") int page,
                                      @RequestParam("size") int size,
                                      @RequestParam(required = false) Integer stageId,
                                      @RequestParam(required = false) Integer imageTypeId) {
        return userService.getModelByPage(page, size, stageId, imageTypeId);
    }

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public ResponseEntity<?> addmodel(@RequestBody Map<String, String> requestMap) {
        String modelName = requestMap.get("ModelName");
        String stageIdStr = requestMap.get("StageId");
        String imageTypeIdStr = requestMap.get("ImageTypeId");
        String apiPath = requestMap.get("api_path");

        if (modelName == null || stageIdStr == null || imageTypeIdStr == null || apiPath == null) {
            return new ResponseEntity<>("Missing fields in request", HttpStatus.BAD_REQUEST);
        }

        int stageId, imageTypeId;
        try {
            stageId = Integer.parseInt(stageIdStr);
            imageTypeId = Integer.parseInt(imageTypeIdStr);
        } catch (NumberFormatException e) {
            return new ResponseEntity<>("Invalid format for StageId or ImageTypeId", HttpStatus.BAD_REQUEST);
        }

        model model = new model();
        model.setModelName(modelName);
        model.setStageId(stageId);
        model.setImageTypeId(imageTypeId);
        model.setApiPath(apiPath);

        userService.addModel(model);

        return new ResponseEntity<>("model added successfully", HttpStatus.CREATED);
    }


    @GetMapping("/{modelName}")
    public ResponseEntity<model> getmodelByName(@PathVariable String modelName) {
        model model = userService.getModelByName(modelName);

        if (model == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(model, HttpStatus.OK);
    }
}
