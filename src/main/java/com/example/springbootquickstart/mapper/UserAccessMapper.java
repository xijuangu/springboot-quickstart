package com.example.springbootquickstart.mapper;

import com.example.springbootquickstart.pojo.UserAccess;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import java.time.LocalDateTime;


@Mapper
public interface UserAccessMapper {

    @Insert("INSERT INTO user_access(user_id, user_type, access_time) VALUES(#{userId}, #{userType}, #{accessTime})")
    void insertAccessRecord(UserAccess userAccess);

    @Select("SELECT COUNT(*) FROM user_access WHERE user_type = #{userType} AND access_time BETWEEN #{startTime} AND #{endTime}")
    int countAccessByUserTypeAndTime(@Param("userType") String userType, @Param("startTime") LocalDateTime startTime, @Param("endTime") LocalDateTime endTime);
}