package com.University.Management.System;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.util.List;

public class ViewTeacherDetails extends JFrame implements Printable {
    private final JPanel jp;
    private JPanel jp2;
    public ViewTeacherDetails(){
        JLabel searchByEmpId = new JLabel("Search by Employee Id");
        searchByEmpId.setFont(new Font("Arial", Font.BOLD, 14));
        searchByEmpId.setBounds(30, 30, 200, 30);
        add(searchByEmpId);

        StudentDetailsDao std = new StudentDetailsDao();

        List<Faculty> listOfTeachers = std.getTeachers();
        String[] teachersId = new String[listOfTeachers.size()];
        int index = 0;
        for (Faculty ft : listOfTeachers){
            teachersId[index++] = String.valueOf(ft.getEmployeeId());
        }
        JComboBox<String> searchFieldMenu = new JComboBox<>(teachersId);
        searchFieldMenu.setFont(new Font("Arial", Font.BOLD, 14));
        searchFieldMenu.setBounds(240, 30, 200, 30);
        add(searchFieldMenu);

        JButton search = new JButton("Search");
        search.setFont(new Font("Arial", Font.BOLD, 12));
        search.setFocusPainted(false);
        search.setBounds(30, 80, 100, 30);
        add(search);

        JButton print = new JButton("Print");
        print.setFont(new Font("Arial", Font.BOLD, 12));
        print.setFocusPainted(false);
        print.setBounds(140, 80, 100, 30);
        add(print);

        JButton addBtn = new JButton("Add");
        addBtn.setFont(new Font("Arial", Font.BOLD, 12));
        addBtn.setFocusPainted(false);
        addBtn.setBounds(250, 80, 100, 30);
        add(addBtn);

        JButton update = new JButton("Update");
        update.setFont(new Font("Arial", Font.BOLD, 12));
        update.setFocusPainted(false);
        update.setBounds(360, 80, 100, 30);
        add(update);

        JButton back = new JButton("Back");
        back.setFont(new Font("Arial", Font.BOLD, 12));
        back.setFocusPainted(false);
        back.setBounds(470, 80, 100, 30);
        add(back);

        String[] columns = {"name", "fname", "dob", "address", "phone", "email", "class X",
                "class XII", "aadhaar", "empid", "course", "branch"};
        DefaultTableModel dft = new DefaultTableModel(columns, 0);
        for (Faculty faculty : listOfTeachers) {
            String[] teacherRow = {faculty.getName(), faculty.getFatherName(),
                    faculty.getDob(), faculty.getAddress(),
                    String.valueOf(faculty.getPhone()), faculty.getEmailId(),
                    String.valueOf(faculty.getClassX()),
                    String.valueOf(faculty.getClassXII()), faculty.getAadhaarNo(),
                    String.valueOf(faculty.getEmployeeId()), faculty.getEducation(),
                    faculty.getDepartment()};
            dft.addRow(teacherRow);
        }
        JTable table = new JTable(dft);
        JScrollPane jsp = new JScrollPane(table);
        jp = new JPanel();
        jp.setLayout(new BorderLayout());
        jp.add(jsp);
        jp.setBounds(0, 120, 750, 580);
//        jp.setVisible(true);
        add(jp);

        search.addActionListener(e -> {
            String empIdVal = String.valueOf(searchFieldMenu.getSelectedItem());
            StudentDetailsDao stdao = new StudentDetailsDao();
            Faculty faculty = stdao.searchByEmployeeId(empIdVal);
            DefaultTableModel df = new DefaultTableModel(columns, 0);
            String[] teacherEmpIdRow = {faculty.getName(), faculty.getFatherName(),
                    faculty.getDob(), faculty.getAddress(),
                    String.valueOf(faculty.getPhone()), faculty.getEmailId(),
                    String.valueOf(faculty.getClassX()),
                    String.valueOf(faculty.getClassXII()), faculty.getAadhaarNo(),
                    String.valueOf(faculty.getEmployeeId()), faculty.getEducation(),
                    faculty.getDepartment()};
            df.addRow(teacherEmpIdRow);
            JTable teacherTable = new JTable(df);
            JScrollPane jsp2 = new JScrollPane(teacherTable);
//            jp.setVisible(false);
//            jp2 = new JPanel();
//            jp2.setLayout(new BorderLayout());
//            jp2.add(jsp2);
//            jp2.setBounds(0, 120, 750, 580);
//            add(jp2);
            jsp2.setBounds(0, 120, 750, 580);
            add(jsp2);
        });

        addBtn.addActionListener(e -> {
            new AddFacultyDetails();
            dispose();
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

        update.addActionListener(e -> {
            new UpdateTeacherDetails();
            dispose();
        });

        back.addActionListener(e -> dispose());

        setLocation(350, 80);
        setSize(750, 580);
        setLayout(null);
        setVisible(true);
    }
    public static void main(String[] args){
        new ViewTeacherDetails();
    }

    @Override
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) {
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

