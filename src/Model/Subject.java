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
public class Subject {
    private String MaMon;
    private String TenMon;
    private int SoTin;

    public Subject() {
    }

    public Subject(String MaMon, String TenMon, int SoTin) {
        this.MaMon = MaMon;
        this.TenMon = TenMon;
        this.SoTin = SoTin;
    }

    public String getMaMon() {
        return MaMon;
    }

    public void setMaMon(String MaMon) {
        this.MaMon = MaMon;
    }

    public String getTenMon() {
        return TenMon;
    }

    public void setTenMon(String TenMon) {
        this.TenMon = TenMon;
    }

    public int getSoTin() {
        return SoTin;
    }

    public void setSoTin(int SoTin) {
        this.SoTin = SoTin;
    }
    
    
}
