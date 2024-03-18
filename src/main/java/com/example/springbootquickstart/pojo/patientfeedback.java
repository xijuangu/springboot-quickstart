package com.example.springbootquickstart.pojo;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Lob;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Entity
@Table(name = "patientfeedback")
public class patientfeedback {

    @Id
    @Column(length = 255)
    private String PatientFeedbackId;

    @Column(length = 18)
    private String pIDCard;

    @Temporal(TemporalType.TIMESTAMP)
    private Date pfTime;

    @Column(length = 10)
    private String PatientFeedbackComment;

    @Column
    private int pfLikesCount;

    @Lob
    private String pfComentText;

    // Getter and setter methods

    public String getPatientFeedbackId() {
        return PatientFeedbackId;
    }

    public void setPatientFeedbackId(String patientFeedbackId) {
        PatientFeedbackId = patientFeedbackId;
    }

    public String getPIDCard() {
        return pIDCard;
    }

    public void setPIDCard(String pIDCard) {
        this.pIDCard = pIDCard;
    }

    public Date getPfTime() {
        return pfTime;
    }

    public void setPfTime(Date pfTime) {
        this.pfTime = pfTime;
    }

    public String getPatientFeedbackComment() {
        return PatientFeedbackComment;
    }

    public void setPatientFeedbackComment(String patientFeedbackComment) {
        this.PatientFeedbackComment = patientFeedbackComment;
    }

    public int getPfLikesCount() {
        return pfLikesCount;
    }

    public void setPfLikesCount(int pfLikesCount) {
        this.pfLikesCount = pfLikesCount;
    }

    public String getPfCommentText() {
        return pfComentText;
    }

    public void setPfComentText(String pfCommentText) {
        this.pfComentText = pfCommentText;
    }
}