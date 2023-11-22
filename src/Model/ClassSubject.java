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
public class ClassSubject {
    private String Msv;
    private String MaMon;

    public ClassSubject() {
    }

    public ClassSubject(String Msv, String MaMon) {
        this.Msv = Msv;
        this.MaMon = MaMon;
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
    
    
    
}
