//pinfoController.java

package com.example.springbootquickstart.controller;

import com.example.springbootquickstart.pojo.pinfo;
import com.example.springbootquickstart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RestController
public class pinfoController {

    //pinfo getter

    @Autowired
    private UserService userService;

    @GetMapping("/name/{id}")
    public String getUserNameById(@PathVariable Integer id) {
        return userService.FindNameById(id);
    }

    @GetMapping("/address/{id}")
    public String getUserAddressById(@PathVariable Integer id) {
        return userService.FindAddressById(id);
    }

    @GetMapping("/pName/{pIDCard}")
    public String getpNameBypIdCard(@PathVariable String pIDCard) {
        return userService.FindpNameBypIdCard(pIDCard);
    }

    @GetMapping("/history/{pIDCard}")
    public Boolean getHistoryBypIdCard(@PathVariable String pIDCard) {
        return userService.FindHistoryBypIdCard(pIDCard);
    }

    @GetMapping("/other/{pIDCard}")
    public Boolean getOtherBypIdCard(@PathVariable String pIDCard) {
        return userService.FindOtherBypIdCard(pIDCard);
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
    @ResponseBody
    @RequestMapping(value = "/setpIDCard/{pIDCard}",method = RequestMethod.GET)
    public pinfo setpIDCard(@PathVariable String pIDCard){
        pinfo patient = new pinfo();
        patient.setpIDCard(pIDCard);
        userService.setpIDCard(patient);
        //返回完整的patient信息
        pinfo updatedPatient = userService.findPatientByIdCard(pIDCard);
        return updatedPatient;
    }

    @ResponseBody
    @RequestMapping(value = "/updatepNameBypIDCard/{pIDCard}/{pName}",method = RequestMethod.GET)
    public pinfo updatepNameBypIDCard(@PathVariable String pIDCard, @PathVariable String pName){
        pinfo patient = new pinfo();
        patient.setName(pName);
        patient.setpIDCard(pIDCard);
        userService.updatepName(patient);
        //返回完整的patient信息
        pinfo updatedPatient = userService.findPatientByIdCard(pIDCard);
        return updatedPatient;
    }

    @ResponseBody
    @RequestMapping(value = "/updatepGenderBypIDCard/{pIDCard}/{pGender}",method = RequestMethod.GET)
    public pinfo updatepGenderBypIDCard(@PathVariable String pIDCard, @PathVariable String pGender){
        pinfo patient = new pinfo();
        patient.setGender(pGender);
        patient.setpIDCard(pIDCard);
        userService.updatepGender(patient);
        //返回完整的patient信息
        pinfo updatedPatient = userService.findPatientByIdCard(pIDCard);
        return updatedPatient;
    }



}
