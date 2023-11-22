/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author trant
 */
public class Score {
    private String Msv;
    private String HoTen;
    private String MaMon;
    private float DiemChuyenCan;
    private float DiemGk;
    private float DiemThi;
    private float DiemTongKet;
    

    public Score() {
    }

    public Score(String Msv,String HoTen, String MaMon, float DiemChuyenCan, float DiemGk, float DiemThi) {
        this.Msv = Msv;
        this.HoTen = HoTen;
        this.MaMon = MaMon;
        this.DiemChuyenCan = DiemChuyenCan;
        this.DiemGk = DiemGk;
        this.DiemThi = DiemThi;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    public String getMsv() {
        return Msv;
    }

    public void setMsv(String Msv) {
        this.Msv = Msv;
    }

    public String getMaMon() {
        return MaMon;
    }

    public void setMaMon(String MaMon) {
        this.MaMon = MaMon;
    }

    public float getDiemChuyenCan() {
        return DiemChuyenCan;
    }

    public void setDiemChuyenCan(float DiemChuyenCan) {
        this.DiemChuyenCan = DiemChuyenCan;
    }

    public float getDiemGk() {
        return DiemGk;
    }

    public void setDiemGk(float DiemGk) {
        this.DiemGk = DiemGk;
    }

    public float getDiemThi() {
        return DiemThi;
    }

    public void setDiemThi(float DiemThi) {
        this.DiemThi = DiemThi;
    }

    public String getDiemTongKet() {
        DiemTongKet = (float) ((this.DiemChuyenCan*0.3+this.DiemGk*0.7)*0.3+this.DiemThi*0.7);
         String formattedValue = String.format("%.2f", DiemTongKet);
        return formattedValue;
    }

   
    
}
