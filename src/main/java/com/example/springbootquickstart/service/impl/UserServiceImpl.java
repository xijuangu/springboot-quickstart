//UserServiceImpl.java

package com.example.springbootquickstart.service.impl;

import com.example.springbootquickstart.mapper.UserMapper;
import com.example.springbootquickstart.pojo.*;
import com.example.springbootquickstart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Repository
public class UserServiceImpl implements UserService {


    // 通过ID找聊天记录
    public List<communicationrecord> findCRByPid(String pIDCard){
        return userMapper.FindCRByPid(pIDCard);
    }
    public List<communicationrecord> findCRByDid(String dID){
        return userMapper.FindCRByDid(dID);
    }


    // pinfo分页查询
    public List<pinfo> getPinfoByPage(int page, int size) {
        int offset = (page - 1) * size;
        return userMapper.findPinfoByPage(offset, size);
    }


    // 根据名字找pinfo
    public List<pinfo> getPinfoByName(String pName){
        return userMapper.FindpINFOBypName(pName);
    }

    // 根据职位找dinfo
    public List<dinfo> getDinfoByJob(String Job){
        return userMapper.FindDinfoByJob(Job);
    }



    // dinfo分页查询,新增两个参数
    /*public List<dinfo> getDinfoByPage(int page, int size) {
        int offset = (page - 1) * size;
        return userMapper.findDinfoByPage(offset, size);
    }*/

    public List<dinfo> getDinfoByPage(int page, int size, String dName, String dJob) {
        int offset = (page - 1) * size;
        return userMapper.findDinfoByPage(offset, size, dName, dJob);
    }



    //pinfo getter

    @Autowired
    private UserMapper userMapper;


    @Override
    public String FindAddressById(String id){
        return userMapper.FindpAddressBypIdCard(id);
    }

    @Override
    public String FindpNameBypIdCard(String pIDCard){ return userMapper.FindpNameBypIdCard(pIDCard);}

    @Override
    public Boolean FindHistoryBypIdCard(String pIDCard) {
        return userMapper.FindpHistoryBypIdCard(pIDCard);
    }

    @Override
    public Integer FindAgeByIdCard(String pIDCard) { return userMapper.FindpAgeBypIdCard(pIDCard); }

    @Override
    public Boolean FindOtherBypIdCard(String pIDCard) {
        return userMapper.FindpOtherBypIdCard(pIDCard);
    }

    @Override
    public Boolean FindFamilyBypIdCard(String pIDCard) {
        return userMapper.FindpFamilyBypIdCard(pIDCard);
    }

    @Override
    public String FindOtherInfoBypIdCard(String pIDCard) {
        return userMapper.FindpOtherInfoBypIdCard(pIDCard);
    }

    @Override
    public String FindFamilyInfoBypIdCard(String pIDCard) {
        return userMapper.FindpFamilyInfoBypIdCard(pIDCard);
    }

    @Override
    public String FindSymptomBypIdCard(String pIDCard) {
        return userMapper.FindpSymptomBypIdCard(pIDCard);
    }

    @Override
    public byte[] FindPictureBypIdCard(String pIDCard) {
        return userMapper.FindpPictureBypIdCard(pIDCard);
    }

    @Override
    public String FindPasswordHashBypIdCard(String pIDCard) {
        return userMapper.FindpPasswordHashBypIdCard(pIDCard);
    }

    @Override
    public pinfo findPatientByIdCard(String pIDCard) {
        String sql = "SELECT * FROM pinfo WHERE pIDCard = :idCard";
        Map<String, Object> param = new HashMap<>();
        param.put("idCard", pIDCard);
        return jdbcTemplate.queryForObject(sql, param, new BeanPropertyRowMapper<>(com.example.springbootquickstart.pojo.pinfo.class));
    }


