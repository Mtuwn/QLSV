/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author trant
 */
public class Connect {
    public static Connection getConnection() {
        Connection conn = null;
        try{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url ="jdbc:sqlserver://LAPTOP-S1L4C1MF:1433;databaseName=QuanLySinhVien;encrypt=true;trustServerCertificate=true;";
        String userName = "sa";
        String Password = "16040312b";
       conn = DriverManager.getConnection(url, userName, Password);

        } catch(ClassNotFoundException | SQLException e){
            System.out.println(e);
        }
        
        return conn;
    }




   
}