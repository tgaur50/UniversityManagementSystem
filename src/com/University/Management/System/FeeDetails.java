package com.University.Management.System;

public class FeeDetails {
    private String course;
    private int semester1Fee;
    private int semester2Fee;
    private int semester3Fee;
    private int semester4Fee;
    private int semester5Fee;
    private int semester6Fee;
    private int semester7Fee;
    private int semester8Fee;
    public FeeDetails(){}

    public FeeDetails(String course, int semester1Fee, int semester2Fee,
                      int semester3Fee, int semester4Fee, int semester5Fee,
                      int semester6Fee, int semester7Fee, int semester8Fee) {
        this.course = course;
        this.semester1Fee = semester1Fee;
        this.semester2Fee = semester2Fee;
        this.semester3Fee = semester3Fee;
        this.semester4Fee = semester4Fee;
        this.semester5Fee = semester5Fee;
        this.semester6Fee = semester6Fee;
        this.semester7Fee = semester7Fee;
        this.semester8Fee = semester8Fee;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getSemester1Fee() {
        return semester1Fee;
    }

    public void setSemester1Fee(int semester1Fee) {
        this.semester1Fee = semester1Fee;
    }

    public int getSemester2Fee() {
        return semester2Fee;
    }

    public void setSemester2Fee(int semester2Fee) {
        this.semester2Fee = semester2Fee;
    }

    public int getSemester3Fee() {
        return semester3Fee;
    }

    public void setSemester3Fee(int semester3Fee) {
        this.semester3Fee = semester3Fee;
    }

    public int getSemester4Fee() {
        return semester4Fee;
    }

    public void setSemester4Fee(int semester4Fee) {
        this.semester4Fee = semester4Fee;
    }

    public int getSemester5Fee() {
        return semester5Fee;
    }

    public void setSemester5Fee(int semester5Fee) {
        this.semester5Fee = semester5Fee;
    }

    public int getSemester6Fee() {
        return semester6Fee;
    }

    public void setSemester6Fee(int semester6Fee) {
        this.semester6Fee = semester6Fee;
    }

    public int getSemester7Fee() {
        return semester7Fee;
    }

    public void setSemester7Fee(int semester7Fee) {
        this.semester7Fee = semester7Fee;
    }

    public int getSemester8Fee() {
        return semester8Fee;
    }

    public void setSemester8Fee(int semester8Fee) {
        this.semester8Fee = semester8Fee;
    }
}
