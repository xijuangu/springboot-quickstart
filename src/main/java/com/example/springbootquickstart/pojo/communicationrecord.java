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

    @Lob
    private String crText;

    @Temporal(TemporalType.DATE)
    private Date crTime;

    private Integer crTexter;

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

    public Integer getCrTexter() {
        return crTexter;
    }

    public void setCrTexter(Integer crTexter) {
        this.crTexter = crTexter;
    }

}
