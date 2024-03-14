//UserService.java

package com.example.springbootquickstart.service;

import com.example.springbootquickstart.pojo.*;

import java.util.Date;
import java.util.List;

public interface UserService {

    //pinfo getter

    public String FindAddressById(String id);
    public String FindpNameBypIdCard(String pIDCard);
    public Boolean FindHistoryBypIdCard(String pIDCard);
    public Integer FindAgeByIdCard(String pIDCard);
    public Boolean FindOtherBypIdCard(String pIDCard);
    public Boolean FindFamilyBypIdCard(String pIDCard);
    public String FindOtherInfoBypIdCard(String pIDCard);
    public String FindFamilyInfoBypIdCard(String pIDCard);
    public String FindSymptomBypIdCard(String pIDCard);
    public byte[] FindPictureBypIdCard(String pIDCard);
    public String FindPasswordHashBypIdCard(String pIDCard);

    public pinfo findPatientByIdCard(String pIDCard);

    //pinfo setter

    int saveOrUpdatePinfo(pinfo patient);
    int setpIDCard(pinfo patient);
    int updatepName(pinfo patient);
    int updatepGender(pinfo patient);
    int updatepPhone(pinfo patient);
    int updatepAddress(pinfo patient);
    int updatepHistory(pinfo patient);
    int updatepOther(pinfo patient);
    int updatepFamily(pinfo patient);
    int updatepOtherInfo(pinfo patient);
    int updatepFamilyInfo(pinfo patient);
    int updatepSymptom(pinfo patient);
    // int updatepPicture(pinfo patient);
    int updatepPasswordHash(pinfo patient);
    int updatepPicture(String pIDCard, byte[] picture);


    // dinfo getters
    dinfo findDinfoById(String dId);
    String findDNameBydId(String dId);
    String findDGenderBydId(String dId);
    String findDHospitalBydId(String dId);
    Date findDWorkTimeBydId(String dId);
    String findDJobBydId(String dId);
    String findDStrengthBydId(String dId);
    String findDIntroductionBydId(String dId);
    byte[] findDPictureBydId(String dId);
    String findDPasswordHashBydId(String dId);

    // dinfo setters
    int setDinfo(dinfo doctorInfo);
    int updateDNameBydId(String dId, String dName);
    int updateDGenderBydId(String dId, String dGender);
    int updateDHospitalBydId(String dId, String dHospital);
    int updateDWorkTimeBydId(String dId, Date dWorkTime);
    int updateDJobBydId(String dId, String dJob);
    int updateDStrengthBydId(String dId, String dStrength);
    int updateDIntroductionBydId(String dId, String dIntroduction);
    int updateDPictureBydId(String dId, byte[] dPicture);
    int updateDPasswordHashBydId(String dId, String dPasswordHash);

    List<pinfo> getPinfoByPage(int page, int size);

    List<dinfo> getDinfoByPage(int page, int size);



    // communication record

    // 添加通讯记录
    void addCommunicationRecord(communicationrecord record);

    // 根据crId获取通讯记录
    communicationrecord getCommunicationRecordById(int crId);

    // 获取所有通讯记录
    List<communicationrecord> getAllCommunicationRecords();

    // 更新通讯记录
    void updateCommunicationRecord(communicationrecord record);

    // 删除通讯记录
    void deleteCommunicationRecord(int crId);



    // diagnosisrequest的添加数据操作
    void addDiagnosisRequest(diagnosisrequest request);


    // image type 操作
    void addImageType(imagetype imageType);


    // stage 操作
    void addStage(stage Stage);

}
