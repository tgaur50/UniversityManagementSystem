package com.University.Management.System;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.util.List;

public class UpdateStudentInfo extends JFrame {
    public UpdateStudentInfo() {
        JLabel heading = new JLabel("Update Student Details:");
        heading.setFont(new Font("Arial", Font.ITALIC, 25));
        heading.setBounds(40, 20, 300, 30);
        add(heading);
        JLabel searchByRollNo = new JLabel("Select Roll Number");
        searchByRollNo.setFont(new Font("Arial", Font.PLAIN, 12));
        searchByRollNo.setBounds(40, 80, 200, 30);
        add(searchByRollNo);

        StudentDetailsDao std = new StudentDetailsDao();

        List<Student> listOfStudents = std.getStudent();
        String[] studentsRollNum = new String[listOfStudents.size()];
        int index = 0;
        for (Student st : listOfStudents) {
            studentsRollNum[index++] = String.valueOf(st.getRollNum());
        }
        JComboBox<String> searchFieldMenu = new JComboBox<>(studentsRollNum);
        searchFieldMenu.setFont(new Font("Arial", Font.BOLD, 12));
        searchFieldMenu.setBounds(170, 80, 200, 30);
        add(searchFieldMenu);

        Student st = std.searchByRollNum(String.valueOf(searchFieldMenu.getSelectedItem()));

        JLabel name = new JLabel("Name");
        name.setFont(new Font("Arial", Font.BOLD, 14));
        name.setBounds(40, 140, 100, 30);
        add(name);

        JLabel nameVal = new JLabel();
        nameVal.setFont(new Font("Arial", Font.BOLD, 14));
        nameVal.setBounds(160, 140, 150, 30);
        nameVal.setText(st.getName());
        add(nameVal);

        JLabel fname = new JLabel("Father's Name");
        fname.setFont(new Font("Arial", Font.BOLD, 14));
        fname.setBounds(330, 140, 150, 30);
        add(fname);

        JLabel fnameVal = new JLabel();
        fnameVal.setFont(new Font("Arial", Font.BOLD, 14));
        fnameVal.setBounds(490, 140, 150, 30);
        fnameVal.setText(st.getFatherName());
        add(fnameVal);

        JLabel rollNumField = new JLabel("Roll No");
        rollNumField.setFont(new Font("Arial", Font.BOLD, 14));
        rollNumField.setBounds(40, 180, 100, 30);
        add(rollNumField);

        JLabel rollNumVal = new JLabel();
        rollNumVal.setFont(new Font("Arial", Font.BOLD, 14));
        rollNumVal.setBounds(160, 180, 150, 30);
        rollNumVal.setText(String.valueOf(st.getRollNum()));
        add(rollNumVal);

        JLabel dob = new JLabel("Date of Birth");
        dob.setFont(new Font("Arial", Font.BOLD, 14));
        dob.setBounds(330, 1780, 150, 30);
        add(dob);

        JLabel dobVal = new JLabel();
        dobVal.setFont(new Font("Arial", Font.BOLD, 14));
        dobVal.setBounds(490, 180, 150, 30);
        dobVal.setText(st.getDob());
        add(dobVal);

        JLabel address = new JLabel("Address");
        address.setFont(new Font("Arial", Font.BOLD, 14));
        address.setBounds(40, 220, 100, 30);
        add(address);

        JTextField addrVal = new JTextField();
        addrVal.setFont(new Font("Arial", Font.BOLD, 14));
        addrVal.setBounds(160, 220, 150, 30);
        addrVal.setText(st.getAddress());
        add(addrVal);

        JLabel phone = new JLabel("Phone");
        phone.setFont(new Font("Arial", Font.BOLD, 14));
        phone.setBounds(330, 220, 150, 30);
        add(phone);

        JTextField phoneVal = new JTextField();
        phoneVal.setFont(new Font("Arial", Font.BOLD, 14));
        phoneVal.setBounds(490, 220, 150, 30);
        phoneVal.setText(String.valueOf(st.getPhone()));
        add(phoneVal);

        JLabel email = new JLabel("Email Id");
        email.setFont(new Font("Arial", Font.BOLD, 14));
        email.setBounds(40, 260, 100, 30);
        add(email);

        JTextField emailVal = new JTextField();
        emailVal.setFont(new Font("Arial", Font.BOLD, 14));
        emailVal.setBounds(160, 260, 150, 30);
        emailVal.setText(st.getEmailId());
        add(emailVal);

        JLabel classX = new JLabel("Class X(%)");
        classX.setFont(new Font("Arial", Font.BOLD, 14));
        classX.setBounds(330, 260, 150, 30);
        add(classX);

        JLabel classXVal = new JLabel();
        classXVal.setFont(new Font("Arial", Font.BOLD, 14));
        classXVal.setBounds(490, 260, 150, 30);
        classXVal.setText(String.valueOf(st.getClassX()));
        add(classXVal);

        JLabel classXII = new JLabel("CLass XII(%)");
        classXII.setFont(new Font("Arial", Font.BOLD, 14));
        classXII.setBounds(40, 300, 100, 30);
        add(classXII);

        JTextField classXIIVal = new JTextField();
        classXIIVal.setFont(new Font("Arial", Font.BOLD, 14));
        classXIIVal.setBounds(160, 300, 150, 30);
        classXIIVal.setText(String.valueOf(st.getClassXII()));
        add(classXIIVal);

        JLabel aadharNo = new JLabel("Aadhar No");
        aadharNo.setFont(new Font("Arial", Font.BOLD, 14));
        aadharNo.setBounds(330, 300, 150, 30);
        add(aadharNo);

        JLabel aadharNoVal = new JLabel();
        aadharNoVal.setFont(new Font("Arial", Font.BOLD, 14));
        aadharNoVal.setBounds(490, 300, 150, 30);
        aadharNoVal.setText(st.getAadhaarNo());
        add(aadharNoVal);

        JLabel course = new JLabel("Course");
        course.setFont(new Font("Arial", Font.BOLD, 14));
        course.setBounds(40, 340, 100, 30);
        add(course);

        JTextField courseVal = new JTextField();
        courseVal.setFont(new Font("Arial", Font.BOLD, 14));
        courseVal.setBounds(160, 340, 150, 30);
        courseVal.setText(st.getCourse());
        add(courseVal);

        JLabel branch = new JLabel("Branch");
        branch.setFont(new Font("Arial", Font.BOLD, 14));
        branch.setBounds(330, 340, 150, 30);
        add(branch);

        JTextField branchVal = new JTextField();
        branchVal.setFont(new Font("Arial", Font.BOLD, 14));
        branchVal.setBounds(490, 340, 150, 30);
        branchVal.setText(st.getBranch());
        add(branchVal);

        JButton submit = new JButton("Submit");
        submit.setFont(new Font("Arial", Font.BOLD, 12));
        submit.setOpaque(true);
        submit.setBorderPainted(false);
        submit.setForeground(Color.WHITE);
        submit.setBackground(Color.BLACK);
        submit.setBounds(210, 450, 120, 30);
        add(submit);

        JButton cancel = new JButton("Cancel");
        cancel.setFont(new Font("Arial", Font.BOLD, 12));
        cancel.setOpaque(true);
        cancel.setBorderPainted(false);
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(Color.BLACK);
        cancel.setBounds(370, 450, 120, 30);
        add(cancel);

        submit.addActionListener(e->{
            String error = "";
            Validation val = new Validation();
            String addressVal = addrVal.getText();
            String phoneNumVal = phoneVal.getText();
            String emailidVal = emailVal.getText();
            String courseFieldVal = courseVal.getText();
            String branchFieldVal = branchVal.getText();

            if (!val.checkAddress(addressVal)){
                error += "Invalid Address\n";
            }
            if (!val.checkPhone(String.valueOf(phoneNumVal))){
                error += "Invalid Phone Number\n";
            }
            if (!val.checkEmail(emailidVal)){
                error += "Invalid email id\n";
            }
            if (!val.checkNames(courseFieldVal)){
                error += "Invalid Course selection\n";
            }
            if (!val.checkNames(branchFieldVal)){
                error += "Invalid Branch Selection\n";
            }
            if (!error.equals("")){
                JOptionPane.showMessageDialog(null, error);
            }
            else {
                Student student = new Student(Long.parseLong(rollNumVal.getText()),
                        nameVal.getText(), fnameVal.getText(), dobVal.getText(),
                        addressVal, Long.parseLong(phoneNumVal), emailidVal,
                        Double.parseDouble(classXVal.getText()),
                        Double.parseDouble(classXIIVal.getText()),
                        aadharNoVal.getText(), courseFieldVal, branchFieldVal);
                if(std.updateStudentDetails(Long.parseLong(rollNumVal.getText()), student) > 0){
                    JOptionPane.showMessageDialog(null, "Student details updated successfully!");
                    dispose();
                }
                else {
                    JOptionPane.showMessageDialog(null, "Student details are not updated!");
                }
            }
        });

        cancel.addActionListener(e->{
            dispose();
        });

        searchFieldMenu.addActionListener(e -> {
            JComboBox jcb = (JComboBox)e.getSource();
            String rollNum = String.valueOf(jcb.getSelectedItem());
            Student student = std.searchByRollNum(rollNum);
            nameVal.setText(student.getName());
            fnameVal.setText(student.getFatherName());
            rollNumVal.setText(String.valueOf(student.getRollNum()));
            dobVal.setText(student.getDob());
            addrVal.setText(student.getAddress());
            phoneVal.setText(String.valueOf(student.getPhone()));
            emailVal.setText(student.getEmailId());
            classXVal.setText(String.valueOf(student.getClassX()));
            classXIIVal.setText(String.valueOf(student.getClassXII()));
            aadharNoVal.setText(student.getAadhaarNo());
            courseVal.setText(student.getCourse());
            branchVal.setText(student.getBranch());
        });

        setLocation(350, 80);
        setSize(750, 580);
        setLayout(null);
        setVisible(true);
    }
    public static void main(String[] args){new UpdateStudentInfo();}
}
