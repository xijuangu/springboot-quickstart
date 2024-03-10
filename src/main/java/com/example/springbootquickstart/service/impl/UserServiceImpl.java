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
        param.put("name", patient.getName());
        param.put("idCard", patient.getpIDCard());

        // 使用 jdbcTemplate 执行 update 语句
        int updatedRows = jdbcTemplate.update(sql, param);

        return updatedRows; // 返回更新的行数
    }

    @Override
    public int updatepGender(pinfo patient) {
        String sql = "UPDATE pinfo SET pGender = :gender WHERE pIDCard = :idCard";
        Map<String, Object> param = new HashMap<>();
        param.put("gender", patient.getGender());
        param.put("idCard", patient.getpIDCard());

        // 使用 jdbcTemplate 执行 update 语句
        int updatedRows = jdbcTemplate.update(sql, param);

        return updatedRows; // 返回更新的行数
    }

}
