//UserMapper.java

package com.example.springbootquickstart.mapper;

import com.example.springbootquickstart.pojo.*;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("select pAddress from pinfo where pIDCard = #{pIDCard}")
    public String FindpAddressBypIdCard(String pIDCard);

    @Select("select pName from pinfo where pIDCard = #{pIDCard}")
    public String FindpNameBypIdCard(String pIDCard);

    @Select("select pHistory from pinfo where pIDCard = #{pIDCard}")
    public Boolean FindpHistoryBypIdCard(String pIDCard);

    @Select("select pAge from pinfo where pIDCard = #{pIDCard}")
    public Integer FindpAgeBypIdCard(String pIDCard);

    @Select("select pOther from pinfo where pIDCard = #{pIDCard}")
    public Boolean FindpOtherBypIdCard(String pIDCard);

    @Select("select pFamily from pinfo where pIDCard = #{pIDCard}")
    public Boolean FindpFamilyBypIdCard(String pIDCard);

    @Select("select pOtherInfo from pinfo where pIDCard = #{pIDCard}")
    public String FindpOtherInfoBypIdCard(String pIDCard);

    @Select("select pFamilyInfo from pinfo where pIDCard = #{pIDCard}")
    public String FindpFamilyInfoBypIdCard(String pIDCard);

    @Select("select pSymptom from pinfo where pIDCard = #{pIDCard}")
    public String FindpSymptomBypIdCard(String pIDCard);

    @Select("select pPicture from pinfo where pIDCard = #{pIDCard}")
    public byte[] FindpPictureBypIdCard(String pIDCard);

    @Select("select pPasswordHash from pinfo where pIDCard = #{pIDCard}")
    public String FindpPasswordHashBypIdCard(String pIDCard);

    // 分页查询实现
    List<pinfo> findPinfoByPage(@Param("offset") int offset, @Param("limit") int limit);

    List<dinfo> findDinfoByPage(@Param("offset") int offset, @Param("limit") int limit);






    // communication record

    // 插入通讯记录
    @Insert("INSERT INTO communicationrecord (crId, pIDCard, dID, crText, crTime, crTexter) VALUES (#{crId}, #{pIDCard}, #{dID}, #{crText}, #{crTime}, #{crTexter})")
    void insertCommunicationRecord(communicationrecord record);

    // 根据ID选择通讯记录
    @Select("SELECT * FROM communicationrecord WHERE crId = #{crId}")
    communicationrecord selectCommunicationRecordById(int crId);

    // 选择所有通讯记录
    @Select("SELECT * FROM communicationrecord")
    List<communicationrecord> selectAllCommunicationRecords();

    // 更新通讯记录
    @Update("UPDATE communicationrecord SET pIDCard = #{pIDCard}, dID = #{dID}, crText = #{crText}, crTime = #{crTime}, crTexter = #{crTexter} WHERE crId = #{crId}")
    void updateCommunicationRecord(communicationrecord record);

    // 删除通讯记录
    @Delete("DELETE FROM communicationrecord WHERE crId = #{crId}")
    void deleteCommunicationRecord(int crId);


    // diagnosis request 操作
    @Insert("INSERT INTO diagnosisrequest (drId, dId, ImageTypeId, StageId, Image) VALUES (#{drId}, #{dId}, #{ImageTypeId}, #{StageId}, #{Image})")
    void insertDiagnosisRequest(diagnosisrequest request);


    // image type 操作
    @Insert("INSERT INTO imagetype (ImageTypeId, ImageTypeName) VALUES (#{ImageTypeId}, #{ImageTypeName})")
    void insertImageType(imagetype imageType);


    // stage  操作
    @Insert("INSERT INTO stage (StageId, StageName) VALUES (#{StageId}, #{StageName})")
    void insertStage(stage Stage);





}

