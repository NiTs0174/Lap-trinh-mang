/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bai01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 *
 * @author TN
 */
public class ClientUDP {
    public static void main(String[] args) {
        String ip="127.0.0.1";
        int port=6789;
        byte[] buffer =new byte[255];
        DatagramSocket ds=null;
        try{
            ds=new DatagramSocket();
            InetAddress server=InetAddress.getByName(ip);
            System.out.println("Gui thong diep:");
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            String chuoi=br.readLine();
            byte[] data=chuoi.getBytes();
            // Gửi dữ liệu tới Server
            DatagramPacket dp =new DatagramPacket(data, data.length, server, port);//(byte du lieu, chieu dai byte, ip, port cua server)
            ds.send(dp);// Socket send paket
            DatagramPacket incoming=new DatagramPacket(buffer, buffer.length); 
            ds.receive(incoming);
            System.out.println("Server phan hoi: "+new String (incoming.getData(),0,incoming.getLength()));
        }catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (ds != null)
                ds.close();
        }
    }
}
