//UserMapper.java

package com.example.springbootquickstart.mapper;

import com.example.springbootquickstart.pojo.dinfo;
import com.example.springbootquickstart.pojo.pinfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

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
}

