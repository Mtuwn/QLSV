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
public class Classes {
    private String Lop;
    private String Khoa;

    public Classes() {
    }

    public Classes(String Lop,String Khoa) {
        this.Lop = Lop;
        this.Khoa = Khoa;
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
    
    
}
