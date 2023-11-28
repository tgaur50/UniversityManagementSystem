package com.University.Management.System;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import javax.swing.text.DateFormatter;
import java.awt.*;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.UUID;

public class AddStudentDetails extends JFrame {
    public AddStudentDetails(){
        JLabel heading = new JLabel("New Student Details");
        heading.setFont(new Font("Arial", Font.BOLD, 20));
        heading.setBounds(275, 30, 200, 30);
        add(heading);

        JLabel name = new JLabel("Name");
        name.setFont(new Font("Arial", Font.BOLD, 14));
        name.setBounds(40, 120, 100, 30);
        add(name);

        JTextField nameField = new JTextField();
        nameField.setFont(new Font("Arial", Font.BOLD, 14));
        nameField.setBounds(160, 120, 150, 30);
        add(nameField);

        JLabel fatherName = new JLabel("Father's Name");
        fatherName.setFont(new Font("Arial", Font.BOLD, 14));
        fatherName.setBounds(340, 120, 150, 30);
        add(fatherName);

        JTextField fNameField = new JTextField();
        fNameField.setFont(new Font("Arial", Font.BOLD, 14));
        fNameField.setBounds(490, 120, 150, 30);
        add(fNameField);

        JLabel rollNum = new JLabel("Roll No");
        rollNum.setFont(new Font("Arial", Font.BOLD, 14));
        rollNum.setBounds(40, 160, 100, 30);
        add(rollNum);

        String generateUUIDNo =
                String.format("%010d",new BigInteger(UUID.randomUUID().toString().replace
                        ("-",""),16));

        String rollNo = "1533"
                + generateUUIDNo.substring( generateUUIDNo.length() - 4);

        JLabel rollNumVal = new JLabel(rollNo);
        rollNumVal.setFont(new Font("Arial", Font.BOLD, 14));
        rollNumVal.setBounds(160, 160, 100, 30);
        add(rollNumVal);

        JLabel dateOfBirth = new JLabel("Date of Birth");
        dateOfBirth.setFont(new Font("Arial", Font.BOLD, 14));
        dateOfBirth.setBounds(340, 160, 150, 30);
        add(dateOfBirth);

        JDateChooser dob = new JDateChooser();
        dob.setBounds(490, 160, 150, 30);
        add(dob);

        JLabel address = new JLabel("Address");
        address.setFont(new Font("Arial", Font.BOLD, 14));
        address.setBounds(40, 200, 100, 30);
        add(address);

        JTextField addressField = new JTextField();
        addressField.setFont(new Font("Arial", Font.BOLD, 14));
        addressField.setBounds(160, 200, 150, 30);
        add(addressField);

        JLabel phone = new JLabel("Phone");
        phone.setFont(new Font("Arial", Font.BOLD, 14));
        phone.setBounds(340, 200, 100, 30);
        add(phone);

        JTextField phoneField = new JTextField();
        phoneField.setFont(new Font("Arial", Font.BOLD, 14));
        phoneField.setBounds(490, 200, 150, 30);
        add(phoneField);

        JLabel emailid = new JLabel("Email Id");
        emailid.setFont(new Font("Arial", Font.BOLD, 14));
        emailid.setBounds(40, 240, 100, 30);
        add(emailid);

        JTextField emailField = new JTextField();
        emailField.setFont(new Font("Arial", Font.BOLD, 14));
        emailField.setBounds(160, 240, 150, 30);
        add(emailField);

        JLabel classXPer = new JLabel("Class X(%)");
        classXPer.setFont(new Font("Arial", Font.BOLD, 14));
        classXPer.setBounds(340, 240, 100, 30);
        add(classXPer);

        JTextField classXField = new JTextField();
        classXField.setFont(new Font("Arial", Font.BOLD, 14));
        classXField.setBounds(490, 240, 150, 30);
        add(classXField);

        JLabel classXIIPer = new JLabel("Class XII(%)");
        classXIIPer.setFont(new Font("Arial", Font.BOLD, 14));
        classXIIPer.setBounds(40, 280, 100, 30);
        add(classXIIPer);

        JTextField classXIIField = new JTextField();
        classXIIField.setFont(new Font("Arial", Font.BOLD, 14));
        classXIIField.setBounds(160, 280, 150, 30);
        add(classXIIField);

        JLabel aadhaarNo = new JLabel("Aadhaar No");
        aadhaarNo.setFont(new Font("Arial", Font.BOLD, 14));
        aadhaarNo.setBounds(340, 280, 100, 30);
        add(aadhaarNo);

        JTextField aadhaarField = new JTextField();
        aadhaarField.setFont(new Font("Arial", Font.BOLD, 14));
        aadhaarField.setBounds(490, 280, 150, 30);
        add(aadhaarField);

        JLabel course = new JLabel("Course");
        course.setFont(new Font("Arial", Font.BOLD, 14));
        course.setBounds(40, 320, 100, 30);
        add(course);

        String[] courseList = {"BTech", "Bsc", "Msc", "Bcom", "Mcom", "MTech", "MBA", "BCA", "MCA"};

        JComboBox<String> courseDropdown = new JComboBox<>(courseList);
        courseDropdown.setBounds(160, 320, 150, 30);
        add(courseDropdown);

        JLabel branch = new JLabel("Branch");
        branch.setFont(new Font("Arial", Font.BOLD, 14));
        branch.setBounds(340, 320, 150, 30);
        add(branch);

        String[] branchList = {"Computer Science", "Electronics", "Electrical", "Mechanical",
                "Civil"};
        JComboBox<String> branchDropdown = new JComboBox<>(branchList);
        branchDropdown.setBounds(490, 320, 150, 30);
        add(branchDropdown);

        JButton submit = new JButton("Submit");
        submit.setFont(new Font("Arial", Font.BOLD, 12));
        submit.setOpaque(true);
        submit.setBorderPainted(false);
        submit.setForeground(Color.WHITE);
        submit.setBackground(Color.BLACK);
        submit.setBounds(220, 450, 120, 30);
        add(submit);

        JButton cancel = new JButton("Cancel");
        cancel.setFont(new Font("Arial", Font.BOLD, 12));
        cancel.setOpaque(true);
        cancel.setBorderPainted(false);
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(Color.BLACK);
        cancel.setBounds(380, 450, 120, 30);
        add(cancel);

        submit.addActionListener(e -> {
            String error = "";
            Validation val = new Validation();
            String nameVal = nameField.getText();
            String fNameVal = fNameField.getText();
            String rollNoVal = rollNumVal.getText();
            String dobVal = ((JTextField) dob.getDateEditor().getUiComponent()).getText();
            String addressVal = addressField.getText();
            String phoneNumVal = phoneField.getText();
            String emailidVal = emailField.getText();
            String classXVal = classXField.getText();
            String classXIIVal = classXIIField.getText();
            String aadhaarNoVal = aadhaarField.getText();
            String courseVal = String.valueOf(courseDropdown.getSelectedItem());
            String branchVal = String.valueOf(branchDropdown.getSelectedItem());
            if (!val.checkNames(nameVal)){
                error += "Invalid Name\n";
            }
            if (!val.checkNames(fNameVal)){
                error += "Invalid Father Name\n";
            }
            if (!val.checkRollNo(rollNoVal)){
                error += "Invalid Roll Number\n";
            }
            if (!val.checkDOB(dobVal)){
                error += "Invalid date of birth\n";
            }
            if (!val.checkAddress(addressVal)){
                error += "Invalid Address\n";
            }
            if (!val.checkPhone(String.valueOf(phoneNumVal))){
                error += "Invalid Phone Number\n";
            }
            if (!val.checkEmail(emailidVal)){
                error += "Invalid email id\n";
            }
            if (!val.checkMarks(classXVal)){
                error += "Invalid Marks\n";
            }
            if (!val.checkMarks(classXIIVal)){
                error += "Invalid Marks\n";
            }
            if (!val.checkAadhaar(aadhaarNoVal)){
                error += "Invalid Aadhaar No\n";
            }
            if (!val.checkNames(courseVal)){
                error += "Invalid Course selection\n";
            }
            if (!val.checkNames(branchVal)){
                error += "Invalid Branch Selection\n";
            }
            if (!error.equals("")){
                JOptionPane.showMessageDialog(null, error);
            }
            else {
                StudentDetailsDao std = new StudentDetailsDao();
                Student student = new Student(Integer.parseInt(rollNoVal), nameVal, fNameVal,
                        dobVal, addressVal, Long.parseLong(phoneNumVal), emailidVal,
                        Double.parseDouble(classXVal), Double.parseDouble(classXIIVal),
                        aadhaarNoVal, courseVal, branchVal);
                if(std.insertStudentDetails(student) > 0){
                    JOptionPane.showMessageDialog(null, "Student added successfully!");
                    dispose();
                }
                else {
                    JOptionPane.showMessageDialog(null, "Student is not added!");
                }
            }
        });

        cancel.addActionListener(e -> dispose());

        setLocation(350, 80);
        setSize(750, 580);
        setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args){
        new AddStudentDetails();
    }
}
