package com.example.springbootquickstart.pojo;

public class PatientFeedbackDetail extends patientfeedback { // 或者不继承，如果你不需要
    private String pName;
    private byte[] pPicture;

    // getter和setter
    public String getPName() {
        return pName;
    }

    public void setPName(String pName) {
        this.pName = pName;
    }

    public byte[] getPPicture() {
        return pPicture;
    }

    public void setPPicture(byte[] pPicture) {
        this.pPicture = pPicture;
    }
}

