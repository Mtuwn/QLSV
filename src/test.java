/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author trant
 */
public class test {
    
    private static void xuLiChuoi(){
        String a = "abcnv";
        
        System.out.println(a);
        
        String x = "0000";
        int i = 12;
        int d = String.valueOf(i).length();
        System.out.println(d);
        x = x.substring(0, (x.length() -d));
       
        x = x + i;
         System.out.println(x);
        
    }
     
    public static void main(String[] args) {
        xuLiChuoi();
    }
}
