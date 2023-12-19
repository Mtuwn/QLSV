/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author TAN
 */
public class HandleViewInformation {

    public static String hoten;
    public static String ngaySinh;
    public static int gioiTinh;
    public static String sdt;
    public static String diaChi;
    public static String email;
//    rieng giao vien
    public static String trinhDo;
    public static String luong;
    public static String maMon;
//    rieng hoc sinh
    public static String lop;
    public static float mon1;
    public static float mon2;
    public static float mon3;
    public static float mon4;
    public static float mon5;
    public static float dtb;



    public HandleViewInformation() {
    }
    Connection conn = Connect.getConnection();
    
//    hàm xử lí in thông tin giáo viên
    public void getInformationGiaoVien(String magv) throws SQLException{
       String sql = "select * from  giaovien where magv =?";       
        try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setString(1, magv);

            ResultSet rs = preparedStatement.executeQuery();
            if(rs.next())
            {
                HandleViewInformation.hoten = rs.getString("hoten");
                HandleViewInformation.ngaySinh = rs.getString("ngaysinh");
                HandleViewInformation.gioiTinh = rs.getInt("gioitinh");
                HandleViewInformation.sdt = rs.getString("sdt");
                HandleViewInformation.diaChi = rs.getString("diachi");
                HandleViewInformation.email = rs.getString("email");
                HandleViewInformation.trinhDo = rs.getString("trinhdo");
                HandleViewInformation.luong = rs.getString("luong");
                HandleViewInformation.maMon = rs.getString("mamon");
                

            }
            }
    }
    
    
//    hàm xử lí in thông tin sinh viên
     public void getInformationSinhVien(String masv) throws SQLException{
       String sql = "select * from  sinhvien where msv =?";       
        try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setString(1, masv);

            ResultSet rs = preparedStatement.executeQuery();
            if(rs.next())
            {
                HandleViewInformation.hoten = rs.getString("hoten");
                HandleViewInformation.ngaySinh = rs.getString("ngaysinh");
                HandleViewInformation.gioiTinh = rs.getInt("gioitinh");
                HandleViewInformation.sdt = rs.getString("sdt");
                HandleViewInformation.diaChi = rs.getString("diachi");
                HandleViewInformation.email = rs.getString("email");
                HandleViewInformation.lop = rs.getString("lop");
            }
            }
    }
     
     //    hàm xử lí in thông tin sinh viên
     public void getDiemSinhVien(String masv) throws SQLException{
       String sql = "select * from  diem where msv =?";       
        try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setString(1, masv);

            ResultSet rs = preparedStatement.executeQuery();
            if(rs.next())
            {
                HandleViewInformation.mon1 = rs.getFloat("diemthi");
            }
             if(rs.next())
            {
                HandleViewInformation.mon2 = rs.getFloat("diemthi");
            }
              if(rs.next())
            {
                HandleViewInformation.mon3 = rs.getFloat("diemthi");
            }
               if(rs.next())
            {
                HandleViewInformation.mon4 = rs.getFloat("diemthi");
            }
                if(rs.next())
            {
                HandleViewInformation.mon5 = rs.getFloat("diemthi");
            }
             HandleViewInformation.dtb = ( mon1 + mon2 + mon3 + mon4 + mon5 ) / 5;

            }
    }
}
