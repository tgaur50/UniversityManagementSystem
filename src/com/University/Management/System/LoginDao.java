package com.University.Management.System;

import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginDao {
    private ConnectionToDB cnToDb;
    private Connection con;
    private Statement stm;
    private ResultSet rs;
    public LoginDao(){
        cnToDb = new ConnectionToDB();
        con = cnToDb.getCon();
    }
    public boolean authenticateLogin(String username, String password){
        boolean isFound = false;
        String query = "select * from Login";
        try {
            stm = con.createStatement();
            rs = stm.executeQuery(query);
            while (rs.next()){
                String uname = rs.getString(1);
                String pwd = rs.getString(2);
                if (uname.equals(username) && pwd.equals(password)){
                    isFound = true;
                    break;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return isFound;
    }
}