    //setter
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public int saveOrUpdatePinfo(pinfo patient) {
        String sql = "INSERT INTO pinfo (pIDCard, pName, pAge, pGender, pPhone, pAddress, pHistory, pOther, pFamily, pOtherInfo, pFamilyInfo, pSymptom, pPicture, pPasswordHash) " +
                "VALUES (:pIDCard, :pName, :pAge, :pGender, :pPhone, :pAddress, :pHistory, :pOther, :pFamily, :pOtherInfo, :pFamilyInfo, :pSymptom, :pPicture, :pPasswordHash) " +
                "ON DUPLICATE KEY UPDATE pName = :pName, pAge = :pAge, pGender = :pGender, pPhone = :pPhone, pAddress = :pAddress, pHistory = :pHistory, pOther = :pOther, pFamily = :pFamily, pOtherInfo = :pOtherInfo, pFamilyInfo = :pFamilyInfo, pSymptom = :pSymptom, pPicture = :pPicture, pPasswordHash = :pPasswordHash";
        Map<String, Object> params = new HashMap<>();
        params.put("pIDCard", patient.getpIDCard());
        params.put("pName", patient.getpName());
        params.put("pAge", patient.getpAge());
        params.put("pGender", patient.getpGender());
        params.put("pPhone", patient.getpPhone());
        params.put("pAddress", patient.getpAddress());
        params.put("pHistory", patient.getpHistory());
        params.put("pOther", patient.getpOther());
        params.put("pFamily", patient.getpFamily());
        params.put("pOtherInfo", patient.getpOtherInfo());
        params.put("pFamilyInfo", patient.getpFamilyInfo());
        params.put("pSymptom", patient.getpSymptom());
        params.put("pPicture", patient.getpPicture());
        params.put("pPasswordHash", patient.getpPasswordHash());

        return jdbcTemplate.update(sql, params);
    }


    @Override
    public int setpIDCard(pinfo patient) {
        String sql ="INSERT INTO pinfo(pIDCard) " +
                "SELECT :IDCard " +
                "WHERE NOT EXISTS (SELECT 1 FROM pinfo WHERE pIDCard = :IDCard)";
        Map<String, Object> param = new HashMap<>();
        param.put("IDCard", patient.getpIDCard());

        return (int) jdbcTemplate.update(sql, param);
    }

    @Override
    public int updatepName(pinfo patient) {
        String sql = "UPDATE pinfo SET pName = :name WHERE pIDCard = :idCard";
        Map<String, Object> param = new HashMap<>();
        param.put("name", patient.getpName());
        param.put("idCard", patient.getpIDCard());
        return jdbcTemplate.update(sql, param);
    }

    @Override
    public int updatepGender(pinfo patient) {
        String sql = "UPDATE pinfo SET pGender = :gender WHERE pIDCard = :idCard";
        Map<String, Object> param = new HashMap<>();
        param.put("gender", patient.getpGender());
        param.put("idCard", patient.getpIDCard());
        return jdbcTemplate.update(sql, param);
    }

    @Override
    public int updatepPhone(pinfo patient) {
        String sql = "UPDATE pinfo SET pPhone = :phone WHERE pIDCard = :idCard";
        Map<String, Object> param = new HashMap<>();
        param.put("phone", patient.getpPhone());
        param.put("idCard", patient.getpIDCard());
        return jdbcTemplate.update(sql, param);
    }

    @Override
    public int updatepAddress(pinfo patient) {
        String sql = "UPDATE pinfo SET pAddress = :address WHERE pIDCard = :idCard";
        Map<String, Object> param = new HashMap<>();
        param.put("address", patient.getpAddress());
        param.put("idCard", patient.getpIDCard());
        return jdbcTemplate.update(sql, param);
    }

    @Override
    public int updatepHistory(pinfo patient) {
        String sql = "UPDATE pinfo SET pHistory = :history WHERE pIDCard = :idCard";
        Map<String, Object> param = new HashMap<>();
        param.put("history", patient.getpHistory());
        param.put("idCard", patient.getpIDCard());
        return jdbcTemplate.update(sql, param);
    }

    @Override
    public int updatepOther(pinfo patient) {
        String sql = "UPDATE pinfo SET pOther = :other WHERE pIDCard = :idCard";
        Map<String, Object> param = new HashMap<>();
        param.put("other", patient.getpOther());
        param.put("idCard", patient.getpIDCard());
        return jdbcTemplate.update(sql, param);
    }

    @Override
    public int updatepFamily(pinfo patient) {
        String sql = "UPDATE pinfo SET pFamily = :family WHERE pIDCard = :idCard";
        Map<String, Object> param = new HashMap<>();
        param.put("family", patient.getpFamily());
        param.put("idCard", patient.getpIDCard());
        return jdbcTemplate.update(sql, param);
    }

    @Override
    public int updatepOtherInfo(pinfo patient) {
        String sql = "UPDATE pinfo SET pOtherInfo = :otherInfo WHERE pIDCard = :idCard";
        Map<String, Object> param = new HashMap<>();
        param.put("otherInfo", patient.getpOtherInfo());
        param.put("idCard", patient.getpIDCard());
        return jdbcTemplate.update(sql, param);
    }

