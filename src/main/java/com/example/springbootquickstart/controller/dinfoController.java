//dinfoController.java

package com.example.springbootquickstart.controller;

import com.example.springbootquickstart.pojo.dinfo;
import com.example.springbootquickstart.pojo.pinfo;
import com.example.springbootquickstart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/dinfo")
@CrossOrigin
public class dinfoController {


    // 根据职位找dinfo
    @GetMapping("/getDinfoByJob/{dJob}")
    public List<dinfo> getDinfoByJob(@PathVariable String dJob) {
        return userService.getDinfoByJob(dJob);
    }

    //分页显示
   /* @GetMapping("/getdinfoByPage")
    public List<dinfo> getDinfoByPage(@RequestParam("page") int page, @RequestParam("size") int size) {
        return userService.getDinfoByPage(page, size);
    }*/
    @GetMapping("/getDinfoByPage")
    public List<dinfo> getDinfoByPage(@RequestParam("page") int page,
                                      @RequestParam("size") int size,
                                      @RequestParam(required = false) String dName,
                                      @RequestParam(required = false) String dJob) {
        return userService.getDinfoByPage(page, size, dName, dJob);
    }

    @Autowired
    private UserService userService;

    // dinfo getter
    @GetMapping("/getDinfoById/{dId}")
    public ResponseEntity<dinfo> getDinfoById(@PathVariable String dId) {
        dinfo doctor = userService.findDinfoById(dId);
        if (doctor != null) {
            return new ResponseEntity<>(doctor, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/name/{dId}")
    public ResponseEntity<String> getDNameBydId(@PathVariable String dId) {
        try {
            String dName = userService.findDNameBydId(dId);
            return ResponseEntity.ok(dName);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(null);
        }
    }

    @GetMapping("/gender/{dId}")
    public ResponseEntity<String> getDGenderBydId(@PathVariable String dId) {
        try {
            String dGender = userService.findDGenderBydId(dId);
            return ResponseEntity.ok(dGender);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(null);
        }
    }

    @GetMapping("/hospital/{dId}")
    public ResponseEntity<String> getDHospitalBydId(@PathVariable String dId) {
        try {
            String dHospital = userService.findDHospitalBydId(dId);
            return ResponseEntity.ok(dHospital);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(null);
        }
    }

    @GetMapping("/worktime/{dId}")
    public ResponseEntity<Date> getDWorkTimeBydId(@PathVariable String dId) {
        try {
            Date dWorkTime = userService.findDWorkTimeBydId(dId);
            return ResponseEntity.ok(dWorkTime);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(null);
        }
    }

    @GetMapping("/job/{dId}")
    public ResponseEntity<String> getDJobBydId(@PathVariable String dId) {
        try {
            String dJob = userService.findDJobBydId(dId);
            return ResponseEntity.ok(dJob);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(null);
        }
    }

    @GetMapping("/strength/{dId}")
    public ResponseEntity<String> getDStrengthBydId(@PathVariable String dId) {
        try {
            String dStrength = userService.findDStrengthBydId(dId);
            return ResponseEntity.ok(dStrength);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(null);
        }
    }

    @GetMapping("/introduction/{dId}")
    public ResponseEntity<String> getDIntroductionBydId(@PathVariable String dId) {
        try {
            String dIntroduction = userService.findDIntroductionBydId(dId);
            return ResponseEntity.ok(dIntroduction);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(null);
        }
    }

    @GetMapping("/picture/{dId}")
    public ResponseEntity<byte[]> getDPictureBydId(@PathVariable String dId) {
        try {
            byte[] dPicture = userService.findDPictureBydId(dId);
            if (dPicture != null) {
                return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(dPicture);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(null);
        }
    }

    @GetMapping("/passwordHash/{dId}")
    public ResponseEntity<String> getDPasswordHashBydId(@PathVariable String dId) {
        try {
            String dPasswordHash = userService.findDPasswordHashBydId(dId);
            return ResponseEntity.ok(dPasswordHash);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(null);
        }
    }





    // dinfo setter
    @PostMapping("/")
    public ResponseEntity<Void> createDinfo(@RequestBody Map<String, String> dIdMap) {
        String dId = dIdMap.get("dId");
        if (dId == null || dId.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        dinfo newDoctorInfo = new dinfo();
        newDoctorInfo.setDId(dId);
        userService.setDinfo(newDoctorInfo);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @PutMapping("/name/{dId}")
    public ResponseEntity<?> updateDName(@PathVariable String dId, @RequestBody String newName) {       //请求体不需要大括号，只需要一个值
        try {
            userService.updateDNameBydId(dId, newName);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PutMapping("/gender/{dId}")
    public ResponseEntity<?> updateDGender(@PathVariable String dId, @RequestBody String newGender) {
        try {
            userService.updateDGenderBydId(dId, newGender);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PutMapping("/hospital/{dId}")
    public ResponseEntity<?> updateDHospital(@PathVariable String dId, @RequestBody String newHospital) {
        try {
            userService.updateDHospitalBydId(dId, newHospital);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PutMapping("/worktime/{dId}")
    public ResponseEntity<?> updateDWorkTime(@PathVariable String dId, @RequestBody Date newWorkTime) {
        try {
            userService.updateDWorkTimeBydId(dId, newWorkTime);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PutMapping("/job/{dId}")
    public ResponseEntity<?> updateDJob(@PathVariable String dId, @RequestBody String newJob) {
        try {
            userService.updateDJobBydId(dId, newJob);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PutMapping("/strength/{dId}")
    public ResponseEntity<?> updateDStrength(@PathVariable String dId, @RequestBody String newStrength) {
        try {
            userService.updateDStrengthBydId(dId, newStrength);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PutMapping("/introduction/{dId}")
    public ResponseEntity<?> updateDIntroduction(@PathVariable String dId, @RequestBody String newIntroduction) {
        try {
            userService.updateDIntroductionBydId(dId, newIntroduction);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PutMapping("/updatePicture/{dId}")
    public ResponseEntity<String> updateDPictureBydId(@PathVariable String dId, @RequestParam("picture") MultipartFile picture) {
        try {
            byte[] pictureBytes = picture.getBytes();
            int updateCount = userService.updateDPictureBydId(dId, pictureBytes);
            if (updateCount > 0) {
                return ResponseEntity.ok("Picture updated successfully");
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Error updating picture", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/passwordHash/{dId}")
    public ResponseEntity<?> updateDPasswordHash(@PathVariable String dId, @RequestBody String newPasswordHash) {
        try {
            userService.updateDPasswordHashBydId(dId, newPasswordHash);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

}