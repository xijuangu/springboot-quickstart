package com.example.springbootquickstart.pojo;

public class User {
    
    private Integer id;
    private String name;
    private String address;
    private Short gender;
    private String phone;

    public User() {
    }

    public User(Integer id, String name, String address, Short gender, String phone) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.gender = gender;
        this.phone = phone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAge(String address) {
        this.address = address;
    }

    public Short getGender() {
        return gender;
    }

    public void setGender(Short gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address=" + address +
                ", gender=" + gender +
                ", phone='" + phone + '\'' +
                '}';
    }
}
