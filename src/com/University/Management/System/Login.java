package com.University.Management.System;

import javax.swing.*;
import java.awt.*;

public class Login extends JFrame {
    public Login(){
        JLabel username = new JLabel("Username");
        username.setFont(new Font("Arial", Font.BOLD, 12));
        username.setBounds(30, 20, 100, 30);
        add(username);

        JTextField userfield = new JTextField();
        userfield.setFont(new Font("Arial", Font.BOLD, 12));
        userfield.setBounds(140, 20, 150, 30);
        add(userfield);

        JLabel password = new JLabel("Password");
        password.setFont(new Font("Arial", Font.BOLD, 12));
        password.setBounds(30, 70, 100, 30);
        add(password);

        JPasswordField passField = new JPasswordField();
        passField.setFont(new Font("Arial", Font.BOLD, 12));
        passField.setBounds(140, 70, 150, 30);
        add(passField);

        JButton login = new JButton("Login");
        login.setFont(new Font("Arial", Font.BOLD, 12));
        login.setBounds(30, 130, 120, 25);
        login.setOpaque(true);
        login.setBorderPainted(false);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        add(login);

        JButton cancel = new JButton("Cancel");
        cancel.setFont(new Font("Arial", Font.BOLD, 12));
        cancel.setBounds(165, 130, 125, 25);
        cancel.setOpaque(true);
        cancel.setBorderPainted(false);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        add(cancel);

        ImageIcon ic = new ImageIcon(ClassLoader.getSystemResource("icons/person.jpg"));
        Image img = ic.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT);
        ImageIcon ic1 = new ImageIcon(img);
        JLabel image = new JLabel(ic1);
        image.setBounds(320, 0, 150, 150);
        add(image);

        login.addActionListener(e -> {
            String uName = userfield.getText();
            String pwd = passField.getText();
            LoginDao lgn = new LoginDao();
            if (lgn.authenticateLogin(uName, pwd)){
                JOptionPane.showMessageDialog(null,"Successfully logged in!");
                new HomePage();
                dispose();
            }
            else {
                JOptionPane.showMessageDialog(null, "Invalid Credentials!");
            }
        });

        cancel.addActionListener(e -> {
            dispose();
        });

        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setLocation(450, 300);
        setSize(550, 260);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    public static void main(String[] args){
        new Login();
    }
}
