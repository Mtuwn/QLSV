/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaiTapLon.View;

import Controller.Connect;
import Controller.HandleClassSubject;
import Model.ClassSubject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
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
public class ClassSubjectManagement extends javax.swing.JPanel {

    /**
     * Creates new form MonHoc
     */
    List<String> list = new ArrayList<String>();
    ClassSubject x = new ClassSubject();
    private static int pos = 0;
    private boolean flag = true;

    public ClassSubjectManagement() throws SQLException {
        initComponents();
        ShowComboBox();
        viewTable();
    }

    private void view() {
        this.textMsv.setText(list.get(pos));
    }

    private void viewTable() throws SQLException {
        DefaultTableModel model = (DefaultTableModel) this.Table1.getModel();
        model.setNumRows(0);
        list.removeAll(list);
        String selectedItem = (String) jComboBox1.getSelectedItem();
        String sql = "SELECT\n"
                + "    LT.Msv,\n"
                + "    SV.HoTen,\n"
                + "    MH.TenMon AS MonHoc,\n"
                + "    MH.SoTin\n"
                + "FROM\n"
                + "    LopTheoMon LT\n"
                + "    INNER JOIN SinhVien SV ON LT.Msv = SV.Msv\n"
                + "    INNER JOIN MonHoc MH ON LT.MaMon = MH.MaMon\n"
                + "LEFT JOIN MonHoc M ON LT.MaMon = M.MaMon\n"
                + "	where M.TenMon = ? Order by LT.Msv";

        Connection conn = Connect.getConnection();

        try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {

            preparedStatement.setString(1, selectedItem);

            // Execute the query and process the results
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {

                model.addRow(new Object[]{rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)});
                list.add(rs.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
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

        jLabel25 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        textMsv = new javax.swing.JTextField();
        jScrollPane7 = new javax.swing.JScrollPane();
        Table1 = new javax.swing.JTable();
        jComboBox1 = new javax.swing.JComboBox<>();
        addOb = new javax.swing.JButton();
        DeleteOb = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();

        jLabel25.setText("Môn học");

        setBorder(javax.swing.BorderFactory.createEtchedBorder());

        textMsv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textMsvActionPerformed(evt);
            }
        });

        Table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "MSV", "Họ Tên", "Môn học", "Số tín"
            }
        ));
        Table1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Table1MouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(Table1);
        if (Table1.getColumnModel().getColumnCount() > 0) {
            Table1.getColumnModel().getColumn(2).setHeaderValue("Môn học");
        }

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "OOP", "LTCB", "MMH", " " }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        addOb.setText("Thêm");
        addOb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addObActionPerformed(evt);
            }
        });

        DeleteOb.setText("Xóa");
        DeleteOb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteObActionPerformed(evt);
            }
        });

        jLabel20.setText("Mã sinh viên:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                        .addComponent(textMsv, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(addOb)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(DeleteOb)
                        .addGap(90, 90, 90)))
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 584, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(30, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(151, 151, 151)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel20)
                            .addComponent(textMsv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addOb)
                            .addComponent(DeleteOb))
                        .addGap(101, 101, 101))))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 27, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 19, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 19, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void DeleteObActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteObActionPerformed
        String TenMon = (String) jComboBox1.getSelectedItem();
        String Msv = this.textMsv.getText();
        HandleClassSubject handle = new HandleClassSubject();
        try {
            if (!handle.deleteClassDatabase(TenMon, Msv)) {
                JOptionPane.showMessageDialog(null, "Xóa không thành công");
            } else {
                JOptionPane.showMessageDialog(null, "Xóa thành công");
            }
            viewTable();
        } catch (SQLException ex) {
            Logger.getLogger(ClassSubjectManagement.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(ClassSubjectManagement.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_DeleteObActionPerformed

    private void addObActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addObActionPerformed
        // TODO add your handling code here:
        String TenMon = (String) jComboBox1.getSelectedItem();
        String Msv = this.textMsv.getText();
        HandleClassSubject handle = new HandleClassSubject();
        try {
            if (!handle.addClassDatabase(TenMon, Msv)) {
                return;
            } else {
                JOptionPane.showMessageDialog(null, "Thêm thành công");
            }
            viewTable();
        } catch (SQLException ex) {
            Logger.getLogger(ClassSubjectManagement.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(ClassSubjectManagement.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_addObActionPerformed

    private void Table1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Table1MouseClicked
        // TODO add your handling code here:
        pos = this.Table1.getSelectedRow();
        view();
    }//GEN-LAST:event_Table1MouseClicked

    private void textMsvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textMsvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textMsvActionPerformed

    private void ShowComboBox() throws SQLException {
        String selectedItem = (String) jComboBox1.getSelectedItem();

        String sql = "select M.TenMon from LopTheoMon as L join MonHoc as M on M.MaMon = L.MaMon group by M.TenMon";

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
            Logger.getLogger(ClassSubjectManagement.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jComboBox1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DeleteOb;
    private javax.swing.JTable Table1;
    private javax.swing.JButton addOb;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTextField textMsv;
    // End of variables declaration//GEN-END:variables
}
