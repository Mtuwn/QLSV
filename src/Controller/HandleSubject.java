/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Subject;
import com.sun.org.apache.xpath.internal.compiler.OpCodes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import javax.swing.JOptionPane;

/**
 *
 * @author trant
 */
public class HandleSubject {

    public HandleSubject() {
    }
    
    Connection conn = Connect.getConnection();
    public void addSubjectDatabase(Subject x) throws SQLException, ParseException {

        String sql = "INSERT INTO MonHoc VALUES (?,?,?)";
        try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setString(1, x.getMaMon());
            preparedStatement.setString(2, x.getTenMon());
            preparedStatement.setInt(3, x.getSoTin());
            preparedStatement.executeUpdate();
        }

    }

    public Boolean updateSubjectDatabase(Subject x) throws SQLException {

        String sql = "update MonHoc set TenMon = ? , SoTin = ? where MaMon = ?";
        try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {

            preparedStatement.setString(1, x.getTenMon());


            preparedStatement.setInt(2, x.getSoTin());
            preparedStatement.setString(3, x.getMaMon());
        

            // Sử dụng executeUpdate cho truy vấn INSERT/UPDATE/DELETE
            return preparedStatement.executeUpdate() > 0;
        }

    }

    public Boolean deleteSubjectDatabase(String x) throws SQLException {
        String sql = "delete from MonHoc where MaMon = ?  ";

        try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setString(1, x);
            preparedStatement.setString(2, x);
            preparedStatement.setString(3, x);
            return preparedStatement.executeUpdate() > 0;
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Ồ môn học này hiện tại không thể xóa!!!");
            return false;
        }
        
    }

}
