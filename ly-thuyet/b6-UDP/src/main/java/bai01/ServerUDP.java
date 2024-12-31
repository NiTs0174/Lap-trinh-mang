/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package bai01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 *
 * @author TN
 */
public class ServerUDP {
    public static void main(String[] args) {
        DatagramSocket ds=null;
        int Port=6789;// port mở giao tiếp
        byte[] Bufer=new byte[255];//vùng đệm dữ liệu 
        System.out.println("Server bat dau "+Port); 
        System.out.println("Lang nghe Client...");
        try{
            ds=new DatagramSocket(Port);
            // nhận cần gói nhận
            DatagramPacket incoming=new DatagramPacket(Bufer,Bufer.length);//(byte du lieu, packet nhan goi)
            ds.receive(incoming);
            // lấy dữ liệu gói tin
            String tin=new String(incoming.getData(),0,incoming.getLength()); 
            System.out.println("Da nhan:"+tin);
            // Phản hồi dữ liệu
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            String chuoi=br.readLine();
            // lấy dữ liệu từ bàn phím
            byte[] data=chuoi.getBytes();
            DatagramPacket outsend=new DatagramPacket(data,data.length,incoming.getAddress(),incoming.getPort());
            // lấy địa chỉ từ gói nhận, port cũng lấy từ gói nhận
            ds.send(outsend);
        }catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (ds!=null){
                ds.close();
            }
        }
    }
}
