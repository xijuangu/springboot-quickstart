package com.example.springbootquickstart.pojo;

import javax.persistence.*;

@Entity
@Table(name = "imagetype")
public class imagetype {

    @Id
    private int ImageTypeId;

    private String ImageTypeName;

    // Getter and Setter
    public int getImageTypeId() {
        return ImageTypeId;
    }

    public void setImageTypeId(int imageTypeId) {
        ImageTypeId = imageTypeId;
    }

    public String getImageTypeName() {
        return ImageTypeName;
    }

    public void setImageTypeName(String imageTypeName) {
        ImageTypeName = imageTypeName;
    }
}
