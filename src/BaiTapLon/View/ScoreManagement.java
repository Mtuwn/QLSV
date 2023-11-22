/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaiTapLon.View;

import Controller.Connect;
import Controller.HandleScore;
import Model.Score;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author trant
 */
public class ScoreManagement extends javax.swing.JPanel {

    /**
     * Creates new form Score
     */
    List<Score> list = new ArrayList<Score>();
    Score x = new Score();
    private static int pos = 0;
    private boolean flag = true;
    
    public ScoreManagement() throws SQLException {
        initComponents();
        viewTable();
        ShowComboBox();
    }
     private void view() throws SQLException {

        x = list.get(pos);
        this.textName.setText(x.getHoTen());
        this.textMsv.setText(x.getMsv());
        this.textDiemThi.setText(Float.toString(x.getDiemThi()));
        this.textDiemTk.setText((x.getDiemTongKet()));
        this.textDiemTk.setEditable(false);
        this.textName.setEditable(false);
        this.textMsv.setEditable(false);
        
        
       
//        
//       
    }
    
    private void viewTable() throws SQLException {
        DefaultTableModel model = (DefaultTableModel) this.Table1.getModel();
        model.setNumRows(0);
        list.removeAll(list);
        String selectedItem = (String) jComboBox1.getSelectedItem();
        String sql = "select D.*,S.HoTen from Diem as D join MonHoc as M on M.MaMon = D.MaMon join SinhVien as S on S.Msv = D.Msv where M.TenMon=? Order by S.HoTen";
        
        Connection conn = Connect.getConnection();

        try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            
            preparedStatement.setString(1, selectedItem);

            // Execute the query and process the results
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {

                x = new Score(rs.getString(1), rs.getString(6),rs.getString(2), Float.parseFloat(rs.getString(3)),  Float.parseFloat(rs.getString(4)), Float.parseFloat(rs.getString(5)));
                list.add(x);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        for (Score x : list) {
            model.addRow(new Object[]{x.getMsv(), x.getHoTen(), x.getDiemChuyenCan(), x.getDiemGk(), x.getDiemThi(),x.getDiemTongKet()});
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        textName = new javax.swing.JTextField();
        textMsv = new javax.swing.JTextField();
        textDiemThi = new javax.swing.JTextField();
        jScrollPane7 = new javax.swing.JScrollPane();
        Table1 = new javax.swing.JTable();
        jComboBox1 = new javax.swing.JComboBox<>();
        textDiemTk = new javax.swing.JTextField();
        EditOb = new javax.swing.JButton();

        jLabel18.setText("Họ Tên:");

        jLabel21.setText("Mã sinh viên:");

        jLabel23.setText("Điểm thi:");

        jLabel24.setText("Điểm tổng kết");

        textName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textNameActionPerformed(evt);
            }
        });

        textMsv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textMsvActionPerformed(evt);
            }
        });

        textDiemThi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textDiemThiActionPerformed(evt);
            }
        });

        Table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null}
            },
            new String [] {
                "MSV", "Họ Tên", "Điểm chuyên cần", "ĐIểm giữa kỳ", "Điểm thi", "Điểm tổng kết"
            }
        ));
        Table1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Table1MouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(Table1);
        if (Table1.getColumnModel().getColumnCount() > 0) {
            Table1.getColumnModel().getColumn(2).setResizable(false);
        }

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "OOP", "LTCB", "MMH" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        textDiemTk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textDiemTkActionPerformed(evt);
            }
        });

        EditOb.setText("Cập nhật");
        EditOb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditObActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel19)
                                    .addComponent(jLabel24)
                                    .addComponent(jLabel21))
                                .addGap(39, 39, 39))
                            .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textName, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textMsv, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(EditOb)))
                            .addComponent(textDiemTk, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textDiemThi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 675, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel18)
                    .addComponent(textName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel21)
                        .addComponent(textMsv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(textDiemThi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(textDiemTk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(EditOb)
                .addGap(32, 32, 32))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1084, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 567, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(47, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void textNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textNameActionPerformed

    private void textMsvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textMsvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textMsvActionPerformed

    private void textDiemThiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textDiemThiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textDiemThiActionPerformed

    private void Table1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Table1MouseClicked
        // TODO add your handling code here:
        pos = this.Table1.getSelectedRow();
        try {
            view();
        } catch (SQLException ex) {
            Logger.getLogger(ScoreManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_Table1MouseClicked

    private void EditObActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditObActionPerformed
        // TODO add your handling code here:
        
        HandleScore handle = new HandleScore();
        float Score = Float.parseFloat(this.textDiemThi.getText());
        if(Score < 0 || Score > 10)
        {
            JOptionPane.showMessageDialog(null, "Dữ liệu không hợp lệ");
            return;
        }
        String Msv = this.textMsv.getText();
        try {
            if(handle.updateScoreDatabse(Score, Msv)){
                JOptionPane.showMessageDialog(null, "Cập nhật thành công!!!");
            } else {
                JOptionPane.showMessageDialog(null, "Cập nhật không thành công!!!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ScoreManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            viewTable();
        } catch (SQLException ex) {
            Logger.getLogger(ScoreManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_EditObActionPerformed
     private void ShowComboBox() throws SQLException{
        String selectedItem = (String) jComboBox1.getSelectedItem();

        String sql = "select M.TenMon from Diem as D join MonHoc as M on M.MaMon = D.MaMon group by M.TenMon\n" +
"									";
        
        Connection conn = Connect.getConnection();
        jComboBox1.removeAllItems();
        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery(sql);
         while (rs.next()) {
                // Process the result set as needed
                jComboBox1.addItem(rs.getString(1));

            }
    }
    
    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        try {
            // TODO add your handling code here:
            viewTable();
        } catch (SQLException ex) {
            Logger.getLogger(ScoreManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void textDiemTkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textDiemTkActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textDiemTkActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton EditOb;
    private javax.swing.JTable Table1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTextField textDiemThi;
    private javax.swing.JTextField textDiemTk;
    private javax.swing.JTextField textMsv;
    private javax.swing.JTextField textName;
    // End of variables declaration//GEN-END:variables
}
