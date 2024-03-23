package com.example.springbootquickstart.pojo;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "SendPicture")
public class SendPicture {

    @Id
    private int sp_id;

    @Lob
    private byte[] sp_picture;

    @Column(length = 18)
    private String pIDCard;

    @Column(length = 20)
    private String dID;

    @Temporal(TemporalType.TIMESTAMP)
    private Date sp_time;

    private Integer sender;

    // setter and getter

    public int getSp_id() {
        return sp_id;
    }

    public void setSp_id(int sp_id) {
        this.sp_id = sp_id;
    }

    public byte[] getSp_picture() {
        return sp_picture;
    }

    public void setSp_picture(byte[] sp_picture) {
        this.sp_picture = sp_picture;
    }

    public String getpIDCard() {
        return pIDCard;
    }

    public void setpIDCard(String pIDCard) {
        this.pIDCard = pIDCard;
    }

    public String getdID() {
        return dID;
    }

    public void setdID(String dID) {
        this.dID = dID;
    }

    public Date getSp_time() {
        return sp_time;
    }

    public void setSp_time(Date sp_time) {
        this.sp_time = sp_time;
    }

    public Integer getSender() {
        return sender;
    }

    public void setSender(Integer sender) {
        this.sender = sender;
    }

}
