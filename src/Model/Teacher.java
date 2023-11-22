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
public class Teacher extends Person{
    private String TrinhDo;
    private int Luong;
    private String MaGv;
    private String MaMon;

    public Teacher() {
    }

    public Teacher(String MaGv, String HoTen,String NgaySinh,boolean GioiTinh, String SDT, String DiaChi, String Email,String TrinhDo, int Luong,String MaMon) {
        super(HoTen, NgaySinh, DiaChi, GioiTinh, SDT, Email);
        this.MaGv = MaGv;
        this.TrinhDo = TrinhDo;
        this.Luong = Luong;
        this.MaMon = MaMon;

    }

    public String getMaMon() {
        return MaMon;
    }

    public void setMaMon(String MaMon) {
        this.MaMon = MaMon;
    }
    
    
    public String getTrinhDo() {
        return TrinhDo;
    }

    public void setTrinhDo(String TrinhDo) {
        this.TrinhDo = TrinhDo;
    }

    public int getLuong() {
        return Luong;
    }

    public void setLuong(int Luong) {
        this.Luong = Luong;
    }

    public String getMaGv() {
        return MaGv;
    }

    public void setMaGv(String MaGv) {
        this.MaGv = MaGv;
    }
    
    
    
    
    
    
    
}
