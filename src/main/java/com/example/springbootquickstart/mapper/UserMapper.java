//UserMapper.java

package com.example.springbootquickstart.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Select("select name from user where id = #{id}")
    public String FindNameById(Integer id);

    @Select("select address from user where id = #{id}")
    public String FindAddressById(Integer id);

    @Select("select pName from pinfo where pIDCard = #{pIDCard}")
    public String FindpNameBypIdCard(String pIDCard);

    @Select("select pHistory from pinfo where pIDCard = #{pIDCard}")
    public Boolean FindHistoryBypIdCard(String pIDCard);

    @Select("select pOther from pinfo where pIDCard = #{pIDCard}")
    public Boolean FindOtherBypIdCard(String pIDCard);

    @Select("select pFamily from pinfo where pIDCard = #{pIDCard}")
    public Boolean FindFamilyBypIdCard(String pIDCard);

    @Select("select pOtherInfo from pinfo where pIDCard = #{pIDCard}")
    public String FindOtherInfoBypIdCard(String pIDCard);

    @Select("select pFamilyInfo from pinfo where pIDCard = #{pIDCard}")
    public String FindFamilyInfoBypIdCard(String pIDCard);

    @Select("select pSymptom from pinfo where pIDCard = #{pIDCard}")
    public String FindSymptomBypIdCard(String pIDCard);

    @Select("select pPicture from pinfo where pIDCard = #{pIDCard}")
    public byte[] FindPictureBypIdCard(String pIDCard);

    @Select("select pPasswordHash from pinfo where pIDCard = #{pIDCard}")
    public String FindPasswordHashBypIdCard(String pIDCard);
}

