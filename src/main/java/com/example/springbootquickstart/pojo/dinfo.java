//dinfo.java

package com.example.springbootquickstart.pojo;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "dInfo")
public class dinfo {
    @Id
    @Column(length = 20)
    private String dId;

    @Column(length = 30)
    private String dName;

    @Column(length = 10)
    private String dGender;

    @Column(length = 50)
    private String dHospital;

    @Temporal(TemporalType.DATE)
    private Date dWorkTime;

    @Column(length = 30)
    private String dJob;

    @Lob
    private String dStrength;

    @Lob
    private String dIntroduction;

    @Column(length = 20)
    private String patientFeedbackId;

    @Lob
    private byte[] dPicture;

    @Column(length = 255)
    private String dPasswordHash;

    // Getters and Setters

    public String getDId() {
        return dId;
    }

    public void setDId(String dId) {
        this.dId = dId;
    }

    public String getDName() {
        return dName;
    }

    public void setDName(String dName) {
        this.dName = dName;
    }

    public String getDGender() {
        return dGender;
    }

    public void setDGender(String dGender) {
        this.dGender = dGender;
    }

    public String getDHospital() {
        return dHospital;
    }

    public void setDHospital(String dHospital) {
        this.dHospital = dHospital;
    }

    public Date getDWorkTime() {
        return dWorkTime;
    }

    public void setDWorkTime(Date dWorkTime) {
        this.dWorkTime = dWorkTime;
    }

    public String getDJob() {
        return dJob;
    }

    public void setDJob(String dJob) {
        this.dJob = dJob;
    }

    public String getDStrength() {
        return dStrength;
    }

    public void setDStrength(String dStrength) {
        this.dStrength = dStrength;
    }

    public String getDIntroduction() {
        return dIntroduction;
    }

    public void setDIntroduction(String dIntroduction) {
        this.dIntroduction = dIntroduction;
    }

    public String getPatientFeedbackId() {
        return patientFeedbackId;
    }

    public void setPatientFeedbackId(String patientFeedbackId) {
        this.patientFeedbackId = patientFeedbackId;
    }

    public byte[] getDPicture() {
        return dPicture;
    }

    public void setDPicture(byte[] dPicture) {
        this.dPicture = dPicture;
    }

    public String getDPasswordHash() {
        return dPasswordHash;
    }

    public void setDPasswordHash(String dPasswordHash) {
        this.dPasswordHash = dPasswordHash;
    }
}
