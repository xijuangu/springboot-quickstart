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
        String dId = requestMap.get("dId");
        String imageTypeIdStr = requestMap.get("ImageTypeId");
        String stageIdStr = requestMap.get("StageId");
        String image = requestMap.get("Image");

        // Basic validation
        if (dId == null || dId.isEmpty() || imageTypeIdStr == null || stageIdStr == null || image == null) {
            return new ResponseEntity<>("Missing fields in request", HttpStatus.BAD_REQUEST);
        }

        // Converting String to Integer
        int imageTypeId, stageId;
        try {
            imageTypeId = Integer.parseInt(imageTypeIdStr);
            stageId = Integer.parseInt(stageIdStr);
        } catch (NumberFormatException e) {
            return new ResponseEntity<>("Invalid format for ImageTypeId or StageId", HttpStatus.BAD_REQUEST);
        }

        // Creating a new diagnosisrequest object
        diagnosisrequest newRequest = new diagnosisrequest();
        newRequest.setDId(dId);
        newRequest.setImageTypeId(imageTypeId);
        newRequest.setStageId(stageId);
        newRequest.setImage(image);

        // Adding the new diagnosisrequest to the database
        userService.addDiagnosisRequest(newRequest);

        return new ResponseEntity<>("Diagnosis request added successfully", HttpStatus.CREATED);
    }
}
