/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Teacher;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;

/**
 *
 * @author trant
 */
public class HandleTeacher {

    public HandleTeacher() {
    }
    Connection conn = Connect.getConnection();

    public void addTeacherDatabase(Teacher x) throws SQLException, ParseException {

        String sql = "INSERT INTO GiaoVien VALUES (?,?,?,?,?,?,?,?,?,?)";
        int gioiTinh = (x.isGioiTinh().equals("Nam")) ? 1 : 0;

        try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setString(1, x.getMaGv());
            preparedStatement.setString(2, x.getHoTen());

            // Chuyển đổi ngày sinh thành java.sql.Date
            preparedStatement.setString(3, x.getNgaySinh());

            preparedStatement.setInt(4, gioiTinh);
            preparedStatement.setString(5, x.getSDT());
            preparedStatement.setString(6, x.getDiaChi());
            preparedStatement.setString(7, x.getEmail());
            preparedStatement.setString(8, x.getTrinhDo());
            preparedStatement.setInt(9, x.getLuong());
            preparedStatement.setString(10, x.getMaMon());

            // Sử dụng executeUpdate cho truy vấn INSERT/UPDATE/DELETE
            preparedStatement.executeUpdate();
        }

    }

    public Boolean updateStudentDatabase(Teacher x) throws SQLException {
        String sql = "update GiaoVien set Hoten=?,NgaySinh=?,GioiTinh=?,SDT=?,DiaChi=?,Email=?,TrinhDo=?,Luong=?,MaMon=? where MaGv = ?";

        int gioiTinh = (x.isGioiTinh().equals("Nam")) ? 1 : 0;

        try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {

            preparedStatement.setString(1, x.getHoTen());

            // Chuyển đổi ngày sinh thành java.sql.Date
            preparedStatement.setString(2, x.getNgaySinh());

            preparedStatement.setInt(3, gioiTinh);
            preparedStatement.setString(4, x.getSDT());
            preparedStatement.setString(5, x.getDiaChi());
            preparedStatement.setString(6, x.getEmail());
            preparedStatement.setString(7, x.getTrinhDo());
            preparedStatement.setInt(8, x.getLuong());
            preparedStatement.setString(9, x.getMaMon());
            preparedStatement.setString(10, x.getMaGv());
            
            

            // Sử dụng executeUpdate cho truy vấn INSERT/UPDATE/DELETE
            return preparedStatement.executeUpdate() > 0;
        }

    }

    public Boolean deleteStudentDatabase(String x) throws SQLException {
        String sql = "delete from GiaoVien where MaGv=?";
        try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setString(1, x);
      

            return preparedStatement.executeUpdate() > 0;
        }

    }
}
