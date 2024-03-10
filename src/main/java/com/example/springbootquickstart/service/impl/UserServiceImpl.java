//UserServiceImpl.java

package com.example.springbootquickstart.service.impl;

import com.example.springbootquickstart.mapper.UserMapper;
import com.example.springbootquickstart.pojo.dinfo;
import com.example.springbootquickstart.pojo.pinfo;
import com.example.springbootquickstart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
@Repository
public class UserServiceImpl implements UserService {

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

}
