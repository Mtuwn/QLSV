/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package BaiTapLon.View;

import Controller.Connect;
import Model.Teacher;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author TAN
 */
public class DanhSachGiaoVien1 extends javax.swing.JPanel {

    List<Teacher> list = new ArrayList<>();
    Teacher x = new Teacher();
    public DanhSachGiaoVien1() throws SQLException {
        initComponents();
        viewTable();
    }
     private void viewTable() throws SQLException {
        DefaultTableModel model = (DefaultTableModel) this.Table1.getModel();
        model.setNumRows(0);
        list.removeAll(list);

    String sql = "select * from giaovien";

        Connection conn = Connect.getConnection();

        try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
           
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {

                // Process the result set as needed
                Boolean gender = Integer.parseInt(rs.getString(4)) == 1 ? true : false;
                String gioiTinh = Integer.parseInt(rs.getString(4)) == 1 ? "Nam" : "Nữ";
                x = new Teacher(rs.getString(1), rs.getString(2), rs.getString(3), gender, rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(9),rs.getString(10));
                list.add(x);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        for (Teacher x : list) {
            model.addRow(new Object[]{x.getMaGv(), x.getHoTen(), x.isGioiTinh(), x.getEmail(),x.getSDT(),x.getMaMon()});
        }
       
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane7 = new javax.swing.JScrollPane();
        Table1 = new javax.swing.JTable();

        Table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null}
            },
            new String [] {
                "MGV", "Họ Tên", "Giới tính", "Email", "Số Điện Thoại", "Bộ Môn"
            }
        ));
        Table1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Table1MouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(Table1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 811, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void Table1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Table1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Table1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Table1;
    private javax.swing.JScrollPane jScrollPane7;
    // End of variables declaration//GEN-END:variables

}
