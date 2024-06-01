//pinfoController.java

package com.example.springbootquickstart.controller;

import com.example.springbootquickstart.mapper.UserMapper;
import com.example.springbootquickstart.pojo.pinfo;
import com.example.springbootquickstart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@CrossOrigin
@RequestMapping("/pinfo")
@RestController
public class pinfoController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/getCountByPatientAge/{low}/{high}")
    public long getCountByPatientAge(@PathVariable int low, @PathVariable int high){
        return userMapper.countPatientByAge(low, high);
    }

    // 根据名字找pinfo
    @GetMapping("/getpinfoByName/{pName}")
    public List<pinfo> getPinfoByName(@PathVariable String pName) {
        return userService.getPinfoByName(pName);
    }

    @GetMapping("/getpinfoBySymptom")
    public List<pinfo> getPinfoByNameAndSymptom(@RequestParam(value = "page", defaultValue = "0") int offset,
                                                @RequestParam(value = "size", defaultValue = "10") int limit,
                                                @RequestParam(value = "pName", required = false) String pName,
                                                @RequestParam(value = "pSymptom", required = false) String pSymptom) {
        // Log input parameters for debugging
        // System.out.println("Parameters - page: " + offset + ", size: " + limit + ", pName: " + pName + ", pSymptom: " + pSymptom);

        // Handle null or empty string cases
        if (pName == null || pName.isEmpty() || pName.equals("undefined")) {
            pName = "";
        }
        if (pSymptom == null || pSymptom.isEmpty() || pSymptom.equals("undefined")) {
            pSymptom = "";
        }


        List<pinfo> result = userService.getPinfoBySymptom(pName, pSymptom, offset, limit);

        // Log the result for debugging
        // System.out.println("Result size: " + result.size());

        return result;
    }



    // 分页查询pinfo
    @GetMapping("/getpinfoByPage")
    public List<pinfo> getPinfoByPage(@RequestParam("page") int page, @RequestParam("size") int size) {
        return userService.getPinfoByPage(page, size);
    }

    //pinfo getter

    @Autowired
    private UserService userService;

    @GetMapping("/pName/{pIDCard}")
    public String getpNameBypIdCard(@PathVariable String pIDCard) {
        return userService.FindpNameBypIdCard(pIDCard);
    }

    @GetMapping("/history/{pIDCard}")
    public Boolean getHistoryBypIdCard(@PathVariable String pIDCard) {return userService.FindHistoryBypIdCard(pIDCard);}

    @GetMapping("/pAddress/{pIDCard}")
    public String getAddressBypIdCard(@PathVariable String pIDCard) {
        return userService.FindAddressById(pIDCard);
    }

    @GetMapping("/other/{pIDCard}")
    public Boolean getOtherBypIdCard(@PathVariable String pIDCard) {
        return userService.FindOtherBypIdCard(pIDCard);
    }

    @GetMapping("/pAge/{pIDCard}")
    public Integer getpAgeBypIdCard(@PathVariable String pIDCard) {
        return userService.FindAgeByIdCard(pIDCard);
    }


    @GetMapping("/family/{pIDCard}")
    public Boolean getFamilyBypIdCard(@PathVariable String pIDCard) {
        return userService.FindFamilyBypIdCard(pIDCard);
    }

    @GetMapping("/otherInfo/{pIDCard}")
    public String getOtherInfoBypIdCard(@PathVariable String pIDCard) {
        return userService.FindOtherInfoBypIdCard(pIDCard);
    }

    @GetMapping("/familyInfo/{pIDCard}")
    public String getFamilyInfoBypIdCard(@PathVariable String pIDCard) {
        return userService.FindFamilyInfoBypIdCard(pIDCard);
    }

    @GetMapping("/symptom/{pIDCard}")
    public String getSymptomBypIdCard(@PathVariable String pIDCard) {
        return userService.FindSymptomBypIdCard(pIDCard);
    }

    @GetMapping("/picture/{pIDCard}")
    public byte[] getPictureBypIdCard(@PathVariable String pIDCard) {
        return userService.FindPictureBypIdCard(pIDCard);
    }

    @GetMapping("/passwordHash/{pIDCard}")
    public String getPasswordHashBypIdCard(@PathVariable String pIDCard) {
        return userService.FindPasswordHashBypIdCard(pIDCard);
    }

    @GetMapping("/getPatientinfo/{pIDCard}")
    public pinfo getPatientinfo(@PathVariable String pIDCard) {
        pinfo updatedPatient = userService.findPatientByIdCard(pIDCard);
        return updatedPatient;
    }



    //pinfo setter

    @PostMapping("/addOrUpdatePinfo")
    public ResponseEntity<?> addOrUpdatePinfo(@RequestBody pinfo patientInfo) {
        try {
            int result = userService.saveOrUpdatePinfo(patientInfo);
            if (result == 0) {
                return new ResponseEntity<>("No changes made to the database.", HttpStatus.OK);
            }
            return new ResponseEntity<>("Patient information saved/updated successfully.", HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error saving/updating patient information: " + e.getMessage());
        }
    }
    @PutMapping("/setpIDCard/{pIDCard}")
    public pinfo setpIDCard(@PathVariable String pIDCard) {
        pinfo patient = new pinfo();
        patient.setpIDCard(pIDCard);
        userService.setpIDCard(patient);
        return userService.findPatientByIdCard(pIDCard);
    }

    @PutMapping("/updatepNameBypIDCard/{pIDCard}/{pName}")
    public pinfo updatepNameBypIDCard(@PathVariable String pIDCard, @PathVariable String pName) {
        pinfo patient = new pinfo();
        patient.setpIDCard(pIDCard);
        patient.setpName(pName);
        userService.updatepName(patient);
        return userService.findPatientByIdCard(pIDCard);
    }

    @PutMapping("/updatepAddressBypIDCard/{pIDCard}/{pAddress}")
    public pinfo updatepAddressBypIDCard(@PathVariable String pIDCard, @PathVariable String pAddress) {
        pinfo patient = new pinfo();
        patient.setpIDCard(pIDCard);
        patient.setpAddress(pAddress);
        userService.updatepAddress(patient);
        return userService.findPatientByIdCard(pIDCard);
    }


    @PutMapping("/updatepGenderBypIDCard/{pIDCard}/{pGender}")
    public pinfo updatepGenderBypIDCard(@PathVariable String pIDCard, @PathVariable String pGender) {
        pinfo patient = new pinfo();
        patient.setpIDCard(pIDCard);
        patient.setpGender(pGender);
        userService.updatepGender(patient);
        return userService.findPatientByIdCard(pIDCard);
    }

    @PutMapping("/updatepPhoneBypIDCard/{pIDCard}/{pPhone}")
    public pinfo updatepPhoneBypIDCard(@PathVariable String pIDCard, @PathVariable String pPhone) {
        pinfo patient = new pinfo();
        patient.setpIDCard(pIDCard);
        patient.setpPhone(pPhone);
        userService.updatepPhone(patient);
        return userService.findPatientByIdCard(pIDCard);
    }

    @PutMapping("/updatepHistoryBypIDCard/{pIDCard}/{history}")
    public pinfo updatepHistoryBypIDCard(@PathVariable String pIDCard, @PathVariable Integer history) {
        pinfo patient = new pinfo();
        patient.setpIDCard(pIDCard);
        patient.setpHistory(history);
        userService.updatepHistory(patient);
        return userService.findPatientByIdCard(pIDCard);
    }

    @PutMapping("/updatepOtherBypIDCard/{pIDCard}/{other}")
    public pinfo updatepOtherBypIDCard(@PathVariable String pIDCard, @PathVariable Integer other) {
        pinfo patient = new pinfo();
        patient.setpIDCard(pIDCard);
        patient.setpOther(other);
        userService.updatepOther(patient);
        return userService.findPatientByIdCard(pIDCard);
    }

    @PutMapping("/updatepFamilyBypIDCard/{pIDCard}/{family}")
    public pinfo updatepFamilyBypIDCard(@PathVariable String pIDCard, @PathVariable Integer family) {
        pinfo patient = new pinfo();
        patient.setpIDCard(pIDCard);
        patient.setpFamily(family);
        userService.updatepFamily(patient);
        return userService.findPatientByIdCard(pIDCard);
    }

    @PutMapping("/updatepOtherInfoBypIDCard/{pIDCard}/{otherInfo}")
    public pinfo updatepOtherInfoBypIDCard(@PathVariable String pIDCard, @PathVariable String otherInfo) {
        pinfo patient = new pinfo();
        patient.setpIDCard(pIDCard);
        patient.setpOtherInfo(otherInfo);
        userService.updatepOtherInfo(patient);
        return userService.findPatientByIdCard(pIDCard);
    }

    @PutMapping("/updatepFamilyInfoBypIDCard/{pIDCard}/{familyInfo}")
    public pinfo updatepFamilyInfoBypIDCard(@PathVariable String pIDCard, @PathVariable String familyInfo) {
        pinfo patient = new pinfo();
        patient.setpIDCard(pIDCard);
        patient.setpFamilyInfo(familyInfo);
        userService.updatepFamilyInfo(patient);
        return userService.findPatientByIdCard(pIDCard);
    }

    @PutMapping("/updatepSymptomBypIDCard/{pIDCard}/{symptom}")
    public pinfo updatepSymptomBypIDCard(@PathVariable String pIDCard, @PathVariable String symptom) {
        pinfo patient = new pinfo();
        patient.setpIDCard(pIDCard);
        patient.setpSymptom(symptom);
        userService.updatepSymptom(patient);
        return userService.findPatientByIdCard(pIDCard);
    }

    @PutMapping("/updatepPasswordHashBypIDCard/{pIDCard}/{passwordHash}")
    public pinfo updatepPasswordHashBypIDCard(@PathVariable String pIDCard, @PathVariable String passwordHash) {
        pinfo patient = new pinfo();
        patient.setpIDCard(pIDCard);
        patient.setpPasswordHash(passwordHash);
        userService.updatepPasswordHash(patient);
        return userService.findPatientByIdCard(pIDCard);
    }

    @PutMapping("/updatepPicture/{pIDCard}")
    public ResponseEntity<?> updatepPicture(@PathVariable String pIDCard, @RequestParam("picture") MultipartFile picture) {
        if (picture.isEmpty()) {
            return ResponseEntity.badRequest().body("Picture is not provided");
        }
        try {
            pinfo patient = userService.findPatientByIdCard(pIDCard);
            if (patient == null) {
                return ResponseEntity.notFound().build();
            }
            byte[] pictureBytes = picture.getBytes();
            userService.updatepPicture(pIDCard, pictureBytes);
            return ResponseEntity.ok().body("Picture updated successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating picture");
        }
    }
    //    图片提交需要确保客户端在发送图片时使用multipart/form-data内容类型。如果是在HTML表单中，你的表单应该像这样：
    //<form action="http://localhost:8080/updatepPicture/12345" method="post" enctype="multipart/form-data">
    //    <input type="file" name="picture">
    //    <input type="submit" value="Upload">
    //</form>
    //    对于非表单的客户端（如使用Fetch API的JavaScript代码），确保正确设置请求的Content-Type和正文。


}
