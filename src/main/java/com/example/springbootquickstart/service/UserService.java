//UserService.java

package com.example.springbootquickstart.service;

import com.example.springbootquickstart.pojo.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface UserService {

    public long countDinfo(String dName, String dJob);
    public long countTotalDinfo();

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



    // 返回列表
    List<pinfo> getPinfoByPage(int page, int size);

//    List<dinfo> getDinfoByPage(int page, int size);
    List<dinfo> getDinfoByPage(int page, int size, String dName, String dJob);


    // 根据名字找pinfo
    List<pinfo> getPinfoByName(String pName);

    List<pinfo> getPinfoBySymptom(String pName, String pSymptom, int page, int size);

    // 根据职位找dinfo
    List<dinfo> getDinfoByJob(String Job);





    // communication record

    // 添加通讯记录
    void addCommunicationRecord(communicationrecord record);

    // 根据crId获取通讯记录
    communicationrecord getCommunicationRecordById(int crId);

    // 获取所有通讯记录
    List<communicationrecord> getAllCommunicationRecords();

    // 更新通讯记录
    void updateCommunicationRecord(communicationrecord record);


    // 通过ID找聊天记录
    List<communicationrecord> findCRByPid(String pIDCard);
    List<communicationrecord> findCRByDid(String dID);

    // 删除通讯记录
    void deleteCommunicationRecord(int crId);



    // diagnosisrequest的添加数据操作
    void addDiagnosisRequest(diagnosisrequest request);
    diagnosisrequest getDiagnosisRequestById(int drId);
    List<diagnosisrequest> getDiagnosisRequestsByPIDCard(String pIDCard);
    List<Map<String, Object>> getImagesByPIDCard(String pIDCard);



    // image type 操作
    void addImageType(imagetype imageType);
    imagetype getImageTypeById(int imageTypeId);
    List<imagetype> getImageTypeByPage(int page, int size, String typeName);


    // stage 操作
    void addStage(stage Stage);
    stage getStageById(int stageId);
    List<stage> getStageByPage(int page, int size, String stageName);


    // predictfeedback 操作
    void addPredictFeedback(predictfeedback feedback);
    predictfeedback getPredictFeedbackById(int PredictFeedbackId);
    predictfeedback getPredictFeedbackByDrId(int drId);


    // model操作
    void addModel(model model);
    model getModelByName(String ModelName);
    List<model> getModelByPage(int page, int size, Integer stageId, Integer imageTypeId);


    // patientfeedback操作
    void addPatientFeedback(patientfeedback patientFeedback);
    patientfeedback getPatientFeedbackById(int PatientFeedbackId);
    List<PatientFeedbackDetail> getPatientFeedbackByDid(String dID) ;



    // user表操作
    boolean addUser(User user);
    User getUserById(int id);




    // SendPicture操作

    // 添加图片发送记录
    void addSendPicture(SendPicture record);

    // 根据sp_id获取图片发送记录
    SendPicture getSendPictureById(int sp_id);

    // 获取所有图片发送记录
    List<SendPicture> getAllSendPictures();

    // 更新图片发送记录
    void updateSendPicture(SendPicture record);

    // 通过pIDCard找图片发送记录
    List<SendPicture> findSPByPid(String pIDCard);
    // 通过dID找图片发送记录
    List<SendPicture> findSPByDid(String dID);

    // 删除图片发送记录
    void deleteSendPicture(int sp_id);


}
