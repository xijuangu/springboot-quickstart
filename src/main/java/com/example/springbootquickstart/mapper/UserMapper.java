//UserMapper.java

package com.example.springbootquickstart.mapper;

import com.example.springbootquickstart.pojo.*;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {


    // 根据名字找pinfo
    @Select("select * from pinfo where pName = #{pName}")
    public List<pinfo> FindpINFOBypName(String pName);

    // 根据职位找dinfo
    @Select("select * from dinfo where dJob = #{Job}")
    public List<dinfo> FindDinfoByJob(String Job);

    // 通过ID找聊天记录
    @Select("select * from communicationrecord where pIDCard = #{pIDCard}")
    public List<communicationrecord> FindCRByPid(String pIDCard);
    @Select("select * from communicationrecord where dID = #{dID}")
    public List<communicationrecord> FindCRByDid(String dID);




    // pinfo操作……

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

    @Select("SELECT * FROM diagnosisrequest WHERE drId = #{drId}")
    diagnosisrequest findDiagnosisRequestById(int drId);


    // image type 操作
    @Insert("INSERT INTO imagetype (ImageTypeId, ImageTypeName) VALUES (#{ImageTypeId}, #{ImageTypeName})")
    void insertImageType(imagetype imageType);

    @Select("SELECT * FROM imagetype WHERE ImageTypeId = #{imageTypeId}")
    imagetype findImageTypeById(int imageTypeId);


    // stage  操作
    @Insert("INSERT INTO stage (StageId, StageName) VALUES (#{StageId}, #{StageName})")
    void insertStage(stage Stage);

    @Select("SELECT * FROM stage WHERE StageId = #{stageId}")
    stage findStageById(int stageId);


    // predictfeedback操作
    @Insert("INSERT INTO predictfeedback (PredictFeedbackId, ImageTypeId, StageId, ModelName, PredictFeedbackComment, drId, ModelResult) VALUES (#{PredictFeedbackId}, #{ImageTypeId}, #{StageId}, #{ModelName}, #{PredictFeedbackComment}, #{drId}, #{ModelResult})")
    void insertPredictFeedback(predictfeedback feedback);
    @Select("SELECT * FROM predictfeedback WHERE PredictFeedbackId = #{PredictFeedbackId}")
    predictfeedback findPredictFeedbackById(int PredictFeedbackId);


    // model操作
    @Insert("INSERT INTO model (ModelName, StageId, ImageTypeId, api_path) VALUES (#{ModelName}, #{StageId}, #{ImageTypeId}, #{apiPath})")
    void insertModel(model model);

    @Select("SELECT * FROM model WHERE ModelName = #{ModelName}")
    model findModelByName(String ModelName);


    // patientfeedback 操作
    @Insert("INSERT INTO patientfeedback (PatientFeedbackId, pIDCard, pfTime, PatientFeedbackComment, pfLikesCount, pfComentText) VALUES (#{PatientFeedbackId}, #{pIDCard}, #{pfTime}, #{PatientFeedbackComment}, #{pfLikesCount}, #{pfComentText})")
    void insertPatientFeedback(patientfeedback patientFeedback);

    @Select("SELECT * FROM patientfeedback WHERE PatientFeedbackId = #{PatientFeedbackId}")
    patientfeedback findPatientFeedbackById(String PatientFeedbackId);


    // User表操作
    @Insert("INSERT INTO User(username, password, userType) VALUES(#{username}, #{password}, #{userType})")
    int insertUser(User user);

    @Select("SELECT * FROM User WHERE id = #{id}")
    User findUserById(int id);



    // SendPicture操作

    // 插入图片发送记录
    @Insert("INSERT INTO SendPicture (sp_id, sp_picture, pIDCard, dID, sp_time, sender) VALUES (#{sp_id}, #{sp_picture}, #{pIDCard}, #{dID}, #{sp_time}, #{sender})")
    void insertSendPicture(SendPicture record);

    // 根据ID选择图片发送记录
    @Select("SELECT * FROM SendPicture WHERE sp_id = #{sp_id}")
    SendPicture selectSendPictureById(int sp_id);

    // 选择所有图片发送记录
    @Select("SELECT * FROM SendPicture")
    List<SendPicture> selectAllSendPictures();

    // 更新图片发送记录
    @Update("UPDATE SendPicture SET pIDCard = #{pIDCard}, dID = #{dID}, sp_picture = #{sp_picture}, sp_time = #{sp_time}, sender = #{sender} WHERE sp_id = #{sp_id}")
    void updateSendPicture(SendPicture record);

    // 删除图片发送记录
    @Delete("DELETE FROM SendPicture WHERE sp_id = #{sp_id}")
    void deleteSendPicture(int sp_id);

    // 通过ID找图片发送记录
    @Select("SELECT * FROM SendPicture WHERE pIDCard = #{pIDCard}")
    List<SendPicture> FindSPByPid(String pIDCard);
    @Select("SELECT * FROM SendPicture WHERE dID = #{dID}")
    List<SendPicture> FindSPByDid(String dID);


}

