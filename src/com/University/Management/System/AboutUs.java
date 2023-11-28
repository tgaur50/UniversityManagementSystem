package com.University.Management.System;

import javax.swing.*;
import java.awt.*;

public class AboutUs extends JFrame {
    public AboutUs(){
        JLabel heading = new JLabel("<html>University<br>Management<br>System</html>");
        heading.setFont(new Font("Arial", Font.ITALIC | Font.BOLD, 30));
        heading.setForeground(Color.GREEN);
        heading.setBounds(60, 30, 200, 100);
        add(heading);

        JLabel developerName = new JLabel("Developed by : Tushar Gaur");
        developerName.setFont(new Font("Arial", Font.BOLD, 25));
        developerName.setBounds(60, 220, 350, 30);
        add(developerName);

        JLabel rollNum = new JLabel("Roll Number -  10000007");
        rollNum.setFont(new Font("Arial", Font.BOLD, 18));
        rollNum.setBounds(60, 270, 300, 30);
        add(rollNum);

        JLabel contact = new JLabel("Contact : gaur.tushar1000@mail.com");
        contact.setFont(new Font("Arial", Font.BOLD, 18));
        contact.setBounds(60, 310, 350, 30);
        add(contact);

        JLabel education = new JLabel("Education - B.Tech (Computer Science)");
        education.setFont(new Font("Arial", Font.BOLD, 18));
        education.setBounds(60, 350, 350, 30);
        add(education);

        JLabel phoneNum = new JLabel("Phone - +91 8755237588");
        phoneNum.setFont(new Font("Arial", Font.BOLD, 18));
        phoneNum.setBounds(60, 390, 300, 30);
        add(phoneNum);

        ImageIcon imgIcon = new ImageIcon(ClassLoader.getSystemResource("icons/about.jpg"));
        Image img = imgIcon.getImage().getScaledInstance(270, 180, Image.SCALE_DEFAULT);
        ImageIcon ic = new ImageIcon(img);
        JLabel imgLabel = new JLabel(ic);
        imgLabel.setBounds(300, 10, 270, 180);
        add(imgLabel);
        setLocation(400, 130);
        setSize(600, 480);
        setLayout(null);
        setVisible(true);
    }
    public static void main(String[] args){new AboutUs();}
}
