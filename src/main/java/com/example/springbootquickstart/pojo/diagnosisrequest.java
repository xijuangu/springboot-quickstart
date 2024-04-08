// diagnosisrequest.java

package com.example.springbootquickstart.pojo;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "diagnosisrequest")
@JsonIgnoreProperties(ignoreUnknown = true) // 添加此行来忽略未知属性
public class diagnosisrequest {
    @Id
    private int drId;

    @Column(length = 20)
    private String dId;

    private int operationFlag;

    private String ModelName;

    @Column(length = 18)
    private String pIDCard;

    @Lob
    private String Image; // 保持不变，因为它将存储JSON字符串


    public String getPIDCard() {
        return pIDCard;
    }

    public void setPIDCard(String pIDCard) {
        this.pIDCard = pIDCard;
    }

    // Getter and setter for drId
    public int getDrId() {
        return drId;
    }

    public void setDrId(int drId) {
        this.drId = drId;
    }

    // Getter and setter for dId
    public String getDId() {
        return dId;
    }

    public void setDId(String dId) {
        this.dId = dId;
    }


    // Getter and setter for StageId
    /*public int getStageId() {
        return StageId;
    }*/

//    public void setStageId(int StageId) {
//        this.StageId = StageId;
//    }

    // Getter and setter for Image
    public String getImage() {
        return Image;
    }

    public void setImage(String Image) {
        this.Image = Image;
    }


    public int getoperationFlag() {
        return operationFlag;
    }

    public void setoperationFlag(int operationFlag) {
        this.operationFlag = operationFlag;
    }


    public String getModelName() {
        return ModelName;
    }

    public void setModelName(String ModelName) {
        this.ModelName = ModelName;
    }

}
