package com.University.Management.System;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.util.List;

public class StudentLeaveDetails extends JFrame implements Printable {
    private JPanel jp;
    public StudentLeaveDetails(){
        JLabel rollNumField = new JLabel("Search by Roll Number");
        rollNumField.setFont(new Font("Arial", Font.PLAIN, 12));
        rollNumField.setBounds(20, 20, 150, 30);
        add(rollNumField);
        StudentDetailsDao std = new StudentDetailsDao();
        List<Student> listOfStudents = std.getStudent();
        String[] studentRollNums = new String[listOfStudents.size()];
        int index = 0;
        for (Student st : listOfStudents){
            studentRollNums[index++] = String.valueOf(st.getRollNum());
        }
        JComboBox<String> rollNumMenu = new JComboBox<>(studentRollNums);
        rollNumMenu.setFont(new Font("Arial", Font.PLAIN, 12));
        rollNumMenu.setBounds(180, 20, 150, 30);
        add(rollNumMenu);

        JButton search = new JButton("Search");
        search.setFont(new Font("Arial", Font.BOLD, 12));
        search.setFocusPainted(false);
        search.setBounds(20, 70, 100, 30);
        add(search);

        JButton print = new JButton("Print");
        print.setFont(new Font("Arial", Font.BOLD, 12));
        print.setFocusPainted(false);
        print.setBounds(130, 70, 100, 30);
        add(print);

        JButton back = new JButton("Back");
        back.setFont(new Font("Arial", Font.BOLD, 12));
        back.setFocusPainted(false);
        back.setBounds(240, 70, 100, 30);
        add(back);

        String[] columns = {"rollnumber", "date", "time"};
        DefaultTableModel dft = new DefaultTableModel(columns, 0);
        List<String[]> studentLeaves = std.getStudentLeaves();
        for (String[] leave: studentLeaves){
            String[] rowToAdd = {leave[0], leave[1], leave[2]};
            dft.addRow(rowToAdd);
        }
        JTable table = new JTable(dft);
        JScrollPane jsp = new JScrollPane(table);
        jp = new JPanel();
        jp.setLayout(new BorderLayout());
        jp.add(jsp);
        jp.setBounds(0, 110, 750, 580);
        add(jp);

        search.addActionListener(e -> {
            String rollNumVal = String.valueOf(rollNumMenu.getSelectedItem());
            DefaultTableModel df = new DefaultTableModel(columns, 0);
            List<String[]> studentLeavesByRollum = std.getStudentLeavesByRollNum(rollNumVal);
            if (!studentLeavesByRollum.isEmpty()){
                for (String[] leaveByRollNum : studentLeavesByRollum){
                    String[] studentLeavesByRollNumRow = {leaveByRollNum[0], leaveByRollNum[1], leaveByRollNum[2]};
                    df.addRow(studentLeavesByRollNumRow);
                }
            }
            JTable studentLeavesByRollNumTable = new JTable(df);
            JScrollPane jsp2 = new JScrollPane(studentLeavesByRollNumTable);
            jsp2.setBounds(0, 110, 750, 580);
            add(jsp2);
        });

        print.addActionListener(e -> {
            PrinterJob pjob = PrinterJob.getPrinterJob();
            pjob.setPrintable(this);
            if (pjob.printDialog()){
                try {
                    pjob.print();
                } catch (PrinterException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        back.addActionListener(e -> dispose());

        setLocation(350, 80);
        setSize(750, 580);
        setLayout(null);
        setVisible(true);
    }
    public static void main(String[] args){
        new StudentLeaveDetails();
    }

    @Override
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
        if (pageIndex > 0) {
            return NO_SUCH_PAGE;
        }

        // User (0,0) is typically outside the
        // imageable area, so we must translate
        // by the X and Y values in the PageFormat
        // to avoid clipping.
        Graphics2D g2d = (Graphics2D)graphics;
        g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
        g2d.scale(0.47, 0.47);

        jp.print(g2d);

        // tell the caller that this page is part
        // of the printed document
        return PAGE_EXISTS;
    }
}
