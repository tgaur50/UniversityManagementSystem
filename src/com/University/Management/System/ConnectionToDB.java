package com.University.Management.System;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionToDB {
    private final Connection con;
    public ConnectionToDB(){
        String url = "jdbc:mysql:///UniversityManagementSystem";
        String password = "ThisisMySql11*";
        String user = "root";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Connection getCon() {
        return con;
    }
}