    @Override
    public int updatepFamilyInfo(pinfo patient) {
        String sql = "UPDATE pinfo SET pFamilyInfo = :familyInfo WHERE pIDCard = :idCard";
        Map<String, Object> param = new HashMap<>();
        param.put("familyInfo", patient.getpFamilyInfo());
        param.put("idCard", patient.getpIDCard());
        return jdbcTemplate.update(sql, param);
    }

    @Override
    public int updatepSymptom(pinfo patient) {
        String sql = "UPDATE pinfo SET pSymptom = :symptom WHERE pIDCard = :idCard";
        Map<String, Object> param = new HashMap<>();
        param.put("symptom", patient.getpSymptom());
        param.put("idCard", patient.getpIDCard());
        return jdbcTemplate.update(sql, param);
    }

    @Override
    public int updatepPasswordHash(pinfo patient) {
        String sql = "UPDATE pinfo SET pPasswordHash = :passwordHash WHERE pIDCard = :idCard";
        Map<String, Object> param = new HashMap<>();
        param.put("passwordHash", patient.getpPasswordHash());
        param.put("idCard", patient.getpIDCard());
        return jdbcTemplate.update(sql, param);
    }

    @Override
    public int updatepPicture(String pIDCard, byte[] picture) {
        String sql = "UPDATE pinfo SET pPicture = :picture WHERE pIDCard = :idCard";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("picture", picture);
        paramMap.put("idCard", pIDCard);
        return jdbcTemplate.update(sql, paramMap);
    }


    // dinfo getters
    @Override
    public dinfo findDinfoById(String dId) {
        String sql = "SELECT * FROM dinfo WHERE dId = :dId";
        Map<String, Object> params = new HashMap<>();
        params.put("dId", dId);
        return jdbcTemplate.queryForObject(sql, params, new BeanPropertyRowMapper<>(dinfo.class));
    }

    @Override
    public String findDNameBydId(String dId) {
        String sql = "SELECT dName FROM dinfo WHERE dId = :dId";
        Map<String, Object> params = new HashMap<>();
        params.put("dId", dId);
        return jdbcTemplate.queryForObject(sql, params, String.class);
    }

    @Override
    public String findDGenderBydId(String dId) {
        String sql = "SELECT dGender FROM dinfo WHERE dId = :dId";
        Map<String, Object> params = new HashMap<>();
        params.put("dId", dId);
        return jdbcTemplate.queryForObject(sql, params, String.class);
    }

    @Override
    public String findDHospitalBydId(String dId) {
        String sql = "SELECT dHospital FROM dinfo WHERE dId = :dId";
        Map<String, Object> params = new HashMap<>();
        params.put("dId", dId);
        return jdbcTemplate.queryForObject(sql, params, String.class);
    }

    @Override
    public Date findDWorkTimeBydId(String dId) {
        String sql = "SELECT dWorkTime FROM dinfo WHERE dId = :dId";
        Map<String, Object> params = new HashMap<>();
        params.put("dId", dId);
        return jdbcTemplate.queryForObject(sql, params, Date.class);
    }

    @Override
    public String findDJobBydId(String dId) {
        String sql = "SELECT dJob FROM dinfo WHERE dId = :dId";
        Map<String, Object> params = new HashMap<>();
        params.put("dId", dId);
        return jdbcTemplate.queryForObject(sql, params, String.class);
    }

    @Override
    public String findDStrengthBydId(String dId) {
        String sql = "SELECT dStrength FROM dinfo WHERE dId = :dId";
        Map<String, Object> params = new HashMap<>();
        params.put("dId", dId);
        return jdbcTemplate.queryForObject(sql, params, String.class);
    }

    @Override
    public String findDIntroductionBydId(String dId) {
        String sql = "SELECT dIntroduction FROM dinfo WHERE dId = :dId";
        Map<String, Object> params = new HashMap<>();
        params.put("dId", dId);
        return jdbcTemplate.queryForObject(sql, params, String.class);
    }

    @Override
    public byte[] findDPictureBydId(String dId) {
        String sql = "SELECT dPicture FROM dinfo WHERE dId = :dId";
        Map<String, Object> params = new HashMap<>();
        params.put("dId", dId);
        return jdbcTemplate.queryForObject(sql, params, byte[].class);
    }

