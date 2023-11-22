/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author trant
 */
public class HandleScore {

    public HandleScore() {
    }

    public Boolean updateScoreDatabse(float diem, String Msv) throws SQLException {
//          if(diem < 0 || diem > 10)
//        {
//            JOptionPane.showMessageDialog(null, "Dữ liệu không hợp lệ");
//            return false;
//        }
        String sql = "update Diem set DiemThi = ? where Msv = ?";
        Connection conn = Connect.getConnection();
        try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setFloat(1, diem);
            preparedStatement.setString(2, Msv);
            return preparedStatement.executeUpdate()>0;
        }
    }


}
