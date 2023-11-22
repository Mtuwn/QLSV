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
public class Student extends Person{
    private String Msv;
    private String Lop;
    private String Khoa;

    public Student() {
    }

    public Student(String Msv, String HoTen,String NgaySinh,boolean GioiTinh, String SDT, String DiaChi, String Email,String Lop, String Khoa) {
        super(HoTen, NgaySinh, DiaChi, GioiTinh, SDT, Email);
        this.Msv = Msv;
        this.Lop = Lop;
        this.Khoa = Khoa;
    }

    public String getMsv() {
        return Msv;
    }

    public void setMsv(String Msv) {
        this.Msv = Msv;
    }

    public String getLop() {
        return Lop;
    }

    public void setLop(String Lop) {
        this.Lop = Lop;
    }

    public String getKhoa() {
        return Khoa;
    }

    public void setKhoa(String Khoa) {
        this.Khoa = Khoa;
    }

    @Override
    public String toString() {
        return  "Msv=" + Msv + ", Lop=" + Lop + ", Khoa=" + Khoa + super.toString();
    }

    
}