    @Override
    public String findDPasswordHashBydId(String dId) {
        String sql = "SELECT dPasswordHash FROM dinfo WHERE dId = :dId";
        Map<String, Object> params = new HashMap<>();
        params.put("dId", dId);
        return jdbcTemplate.queryForObject(sql, params, String.class);
    }


    // dinfo setters
    @Override
    public int setDinfo(dinfo doctorInfo) {
        String sql = "INSERT INTO dinfo (dId, dName, dGender, dHospital, dWorkTime, dJob, dStrength, dIntroduction, PatientFeedbackId, dPicture, dPasswordHash) " +
                "VALUES (:dId, :dName, :dGender, :dHospital, :dWorkTime, :dJob, :dStrength, :dIntroduction, :PatientFeedbackId, :dPicture, :dPasswordHash)";

        Map<String, Object> params = new HashMap<>();
        params.put("dId", doctorInfo.getDId());
        params.put("dName", doctorInfo.getDName());
        params.put("dGender", doctorInfo.getDGender());
        params.put("dHospital", doctorInfo.getDHospital());
        params.put("dWorkTime", doctorInfo.getDWorkTime());
        params.put("dJob", doctorInfo.getDJob());
        params.put("dStrength", doctorInfo.getDStrength());
        params.put("dIntroduction", doctorInfo.getDIntroduction());
        params.put("PatientFeedbackId", doctorInfo.getPatientFeedbackId());
        params.put("dPicture", doctorInfo.getDPicture());
        params.put("dPasswordHash", doctorInfo.getDPasswordHash());

        return jdbcTemplate.update(sql, params);
    }

    @Override
    public int updateDNameBydId(String dId, String dName) {
        String sql = "UPDATE dinfo SET dName = :dName WHERE dId = :dId";
        Map<String, Object> params = new HashMap<>();
        params.put("dId", dId);
        params.put("dName", dName);
        return jdbcTemplate.update(sql, params);
    }

    @Override
    public int updateDGenderBydId(String dId, String dGender) {
        String sql = "UPDATE dinfo SET dGender = :dGender WHERE dId = :dId";
        Map<String, Object> params = new HashMap<>();
        params.put("dId", dId);
        params.put("dGender", dGender);
        return jdbcTemplate.update(sql, params);
    }

    @Override
    public int updateDHospitalBydId(String dId, String dHospital) {
        String sql = "UPDATE dinfo SET dHospital = :dHospital WHERE dId = :dId";
        Map<String, Object> params = new HashMap<>();
        params.put("dId", dId);
        params.put("dHospital", dHospital);
        return jdbcTemplate.update(sql, params);
    }

    @Override
    public int updateDWorkTimeBydId(String dId, Date dWorkTime) {
        String sql = "UPDATE dinfo SET dWorkTime = :dWorkTime WHERE dId = :dId";
        Map<String, Object> params = new HashMap<>();
        params.put("dId", dId);
        params.put("dWorkTime", dWorkTime);
        return jdbcTemplate.update(sql, params);
    }

    @Override
    public int updateDJobBydId(String dId, String dJob) {
        String sql = "UPDATE dinfo SET dJob = :dJob WHERE dId = :dId";
        Map<String, Object> params = new HashMap<>();
        params.put("dId", dId);
        params.put("dJob", dJob);
        return jdbcTemplate.update(sql, params);
    }

    @Override
    public int updateDStrengthBydId(String dId, String dStrength) {
        String sql = "UPDATE dinfo SET dStrength = :dStrength WHERE dId = :dId";
        Map<String, Object> params = new HashMap<>();
        params.put("dId", dId);
        params.put("dStrength", dStrength);
        return jdbcTemplate.update(sql, params);
    }

    @Override
    public int updateDIntroductionBydId(String dId, String dIntroduction) {
        String sql = "UPDATE dinfo SET dIntroduction = :dIntroduction WHERE dId = :dId";
        Map<String, Object> params = new HashMap<>();
        params.put("dId", dId);
        params.put("dIntroduction", dIntroduction);
        return jdbcTemplate.update(sql, params);
    }


    @Override
    public int updateDPictureBydId(String dId, byte[] dPicture) {
        String sql = "UPDATE dinfo SET dPicture = :dPicture WHERE dId = :dId";
        Map<String, Object> params = new HashMap<>();
        params.put("dId", dId);
        params.put("dPicture", dPicture);
        return jdbcTemplate.update(sql, params);
    }

