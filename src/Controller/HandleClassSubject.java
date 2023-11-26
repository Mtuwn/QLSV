/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.ClassSubject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

/**
 *
 * @author trant
 */
public class HandleClassSubject {

    public HandleClassSubject() {
    }

    Connection conn = Connect.getConnection();
    

    public Boolean addClassDatabase(String TenMon, String Msv) throws SQLException, ParseException {

        String sql = "select MaMon from  MonHoc where TenMon=?";
        String MaMon = null;
        try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setString(1, TenMon);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                MaMon = rs.getString(1);
            }
        }
        

        String sqlInsert = "INSERT INTO LopTheoMon VALUES (?,?)";
        System.out.println(MaMon);
        
        try (PreparedStatement sttd = conn.prepareStatement(sqlInsert)) {
            sttd.setString(1, MaMon);
            sttd.setString(2, Msv); 
            return sttd.executeUpdate()>0;
        }
        
        
    }
    
     public Boolean deleteClassDatabase(String TenMon, String Msv) throws SQLException, ParseException {

        String sql = "select MaMon from  MonHoc where TenMon=?";
        String MaMon = null;
        try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setString(1, TenMon);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                MaMon = rs.getString(1);
            }
        }
        

        String sqlDelete = "Delete from LopTheoMon where Msv= ? and MaMon = ?";
        
        try (PreparedStatement sttd = conn.prepareStatement(sqlDelete)) {
            sttd.setString(1, Msv);
            sttd.setString(2, MaMon); 
            return sttd.executeUpdate()>0;
        }
    }
}
