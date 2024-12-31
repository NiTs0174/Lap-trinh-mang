/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bai01;

/**
 *
 * @author TN
 */
import java.lang.System.Logger;
import java.util.Random;
import java.util.logging.Level;
public class SynDongBoLuong {
    static Data dataShare;
    public static void main(String[] args) { 
        dataShare = new Data();
        // Gán Cờ Phân chia công việc theo thứ tự 
        //Quy ước 1 =L1 chạy,2-L2 và 3– Sum 
        dataShare.setLaCo(1);
        // Luồng 1
        Thread T1=new Thread (new Runnable() {
            @Override
            public void run() {
                synchronized (dataShare){
                for (int i = 0; i < 10; i++) {
                    try {
                        if (dataShare.getLaCo()==1) {
                        int a=new Random().nextInt(100);
                        dataShare.setA(a);
                        System.out.println("A= "+dataShare.getA()); 
                        Thread.sleep(90);
                        dataShare.setLaCo(2);//Gán cờ cho luồng 2
                        dataShare.notifyAll();// đánh thức các luồng đnag ngủ đậy
                        }
                        else{
                            dataShare.wait();// Dung- Đoi
                        }
                    } catch (InterruptedException ex) {
                        //Logger.getLogger(SynDongBoLuong.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }}
        });
    }
}
    
    