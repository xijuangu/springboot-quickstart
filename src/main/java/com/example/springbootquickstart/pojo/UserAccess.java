package com.example.springbootquickstart.pojo;

import java.time.LocalDateTime;

public class UserAccess {
    private Integer id;
    private Integer userId;
    private String userType;
    private LocalDateTime accessTime;

    // Constructors
    public UserAccess() {}

    public UserAccess(Integer userId, String userType, LocalDateTime accessTime) {
        this.userId = userId;
        this.userType = userType;
        this.accessTime = accessTime;
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public LocalDateTime getAccessTime() {
        return accessTime;
    }

    public void setAccessTime(LocalDateTime accessTime) {
        this.accessTime = accessTime;
    }
}
