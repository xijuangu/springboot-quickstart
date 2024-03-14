package com.example.springbootquickstart.pojo;

import javax.persistence.*;

@Entity
@Table(name = "stage")
public class stage {

    @Id
    private int StageId;

    private String StageName;


    // Getter and Setter
    public int getStageId() {
        return StageId;
    }

    public void setStageId(int stageId) {
        StageId = stageId;
    }

    public String getStageName() {
        return StageName;
    }

    public void setStageName(String stageName) {
        StageName = stageName;
    }
}