    @Override
    public int updateDPasswordHashBydId(String dId, String dPasswordHash) {
        String sql = "UPDATE dinfo SET dPasswordHash = :dPasswordHash WHERE dId = :dId";
        Map<String, Object> params = new HashMap<>();
        params.put("dId", dId);
        params.put("dPasswordHash", dPasswordHash);
        return jdbcTemplate.update(sql, params);
    }



    // communication record

    @Override
    public void addCommunicationRecord(communicationrecord record) {
        userMapper.insertCommunicationRecord(record);
    }

    @Override
    public communicationrecord getCommunicationRecordById(int crId) {
        return userMapper.selectCommunicationRecordById(crId);
    }

    @Override
    public List<communicationrecord> getAllCommunicationRecords() {
        return userMapper.selectAllCommunicationRecords();
    }

    @Override
    public void updateCommunicationRecord(communicationrecord record) {
        userMapper.updateCommunicationRecord(record);
    }

    @Override
    public void deleteCommunicationRecord(int crId) {
        userMapper.deleteCommunicationRecord(crId);
    }


    // diagnosis request 添加数据操作
    @Override
    public void addDiagnosisRequest(diagnosisrequest request) {
        userMapper.insertDiagnosisRequest(request);
    }
    @Override
    public diagnosisrequest getDiagnosisRequestById(int drId) {
        return userMapper.findDiagnosisRequestById(drId);
    }


    // image type 操作
    @Override
    public void addImageType(imagetype imageType) {
        userMapper.insertImageType(imageType);
    }
    @Override
    public imagetype getImageTypeById(int imageTypeId) {
        return userMapper.findImageTypeById(imageTypeId);
    }

    @Override
    public List<imagetype> getImageTypeByPage(int page, int size, String typeName) {
        int offset = (page - 1) * size;
        return userMapper.findImageTypeByPage(offset, size, typeName);
    }

    // stage 操作
    @Override
    public void addStage(stage Stage) {
        userMapper.insertStage(Stage);
    }
    @Override
    public stage getStageById(int stageId) {
        return userMapper.findStageById(stageId);
    }
    @Override
    public List<stage> getStageByPage(int page, int size, String stageName) {
        int offset = (page - 1) * size;
        return userMapper.findStageByPage(offset, size, stageName);
    }



    // predictfeedback操作
    @Override
    public void addPredictFeedback(predictfeedback feedback) {
        userMapper.insertPredictFeedback(feedback);
    }

    @Override
    public predictfeedback getPredictFeedbackById(int PredictFeedbackId) {
        return userMapper.findPredictFeedbackById(PredictFeedbackId);
    }



    // model操作
    @Override
    public void addModel(model model) {
        userMapper.insertModel(model);
    }

    @Override
    public model getModelByName(String ModelName) {
        return userMapper.findModelByName(ModelName);
    }




    // patientfeedback操作
    @Override
    public void addPatientFeedback(patientfeedback patientFeedback) {
        userMapper.insertPatientFeedback(patientFeedback);
    }

    @Override
    public patientfeedback getPatientFeedbackById(String PatientFeedbackId) {
        return userMapper.findPatientFeedbackById(PatientFeedbackId);
    }



    // user表操作
    @Override
    public boolean addUser(User user) {
        int affectedRows = userMapper.insertUser(user);
        return affectedRows > 0;
    }

    @Override
    public User getUserById(int id) {
        return userMapper.findUserById(id);
    }




    // SendPicture操作

    @Override
    public void addSendPicture(SendPicture record) {
        userMapper.insertSendPicture(record);
    }

    @Override
    public SendPicture getSendPictureById(int sp_id) {
        return userMapper.selectSendPictureById(sp_id);
    }

    @Override
    public List<SendPicture> getAllSendPictures() {
        return userMapper.selectAllSendPictures();
    }

    @Override
    public void updateSendPicture(SendPicture record) {
        userMapper.updateSendPicture(record);
    }

    @Override
    public void deleteSendPicture(int sp_id) {
        userMapper.deleteSendPicture(sp_id);
    }

    // 通过ID找图片发送记录
    public List<SendPicture> findSPByPid(String pIDCard){
        return userMapper.FindSPByPid(pIDCard);
    }
    public List<SendPicture> findSPByDid(String dID){
        return userMapper.FindSPByDid(dID);
    }


}
