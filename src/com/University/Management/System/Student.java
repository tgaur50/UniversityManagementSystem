package com.University.Management.System;

public class Student {
    private long rollNum;
    private String name;
    private String fatherName;
    private String dob;
    private String address;
    private long phone;
    private String emailId;
    private double classX;
    private double classXII;
    private String aadhaarNo;
    private String course;
    private String branch;

    public Student(){}
    public Student(long rollNum, String name, String fatherName, String dob,
                   String address, long phone, String emailId, double classX, double classXII,
                   String aadhaarNo, String course, String branch){
        this.rollNum = rollNum;
        this.name = name;
        this.fatherName = fatherName;
        this.dob = dob;
        this.address = address;
        this.phone = phone;
        this.emailId = emailId;
        this.classX = classX;
        this.classXII = classXII;
        this.aadhaarNo = aadhaarNo;
        this.course = course;
        this.branch = branch;
    }

    public long getRollNum() {
        return rollNum;
    }

    public void setRollNum(long rollNum) {
        this.rollNum = rollNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public double getClassX() {
        return classX;
    }

    public void setClassX(double classX) {
        this.classX = classX;
    }

    public double getClassXII() {
        return classXII;
    }

    public void setClassXII(double classXII) {
        this.classXII = classXII;
    }

    public String getAadhaarNo() {
        return aadhaarNo;
    }

    public void setAadhaarNo(String aadhaarNo) {
        this.aadhaarNo = aadhaarNo;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }
}
