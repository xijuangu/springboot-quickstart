package com.example.springbootquickstart.pojo;

import javax.persistence.*;

@Entity
@Table(name = "diagnosisrequest")
public class diagnosisrequest {

    @Id
    private int drId;

    @Column(length = 20)
    private String dId;

    private int ImageTypeId;

    private int StageId;

    @Lob
    private String Image;

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

    // Getter and setter for ImageTypeId
    public int getImageTypeId() {
        return ImageTypeId;
    }

    public void setImageTypeId(int ImageTypeId) {
        this.ImageTypeId = ImageTypeId;
    }

    // Getter and setter for StageId
    public int getStageId() {
        return StageId;
    }

    public void setStageId(int StageId) {
        this.StageId = StageId;
    }

    // Getter and setter for Image
    public String getImage() {
        return Image;
    }

    public void setImage(String Image) {
        this.Image = Image;
    }

}
