package com.University.Management.System;

import javax.swing.*;
import java.awt.*;

public class WelcomePage extends JFrame implements Runnable {
    Thread t;
    public WelcomePage(){
        ImageIcon ic = new ImageIcon(ClassLoader.getSystemResource("icons/welcome_screen.jpg"));
        Image img = ic.getImage().getScaledInstance(1000, 700, Image.SCALE_DEFAULT);
        ImageIcon ic1 = new ImageIcon(img);
        JLabel welcome = new JLabel(ic1);
        add(welcome);
        t = new Thread(this);
        t.start();
        setVisible(true);
        int x = 1;
        for (int i = 3; i <= 550; i+=4, x+=1){
            setLocation(550 - i/2, 350 - i/2);
            setSize(i+(i+x)/2, i+x);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public static void main(String[] args){
        new WelcomePage();
    }

    @Override
    public void run() {
        try {
            Thread.sleep(7000);
            setVisible(false);
            new Login();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
