package com.University.Management.System;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class UpdateTeacherDetails extends JFrame {
    public UpdateTeacherDetails() {
        JLabel heading = new JLabel("Update Teacher Details:");
        heading.setFont(new Font("Arial", Font.ITALIC, 25));
        heading.setBounds(40, 20, 300, 30);
        add(heading);
        JLabel searchByRollNo = new JLabel("Select Employee Id");
        searchByRollNo.setFont(new Font("Arial", Font.PLAIN, 12));
        searchByRollNo.setBounds(40, 80, 200, 30);
        add(searchByRollNo);

        StudentDetailsDao std = new StudentDetailsDao();

        List<Faculty> listOfTeachers = std.getTeachers();
        String[] teachersEmpIds = new String[listOfTeachers.size()];
        int index = 0;
        for (Faculty ft : listOfTeachers) {
            teachersEmpIds[index++] = String.valueOf(ft.getEmployeeId());
        }
        JComboBox<String> searchFieldMenu = new JComboBox<>(teachersEmpIds);
        searchFieldMenu.setFont(new Font("Arial", Font.BOLD, 12));
        searchFieldMenu.setBounds(170, 80, 200, 30);
        add(searchFieldMenu);

        Faculty ft = std.searchByEmployeeId(String.valueOf(searchFieldMenu.getSelectedItem()));

        JLabel name = new JLabel("Name");
        name.setFont(new Font("Arial", Font.BOLD, 14));
        name.setBounds(40, 140, 100, 30);
        add(name);

        JLabel nameVal = new JLabel();
        nameVal.setFont(new Font("Arial", Font.BOLD, 14));
        nameVal.setBounds(160, 140, 150, 30);
        nameVal.setText(ft.getName());
        add(nameVal);

        JLabel fname = new JLabel("Father's Name");
        fname.setFont(new Font("Arial", Font.BOLD, 14));
        fname.setBounds(330, 140, 150, 30);
        add(fname);

        JLabel fnameVal = new JLabel();
        fnameVal.setFont(new Font("Arial", Font.BOLD, 14));
        fnameVal.setBounds(490, 140, 150, 30);
        fnameVal.setText(ft.getFatherName());
        add(fnameVal);

        JLabel empIdField = new JLabel("Employee Id");
        empIdField.setFont(new Font("Arial", Font.BOLD, 14));
        empIdField.setBounds(40, 180, 100, 30);
        add(empIdField);

        JLabel empIdVal = new JLabel();
        empIdVal.setFont(new Font("Arial", Font.BOLD, 14));
        empIdVal.setBounds(160, 180, 150, 30);
        empIdVal.setText(String.valueOf(ft.getEmployeeId()));
        add(empIdVal);

        JLabel dob = new JLabel("Date of Birth");
        dob.setFont(new Font("Arial", Font.BOLD, 14));
        dob.setBounds(330, 1780, 150, 30);
        add(dob);

        JLabel dobVal = new JLabel();
        dobVal.setFont(new Font("Arial", Font.BOLD, 14));
        dobVal.setBounds(490, 180, 150, 30);
        dobVal.setText(ft.getDob());
        add(dobVal);

        JLabel address = new JLabel("Address");
        address.setFont(new Font("Arial", Font.BOLD, 14));
        address.setBounds(40, 220, 100, 30);
        add(address);

        JTextField addrVal = new JTextField();
        addrVal.setFont(new Font("Arial", Font.BOLD, 14));
        addrVal.setBounds(160, 220, 150, 30);
        addrVal.setText(ft.getAddress());
        add(addrVal);

        JLabel phone = new JLabel("Phone");
        phone.setFont(new Font("Arial", Font.BOLD, 14));
        phone.setBounds(330, 220, 150, 30);
        add(phone);

        JTextField phoneVal = new JTextField();
        phoneVal.setFont(new Font("Arial", Font.BOLD, 14));
        phoneVal.setBounds(490, 220, 150, 30);
        phoneVal.setText(String.valueOf(ft.getPhone()));
        add(phoneVal);

        JLabel email = new JLabel("Email Id");
        email.setFont(new Font("Arial", Font.BOLD, 14));
        email.setBounds(40, 260, 100, 30);
        add(email);

        JTextField emailVal = new JTextField();
        emailVal.setFont(new Font("Arial", Font.BOLD, 14));
        emailVal.setBounds(160, 260, 150, 30);
        emailVal.setText(ft.getEmailId());
        add(emailVal);

        JLabel classX = new JLabel("Class X(%)");
        classX.setFont(new Font("Arial", Font.BOLD, 14));
        classX.setBounds(330, 260, 150, 30);
        add(classX);

        JLabel classXVal = new JLabel();
        classXVal.setFont(new Font("Arial", Font.BOLD, 14));
        classXVal.setBounds(490, 260, 150, 30);
        classXVal.setText(String.valueOf(ft.getClassX()));
        add(classXVal);

        JLabel classXII = new JLabel("CLass XII(%)");
        classXII.setFont(new Font("Arial", Font.BOLD, 14));
        classXII.setBounds(40, 300, 100, 30);
        add(classXII);

        JTextField classXIIVal = new JTextField();
        classXIIVal.setFont(new Font("Arial", Font.BOLD, 14));
        classXIIVal.setBounds(160, 300, 150, 30);
        classXIIVal.setText(String.valueOf(ft.getClassXII()));
        add(classXIIVal);

        JLabel aadharNo = new JLabel("Aadhar No");
        aadharNo.setFont(new Font("Arial", Font.BOLD, 14));
        aadharNo.setBounds(330, 300, 150, 30);
        add(aadharNo);

        JLabel aadharNoVal = new JLabel();
        aadharNoVal.setFont(new Font("Arial", Font.BOLD, 14));
        aadharNoVal.setBounds(490, 300, 150, 30);
        aadharNoVal.setText(ft.getAadhaarNo());
        add(aadharNoVal);

        JLabel course = new JLabel("Education");
        course.setFont(new Font("Arial", Font.BOLD, 14));
        course.setBounds(40, 340, 100, 30);
        add(course);

        JTextField eductionVal = new JTextField();
        eductionVal.setFont(new Font("Arial", Font.BOLD, 14));
        eductionVal.setBounds(160, 340, 150, 30);
        eductionVal.setText(ft.getEducation());
        add(eductionVal);

        JLabel branch = new JLabel("Department");
        branch.setFont(new Font("Arial", Font.BOLD, 14));
        branch.setBounds(330, 340, 150, 30);
        add(branch);

        JLabel deptVal = new JLabel();
        deptVal.setFont(new Font("Arial", Font.BOLD, 14));
        deptVal.setBounds(490, 340, 150, 30);
        deptVal.setText(ft.getDepartment());
        add(deptVal);

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
            String educationFieldVal = eductionVal.getText();
            String deptFieldVal = deptVal.getText();

            if (!val.checkAddress(addressVal)){
                error += "Invalid Address\n";
            }
            if (!val.checkPhone(String.valueOf(phoneNumVal))){
                error += "Invalid Phone Number\n";
            }
            if (!val.checkEmail(emailidVal)){
                error += "Invalid email id\n";
            }
            if (!val.checkNames(educationFieldVal)){
                error += "Invalid Education selection\n";
            }
            if (!val.checkNames(deptFieldVal)){
                error += "Invalid Department Selection\n";
            }
            if (!error.equals("")){
                JOptionPane.showMessageDialog(null, error);
            }
            else {
                Faculty faculty = new Faculty(Long.parseLong(empIdVal.getText()),
                        nameVal.getText(), fnameVal.getText(), dobVal.getText(),
                        addressVal, Long.parseLong(phoneNumVal), emailidVal,
                        Double.parseDouble(classXVal.getText()),
                        Double.parseDouble(classXIIVal.getText()),
                        aadharNoVal.getText(), educationFieldVal, deptFieldVal);
                if(std.updateTeacherDetails(Long.parseLong(empIdVal.getText()), faculty) > 0){
                    JOptionPane.showMessageDialog(null, "Teacher details updated successfully!");
                    dispose();
                }
                else {
                    JOptionPane.showMessageDialog(null, "Teacher details are not updated!");
                }
            }
        });

        cancel.addActionListener(e->{
            dispose();
        });

        searchFieldMenu.addActionListener(e -> {
            JComboBox jcb = (JComboBox)e.getSource();
            String empIdFieldVal = String.valueOf(jcb.getSelectedItem());
            Faculty faculty = std.searchByEmployeeId(empIdFieldVal);
            nameVal.setText(faculty.getName());
            fnameVal.setText(faculty.getFatherName());
            empIdVal.setText(String.valueOf(faculty.getEmployeeId()));
            dobVal.setText(faculty.getDob());
            addrVal.setText(faculty.getAddress());
            phoneVal.setText(String.valueOf(faculty.getPhone()));
            emailVal.setText(faculty.getEmailId());
            classXVal.setText(String.valueOf(faculty.getClassX()));
            classXIIVal.setText(String.valueOf(faculty.getClassXII()));
            aadharNoVal.setText(faculty.getAadhaarNo());
            eductionVal.setText(faculty.getEducation());
            deptVal.setText(faculty.getDepartment());
        });

        setLocation(350, 80);
        setSize(750, 580);
        setLayout(null);
        setVisible(true);
    }
    public static void main(String[] args){new UpdateTeacherDetails();}
}
