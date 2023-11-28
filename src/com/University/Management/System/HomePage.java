package com.University.Management.System;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class HomePage extends JFrame {
    public HomePage(){
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        JMenuBar menuBar = new JMenuBar();
        JMenu newInfo = new JMenu("New Information");
        newInfo.setForeground(Color.BLUE);
        JMenuItem newFaculty = new JMenuItem("New Faculty Information");
        JMenuItem newStudent = new JMenuItem("New Student Information");
        newInfo.add(newFaculty);
        newInfo.add(newStudent);
        JMenu viewDetails = new JMenu("View Details");
        JMenuItem viewStudentDetails = new JMenuItem("View Student Details");
        JMenuItem viewFacultyDetails = new JMenuItem("View Teacher Details");
        viewDetails.add(viewStudentDetails);
        viewDetails.add(viewFacultyDetails);
        viewDetails.setForeground(Color.RED);
        JMenu applyLeave = new JMenu("Apply Leave");
        JMenuItem applyStudentLeave = new JMenuItem("Apply Student Leave");
        JMenuItem applyTeacherLeave = new JMenuItem("Apply Teacher Leave");
        applyLeave.add(applyStudentLeave);
        applyLeave.add(applyTeacherLeave);
        applyLeave.setForeground(Color.BLUE);
        JMenu leaveDetails = new JMenu("Leave Details");
        JMenuItem studentLeaveDetails = new JMenuItem("Student Leave Details");
        JMenuItem teacherLeaveDetails = new JMenuItem("Teacher Leave Details");
        leaveDetails.add(studentLeaveDetails);
        leaveDetails.add(teacherLeaveDetails);
        leaveDetails.setForeground(Color.RED);
        JMenu examination = new JMenu("Examination");
        JMenuItem examinationDetails = new JMenuItem("Examination Details");
        JMenuItem enterMarks = new JMenuItem("Enter Marks");
        examination.add(examinationDetails);
        examination.add(enterMarks);
        examination.setForeground(Color.BLUE);
        JMenu updateDetails = new JMenu("Update Details");
        JMenuItem updateStudentDetails = new JMenuItem("Update Student Details");
        JMenuItem updateTeacherDetails = new JMenuItem("Update Teacher Details");
        updateDetails.add(updateStudentDetails);
        updateDetails.add(updateTeacherDetails);
        updateDetails.setForeground(Color.RED);
        JMenu feeDetails = new JMenu("Fee Details");
        JMenuItem feeStructure = new JMenuItem("Fee Structure");
        JMenuItem stuFeeForm = new JMenuItem("Student Fee Form");
        feeDetails.add(feeStructure);
        feeDetails.add(stuFeeForm);
        feeDetails.setForeground(Color.BLUE);
        JMenu utility = new JMenu("Utility");
        JMenuItem notepad = new JMenuItem("Notepad");
        JMenuItem calculator = new JMenuItem("Calculator");
        JMenuItem webBrowser = new JMenuItem("Web Browser");
        utility.add(notepad);
        utility.add(calculator);
        utility.add(webBrowser);
        utility.setForeground(Color.RED);
        JMenu about = new JMenu("About");
        JMenuItem aboutUs = new JMenuItem("About Us");
        about.add(aboutUs);
        about.setForeground(Color.BLUE);
        JMenu exit = new JMenu("Exit");
        JMenuItem exitItem = new JMenuItem("Exit");
        exit.add(exitItem);
        exit.setForeground(Color.RED);
        menuBar.add(newInfo);
        menuBar.add(viewDetails);
        menuBar.add(applyLeave);
        menuBar.add(leaveDetails);
        menuBar.add(examination);
        menuBar.add(updateDetails);
        menuBar.add(feeDetails);
        menuBar.add(utility);
        menuBar.add(about);
        menuBar.add(exit);
        setJMenuBar(menuBar);

        newFaculty.addActionListener(e -> new AddFacultyDetails());
        newStudent.addActionListener(e -> new AddStudentDetails());
        viewStudentDetails.addActionListener(e -> new ViewStudentDetails());
        viewFacultyDetails.addActionListener(e -> new ViewTeacherDetails());
        applyStudentLeave.addActionListener(e -> new ApplyStudentLeave());
        applyTeacherLeave.addActionListener(e -> new ApplyTeacherLeaves());
        studentLeaveDetails.addActionListener(e -> new StudentLeaveDetails());
        teacherLeaveDetails.addActionListener(e -> new TeacherLeaveDetails());
        examinationDetails.addActionListener(e -> new ExaminationDetails());
        enterMarks.addActionListener(e -> new EnterMarks());
        updateStudentDetails.addActionListener(e -> new UpdateStudentInfo());
        updateTeacherDetails.addActionListener(e -> new UpdateTeacherDetails());
        feeStructure.addActionListener(e -> new FeeStructure());
        stuFeeForm.addActionListener(e -> new StudentFeeForm());

        Runtime runtime = Runtime.getRuntime();

        notepad.addActionListener(e -> {
            String[] startNotePadWithoutAdminPermissions = new String[] {"CMD.EXE", "/C", "start", "notepad" };
            try {
                runtime.exec(new String[]{"open", "-a", "Notes"});
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        calculator.addActionListener(e -> {
            try {
                runtime.exec("open -a Calculator");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        webBrowser.addActionListener(e -> {
            try {
                Runtime.getRuntime().exec(new String[]{"open", "-a", "Safari", "https://google.com"});
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        aboutUs.addActionListener(e -> new AboutUs());

        exitItem.addActionListener(e -> {
            dispose();
        });

        ImageIcon ic = new ImageIcon(ClassLoader.getSystemResource("icons/HomePageBackground.jpg"));
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        final int widthScreen = screenSize.width;
        final int heightScreen = screenSize.height;
        Image img = ic.getImage().getScaledInstance(widthScreen, heightScreen, Image.SCALE_DEFAULT);
        ImageIcon ic1 = new ImageIcon(img);
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, widthScreen, heightScreen);
        add(panel);
        JLabel image = new JLabel(ic1);
        image.setBounds(10, 10, widthScreen, heightScreen);
        panel.add(image);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
    }
    public static void main(String[] args){
        new HomePage();
    }
}
