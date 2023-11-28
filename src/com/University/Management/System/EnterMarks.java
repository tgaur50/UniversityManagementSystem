package com.University.Management.System;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class EnterMarks extends JFrame {
    public EnterMarks(){
        JLabel heading = new JLabel("Enter marks of Student");
        heading.setFont(new Font("Arial", Font.BOLD, 16));
        heading.setBounds(40, 30, 200, 30);
        add(heading);

        JLabel searchByRollNo = new JLabel("Search Roll Number");
        searchByRollNo.setFont(new Font("Arial", Font.BOLD, 13));
        searchByRollNo.setBounds(40, 90, 150, 30);
        add(searchByRollNo);

        StudentDetailsDao std = new StudentDetailsDao();

        List<Student> listOfStudents = std.getStudent();
        String[] studentsRollNum = new String[listOfStudents.size()];
        int index = 0;
        for (Student st : listOfStudents){
            studentsRollNum[index++] = String.valueOf(st.getRollNum());
        }
        JComboBox<String> rollNumsMenu = new JComboBox<>(studentsRollNum);
        rollNumsMenu.setFont(new Font("Arial", Font.BOLD, 13));
        rollNumsMenu.setBounds(200, 90, 180, 30);
        add(rollNumsMenu);

        JLabel semester = new JLabel("Select Semester");
        semester.setFont(new Font("Arial", Font.BOLD, 13));
        semester.setBounds(40, 140, 150, 30);
        add(semester);

        String[] semesters = {"1st Semester", "2nd Semester", "3rd Semester", "4th Semester",
                "5th Semester", "6th Semester", "7th Semester", "8th Semester"};
        JComboBox<String> semesterMenu = new JComboBox<>(semesters);
        semesterMenu.setFont(new Font("Arial", Font.BOLD, 13));
        semesterMenu.setBounds(200, 140, 180, 30);
        add(semesterMenu);

        JLabel subjHeading = new JLabel("Enter Subject");
        subjHeading.setFont(new Font("Arial", Font.BOLD, 13));
        subjHeading.setBounds(90, 180, 100, 30);
        add(subjHeading);

        JLabel marksHeading = new JLabel("Enter Marks");
        marksHeading.setFont(new Font("Arial", Font.BOLD, 13));
        marksHeading.setBounds(320, 180, 100, 30);
        add(marksHeading);

        JTextField sub1 = new JTextField();
        sub1.setFont(new Font("Arial", Font.BOLD, 13));
        sub1.setBounds(40, 220, 220, 30);
        add(sub1);

        JTextField marks1 = new JTextField();
        marks1.setFont(new Font("Arial", Font.BOLD, 13));
        marks1.setBounds(254, 220, 220, 30);
        add(marks1);

        JTextField sub2 = new JTextField();
        sub2.setFont(new Font("Arial", Font.BOLD, 13));
        sub2.setBounds(40, 255, 220, 30);
        add(sub2);

        JTextField marks2 = new JTextField();
        marks2.setFont(new Font("Arial", Font.BOLD, 13));
        marks2.setBounds(254, 255, 220, 30);
        add(marks2);

        JTextField sub3 = new JTextField();
        sub3.setFont(new Font("Arial", Font.BOLD, 13));
        sub3.setBounds(40, 290, 220, 30);
        add(sub3);

        JTextField marks3 = new JTextField();
        marks3.setFont(new Font("Arial", Font.BOLD, 13));
        marks3.setBounds(254, 290, 220, 30);
        add(marks3);

        JTextField sub4 = new JTextField();
        sub4.setFont(new Font("Arial", Font.BOLD, 13));
        sub4.setBounds(40, 325, 220, 30);
        add(sub4);

        JTextField marks4 = new JTextField();
        marks4.setFont(new Font("Arial", Font.BOLD, 13));
        marks4.setBounds(254, 325, 220, 30);
        add(marks4);

        JTextField sub5 = new JTextField();
        sub5.setFont(new Font("Arial", Font.BOLD, 13));
        sub5.setBounds(40, 360, 220, 30);
        add(sub5);

        JTextField marks5 = new JTextField();
        marks5.setFont(new Font("Arial", Font.BOLD, 13));
        marks5.setBounds(254, 360, 220, 30);
        add(marks5);

        JButton submit = new JButton("Submit");
        submit.setFont(new Font("Arial", Font.BOLD, 12));
        submit.setOpaque(true);
        submit.setBorderPainted(false);
        submit.setForeground(Color.WHITE);
        submit.setBackground(Color.BLACK);
        submit.setBounds(70, 410, 150, 25);
        add(submit);

        JButton back = new JButton("Back");
        back.setFont(new Font("Arial", Font.BOLD, 12));
        back.setOpaque(true);
        back.setBorderPainted(false);
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        back.setBounds(285, 410, 150, 25);
        add(back);

        submit.addActionListener(e -> {
            String rollNum = String.valueOf(rollNumsMenu.getSelectedItem());
            String semesterVal = String.valueOf(semesterMenu.getSelectedItem());
            String sub1Val = sub1.getText();
            String sub2Val = sub2.getText();
            String sub3Val = sub3.getText();
            String sub4Val = sub4.getText();
            String sub5Val = sub5.getText();

            String marks1Val = marks1.getText();
            String marks2Val = marks2.getText();
            String marks3Val = marks3.getText();
            String marks4Val = marks4.getText();
            String marks5Val = marks5.getText();

            Validation val = new Validation();
            String error = "";
            if (!val.checkRollNo(rollNum)){
                error += "Invalid Roll Number\n";
            }
            if (!val.checkMarks(marks1Val)){
                error += "Invalid " + sub1Val + " marks!\n";
            }
            if (!val.checkMarks(marks2Val)){
                error += "Invalid " + sub2Val + " marks!\n";
            }
            if (!val.checkMarks(marks3Val)){
                error += "Invalid " + sub3Val + " marks!\n";
            }
            if (!val.checkMarks(marks4Val)){
                error += "Invalid " + sub4Val + " marks!\n";
            }
            if (!val.checkMarks(marks5Val)){
                error += "Invalid " + sub5Val + " marks!\n";
            }
            if (error.equals("")){
                if (std.insertStudentMarks(Long.parseLong(rollNum), semesterVal, sub1Val, sub2Val, sub3Val,
                        sub4Val, sub5Val, marks1Val, marks2Val, marks3Val, marks4Val, marks5Val) != 0){
                    JOptionPane.showMessageDialog(null, "Marks Inserted successfully!");
                    dispose();
                }
                else {
                    JOptionPane.showMessageDialog(null, "Technical Error!");
                }
            }
            else {
                JOptionPane.showMessageDialog(null, error);
            }
        });

        back.addActionListener(e -> dispose());

        ImageIcon imgIcon = new ImageIcon(ClassLoader.getSystemResource("icons/exam.jpg"));
        Image img = imgIcon.getImage().getScaledInstance(500, 330, Image.SCALE_DEFAULT);
        ImageIcon ic = new ImageIcon(img);
        JLabel imgLabel = new JLabel(ic);
        imgLabel.setBounds(500, 60, 500, 330);
        add(imgLabel);
        setLocation(180, 150);
        setSize(1100, 540);
        setLayout(null);
        setVisible(true);
    }
    public static void main(String[] args){new EnterMarks();}
}
