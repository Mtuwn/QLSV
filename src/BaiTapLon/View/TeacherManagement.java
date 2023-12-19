/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaiTapLon.View;

import Controller.Connect;
import Controller.HandleTeacher;
import Model.Teacher;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author trant
 */
public class TeacherManagement extends javax.swing.JPanel {

    /**
     * Creates new form AddTeacher
     */
    Teacher x = new Teacher();
    List<Teacher> list = new ArrayList<Teacher>();
    private static int pos = 0;
    private boolean add = true;
    private boolean edit = false;
    private boolean delete = false;
    HandleTeacher handle = new HandleTeacher();

    public TeacherManagement() throws SQLException {
        initComponents();
        textID.setVisible(false);
        labelMa.setVisible(false);
        viewTable();
    }

    private String handleMgv() {
        String sql = "select Top 1 MaGV from GiaoVien order by MaGv desc";
        Connection conn = Connect.getConnection();
        String maGvCu = "";
        try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {

            // Execute the query and process the results
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                maGvCu = rs.getString(1);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String newMaGv = "";
        if (maGvCu.trim().isEmpty()) {
            String regex = "GV\\d{4}";
            newMaGv = this.textID.getText().trim();
            if (!newMaGv.matches(regex)) {
                JOptionPane.showMessageDialog(null, "Mã không đúng định dạng!!!\nĐịnh dạng đúng GV\\d{4}");
                return null;
            }
        } else {
            String head = maGvCu.substring(0, 2);
            int last = Integer.parseInt(maGvCu.substring(2, 6));
            last++;
            newMaGv = head + last;

        }
        return newMaGv;

    }

    private void view() throws SQLException {

        x = list.get(pos);
        this.textName.setText(x.getHoTen());
        String dateString = x.getNgaySinh();
        this.textDate.setText(dateString);
        this.textAddress.setText(x.getDiaChi());
        this.textID.setText(x.getMaGv());
        this.textEmail.setText(x.getEmail());
        if (x.isGioiTinh() == "Nam") {
            this.btnMe.setSelected(true);
        } else {
            this.btnFe.setSelected(true);
        }
        this.textSDT.setText(x.getSDT());
        String degree = (String) jComboBox1.getSelectedItem();
        jComboBox1.setSelectedItem(x.getTrinhDo().trim());
        this.textSalary.setText(Integer.toString(x.getLuong()));
//       
    }

    public void viewTable() throws SQLException {
        DefaultTableModel model = (DefaultTableModel) this.Table1.getModel();
        model.setNumRows(0);
        list.removeAll(list);

        String sql = "	select * From GiaoVien order by MaGv";

        Connection conn = Connect.getConnection();

        try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {

                // Process the result set as needed
                Boolean gender = Integer.parseInt(rs.getString(4)) == 1 ? true : false;
                String gioiTinh = Integer.parseInt(rs.getString(4)) == 1 ? "Nam" : "Nữ";
                x = new Teacher(rs.getString(1), rs.getString(2), rs.getString(3), gender, rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(9), rs.getString(10));
                list.add(x);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        for (Teacher x : list) {
            model.addRow(new Object[]{x.getMaGv(), x.getHoTen(), x.isGioiTinh(), x.getLuong()});
        }
        if (this.Table1.getRowCount() == 0) {
            textID.setVisible(true);
            labelMa.setVisible(true);
        } else if((this.Table1.getRowCount() != 0) && (!edit && !delete)){
            textID.setVisible(false);
            labelMa.setVisible(false);
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        addOb = new javax.swing.JButton();
        EditOb = new javax.swing.JButton();
        DeleteOb = new javax.swing.JButton();
        ssss = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        textName = new javax.swing.JTextField();
        textDate = new javax.swing.JTextField();
        textAddress = new javax.swing.JTextField();
        textEmail = new javax.swing.JTextField();
        btnMe = new javax.swing.JRadioButton();
        btnFe = new javax.swing.JRadioButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        Table1 = new javax.swing.JTable();
        textSDT = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        textID = new javax.swing.JTextField();
        labelMa = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        textSalary = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        headerLabel = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createEtchedBorder());

        addOb.setText("Thêm");
        addOb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addObActionPerformed(evt);
            }
        });

