package com.University.Management.System;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FeeStructure extends JFrame {
    public FeeStructure(){
        JLabel heading = new JLabel("Fee Structure");
        heading.setFont(new Font("Arial", Font.BOLD, 18));
        heading.setBounds(40, 30, 150, 30);
        add(heading);

        StudentDetailsDao std = new StudentDetailsDao();

        ResultSet rs = std.getFeeDetails();
        String[] tableHeaderRow = {"Course", "semester1", "semester2", "semester3", "semester4",
                "semester5", "semester6", "semester7", "semester8"};

        DefaultTableModel dft = new DefaultTableModel(tableHeaderRow, 0);
        while (true) {
            try {
                if (!rs.next()) break;
                else {
                    String courseName = rs.getString(1);
                    String sem1Fee = String.valueOf(rs.getInt(2));
                    sem1Fee = !sem1Fee.equals("0") ? sem1Fee : "";
                    String sem2Fee = String.valueOf(rs.getInt(3));
                    sem2Fee = !sem2Fee.equals("0") ? sem2Fee : "";
                    String sem3Fee = String.valueOf(rs.getInt(4));
                    sem3Fee = !sem3Fee.equals("0") ? sem1Fee : "";
                    String sem4Fee = String.valueOf(rs.getInt(5));
                    sem4Fee = !sem4Fee.equals("0") ? sem1Fee : "";
                    String sem5Fee = String.valueOf(rs.getInt(6));
                    sem5Fee = !sem5Fee.equals("0") ? sem1Fee : "";
                    String sem6Fee = String.valueOf(rs.getInt(7));
                    sem6Fee = !sem6Fee.equals("0") ? sem1Fee : "";
                    String sem7Fee = String.valueOf(rs.getInt(8));
                    sem7Fee = !sem7Fee.equals("0") ? sem1Fee : "";
                    String sem8Fee = String.valueOf(rs.getInt(9));
                    sem8Fee = !sem8Fee.equals("0") ? sem1Fee : "";
                    String[] tableRow = {courseName, sem1Fee, sem2Fee, sem3Fee, sem4Fee,
                            sem5Fee, sem6Fee, sem7Fee, sem8Fee};
                    dft.addRow(tableRow);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        JTable feeTable = new JTable(dft);
        JScrollPane jsp = new JScrollPane(feeTable);
        jsp.setBounds(0, 70, 750, 580);
        add(jsp);

        setLocation(350, 80);
        setSize(750, 580);
        setLayout(null);
        setVisible(true);
    }
    public static void main(String[] args){new FeeStructure();}
}
