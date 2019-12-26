package com.softwarica.esoftwarica.Models;

public class Students {

    private int imageId;
    private String fullname;
    private String gender;
    private String age;
    private String address;


    public Students(String fullname, String gender, String age, String address) {
        this.imageId = imageId;
        this.fullname = fullname;
        this.gender = gender;
        this.age = age;
        this.address = address;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
