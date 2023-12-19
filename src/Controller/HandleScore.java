/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import com.sun.corba.se.spi.orbutil.fsm.Guard;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author trant
 */
public class HandleScore {

    public HandleScore() {
    }

    public Boolean updateScoreDatabse(float diemCC, float diemGK, float diemThi, String Msv, String TenMon) throws SQLException {
        String sql = "select d.DiemChuyenCan from SinhVien as s left join diem as d on d.Msv = s.Msv join MonHoc M on M.MaMon = D.MaMon\n"
                + "where M.TenMon = ? and D.Msv = ?";
//        sql = "update Diem set DiemThi = ?,DiemChuyenCan = ?, DiemGk=? where Msv = ?";
        Connection conn = Connect.getConnection();
        String MaMon = "";
        try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {

            preparedStatement.setString(1, TenMon);
            preparedStatement.setString(2, Msv);

            ResultSet rs = preparedStatement.executeQuery();
//            System.out.println(rs.getString(1));
            if (rs.next()) {

                sql = "update Diem set DiemThi = ?,DiemChuyenCan = ?, DiemGk=? where Msv = ?";
                try (PreparedStatement sttd = conn.prepareStatement(sql)) {
                    sttd.setFloat(1, diemThi);
                    sttd.setFloat(2, diemCC);
                    sttd.setFloat(3, diemGK);
                    sttd.setString(4, Msv);
                    return sttd.executeUpdate() > 0;
                }
            } else {

                sql = "select MaMon from MonHoc";
                try (PreparedStatement a = conn.prepareStatement(sql)) {
                    ResultSet aa = a.executeQuery();

                    while (aa.next()) {
                        MaMon = aa.getString(1);
                    }
                }
                System.out.println("Day la:" + MaMon);
                sql = "INSERT INTO Diem (Msv, MaMon, DiemChuyenCan, DiemGk, DiemThi) VALUES(?,?,?,?,?)";
                try (PreparedStatement sttd = conn.prepareStatement(sql)) {
                    sttd.setString(1, Msv);
                    sttd.setString(2, MaMon);
                    sttd.setFloat(3, diemCC);
                    sttd.setFloat(4, diemGK);
                    sttd.setFloat(5, diemThi);

                    return sttd.executeUpdate() > 0;
                }
            }
        }
    }

}
