//UserServiceImpl.java

package com.example.springbootquickstart.service.impl;

import com.example.springbootquickstart.mapper.UserMapper;
import com.example.springbootquickstart.pojo.pinfo;
import com.example.springbootquickstart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@Repository
public class UserServiceImpl implements UserService {

    //pinfo getter

    @Autowired
    private UserMapper userMapper;
    @Override                               //重写了UserService接口中的findById方法
    public String FindNameById(Integer id) {
        return userMapper.FindNameById(id);
    }

    @Override
    public String FindAddressById(Integer id){
        return userMapper.FindAddressById(id);
    }

    @Override
    public String FindpNameBypIdCard(String pIDCard){ return userMapper.FindpNameBypIdCard(pIDCard);}

    @Override
    public Boolean FindHistoryBypIdCard(String pIDCard) {
        return userMapper.FindHistoryBypIdCard(pIDCard);
    }

    @Override
    public Boolean FindOtherBypIdCard(String pIDCard) {
        return userMapper.FindOtherBypIdCard(pIDCard);
    }

    @Override
    public Boolean FindFamilyBypIdCard(String pIDCard) {
        return userMapper.FindFamilyBypIdCard(pIDCard);
    }

    @Override
    public String FindOtherInfoBypIdCard(String pIDCard) {
        return userMapper.FindOtherInfoBypIdCard(pIDCard);
    }

    @Override
    public String FindFamilyInfoBypIdCard(String pIDCard) {
        return userMapper.FindFamilyInfoBypIdCard(pIDCard);
    }

    @Override
    public String FindSymptomBypIdCard(String pIDCard) {
        return userMapper.FindSymptomBypIdCard(pIDCard);
    }

    @Override
    public byte[] FindPictureBypIdCard(String pIDCard) {
        return userMapper.FindPictureBypIdCard(pIDCard);
    }

    @Override
    public String FindPasswordHashBypIdCard(String pIDCard) {
        return userMapper.FindPasswordHashBypIdCard(pIDCard);
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
    public int updatepPicture(pinfo patient) {
        // 注意，这里假设数据库可以直接存储byte[]类型的图片数据
        String sql = "UPDATE pinfo SET pPicture = :picture WHERE pIDCard = :idCard";
        Map<String, Object> param = new HashMap<>();
        param.put("picture", patient.getpPicture());
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


}