        EditOb.setText("Sửa");
        EditOb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditObActionPerformed(evt);
            }
        });

        DeleteOb.setText("Xóa");
        DeleteOb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteObActionPerformed(evt);
            }
        });

        jLabel18.setText("Họ Tên:");

        jLabel20.setText("Ngày sinh: ");

        jLabel21.setText("Địa chỉ:");

        jLabel23.setText("Email:");

        jLabel24.setText("Giới tính: ");

        textName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textNameActionPerformed(evt);
            }
        });

        textDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textDateActionPerformed(evt);
            }
        });

        textAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textAddressActionPerformed(evt);
            }
        });

        textEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textEmailActionPerformed(evt);
            }
        });

        buttonGroup1.add(btnMe);
        btnMe.setText("Nam");
        btnMe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMeActionPerformed(evt);
            }
        });

        buttonGroup1.add(btnFe);
        btnFe.setText("Nữ");
        btnFe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFeActionPerformed(evt);
            }
        });

        Table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "MaGv", "Họ Tên", "Giới tính", "Lương"
            }
        ));
        Table1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Table1MouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(Table1);

        textSDT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textSDTActionPerformed(evt);
            }
        });

        jLabel26.setText("SDT");

        jLabel27.setText("Trình độ: ");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tiến sĩ", "Thạc sĩ", "Kỹ sư", "Thực tập" }));

        textID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textIDActionPerformed(evt);
            }
        });

        labelMa.setText("Mã giáo viên");

        javax.swing.GroupLayout ssssLayout = new javax.swing.GroupLayout(ssss);
        ssss.setLayout(ssssLayout);
        ssssLayout.setHorizontalGroup(
            ssssLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ssssLayout.createSequentialGroup()
                .addGroup(ssssLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ssssLayout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel18)
                        .addGap(253, 253, 253))
                    .addGroup(ssssLayout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(ssssLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(ssssLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ssssLayout.createSequentialGroup()
                                .addComponent(jLabel24)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnMe)
                                .addGap(18, 18, 18)
                                .addComponent(btnFe)
                                .addGap(64, 64, 64))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ssssLayout.createSequentialGroup()
                                .addGroup(ssssLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(ssssLayout.createSequentialGroup()
                                        .addComponent(labelMa)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(textID, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(ssssLayout.createSequentialGroup()
                                        .addComponent(jLabel21)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(textAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(ssssLayout.createSequentialGroup()
                                        .addComponent(jLabel23)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(textEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(ssssLayout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addGroup(ssssLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(textSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(textName, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(textDate, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(18, 18, 18))
                            .addGroup(ssssLayout.createSequentialGroup()
                                .addGroup(ssssLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel26)
                                    .addGroup(ssssLayout.createSequentialGroup()
                                        .addComponent(jLabel27)
                                        .addGap(55, 55, 55)
                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 584, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        ssssLayout.setVerticalGroup(
            ssssLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ssssLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ssssLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ssssLayout.createSequentialGroup()
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(ssssLayout.createSequentialGroup()
                        .addGroup(ssssLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelMa))
                        .addGap(34, 34, 34)
                        .addGroup(ssssLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19)
                            .addGroup(ssssLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel18)
                                .addComponent(textName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(28, 28, 28)
                        .addGroup(ssssLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20)
                            .addComponent(textDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addGroup(ssssLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21))
                        .addGap(35, 35, 35)
                        .addGroup(ssssLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel23))
                        .addGap(34, 34, 34)
                        .addGroup(ssssLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel26))
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(ssssLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnFe)
                            .addComponent(btnMe)
                            .addComponent(jLabel24))
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(ssssLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel27)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19))))
        );

        jLabel25.setText("Lương");

        textSalary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textSalaryActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        headerLabel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        headerLabel.setText("Thêm giáo viên");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(366, 366, 366)
                .addComponent(headerLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(headerLabel)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(addOb)
                            .addComponent(jLabel25))
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(EditOb)
                                .addGap(56, 56, 56)
                                .addComponent(DeleteOb))
                            .addComponent(textSalary, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(ssss, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ssss, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textSalary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addOb)
                    .addComponent(EditOb)
                    .addComponent(DeleteOb))
                .addGap(62, 62, 62))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void textNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textNameActionPerformed

    private void textDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textDateActionPerformed

    private void textAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textAddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textAddressActionPerformed

    private void textEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textEmailActionPerformed

    private void textIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textIDActionPerformed

    private void btnMeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMeActionPerformed

    private void btnFeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnFeActionPerformed

    private void textSalaryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textSalaryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textSalaryActionPerformed

    private void Table1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Table1MouseClicked
        // TODO add your handling code here:
        pos = this.Table1.getSelectedRow();
        try {
            view();
        } catch (SQLException ex) {
            Logger.getLogger(TeacherManagement.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_Table1MouseClicked

    private Teacher inputInf() {
        Teacher tmp = new Teacher();

        if (this.textName.getText().trim().isEmpty() || this.textDate.getText().trim().isEmpty() || this.textAddress.getText().trim().isEmpty() || this.textID.getText().trim().isEmpty()
                || (!btnFe.isSelected() && !btnMe.isSelected()) || this.textEmail.getText().trim().isEmpty() || this.textSDT.getText().trim().isEmpty()
                || this.textSalary.getText().trim().isEmpty()) {

            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin");
            return null;
        } else {

            tmp.setHoTen(this.textName.getText());
            String dateString = this.textDate.getText().trim();
            String dateRegex = "\\d{2}/\\d{2}/\\d{4}";
            Pattern pattern = Pattern.compile(dateRegex);
            Matcher matcher = pattern.matcher(dateString);
            if (!matcher.matches()) {
                JOptionPane.showMessageDialog(null, "Ngày sinh không hợp lệ\n"
                        + "(dd/mm/yyyy)");
                return null;
            }
            tmp.setNgaySinh(dateString);
            tmp.setDiaChi(this.textAddress.getText());
            tmp.setMaGv(this.textID.getText());
            if (!(this.textEmail.getText().contains("@"))) {
                JOptionPane.showMessageDialog(null, "Email không hợp lệ\n");
                return null;
            }
            tmp.setEmail(this.textEmail.getText());
            if (this.btnMe.isSelected()) {
                tmp.setGioiTinh(true);
            } else if (this.btnFe.isSelected()) {
                tmp.setGioiTinh(false);
            }
            if (this.textSDT.getText().trim().matches("0[0-9]{9,10}")) {
                tmp.setSDT(this.textSDT.getText());
            } else {
                JOptionPane.showMessageDialog(null, "SDT không hợp lệ\n");
                return null;
            }

            if (this.textSalary.getText().trim().matches("\\d+")) {
                tmp.setLuong(Integer.parseInt(this.textSalary.getText()));
            } else {
                JOptionPane.showMessageDialog(null, "Không hợp lê!!!̣\n(Dữ liệu phải là 1 số)");
                return null;
            }
            String degree = (String) jComboBox1.getSelectedItem();
            tmp.setTrinhDo(degree);

        }

        return tmp;
    }
    private void DeleteObActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteObActionPerformed
        if (!delete) {
            JOptionPane.showMessageDialog(null, "Bạn đang chuyển sang chế độ xóa giáo viên!!!");
            add = false;
            delete = true;
            edit = false;
            textID.setVisible(true);
            labelMa.setVisible(true);

            headerLabel.setText("Xóa giáo viên");
        } else {
            String x = this.textID.getText();
            HandleTeacher handle = new HandleTeacher();
            try {
                if (handle.deleteStudentDatabase(x)) {
                    JOptionPane.showMessageDialog(null, "Xóa thành công!!!");
                } else {
                    JOptionPane.showMessageDialog(null, "Xóa không thành công!!!");
                }

            } catch (SQLException ex) {
                Logger.getLogger(TeacherManagement.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                viewTable();
            } catch (SQLException ex) {
                Logger.getLogger(TeacherManagement.class.getName()).log(Level.SEVERE, null, ex);
            }
        }


    }//GEN-LAST:event_DeleteObActionPerformed

    private void EditObActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditObActionPerformed
        // TODO add your handling code here:
        if (!edit) {
            JOptionPane.showMessageDialog(null, "Bạn đang chuyển sang chế độ sửa giáo viên!!!");
            add = false;
            delete = false;
            edit = true;
            textID.setVisible(true);
            labelMa.setVisible(true);
            headerLabel.setText("Sửa giáo viên");
        } else {
            Teacher std = new Teacher();
            std = inputInf();
            if (std == null) {
                return;
            }
            try {
                if (!handle.updateStudentDatabase(std)) {
                    JOptionPane.showMessageDialog(null, "Không tìm thấy giáo viên");
                } else {
                    JOptionPane.showMessageDialog(null, "Sửa thành công!!!");
                }
            } catch (SQLException ex) {
                Logger.getLogger(TeacherManagement.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                System.out.println(edit);
                viewTable();
            } catch (SQLException ex) {
                Logger.getLogger(TeacherManagement.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
            
    }//GEN-LAST:event_EditObActionPerformed

    private void addObActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addObActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
        if (!add) {
            JOptionPane.showMessageDialog(null, "Bạn đang chuyển sang chế độ thêm giáo viên!!!");
            add = true;
            delete = false;
            edit = false;
            if (this.Table1.getRowCount() == 0) {
                textID.setVisible(true);
                labelMa.setVisible(true);
            } else {
                textID.setVisible(false);
                labelMa.setVisible(false);
            }
            headerLabel.setText("Thêm giáo viên");
        } else {
            x = inputInf();
            if (x == null) {
                return;
            }

            for (Teacher tmp : list) {
                if (tmp.getMaGv().equalsIgnoreCase(x.getMaGv())) {
                    JOptionPane.showMessageDialog(null, "Mã giáo viên đã tồn tại");
                    return;
                }

            }

            try {
                if (handle.addTeacherDatabase(x)) {
                    JOptionPane.showMessageDialog(null, "Thêm thành công!!!");
                } else {
                    JOptionPane.showMessageDialog(null, "Thêm không thành công");
                }

            } catch (SQLException ex) {
                Logger.getLogger(TeacherManagement.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(TeacherManagement.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                viewTable();
            } catch (SQLException ex) {
                Logger.getLogger(TeacherManagement.class.getName()).log(Level.SEVERE, null, ex);
            }
        }


    }//GEN-LAST:event_addObActionPerformed

    private void textSDTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textSDTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textSDTActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DeleteOb;
    private javax.swing.JButton EditOb;
    private javax.swing.JTable Table1;
    private javax.swing.JButton addOb;
    private javax.swing.JRadioButton btnFe;
    private javax.swing.JRadioButton btnMe;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel headerLabel;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JLabel labelMa;
    private javax.swing.JPanel ssss;
    private javax.swing.JTextField textAddress;
    private javax.swing.JTextField textDate;
    private javax.swing.JTextField textEmail;
    private javax.swing.JTextField textID;
    private javax.swing.JTextField textName;
    private javax.swing.JTextField textSDT;
    private javax.swing.JTextField textSalary;
    // End of variables declaration//GEN-END:variables
}
