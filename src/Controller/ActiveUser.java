/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import BaiTapLon.View.LoginView;
import java.awt.BorderLayout;
import java.sql.Connection;
import javax.swing.JPanel;

public class ActiveUser {

    public static String user = "";
    public static String password = "";
    public static String tuCach = "";
    public static String hoTen = "";

    public ActiveUser(String user, String password, String tuCach) {
        this.user = user;
        this.password = password;
        this.tuCach = tuCach;
    }
    Connection conn = Connect.getConnection();

    public static void setUser(String user) {
        ActiveUser.user = user;
    }

    public static void setPassword(String password) {
        ActiveUser.password = password;
    }

    public static String getUser() {
        return user;
    }

    public static String getPassword() {
        return password;
    }

    public static void logout() {
        LoginView login = new LoginView();
        login.setVisible(true);
        login.setLocationRelativeTo(null);
    }

    public static void show(JPanel x, JPanel content) {
//        x.setVisible(false);
//        content.removeAll();
//        content.add(x);
//        x.setVisible(true);

        x.setVisible(false);

        // Sử dụng BorderLayout cho content panel
        content.setLayout(new BorderLayout());

        // Xóa tất cả các thành phần hiện tại trong content panel
        content.removeAll();

        // Thêm x vào vùng trung tâm của BorderLayout
        content.add(x, BorderLayout.CENTER);

        // Cập nhật và vẽ lại content panel
        content.revalidate();
        content.repaint();

        x.setVisible(true);
    }
}
