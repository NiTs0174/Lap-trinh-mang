/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bai02;

/**
 *
 * @author TN
 */
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class UDPServer {
    static final int PORT = 1234;//Khai báo Port sử dụng
    private DatagramSocket socket = null;//Khai báo DatagramSocket để lưu kết nồi 
    public UDPServer() {
        try{
            socket=new DatagramSocket (PORT);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void action() {
        InetAddress host=null;
        int port;
        String chuoi="";//Khai báo biền để lưu chuỗi dữ liệu 
        try{
            System.out.println("Server is listening"); 
            while(true) {//vòng lặp chò
        DatagramPacket packet=receive();//Nhận dữ liệu từ client truyền qua 
        host=packet.getAddress();//Lầy thông tin địa chỉ của máy client
                port=packet.getPort();//Lầy thông tin port của máy client 
        chuoi=new String(packet.getData()).trim();//Lấy dữ liệu của máy client 
                    if(!chuoi.equals("")) {
                        Scanner sc=new Scanner (chuoi);
                        sc.useDelimiter("g");//Cắt chuỗi theo ký tự
            int so1=sc.nextInt();//Lầy sol là phần trước chữ ở đầu tiên 
            String pheptoan=sc.next();//Phép toán là phần trước chủ @ thứ hai 
                    int so2=sc.nextInt();//so2 là phấn trước chữ 8 thứ 3 
                    if(pheptoan.equals("+"))//Nều phép toán là phép cộng 
                        chuoi=(so1+so2) +"";
                    else if(pheptoan.equals("-"))//Nều phép toán là phép trừ
                        chuoi=(so1-so2)+"";
                    else if(pheptoan.equals("*"))//Nều phép toán là phép nhân
                        chuoi=(so1*so2)+"";
                    else if(pheptoan.equals("/"))//Nều phép toán là phép chia 
                        chuoi=((float) so1/so2)+"";
                    send(chuoi,host,port);//Truyển chuỗi trả về cho client
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            socket.close();
        }
    }
    
    private void send (String chuoi, InetAddress host, int port) throws IOException{ 
        byte[] buffer=chuoi.getBytes(); //chuyển chuỗi truyền thành byte 
            //Sau đó đưa chuỗi truyền vào gói tin gửi đi
        DatagramPacket packet=new DatagramPacket (buffer, buffer.length, host,port); 
        socket.send(packet);
    }
    
    private DatagramPacket receive () throws IOException{
        byte[] buffer=new byte[65507];//Khai báo mảng byte nhận
        DatagramPacket packet=new DatagramPacket (buffer, buffer.length); socket.receive(packet);//Nhận dữ liệu
        return packet;
    }
    
    public static void main(String[] args) {
        new UDPServer().action();
    }
}