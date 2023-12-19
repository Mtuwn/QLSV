/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaiTapLon.View;

import Controller.ActiveUser;
import Controller.Connect;
import Model.DiemSinhVien;
import Model.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author TAN
 */
public class ViewSinhVienGiaoVien extends javax.swing.JFrame {

     private JPanel chillPanel;
  
    public ViewSinhVienGiaoVien(String table) throws SQLException {
       initComponents();
       setLocationRelativeTo(null);
       if(table == "diem") show(new DanhSachDiemSinhVien1());
       else if(table == "giaovien") show(new DanhSachGiaoVien1());
       else show(new DanhSachSinhVien1());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        danhSachSinhVien = new javax.swing.JButton();
        danhSachGiaoVien = new javax.swing.JButton();
        diemSinhVien = new javax.swing.JButton();
        jLabel40 = new javax.swing.JLabel();
        content = new javax.swing.JPanel();
        content1 = new javax.swing.JPanel();
        back = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel6.setBackground(new java.awt.Color(153, 255, 153));

        danhSachSinhVien.setBackground(new java.awt.Color(51, 153, 255));
        danhSachSinhVien.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        danhSachSinhVien.setText("Xem DS Sinh Viên");
        danhSachSinhVien.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        danhSachSinhVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                danhSachSinhVienActionPerformed(evt);
            }
        });

        danhSachGiaoVien.setBackground(new java.awt.Color(51, 153, 255));
        danhSachGiaoVien.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        danhSachGiaoVien.setText("Xem DS Giáo Viên");
        danhSachGiaoVien.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        danhSachGiaoVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                danhSachGiaoVienActionPerformed(evt);
            }
        });

        diemSinhVien.setBackground(new java.awt.Color(51, 153, 255));
        diemSinhVien.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        diemSinhVien.setText("Xem  Điểm Sinh Viên");
        diemSinhVien.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        diemSinhVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                diemSinhVienActionPerformed(evt);
            }
        });

        jLabel40.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel40.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel40.setText("Tiện Ích Mở Rộng");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(danhSachSinhVien, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(76, 76, 76)
                .addComponent(danhSachGiaoVien, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                .addComponent(diemSinhVien, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(260, 260, 260)
                .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(jLabel40)
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(danhSachGiaoVien, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(danhSachSinhVien, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(diemSinhVien, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        content.setLayout(new java.awt.BorderLayout());

        content1.setLayout(new java.awt.BorderLayout());

        back.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        back.setText("Back");
        back.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(207, 207, 207)
                        .addComponent(content1, javax.swing.GroupLayout.PREFERRED_SIZE, 750, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(189, 189, 189)
                        .addComponent(content, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(190, 190, 190)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(61, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(content1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(content, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 373, Short.MAX_VALUE)
                .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void danhSachSinhVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_danhSachSinhVienActionPerformed
         try {
             chillPanel = new DanhSachSinhVien1();
         } catch (SQLException ex) {
             Logger.getLogger(ViewSinhVienGiaoVien.class.getName()).log(Level.SEVERE, null, ex);
         }
          show(chillPanel);
        // TODO add your handling code here:
    }//GEN-LAST:event_danhSachSinhVienActionPerformed

    private void danhSachGiaoVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_danhSachGiaoVienActionPerformed
         try {
             chillPanel = new DanhSachGiaoVien1();
         } catch (SQLException ex) {
             Logger.getLogger(ViewSinhVienGiaoVien.class.getName()).log(Level.SEVERE, null, ex);
         }
          show(chillPanel);

        // TODO add your handling code here:
    }//GEN-LAST:event_danhSachGiaoVienActionPerformed

    private void diemSinhVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_diemSinhVienActionPerformed
      
     try {
             chillPanel = new DanhSachDiemSinhVien1();
         } catch (SQLException ex) {
             Logger.getLogger(ViewSinhVienGiaoVien.class.getName()).log(Level.SEVERE, null, ex);
         }
          show(chillPanel);        

// TODO add your handling code here:
    }//GEN-LAST:event_diemSinhVienActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
    if(ActiveUser.tuCach == "giaovien") {
        this.dispose();
        GiaoVienView gv;
        try {
            gv = new GiaoVienView();
             gv.setVisible(true);
           gv.setLocationRelativeTo(null);
        } catch (SQLException ex) {
            Logger.getLogger(ViewSinhVienGiaoVien.class.getName()).log(Level.SEVERE, null, ex);
        }
       }
    else {
      this.dispose();
        SinhVienView sv;
        try {
            sv = new SinhVienView();
             sv.setVisible(true);
           sv.setLocationRelativeTo(null);
        } catch (SQLException ex) {
            Logger.getLogger(ViewSinhVienGiaoVien.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    }//GEN-LAST:event_backActionPerformed

    
    private void show(JPanel x){
        ActiveUser.show(x, content1);
    }  
    
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(ViewSinhVienGiaoVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(ViewSinhVienGiaoVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(ViewSinhVienGiaoVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(ViewSinhVienGiaoVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                try {
//                    new ViewSinhVienGiaoVien("diem").setVisible(true);
//                } catch (SQLException ex) {
//                    Logger.getLogger(ViewSinhVienGiaoVien.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JPanel content;
    private javax.swing.JPanel content1;
    private javax.swing.JButton danhSachGiaoVien;
    private javax.swing.JButton danhSachSinhVien;
    private javax.swing.JButton diemSinhVien;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    // End of variables declaration//GEN-END:variables
}
