//communicationrecord.java

package com.example.springbootquickstart.pojo;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "communicationrecord")
public class communicationrecord {

    @Id
    private int crId;
    @Column(length = 18)
    private String pIDCard;

    @Column(length = 20)
    private String dID;

    @Column(length = 255)
    private String crType;

    @Lob
    private String crText;

    @Temporal(TemporalType.DATE)
    private Date crTime;

    private String crTexter;

    // setter and getter

    public void setCrId(int crId) {
        this.crId = crId;
    }

    public int getCrId() {
        return crId;
    }

    public void setpIDCard(String pIDCard) {
        this.pIDCard = pIDCard;
    }

    public String getpIDCard() {
        return pIDCard;
    }

    public void setdID(String dID) { this.dID = dID; }

    public String getdID() {
        return dID;
    }

    public String getCrType() {
        return crType;
    }

    public void setCrType(String crType) {
        this.crType = crType;
    }

    public void setCrTime(Date crTime) {
        this.crTime = crTime;
    }

    public Date getCrTime() {
        return crTime;
    }

    public String getCrText() {
        return crText;
    }

    public void setCrText(String crText) {
        this.crText = crText;
    }

    public String getCrTexter() {
        return crTexter;
    }

    public void setCrTexter(String crTexter) {
        this.crTexter = crTexter;
    }

}
