package com.University.Management.System;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ApplyStudentLeave extends JFrame {
    public ApplyStudentLeave(){
        JLabel heading = new JLabel("Apply Leave (Student)");
        heading.setFont(new Font("Arial", Font.BOLD, 18));
        heading.setBounds(30, 50, 200, 30);
        add(heading);

        JLabel rollNum = new JLabel("Roll Number");
        rollNum.setFont(new Font("Arial", Font.PLAIN, 14));
        rollNum.setBounds(45, 90, 100, 30);
        add(rollNum);
        StudentDetailsDao std = new StudentDetailsDao();
        List<Student> listOfStudents = std.getStudent();
        String[] studentRollNums = new String[listOfStudents.size()];
        int index = 0;
        for (Student st : listOfStudents){
            studentRollNums[index++] = String.valueOf(st.getRollNum());
        }
        JComboBox<String> rollNumMenu = new JComboBox<>(studentRollNums);
        rollNumMenu.setFont(new Font("Arial", Font.PLAIN, 14));
        rollNumMenu.setBounds(45, 120, 180, 30);
        add(rollNumMenu);

        JLabel date = new JLabel("Date");
        date.setFont(new Font("Arial", Font.PLAIN, 14));
        date.setBounds(45, 170, 100, 30);
        add(date);

        JDateChooser dateField = new JDateChooser();
        dateField.setBounds(45, 200, 180, 30);
        add(dateField);

        JLabel time = new JLabel("Time");
        time.setFont(new Font("Arial", Font.PLAIN, 14));
        time.setBounds(45, 250, 100, 30);
        add(time);

        String[] leaveType = {"Full Day", "Half Day"};

        JComboBox<String> timeField = new JComboBox<>(leaveType);
        timeField.setFont(new Font("Arial", Font.PLAIN, 14));
        timeField.setBounds(45, 280, 180, 30);
        add(timeField);

        JButton submit = new JButton("Submit");
        submit.setFont(new Font("Arial", Font.BOLD, 12));
        submit.setOpaque(true);
        submit.setBorderPainted(false);
        submit.setForeground(Color.WHITE);
        submit.setBackground(Color.BLACK);
        submit.setBounds(45, 340, 100, 25);
        add(submit);

        JButton cancel = new JButton("Cancel");
        cancel.setFont(new Font("Arial", Font.BOLD, 12));
        cancel.setOpaque(true);
        cancel.setBorderPainted(false);
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(Color.BLACK);
        cancel.setBounds(180, 340, 100, 25);
        add(cancel);

        submit.addActionListener(e -> {
            String rollNumVal = String.valueOf(rollNumMenu.getSelectedItem());
            String dateVal = ((JTextField)dateField.getDateEditor().getUiComponent()).getText();
            String timeVal = String.valueOf(timeField.getSelectedItem());
            String error = "";
            if (dateVal.equals("")){
                error += "Date field cannot be empty!\n";
            }
            if (timeVal.equals("")){
                error += "Time field cannot be empty!\n";
            }
            if (error.equals("")){
                if (std.applyStudentLeave(Long.parseLong(rollNumVal), dateVal, timeVal) != 0){
                    JOptionPane.showMessageDialog(null, "Leave confirmed!");
                }
                else {
                    JOptionPane.showMessageDialog(null, "Leave cannot be confirmed due to some technical error!");
                }
            }
            else {
                JOptionPane.showMessageDialog(null, error);
            }
        });

        cancel.addActionListener(e -> {
            dispose();
        });

        setLocation(500, 100);
        setSize(450, 500);
        setLayout(null);
        setVisible(true);
    }
    public static void main(String[] args){new ApplyStudentLeave();}
}
