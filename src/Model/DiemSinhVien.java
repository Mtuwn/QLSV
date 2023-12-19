/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author TAN
 */
public class DiemSinhVien {

    public DiemSinhVien() {
    }

    
    public DiemSinhVien(String maSV, String maMon, float diemCC, float diemGK,float diemCK) {
         this.maSV = maSV;
        this.maMon = maMon;
        this.diemCC = diemCC;
        this.diemGK =diemGK;
        this.diemCK =diemCK;
        
    }
     public DiemSinhVien(String maSV,String name, String mon, float diemCC, float diemGK,float diemCK) {
         this.name=name;
         this.maSV = maSV;
        this.mon = mon;
        this.diemCC = diemCC;
        this.diemGK =diemGK;
        this.diemCK =diemCK;
        
    }
    
    private String maSV;
    private String maMon;
    private float diemCC;
    private float diemGK;
    private float diemCK;
    private String name;
    private String mon;

    public String getName() {
        return name;
    }

    public String getMon() {
        return mon;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMon(String mon) {
        this.mon = mon;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public void setMaMon(String maMon) {
        this.maMon = maMon;
    }

    public void setDiemCC(float diemCC) {
        this.diemCC = diemCC;
    }

    public void setDiemGK(float diemGK) {
        this.diemGK = diemGK;
    }

    public void setDiemCK(float diemCK) {
        this.diemCK = diemCK;
    }

    public String getMaSV() {
        return maSV;
    }

    public String getMaMon() {
        return maMon;
    }

    public float getDiemCC() {
        return diemCC;
    }

    public float getDiemGK() {
        return diemGK;
    }

    public float getDiemCK() {
        return diemCK;
    }
    
}
