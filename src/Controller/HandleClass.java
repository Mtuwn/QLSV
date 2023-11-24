/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Classes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import javax.swing.JOptionPane;

/**
 *
 * @author trant
 */
public class HandleClass {
     public HandleClass() {
    }
    Connection conn = Connect.getConnection();

    public void addClassDatabase(Classes x) throws SQLException, ParseException {

        String sql = "INSERT INTO Lop VALUES (?,?)";
        
        
        try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setString(1, x.getLop());
            preparedStatement.setString(2, x.getKhoa()); 
            preparedStatement.executeUpdate();

        } catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Thêm không thành công");
        }
    }

    public Boolean deleteClassDatabase(Classes x) throws SQLException {
        String sql = "delete from Lop where TenLop = ? ";
     
        try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setString(1, x.getLop());
          
            return preparedStatement.executeUpdate() > 0;
        } catch(SQLException e){
             JOptionPane.showMessageDialog(null, "Lớp đang có sinh viên không thế xóa!!!");
        }
        
        return null;
    }
}
