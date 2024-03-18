package com.example.springbootquickstart.pojo;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "predictfeedback")
public class predictfeedback {

    @Id
    private int PredictFeedbackId;

    @Column
    private int ImageTypeId;

    @Column
    private int StageId;

    @Column(length = 20)
    private String ModelName;

    @Column(length = 10)
    private String PredictFeedbackComment;

    @Column
    private int drId;

    @Column
    private boolean ModelResult;

    // setter and getter methods

    public int getPredictFeedbackId() {
        return PredictFeedbackId;
    }

    public void setPredictFeedbackId(int predictFeedbackId) {
        PredictFeedbackId = predictFeedbackId;
    }

    public int getImageTypeId() {
        return ImageTypeId;
    }

    public void setImageTypeId(int imageTypeId) {
        ImageTypeId = imageTypeId;
    }

    public int getStageId() {
        return StageId;
    }

    public void setStageId(int stageId) {
        StageId = stageId;
    }

    public String getModelName() {
        return ModelName;
    }

    public void setModelName(String modelName) {
        ModelName = modelName;
    }

    public String getPredictFeedbackComment() {
        return PredictFeedbackComment;
    }

    public void setPredictFeedbackComment(String predictFeedbackComment) {
        PredictFeedbackComment = predictFeedbackComment;
    }

    public int getDrId() {
        return drId;
    }

    public void setDrId(int drId) {
        this.drId = drId;
    }

    public boolean getModelResult() {
        return ModelResult;
    }

    public void setModelResult(boolean modelResult) {
        ModelResult = modelResult;
    }

}
