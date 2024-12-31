/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bai2;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.DataInputStream;
public class Server {
    public static void main(String[] args) throws Exception { 
        // Khai báo Socket lắng nghe trên SV
        ServerSocket sv=new ServerSocket (6788);
        System.out.println("Trang thai ban dau: "+sv);
        // Chấp nhận kết nối
        Socket kn=sv.accept();
        System.out.println("Ket noi den Client"+ kn);
        DataOutputStream dos=new DataOutputStream(kn.getOutputStream()); 
        DataInputStream dis=new DataInputStream(kn.getInputStream());
        String s1="", s2="";
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in)); 
        while (true) { // Điều kiện ngắt khi chat "exit" tự thoát
        s1= br.readLine();
        dos.writeUTF (s1);
        
        }
    }
}
