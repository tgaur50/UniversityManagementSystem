package com.University.Management.System;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class StudentFeeForm extends JFrame {
    public StudentFeeForm(){
        JLabel rollNum = new JLabel("Select Roll No");
        rollNum.setFont(new Font("Arial", Font.BOLD, 16));
        rollNum.setBounds(30, 50, 150, 30);
        add(rollNum);

        StudentDetailsDao std = new StudentDetailsDao();
        List<Student> listOfStudents = std.getStudent();
        String[] listOfRollNums = new String[listOfStudents.size()];
        int index = 0;
        for (Student st : listOfStudents){
            listOfRollNums[index++] = String.valueOf(st.getRollNum());
        }
        JComboBox<String> rollNumMenu = new JComboBox<>(listOfRollNums);
        rollNumMenu.setFont(new Font("Arial", Font.BOLD, 16));
        rollNumMenu.setBounds(180, 50, 170, 30);
        add(rollNumMenu);

        Student s = std.searchByRollNum(String.valueOf(rollNumMenu.getSelectedItem()));
        String rollNumValue = String.valueOf(rollNumMenu.getSelectedItem());
        ResultSet rs = std.getStudentResult(Long.parseLong(rollNumValue));
        String sem = "";
        while (true){
            try {
                if (!rs.next()) break;
                else {
                    sem = rs.getString(2);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }

        JLabel name = new JLabel("Name");
        name.setFont(new Font("Arial", Font.BOLD, 16));
        name.setBounds(30, 90, 150, 30);
        add(name);

        JLabel nameVal = new JLabel(s.getName());
        nameVal.setFont(new Font("Arial", Font.BOLD, 16));
        nameVal.setBounds(180, 90, 170, 30);
        add(nameVal);

        JLabel fName = new JLabel("Father's Name");
        fName.setFont(new Font("Arial", Font.BOLD, 16));
        fName.setBounds(30, 130, 150, 30);
        add(fName);

        JLabel fNameVal = new JLabel(s.getFatherName());
        fNameVal.setFont(new Font("Arial", Font.BOLD, 16));
        fNameVal.setBounds(180, 130, 170, 30);
        add(fNameVal);

        JLabel course = new JLabel("Course");
        course.setFont(new Font("Arial", Font.BOLD, 16));
        course.setBounds(30, 170, 150, 30);
        add(course);
        String[] courseList = {"BTech", "Bsc", "Msc", "Bcom", "Mcom", "MTech", "MBA", "BCA", "MCA"};
        JComboBox<String> courseMenu = new JComboBox<>(courseList);
        courseMenu.setFont(new Font("Arial", Font.BOLD, 16));
        courseMenu.setBounds(180, 170, 170, 30);
        courseMenu.setSelectedItem(s.getCourse());
        add(courseMenu);

        JLabel branch = new JLabel("Branch");
        branch.setFont(new Font("Arial", Font.BOLD, 16));
        branch.setBounds(30, 210, 150, 30);
        add(branch);
        String[] branchList = {"Computer Science", "Electronics", "Electrical", "Mechanical",
                "Civil"};
        JComboBox<String> branchMenu = new JComboBox<>(branchList);
        branchMenu.setFont(new Font("Arial", Font.BOLD, 16));
        branchMenu.setBounds(180, 210, 170, 30);
        branchMenu.setSelectedItem(s.getBranch());
        add(branchMenu);

        JLabel semester = new JLabel("Semester");
        semester.setFont(new Font("Arial", Font.BOLD, 16));
        semester.setBounds(30, 250, 150, 30);
        add(semester);

        String[] semesters = {"1st Semester", "2nd Semester", "3rd Semester", "4th Semester",
                "5th Semester", "6th Semester", "7th Semester", "8th Semester"};

        JComboBox<String> semesterMenu = new JComboBox<>(semesters);
        semesterMenu.setFont(new Font("Arial", Font.BOLD, 16));
        semesterMenu.setBounds(180, 250, 170, 30);
        semesterMenu.setSelectedItem(sem);
        add(semesterMenu);

        JLabel totalPayable = new JLabel("Total Payable");
        totalPayable.setFont(new Font("Arial", Font.BOLD, 16));
        totalPayable.setBounds(30, 290, 150, 30);
        add(totalPayable);

        JLabel totalPayableVal = new JLabel();
        totalPayableVal.setFont(new Font("Arial", Font.BOLD, 16));
        totalPayableVal.setBounds(180, 290, 150, 30);
        add(totalPayableVal);

        JButton update = new JButton("Update");
        update.setFont(new Font("Arial", Font.BOLD, 12));
        update.setOpaque(true);
        update.setBorderPainted(false);
        update.setForeground(Color.WHITE);
        update.setBackground(Color.BLACK);
        update.setBounds(30, 380, 110, 25);
        add(update);

        JButton pay = new JButton("Pay Fee");
        pay.setFont(new Font("Arial", Font.BOLD, 12));
        pay.setOpaque(true);
        pay.setBorderPainted(false);
        pay.setForeground(Color.WHITE);
        pay.setBackground(Color.BLACK);
        pay.setBounds(160, 380, 110, 25);
        add(pay);

        JButton back = new JButton("Back");
        back.setFont(new Font("Arial", Font.BOLD, 12));
        back.setOpaque(true);
        back.setBorderPainted(false);
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        back.setBounds(290, 380, 110, 25);
        add(back);

        rollNumMenu.addActionListener(e -> {
            JComboBox<String> menu = (JComboBox<String>) e.getSource();
            String rollNumVal = String.valueOf(menu.getSelectedItem());
            ResultSet rset = std.getStudentResult(Long.parseLong(rollNumVal));
            String semVal = "";
            while (true) {
                try {
                    if (!rset.next()) break;
                    else {
                        semVal = rset.getString(2);
                    }
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
            Student stu = std.searchByRollNum(rollNumVal);
            nameVal.setText(stu.getName());
            fNameVal.setText(stu.getFatherName());
            courseMenu.setSelectedItem(stu.getCourse());
            branchMenu.setSelectedItem(stu.getBranch());
            semesterMenu.setSelectedItem(semVal);
        });

        update.addActionListener(e -> {
            String courseVal = String.valueOf(courseMenu.getSelectedItem());
            String semesterFieldVal = String.valueOf(semesterMenu.getSelectedItem());
            System.out.println(courseVal + " " + semesterFieldVal);
            String totalFeeToPay = "";
            totalFeeToPay = String.valueOf(std.getTotalFeeToPay(courseVal, semesterFieldVal));
            System.out.println(totalFeeToPay);
            if (totalFeeToPay.equals("0")){
                totalFeeToPay = "";
            }
            totalPayableVal.setText(totalFeeToPay);
        });

        pay.addActionListener(e -> {
            if (totalPayableVal.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Please click on update to get the fee amount to pay.");
            }
            else {
                JOptionPane.showMessageDialog(null, "Fees Paid Successfully!");
                dispose();
            }
        });

        back.addActionListener(e -> dispose());

        ImageIcon imgIcon = new ImageIcon(ClassLoader.getSystemResource("icons/fee.jpg"));
        Image img = imgIcon.getImage().getScaledInstance(450, 300, Image.SCALE_DEFAULT);
        ImageIcon ic = new ImageIcon(img);
        JLabel imgLabel = new JLabel(ic);
        imgLabel.setBounds(400, 50, 450, 300);
        add(imgLabel);
        setLocation(220, 130);
        setSize(850, 540);
        setLayout(null);
        setVisible(true);
    }
    public static void main(String[] args){new StudentFeeForm();}
}
