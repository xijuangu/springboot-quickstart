//pinfo.java

package com.example.springbootquickstart.pojo;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class pinfo {
    @Id
    private String pIDCard;
    private String pName;
    private String pGender;
    private String pPhone;
    private String pAddress;
    private Integer pHistory;
    private Integer pOther;
    private Integer pFamily;
    private String pOtherInfo;
    private String pFamilyInfo;
    private String pSymptom;
    private byte[] pPicture;
    private String pPasswordHash;


    public void setpIDCard(String id) {
        this.pIDCard = id;
    }

    public String getpIDCard() {
        return pIDCard;
    }

    public void setpName(String name) {
        this.pName = name;
    }

    public String getpName() {
        return pName;
    }

    public void setpGender(String pGender) {
        this.pGender = pGender;
    }

    public String getpGender() {
        return pGender;
    }

    public void setpPhone(String phone) {
        this.pPhone = phone;
    }

    public String getpPhone() {
        return pPhone;
    }

    public void setpAddress(String address) {
        this.pAddress = address;
    }

    public String getpAddress() {
        return pAddress;
    }

    // 在 pinfo 类中添加以下 getter 和 setter 方法

    public Integer getpHistory() {
        return pHistory;
    }

    public void setpHistory(Integer pHistory) {
        this.pHistory = pHistory;
    }

    public Integer getpOther() {
        return pOther;
    }

    public void setpOther(Integer pOther) {
        this.pOther = pOther;
    }

    public Integer getpFamily() {
        return pFamily;
    }

    public void setpFamily(Integer pFamily) {
        this.pFamily = pFamily;
    }

    public String getpOtherInfo() {
        return pOtherInfo;
    }

    public void setpOtherInfo(String pOtherInfo) {
        this.pOtherInfo = pOtherInfo;
    }

    public String getpFamilyInfo() {
        return pFamilyInfo;
    }

    public void setpFamilyInfo(String pFamilyInfo) {
        this.pFamilyInfo = pFamilyInfo;
    }

    public String getpSymptom() {
        return pSymptom;
    }

    public void setpSymptom(String pSymptom) {
        this.pSymptom = pSymptom;
    }

    public byte[] getpPicture() {
        return pPicture;
    }

    public void setpPicture(byte[] pPicture) {
        this.pPicture = pPicture;
    }

    public String getpPasswordHash() {
        return pPasswordHash;
    }

    public void setpPasswordHash(String pPasswordHash) {
        this.pPasswordHash = pPasswordHash;
    }

}
