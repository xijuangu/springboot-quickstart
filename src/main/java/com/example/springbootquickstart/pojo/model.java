package com.example.springbootquickstart.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "model")
public class model {

    @Id
    @Column(length = 20)
    private String ModelName;

    @Column
    private int StageId;

    @Column
    private int ImageTypeId;

    private String apiPath;



    // Getter and setter

    public String getModelName() {
        return ModelName;
    }

    public void setModelName(String modelName) {
        this.ModelName = modelName;
    }

    public int getStageId() {
        return StageId;
    }

    public void setStageId(int stageId) {
        this.StageId = stageId;
    }

    public int getImageTypeId() {
        return ImageTypeId;
    }

    public void setImageTypeId(int imageTypeId) {
        this.ImageTypeId = imageTypeId;
    }

    public String getApiPath() {
        return apiPath;
    }

    public void setApiPath(String apiPath) {
        this.apiPath = apiPath;
    }

}
