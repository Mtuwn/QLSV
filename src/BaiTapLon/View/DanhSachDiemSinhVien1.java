/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaiTapLon.View;

import Controller.Connect;
import Model.DiemSinhVien;
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
public class DanhSachDiemSinhVien1 extends javax.swing.JPanel {

    List<DiemSinhVien> list = new ArrayList<>();
    DiemSinhVien x = new DiemSinhVien();
    public DanhSachDiemSinhVien1() throws SQLException {
        initComponents();
        viewTable();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane7 = new javax.swing.JScrollPane();
        Table1 = new javax.swing.JTable();

        Table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null}
            },
            new String [] {
                "MSV", "Họ Tên", "Điểm thành phần  1", "Điểm thành phần 2", "Điểm tổng kết"
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
            .addGap(0, 782, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 782, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 402, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
   
     private void viewTable() throws SQLException {
        DefaultTableModel model = (DefaultTableModel) this.Table1.getModel();
        model.setNumRows(0);
        list.removeAll(list);

    String sql = "select * from diem";

        Connection conn = Connect.getConnection();

        try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
           
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                x = new DiemSinhVien(rs.getString(1), rs.getString(2), rs.getFloat(3), rs.getFloat(4), rs.getFloat(5));
                list.add(x);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        for (DiemSinhVien x : list) {
            model.addRow(new Object[]{x.getMaSV(), x.getMaMon(), x.getDiemCC(), x.getDiemGK(),x.getDiemCK()});
        }
       
    }
    private void Table1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Table1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Table1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Table1;
    private javax.swing.JScrollPane jScrollPane7;
    // End of variables declaration//GEN-END:variables
}
