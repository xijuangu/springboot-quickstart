package com.example.springbootquickstart.pojo;

public class PatientAgeGroupCount {
    private String ageGroup;  // 表示年龄分组的范围，如"0~18"
    private int count;        // 表示该年龄分组的人数

    // 正确的构造函数使用String和int类型
    public PatientAgeGroupCount(String ageGroup, int count) {
        this.ageGroup = ageGroup;
        this.count = count;
    }

    // Getters and Setters
    public String getAgeGroup() {
        return ageGroup;
    }

    public void setAgeGroup(String ageGroup) {
        this.ageGroup = ageGroup;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}

