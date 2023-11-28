package com.University.Management.System;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

public class ExaminationDetails extends JFrame {
    private JPanel jp;
    public ExaminationDetails(){
        JLabel heading = new JLabel("Check Result");
        heading.setFont(new Font("Arial", Font.BOLD, 18));
        heading.setBounds(80, 40, 150, 30);
        add(heading);

        JTextField rollNumField = new JTextField();
        rollNumField.setFont(new Font("Arial", Font.BOLD, 14));
        rollNumField.setBounds(80, 90, 150, 30);
        add(rollNumField);

        JButton result = new JButton("Result");
        result.setFont(new Font("Arial", Font.BOLD, 12));
        result.setOpaque(true);
        result.setBorderPainted(false);
        result.setForeground(Color.WHITE);
        result.setBackground(Color.BLACK);
        result.setBounds(250, 90, 120, 28);
        add(result);

        JButton back = new JButton("Back");
        back.setFont(new Font("Arial", Font.BOLD, 12));
        back.setOpaque(true);
        back.setBorderPainted(false);
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        back.setBounds(390, 90, 120, 28);
        add(back);

        StudentDetailsDao std = new StudentDetailsDao();
        List<Student> listOfStudents = std.getStudent();

        String[] columns = {"name", "fname", "dob", "address", "phone", "email", "class_X",
                "class_XII", "aadhar", "rollno", "course", "branch"};
        DefaultTableModel dft = new DefaultTableModel(columns, 0);
        for (Student student : listOfStudents) {
            String[] studentRow = {student.getName(), student.getFatherName(),
                    student.getDob(), student.getAddress(),
                    String.valueOf(student.getPhone()), student.getEmailId(),
                    String.valueOf(student.getClassX()),
                    String.valueOf(student.getClassXII()), student.getAadhaarNo(),
                    String.valueOf(student.getRollNum()), student.getCourse(),
                    student.getBranch()};
            dft.addRow(studentRow);
        }
        JTable table = new JTable(dft);
        JScrollPane jsp = new JScrollPane(table);
        jp = new JPanel();
        jp.setLayout(new BorderLayout());
        jp.add(jsp);
        jp.setBounds(0, 120, 950, 540);
        add(jp);

        table.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = table.getSelectedRow();
                String rollNumVal = String.valueOf(table.getValueAt(row, 9));
                rollNumField.setText(rollNumVal);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        result.addActionListener(e -> {
            String rollNumValue = rollNumField.getText();
            if (!rollNumValue.equals("")){
                new ExamResult(rollNumValue);
                dispose();
            }
            else {
                JOptionPane.showMessageDialog(null, "Please select a row!");
            }
        });

        back.addActionListener(e -> dispose());

        setLocation(260, 120);
        setSize(950, 540);
        setLayout(null);
        setVisible(true);
    }
    public static void main(String[] args){new ExaminationDetails();}
}
