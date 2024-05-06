//UserMapper.java

package com.example.springbootquickstart.mapper;

import com.example.springbootquickstart.pojo.*;
import org.apache.ibatis.annotations.*;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {


    // 患者年龄分布计数
    @Select("SELECT COUNT(*) FROM pinfo WHERE pAge >= #{low} AND pAge < #{high}")
    long countPatientByAge(int low, int high);

    // 医生从业时间分布计数
    @Select("SELECT COUNT(*) FROM dinfo WHERE dWorkTime >= #{low} AND dWorkTime < #{high}")
    long countDoctorByWorkTime(Date low, Date high);



    // dinfo查询计数
    @Select("SELECT COUNT(*) FROM dinfo")
    long count();

    @Select("<script>" +
            "SELECT COUNT(*) FROM dinfo" +
            "<where>" +
            "  <if test='dName != null and dName != \"\"'>AND dName = #{dName}</if>" +
            "  <if test='dJob != null and dJob != \"\"'>AND dJob = #{dJob}</if>" +
            "</where>" +
            "</script>")
    long countByConditions(@Param("dName") String dName, @Param("dJob") String dJob);



    // 根据名字找pinfo
    @Select("select * from pinfo where pName = #{pName}")
    public List<pinfo> FindpINFOBypName(String pName);

    /*@Select("SELECT * FROM pinfo WHERE pName = #{pName} AND pSymptom = #{pSymptom} LIMIT #{offset}, #{limit}")
    List<pinfo> findPinfoBySymptom(@Param("pName") String pName, @Param("pSymptom") String pSymptom, @Param("offset") int offset, @Param("limit") int limit);
*/
    @Select("<script>" +
            "SELECT * FROM pinfo" +
            "<where>" +
            "  <if test='pName != null'>AND pName = #{pName}</if>" +
            "  <if test='pSymptom != null'>AND pSymptom = #{pSymptom}</if>" +
            "</where>" +
            "LIMIT #{limit} OFFSET #{offset}" +
            "</script>")
    List<pinfo> findPinfoBySymptom(@Param("pName") String pName,
                                   @Param("pSymptom") String pSymptom,
                                   @Param("offset") int offset,
                                   @Param("limit") int limit);
    // 根据职位找dinfo
    @Select("select * from dinfo where dJob = #{Job}")
    public List<dinfo> FindDinfoByJob(String Job);

    // 通过ID找聊天记录
    @Select("select * from communicationrecord where pIDCard = #{pIDCard}")
    public List<communicationrecord> FindCRByPid(String pIDCard);
    @Select("select * from communicationrecord where dID = #{dID}")
    public List<communicationrecord> FindCRByDid(String dID);

    @Select("<script>" +
            "select * from dinfo" +
            "<where>" +
            "  <if test='dName != null'>AND dName = #{dName}</if>" +
            "  <if test='dJob != null'>AND dJob = #{dJob}</if>" +
            "</where>" +
            "limit #{limit} offset #{offset}" +
            "</script>")
    List<dinfo> findDinfoByPage(@Param("offset") int offset,
                                @Param("limit") int limit,
                                @Param("dName") String dName,
                                @Param("dJob") String dJob);

    @Select("<script>" +
            "SELECT COUNT(*) FROM dinfo" +
            "<where>" +
            "  <if test='dName != null'>AND dName = #{dName}</if>" +
            "  <if test='dJob != null'>AND dJob = #{dJob}</if>" +
            "</where>" +
            "</script>")
    int countDinfo(@Param("dName") String dName, @Param("dJob") String dJob);




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

    // pinfo分页查询
    List<pinfo> findPinfoByPage(@Param("offset") int offset, @Param("limit") int limit);
    // dinfo分页查询
//    List<dinfo> findDinfoByPage(@Param("offset") int offset, @Param("limit") int limit);






    // communication record

    // 插入通讯记录
//    @Insert("INSERT INTO communicationrecord (crId, pIDCard, dID, crText, crTime, crTexter) VALUES (#{crId}, #{pIDCard}, #{dID}, #{crText}, #{crTime}, #{crTexter})")
//    void insertCommunicationRecord(communicationrecord record);
    @Insert("INSERT INTO communicationrecord (pIDCard, dID, crText, crTime, crTexter, crType) VALUES (#{pIDCard}, #{dID}, #{crText}, #{crTime}, #{crTexter}, #{crType})")
    void insertCommunicationRecord(communicationrecord record);


    // 根据ID选择通讯记录
    @Select("SELECT * FROM communicationrecord WHERE crId = #{crId}")
    communicationrecord selectCommunicationRecordById(int crId);

    // 选择所有通讯记录
    @Select("SELECT * FROM communicationrecord")
    List<communicationrecord> selectAllCommunicationRecords();

    // 更新通讯记录
    @Update("UPDATE communicationrecord SET pIDCard = #{pIDCard}, dID = #{dID}, crText = #{crText}, crTime = #{crTime}, crTexter = #{crTexter}, crType = #{crType} WHERE crId = #{crId}")
    void updateCommunicationRecord(communicationrecord record);

    // 删除通讯记录
    @Delete("DELETE FROM communicationrecord WHERE crId = #{crId}")
    void deleteCommunicationRecord(int crId);


    // diagnosis request 操作
    @Insert("INSERT INTO diagnosisrequest (drId, dId, Image, pIDCard, ModelName, requestTime) VALUES (#{drId}, #{dId}, #{Image}, #{pIDCard}, #{ModelName}, #{requestTime})")
    void insertDiagnosisRequest(diagnosisrequest request);

    @Select("SELECT * FROM diagnosisrequest WHERE drId = #{drId}")
    diagnosisrequest findDiagnosisRequestById(int drId);

    @Select("SELECT * FROM diagnosisrequest WHERE pIDCard = #{pIDCard}")
    List<diagnosisrequest> findDiagnosisRequestsByPIDCard(String pIDCard);
    @Select("SELECT Image, drId FROM diagnosisrequest WHERE pIDCard = #{pIDCard}")
    List<Map<String, Object>> findImagesByPIDCard(String pIDCard);




    // image type 操作
    @Insert("INSERT INTO imagetype (ImageTypeId, ImageTypeName) VALUES (#{ImageTypeId}, #{ImageTypeName})")
    void insertImageType(imagetype imageType);

    @Select("SELECT * FROM imagetype WHERE ImageTypeId = #{imageTypeId}")
    imagetype findImageTypeById(int imageTypeId);

    @Select("<script>" +
            "select * from imagetype" +
            "<where>" +
            "  <if test='typeName != null'>AND ImageTypeName = #{typeName}</if>" +
            "</where>" +
            "limit #{limit} offset #{offset}" +
            "</script>")
    List<imagetype> findImageTypeByPage(@Param("offset") int offset,
                                        @Param("limit") int limit,
                                        @Param("typeName") String typeName);


    // stage  操作
    @Insert("INSERT INTO stage (StageId, StageName) VALUES (#{StageId}, #{StageName})")
    void insertStage(stage Stage);

    @Select("SELECT * FROM stage WHERE StageId = #{stageId}")
    stage findStageById(int stageId);
    @Select("<script>" +
            "select * from stage" +
            "<where>" +
            "  <if test='stageName != null'>AND StageName = #{stageName}</if>" +
            "</where>" +
            "limit #{limit} offset #{offset}" +
            "</script>")
    List<stage> findStageByPage(@Param("offset") int offset,
                                @Param("limit") int limit,
                                @Param("stageName") String stageName);


    // predictfeedback操作
    @Insert("INSERT INTO predictfeedback (PredictFeedbackId, ImageTypeId, StageId, ModelName, PredictFeedbackComment, drId, ModelResult) VALUES (#{PredictFeedbackId}, #{ImageTypeId}, #{StageId}, #{ModelName}, #{PredictFeedbackComment}, #{drId}, #{ModelResult})")
    void insertPredictFeedback(predictfeedback feedback);
    @Select("SELECT * FROM predictfeedback WHERE PredictFeedbackId = #{PredictFeedbackId}")
    predictfeedback findPredictFeedbackById(int PredictFeedbackId);
    @Select("SELECT * FROM predictfeedback WHERE drId = #{drId}")
    predictfeedback findPredictFeedbackByDrId(int drId);
    @Update("UPDATE predictfeedback SET generalComment = #{generalComment} WHERE PredictFeedbackId = #{PredictFeedbackId}")
    void updateGeneralComment(int generalComment, int PredictFeedbackId);
    @Update("UPDATE predictfeedback SET PredictFeedbackComment = #{PredictFeedbackComment} WHERE PredictFeedbackId = #{PredictFeedbackId}")
    void updateComment(String PredictFeedbackComment, int PredictFeedbackId);


    // model操作
    @Insert("INSERT INTO model (ModelName, StageId, ImageTypeId, api_path) VALUES (#{ModelName}, #{StageId}, #{ImageTypeId}, #{apiPath})")
    void insertModel(model model);

    @Select("SELECT * FROM model WHERE ModelName = #{ModelName}")
    model findModelByName(String ModelName);

    @Select("<script>" +
            "select * from model" +
            "<where>" +
            "  <if test='stageId != null'>AND StageId = #{stageId}</if>" +
            "  <if test='imageTypeId != null'>AND ImageTypeId = #{imageTypeId}</if>" +
            "</where>" +
            "limit #{limit} offset #{offset}" +
            "</script>")
    List<model> findModelByPage(@Param("offset") int offset,
                                @Param("limit") int limit,
                                @Param("stageId") Integer stageId,
                                @Param("imageTypeId") Integer imageTypeId);


    @Select("SELECT COUNT(*) FROM model WHERE SUBSTRING(modelName, 1, 7) = #{month}")
    Long countModelsByMonth(@Param("month") String month);


    // patientfeedback 操作
    @Insert("INSERT INTO patientfeedback (dID,pIDCard, pfTime, PatientFeedbackComment, pfLikesCount, pfComentText) VALUES (#{dID},#{pIDCard}, #{pfTime}, #{PatientFeedbackComment}, #{pfLikesCount}, #{pfComentText})")
    void insertPatientFeedback(patientfeedback patientFeedback);


    @Select("SELECT * FROM patientfeedback WHERE PatientFeedbackId = #{PatientFeedbackId}")
    patientfeedback findPatientFeedbackById(int PatientFeedbackId);

    @Select("<script>" +
            "SELECT pf.*, pi.pName, pi.pPicture " +
            "FROM patientfeedback pf " +
            "JOIN pinfo pi ON pf.pIDCard = pi.pIDCard " +
            "<where> " +
            "  <if test='dID != null'>AND pf.dID = #{dID}</if> " +
            "</where> " +
            "</script>")
    List<PatientFeedbackDetail> findPatientFeedbackByDid(@Param("dID") String dID);





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

