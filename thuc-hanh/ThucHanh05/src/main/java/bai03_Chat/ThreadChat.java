/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bai03_Chat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author TN
 */
public class ThreadChat implements Runnable { 
    private Scanner in=null;
    private Socket socket=null; 
    public frmClient chat=null; 
    ServerSocket server=null; 
    
    public ThreadChat () {
        try{
            server=new ServerSocket (1234);//Tạo ra Server socket mới nhận port 1234 làm tham số.
        } catch (Exception e) { e.printStackTrace();}
        new Thread (this).start(); //Khỏi đọng Thread
    }
    
    public void run() {
        try{
            while (true) {
                while((socket=server.accept())!=null){//Nhận kết nối từ máy khác đến
                    this.in=new Scanner (this.socket.getInputStream());
                    String chuoi=in.nextLine().trim();//Nhận chuỗi 
                    chat.HienThi(chuoi+"\n");//Hiển thị chuỗi ra màn hình
                }
            }
        } catch (Exception e) {
        } finally{
            try{socket.close(); } catch (IOException e) {}
        }
    }
}