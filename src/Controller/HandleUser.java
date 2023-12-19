/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import BaiTapLon.View.GiaoVienView;
import BaiTapLon.View.KhaoThiView;
import BaiTapLon.View.SinhVienView;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;

/**
 *
 * @author TAN
 */
public class HandleUser {

    public HandleUser() throws SQLException, ParseException {
       }
    
    String userName = ActiveUser.user;
    String password = ActiveUser.password;
    String tuCach = ActiveUser.tuCach;
    
    Connection conn = Connect.getConnection();
    
    public String ktraUser() throws SQLException, ParseException{

       if(tuCach == "khaothi") {
//       ktra tồn tại user khảo thí
         String sql = "select * from  khaothi where username = ? and passwd = ?";       
        try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setString(1, this.userName);
            preparedStatement.setString(2, this.password);

            ResultSet rs = preparedStatement.executeQuery();
            if(rs.next())
            {
                   
                   ActiveUser.hoTen = userName;
                   KhaoThiView khaothi = new KhaoThiView();
                   khaothi.setVisible(true);
                   khaothi.setLocationRelativeTo(null);
                   
                   return "";
            }
//            return về lỗi
            else  return  "Khảo Thí không tồn tại tài khoản này";
        }
        
       }
   
        else if (tuCach == "giaovien"){
//             ktra tồn tại user giáo viên
           String sql = "select * from  giaovien where magv = ? and passwd = ?";       
           try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setString(1, this.userName);
            preparedStatement.setString(2, this.password);

            ResultSet rs = preparedStatement.executeQuery();
            if(rs.next())
            { 
                 
                 ActiveUser.hoTen = rs.getString("Hoten");
                GiaoVienView giaovien = new GiaoVienView();
                giaovien.setVisible(true);
                giaovien.setLocationRelativeTo(null);
               
                   return "";
            }
//            return về lỗi
            else  return  "Giáo Viên không tồn tại tài khoản này";
        }
        
         
        }
        else if(tuCach == "sinhvien"){
            //       ktra tồn tại user sinh vien
         String sql = "select * from  sinhvien where msv = ? and passwd = ?";       
        try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setString(1, this.userName);
            preparedStatement.setString(2, this.password);

            ResultSet rs = preparedStatement.executeQuery();
            if(rs.next())
            {
                
                  ActiveUser.hoTen = rs.getString("Hoten");
                  SinhVienView sinhvien = new SinhVienView();
                  sinhvien.setVisible(true);
                  sinhvien.setLocationRelativeTo(null);
                  
                   return "";
            }
//            return về lỗi
            else  return "Sinh Viên không tồn tại tài khoản này";
        }
         
        }    
       return "";
   }    
    
}