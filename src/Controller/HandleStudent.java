/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author trant
 */
public class HandleStudent {

    public HandleStudent() {
    }
    Connection conn = Connect.getConnection();

    private String handlePasswd(String passwd) {
        String regex = "-";
        passwd = passwd.replaceAll(regex, "");
        return passwd;
    }

    public boolean addStudentDatabase(Student x) throws SQLException, ParseException {
        String sql = "INSERT INTO SinhVien VALUES (?,?,?,?,?,?,?,?,?)";
        int gioiTinh = (x.isGioiTinh().equals("Nam")) ? 1 : 0;

        try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setString(1, x.getMsv());
            preparedStatement.setString(2, x.getHoTen());

            // Chuyển đổi ngày sinh thành java.sql.Date
            preparedStatement.setString(3, x.getNgaySinh());

            preparedStatement.setInt(4, gioiTinh);
            preparedStatement.setString(5, x.getSDT());
            preparedStatement.setString(6, x.getDiaChi());
            preparedStatement.setString(7, x.getEmail());
            preparedStatement.setString(8, x.getLop());
            preparedStatement.setString(9, handlePasswd(x.getNgaySinh()));
            return preparedStatement.executeUpdate()>0;
        } catch(SQLException e){
            return false;
        }

    }

    public Boolean updateStudentDatabase(Student x) throws SQLException {
        String sql = "update SinhVien set Hoten=?,NgaySinh=?,GioiTinh=?,SDT=?,DiaChi=?,Email=?,Lop=?,passwd=? where Msv = ?";
        int gioiTinh = (x.isGioiTinh().equals("Nam")) ? 1 : 0;

        try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {

            preparedStatement.setString(1, x.getHoTen());

            // Chuyển đổi ngày sinh thành java.sql.Date
            preparedStatement.setString(2, x.getNgaySinh());

            preparedStatement.setInt(3, gioiTinh);
            preparedStatement.setString(4, x.getSDT());
            preparedStatement.setString(5, x.getDiaChi());
            preparedStatement.setString(6, x.getEmail());
            preparedStatement.setString(7, x.getLop());
            preparedStatement.setString(8, x.getNgaySinh());

            preparedStatement.setString(9, x.getMsv());

            // Sử dụng executeUpdate cho truy vấn INSERT/UPDATE/DELETE
            return preparedStatement.executeUpdate() > 0;
        }

    }

    public Boolean deleteStudentDatabase(String x) throws SQLException {
        String sql = "delete from Diem where Msv = ?  ;delete from LopTheoMon where Msv = ?  ;delete from SinhVien where Msv = ?  ;";

        try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setString(1, x);
            preparedStatement.setString(2, x);
            preparedStatement.setString(3, x);
            return preparedStatement.executeUpdate() > 0;
        }

    }

}
