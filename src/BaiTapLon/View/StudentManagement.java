/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaiTapLon.View;

import Controller.Connect;
import Controller.HandleStudent;
import Model.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
public class StudentManagement extends javax.swing.JPanel {

    /**
     * Creates new form AddStudent
     */
    List<Student> list = new ArrayList<Student>();
    Student x = new Student();
    private static int pos = 0;
    private boolean add = true;
    private boolean edit = false;
    private boolean delete = false;
    HandleStudent handle = new HandleStudent();

    public StudentManagement() throws SQLException {
        initComponents();
        
        textID.setVisible(false);
            labelMsv.setVisible(false);
            viewTable("ATTT", "AT18B");
        showCombobox("ATTT");

    }

    private String handleMsv() {
        String Khoa = (String) jComboBox1.getSelectedItem();
        String Lop = (String) jComboBox3.getSelectedItem();
        String sql = "select Top 1 S.Msv from SinhVien as S join Lop L on L.TenLop = S.Lop where L.Khoa = ? and Lop = ? order by Msv desc";
        Connection conn = Connect.getConnection();
        String MsvCu = "";
        try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setString(1, Khoa);
            preparedStatement.setString(2, Lop);

            // Execute the query and process the results
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                MsvCu = rs.getString(1);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String newMsv = "";
        if (MsvCu.trim().isEmpty()) {
            String regex = "[A-Z]{2}\\d{6}";
            newMsv = this.textID.getText().trim();
            if(!newMsv.matches(regex)){
                JOptionPane.showMessageDialog(null, "Mã không đúng định dạng!!!\nĐịnh dạng đúng [A-Z]{2}\\d{6}");
                return null;
            }
        } else {
            String head = MsvCu.substring(0, 5);
            int last = Integer.parseInt(MsvCu.substring(5, 8));
            last++;
            newMsv = head + last;

        }
        return newMsv;


    }

    private void view() throws SQLException {

        x = list.get(pos);
        this.textName.setText(x.getHoTen());
        String dateString = x.getNgaySinh();
        this.textDate.setText(dateString);
        this.textAddress.setText(x.getDiaChi());
        this.textEmail.setText(x.getEmail());
        if (x.isGioiTinh() == "Nam") {
            this.btnMe.setSelected(true);
        } else {
            this.btnFe.setSelected(true);
        }
        this.textSDT.setText(x.getSDT());
        this.textID.setText(x.getMsv());

//        
//       
    }

