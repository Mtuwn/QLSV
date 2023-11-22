/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;

/**
 *
 * @author trant
 */
public class Person {
    private String HoTen;
    private String NgaySinh;
    private String DiaChi;
    private Boolean GioiTinh;
    private String SDT;
    private String Email;

    public Person() {
    }

    public Person(String HoTen, String NgaySinh, String DiaChi, boolean GioiTinh, String SDT, String Email) {
        this.HoTen = HoTen;
        this.NgaySinh = NgaySinh;
        this.DiaChi = DiaChi;
        this.GioiTinh = GioiTinh;
        this.SDT = SDT;
        this.Email = Email;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    public String getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(String NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String isGioiTinh() {
        return GioiTinh == true ? "Nam":"Nu";
    }

    public void setGioiTinh(boolean GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    @Override
    public String toString() {
        return "HoTen=" + HoTen + ", NgaySinh=" + NgaySinh + ", DiaChi=" + DiaChi + ", GioiTinh=" + GioiTinh + ", SDT=" + SDT + ", Email=" + Email;
    }

   
    
}
