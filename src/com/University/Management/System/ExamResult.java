package com.University.Management.System;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ExamResult extends JFrame {
    public ExamResult(String rollNumValue) {
        String semesterFieldVal = "", sub1Val = "", sub2Val = "", sub3Val = "", sub4Val = "",
                sub5Val = "";
        double marks1Val = 0.0, marks2Val = 0.0, marks3Val = 0.0, marks4Val = 0.0, marks5Val = 0.0;
        StudentDetailsDao std = new StudentDetailsDao();
        ResultSet rs = std.getStudentResult(Long.parseLong(rollNumValue));
        while (true){
            try {
                if (!rs.next()) break;
                else {
                    semesterFieldVal = rs.getString(2);
                    sub1Val = rs.getString(3);
                    sub2Val = rs.getString(4);
                    sub3Val = rs.getString(5);
                    sub4Val = rs.getString(6);
                    sub5Val = rs.getString(7);
                    marks1Val = rs.getDouble(8);
                    marks2Val = rs.getDouble(9);
                    marks3Val = rs.getDouble(10);
                    marks4Val = rs.getDouble(11);
                    marks5Val = rs.getDouble(12);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        JLabel heading = new JLabel("Delhi Technical University");
        heading.setFont(new Font("Arial", Font.BOLD, 18));
        heading.setBounds(100, 20, 250, 30);
        add(heading);

        JLabel subheadig = new JLabel("Result of Examination 2023");
        subheadig.setFont(new Font("Arial", Font.BOLD, 16));
        subheadig.setBounds(100, 50, 250, 30);
        add(subheadig);

        JLabel rollNumVal = new JLabel("Roll Number:\t" + rollNumValue );
        rollNumVal.setFont(new Font("Arial", Font.PLAIN, 14));
        rollNumVal.setBounds(50, 90, 200, 30);
        add(rollNumVal);

        JLabel semesterVal = new JLabel("Semester:\t" + semesterFieldVal);
        semesterVal.setFont(new Font("Arial", Font.PLAIN, 14));
        semesterVal.setBounds(50, 120, 200, 30);
        add(semesterVal);

        JLabel subandmarksone = new JLabel(sub1Val + "--------------------------" + marks1Val);
        subandmarksone.setFont(new Font("Arial", Font.PLAIN, 14));
        subandmarksone.setBounds(100, 180, 300, 30);
        add(subandmarksone);

        JLabel subandmarkstwo = new JLabel(sub2Val + "--------------------------" + marks2Val);
        subandmarkstwo.setFont(new Font("Arial", Font.PLAIN, 14));
        subandmarkstwo.setBounds(100, 210, 300, 30);
        add(subandmarkstwo);

        JLabel subandmarksthree = new JLabel(sub3Val + "--------------------------" + marks3Val);
        subandmarksthree.setFont(new Font("Arial", Font.PLAIN, 14));
        subandmarksthree.setBounds(100, 240, 300, 30);
        add(subandmarksthree);

        JLabel subandmarksfour = new JLabel(sub4Val + "--------------------------" + marks4Val);
        subandmarksfour.setFont(new Font("Arial", Font.PLAIN, 14));
        subandmarksfour.setBounds(100, 270, 300, 30);
        add(subandmarksfour);

        JLabel subandmarksfive = new JLabel(sub5Val + "--------------------------" + marks5Val);
        subandmarksfive.setFont(new Font("Arial", Font.PLAIN, 14));
        subandmarksfive.setBounds(100, 300, 300, 30);
        add(subandmarksfive);

        JButton back = new JButton("Back");
        back.setFont(new Font("Arial", Font.BOLD, 13));
        back.setOpaque(true);
        back.setFocusPainted(false);
        back.setBorderPainted(false);
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        back.setBounds(250, 400, 130, 30);
        add(back);

        back.addActionListener(e -> dispose());

        setLocation(500, 100);
        setSize(450, 500);
        setLayout(null);
        setVisible(true);
    }
    public static void main(String[] args){
//        new ExamResult();
    }
}
