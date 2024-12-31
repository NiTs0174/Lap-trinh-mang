/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bai.tap.buoi.pkg2;
import java.io.*;
public class StreamDemo2 {
    public static void main(String[] args) {
        String fileName="C:\\TestB.txt";
        long n = 50000;
        // Ghi với stream vùng đệm
        try{
            long t = System.currentTimeMillis();
            FileOutputStream fo = new FileOutputStream(fileName); 
            BufferedOutputStream bo = new BufferedOutputStream(fo); 
            for (int i=0;i<n;i++) 
                bo.write(i);
            bo.close();
            t = System.currentTimeMillis() -t;
            System.out.println("Ghi co vung dem: mat "+t+"ms."); 
        // Ghi không có stream vùng đệm
            t = System.currentTimeMillis();
            fo = new FileOutputStream(fileName); 
            for (int i=0;i<n;i++)
                fo.write(i);
            fo.close();
            t  = System.currentTimeMillis()-t;
            System.out.println("Ghi khong vung dem: mat "+t+"ms.");
        }catch (IOException e) {}
    }
}
