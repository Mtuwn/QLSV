/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaiTapLon.View;
import Controller.ActiveUser;
import Controller.HandleUser;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.border.Border;

/**
 *
 * @author TAN
 */
public class LoginView extends javax.swing.JFrame {


    public LoginView() {
        initComponents();
        setLocationRelativeTo(null);
       
      
    }

  public  void setEmpty(){
    inputTenDangNhap.setText("");
    inputMatKhau.setText("");
  }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Form = new javax.swing.JLabel();
        submit = new javax.swing.JButton();
        LableTenDangNhap = new javax.swing.JLabel();
        lableTuCach = new javax.swing.JLabel();
        lableMatkhau = new javax.swing.JLabel();
        inputTenDangNhap = new javax.swing.JTextField();
        radioGiaoVien = new javax.swing.JRadioButton();
        radioSinhVien = new javax.swing.JRadioButton();
        radioKhaoThi = new javax.swing.JRadioButton();
        notification = new javax.swing.JLabel();
        inputMatKhau = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Online Login Form ");

        Form.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        Form.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Form.setText("Login Quick");

        submit.setBackground(new java.awt.Color(255, 204, 204));
        submit.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        submit.setForeground(new java.awt.Color(0, 255, 0));
        submit.setText("Đăng Nhập");
        submit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        submit.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                submitFocusGained(evt);
            }
        });
        submit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                submitMouseClicked(evt);
            }
        });
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });

        LableTenDangNhap.setBackground(new java.awt.Color(255, 204, 204));
        LableTenDangNhap.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        LableTenDangNhap.setForeground(new java.awt.Color(102, 102, 0));
        LableTenDangNhap.setText("Tên Đăng Nhập :");

        lableTuCach.setBackground(new java.awt.Color(255, 204, 204));
        lableTuCach.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        lableTuCach.setForeground(new java.awt.Color(102, 102, 0));
        lableTuCach.setText("Tư Cách : ");
        lableTuCach.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        lableMatkhau.setBackground(new java.awt.Color(255, 204, 204));
        lableMatkhau.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        lableMatkhau.setForeground(new java.awt.Color(102, 102, 0));
        lableMatkhau.setText("Mật Khẩu :");
        lableMatkhau.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        inputTenDangNhap.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        inputTenDangNhap.setForeground(new java.awt.Color(153, 153, 0));
        inputTenDangNhap.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 15, 0, 15));

        radioGiaoVien.setBackground(new java.awt.Color(255, 255, 204));
        buttonGroup1.add(radioGiaoVien);
        radioGiaoVien.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        radioGiaoVien.setForeground(new java.awt.Color(153, 153, 0));
        radioGiaoVien.setText("Giáo Viên");
        radioGiaoVien.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        radioGiaoVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioGiaoVienActionPerformed(evt);
            }
        });

        radioSinhVien.setBackground(new java.awt.Color(255, 255, 204));
        buttonGroup1.add(radioSinhVien);
        radioSinhVien.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        radioSinhVien.setForeground(new java.awt.Color(153, 153, 0));
        radioSinhVien.setText("Sinh Viên");
        radioSinhVien.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        radioSinhVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioSinhVienActionPerformed(evt);
            }
        });

        radioKhaoThi.setBackground(new java.awt.Color(255, 255, 204));
        buttonGroup1.add(radioKhaoThi);
        radioKhaoThi.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        radioKhaoThi.setForeground(new java.awt.Color(153, 153, 0));
        radioKhaoThi.setText("Khảo Thí");
        radioKhaoThi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        radioKhaoThi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioKhaoThiActionPerformed(evt);
            }
        });

        notification.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        notification.setForeground(new java.awt.Color(255, 102, 102));

        inputMatKhau.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        inputMatKhau.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 15, 1, 15));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(142, 142, 142)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(LableTenDangNhap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lableMatkhau, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lableTuCach, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(radioSinhVien, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(radioGiaoVien, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(radioKhaoThi, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(inputMatKhau, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(inputTenDangNhap, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 373, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(382, 382, 382)
                        .addComponent(submit, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(111, 111, 111)
                        .addComponent(notification, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(368, 368, 368)
                        .addComponent(Form, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(316, 316, 316)))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(Form, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(LableTenDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(inputTenDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lableMatkhau, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(inputMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(radioSinhVien, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lableTuCach, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(radioGiaoVien, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(radioKhaoThi, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(notification, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(submit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void radioKhaoThiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioKhaoThiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radioKhaoThiActionPerformed

    private void radioSinhVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioSinhVienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radioSinhVienActionPerformed

    private void radioGiaoVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioGiaoVienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radioGiaoVienActionPerformed

    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed

   
         String userInput = inputTenDangNhap.getText();
         String passwordInput = inputMatKhau.getText();
         String tuCach="";
         if(radioKhaoThi.isSelected()) tuCach ="khaothi";
         else if(radioGiaoVien.isSelected()) tuCach="giaovien";
         else if(radioSinhVien.isSelected()) tuCach="sinhvien";
         
        if(userInput.equals("")) 
            JOptionPane.showMessageDialog(this,"Tên Đăng Nhập không được để trống");
        else if(passwordInput.equals(""))
            JOptionPane.showMessageDialog(this,"Mật Khẩu không được để trống");
        else if(tuCach.equals("")) 
            JOptionPane.showMessageDialog(this,"Phải chọn tư cách đăng nhập của bạn");
        else if(true){
//         dang nhap thanh cong
            ActiveUser.user = userInput;
            ActiveUser.password = passwordInput;
            ActiveUser.tuCach = tuCach;
            try {
//                gọi đến hàm xử lí chuyển trang 
                HandleUser xuli = new HandleUser();
                String notification = xuli.ktraUser();
                if(notification.equals("")){
                   this.dispose();
                  JOptionPane.showMessageDialog(this,"Đăng Nhập thành công");
                  
                } 
                else {
                    this.setEmpty();
                     JOptionPane.showMessageDialog(this,notification);         
                }
                   

            } catch (SQLException ex) {
                Logger.getLogger(LoginView.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(LoginView.class.getName()).log(Level.SEVERE, null, ex);
            }
       
        }
        else{
           JOptionPane.showMessageDialog(this,"Tài Khoản Hoặc Mật Khẩu không đúng");
              
        }
   
    }//GEN-LAST:event_submitActionPerformed

    private void submitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_submitMouseClicked
    
 
             // TODO add your handling code here:
    }//GEN-LAST:event_submitMouseClicked

    private void submitFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_submitFocusGained
//  DO add your handling code here:
    }//GEN-LAST:event_submitFocusGained

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Form;
    private javax.swing.JLabel LableTenDangNhap;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPasswordField inputMatKhau;
    private javax.swing.JTextField inputTenDangNhap;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lableMatkhau;
    private javax.swing.JLabel lableTuCach;
    private javax.swing.JLabel notification;
    private javax.swing.JRadioButton radioGiaoVien;
    private javax.swing.JRadioButton radioKhaoThi;
    private javax.swing.JRadioButton radioSinhVien;
    private javax.swing.JButton submit;
    // End of variables declaration//GEN-END:variables
}