    private void viewTable(String Khoa, String Lop) throws SQLException {
        DefaultTableModel model = (DefaultTableModel) this.Table1.getModel();
        model.setNumRows(0);
        list.removeAll(list);

        String sql = "select S.Msv, S.HoTen, S.NgaySinh, S.GioiTinh, S.SDT, S.DiaChi, S.Email, S.Lop, L.Khoa from SinhVien as S join Lop L on L.TenLop = S.Lop where L.Khoa = ? and Lop = ? order by Msv";

        Connection conn = Connect.getConnection();

        try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setString(1, Khoa);
            preparedStatement.setString(2, Lop);

            // Execute the query and process the results
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {

                // Process the result set as needed
                Boolean gender = Integer.parseInt(rs.getString(4)) == 1 ? true : false;
                String gioiTinh = Integer.parseInt(rs.getString(4)) == 1 ? "Nam" : "Nữ";
                x = new Student(rs.getString(1), rs.getString(2), rs.getString(3), gender, rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9));
                list.add(x);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        for (Student x : list) {
            model.addRow(new Object[]{x.getMsv(), x.getHoTen(), x.isGioiTinh(), x.getEmail()});
        }
        if ((this.Table1.getRowCount() == 0)) {
                textID.setVisible(true);
                labelMsv.setVisible(true);
            } else if((this.Table1.getRowCount() == 0) && !edit &&delete){
                 textID.setVisible(false);
                labelMsv.setVisible(false);
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
        jPanel2 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        labelMsv = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        textName = new javax.swing.JTextField();
        textDate = new javax.swing.JTextField();
        textAddress = new javax.swing.JTextField();
        textEmail = new javax.swing.JTextField();
        textID = new javax.swing.JTextField();
        btnMe = new javax.swing.JRadioButton();
        btnFe = new javax.swing.JRadioButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        Table1 = new javax.swing.JTable();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox3 = new javax.swing.JComboBox<>();
        jLabel26 = new javax.swing.JLabel();
        textSDT = new javax.swing.JTextField();
        DeleteOb = new javax.swing.JButton();
        EditOb = new javax.swing.JButton();
        addOb = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        headerLabel = new javax.swing.JLabel();

        jLabel18.setText("Họ Tên:");

        jLabel20.setText("Ngày sinh: ");

        jLabel21.setText("Địa chỉ:");

        labelMsv.setText("Mã sinh viên:");

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

        textID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textIDActionPerformed(evt);
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
                "MSV", "Họ Tên", "Giới tính", "Email"
            }
        ));
        Table1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Table1MouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(Table1);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ATTT", "CT", "DTVT" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });

        jLabel26.setText("SDT");

        textSDT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textSDTActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(labelMsv, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(textID, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel23)
                                .addComponent(jLabel19)
                                .addComponent(jLabel24)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                    .addGap(19, 19, 19)
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel20)
                            .addComponent(jLabel26)
                            .addComponent(jLabel21)
                            .addComponent(jLabel18))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textDate, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(btnMe)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnFe))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(textName, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 675, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 14, Short.MAX_VALUE)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelMsv)
                            .addComponent(textID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(textName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(4, 4, 4)
                        .addComponent(jLabel19)
                        .addGap(30, 30, 30)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(jLabel20)
                                .addGap(32, 32, 32)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel21)
                                    .addComponent(textDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(textAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel23)
                            .addComponent(textEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel24)
                            .addComponent(btnMe)
                            .addComponent(btnFe))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel26)
                            .addComponent(textSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)))
                .addGap(22, 22, 22))
        );

        DeleteOb.setText("Xóa");
        DeleteOb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteObActionPerformed(evt);
            }
        });

        EditOb.setText("Sửa");
        EditOb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditObActionPerformed(evt);
            }
        });

        addOb.setText("Thêm");
        addOb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addObActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        headerLabel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        headerLabel.setText("Thêm sinh viên");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(414, 414, 414)
                .addComponent(headerLabel)
                .addContainerGap(425, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(headerLabel)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addOb)
                        .addGap(54, 54, 54)
                        .addComponent(EditOb)
                        .addGap(66, 66, 66)
                        .addComponent(DeleteOb)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(EditOb)
                        .addComponent(DeleteOb))
                    .addComponent(addOb))
                .addGap(49, 49, 49))
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

    private void btnMeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMeActionPerformed

    private void btnFeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnFeActionPerformed

    private void Table1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Table1MouseClicked
        // TODO add your handling code here:
        pos = this.Table1.getSelectedRow();
        try {
            view();
        } catch (SQLException ex) {
            Logger.getLogger(StudentManagement.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_Table1MouseClicked

    private Student inputInf() {
        Student tmp = new Student();

        if (this.textName.getText().trim().isEmpty() || this.textDate.getText().trim().isEmpty() || this.textAddress.getText().trim().isEmpty()
                || (!btnFe.isSelected() && !btnMe.isSelected()) || this.textEmail.getText().trim().isEmpty() || this.textSDT.getText().trim().isEmpty()) {

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
            tmp.setMsv(this.textID.getText());
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

            String selectedItem1 = (String) jComboBox1.getSelectedItem();
            String selectedItem3 = (String) jComboBox3.getSelectedItem();
            tmp.setKhoa(selectedItem1);
            tmp.setLop(selectedItem3);

        }

        return tmp;
    }


    private void addObActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addObActionPerformed
        // TODO add your handling code here:

        if (!add) {
            JOptionPane.showMessageDialog(null, "Bạn đang chuyển sang chế độ thêm sinh viên!!!");
            add = true;
            delete = false;
            edit = false;
            if (this.Table1.getRowCount() == 0) {
                textID.setVisible(true);
                labelMsv.setVisible(true);
            } else {
                 textID.setVisible(false);
                labelMsv.setVisible(false);
            }

            headerLabel.setText("Thêm sinh viên");
        } else {
             x = inputInf();
            if (x == null) {
                return;
            }

            x.setMsv(handleMsv());
            if(x.getMsv().trim().isEmpty()) return;
            try {
                if( handle.addStudentDatabase(x))
                    JOptionPane.showMessageDialog(null, "Thêm thành công!!!");
                else{
                    JOptionPane.showMessageDialog(null, "Sinh viên đã tồn tại!!!");
                    return;
                }
            } catch (SQLException ex) {
                Logger.getLogger(StudentManagement.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(StudentManagement.class.getName()).log(Level.SEVERE, null, ex);
            }

            String selectedItem1 = (String) jComboBox1.getSelectedItem();
            String selectedItem3 = (String) jComboBox3.getSelectedItem();
            try {
                viewTable(selectedItem1, selectedItem3);
            } catch (SQLException ex) {
                Logger.getLogger(StudentManagement.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_addObActionPerformed

    private void EditObActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditObActionPerformed
        // TODO add your handling code here:
        if (!edit) {
            JOptionPane.showMessageDialog(null, "Bạn đang chuyển sang chế độ sửa sinh viên!!!");
            edit = true;
            add = false;
            delete = false;
            textID.setVisible(true);
            labelMsv.setVisible(true);
            headerLabel.setText("Xóa sinh viên");
        } else {
            Student std = new Student();
            std = inputInf();
            if (std == null) {
                return;
            }
            try {
                if (!handle.updateStudentDatabase(std)) {
                    JOptionPane.showMessageDialog(null, "Không tìm thấy sinh viên");
                } else {
                    JOptionPane.showMessageDialog(null, "Sửa thành công");
                }
            } catch (SQLException ex) {
                Logger.getLogger(StudentManagement.class.getName()).log(Level.SEVERE, null, ex);
            }

            String selectedItem1 = (String) jComboBox1.getSelectedItem();
            String selectedItem3 = (String) jComboBox3.getSelectedItem();
            try {
                viewTable(selectedItem1, selectedItem3);
            } catch (SQLException ex) {
                Logger.getLogger(StudentManagement.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }//GEN-LAST:event_EditObActionPerformed

    private void DeleteObActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteObActionPerformed

        if (!delete) {
            JOptionPane.showMessageDialog(null, "Bạn đang chuyển sang chế độ xóa sinh viên!!!");
            delete = true;
            add = false;
            edit = false;
            textID.setVisible(true);
            labelMsv.setVisible(true);
            headerLabel.setText("Xóa sinh viên");
        } else {

            String x = this.textID.getText();
            HandleStudent handle = new HandleStudent();
            try {
                if(!handle.deleteStudentDatabase(x)){
                    JOptionPane.showMessageDialog(null, "Không tìm thấy sinh viên");
                } else {
                   JOptionPane.showMessageDialog(null, "Xóa thành công");
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(StudentManagement.class.getName()).log(Level.SEVERE, null, ex);
            }
            String selectedItem1 = (String) jComboBox1.getSelectedItem();
            String selectedItem2 = (String) jComboBox3.getSelectedItem();
            try {
                viewTable(selectedItem1, selectedItem2);
            } catch (SQLException ex) {
                Logger.getLogger(StudentManagement.class.getName()).log(Level.SEVERE, null, ex);
            }

        }


    }//GEN-LAST:event_DeleteObActionPerformed

    private void showCombobox(String selectedItem) {
        String sql = "select TenLop from Lop where Khoa = ? group by TenLop";

        Connection conn = Connect.getConnection();
        jComboBox3.removeAllItems();
        try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setString(1, selectedItem);

            // Execute the query and process the results
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                // Process the result set as needed
                jComboBox3.addItem(rs.getString(1));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        String selectedItem1 = (String) jComboBox1.getSelectedItem();
        String selectedItem3 = (String) jComboBox3.getSelectedItem();

        try {
            viewTable(selectedItem1, selectedItem3);
        } catch (SQLException ex) {
            Logger.getLogger(StudentManagement.class.getName()).log(Level.SEVERE, null, ex);
        }

        showCombobox(selectedItem1);
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
        // TODO add your handling code here:

        String selectedItem1 = (String) jComboBox1.getSelectedItem();
        String selectedItem3 = (String) jComboBox3.getSelectedItem();
        try {
            viewTable(selectedItem1, selectedItem3);
        } catch (SQLException ex) {
            Logger.getLogger(StudentManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jComboBox3ActionPerformed

    private void textSDTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textSDTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textSDTActionPerformed

    private void textIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textIDActionPerformed


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
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JLabel labelMsv;
    private javax.swing.JTextField textAddress;
    private javax.swing.JTextField textDate;
    private javax.swing.JTextField textEmail;
    private javax.swing.JTextField textID;
    private javax.swing.JTextField textName;
    private javax.swing.JTextField textSDT;
    // End of variables declaration//GEN-END:variables
}
