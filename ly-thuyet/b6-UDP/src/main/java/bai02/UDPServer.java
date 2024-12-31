/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bai02;

/**
 *
 * @author TN
 */

import java.net.*;
import java.io.*;
public class UDPServer{
    public final static int CONG_MAC_DINH=6789;
    public static void main(String args[]) { 
        int port=CONG_MAC_DINH;
        System.out.println("Server bat dau "+port); 
        try{
            DatagramSocket ds=new DatagramSocket(port);
            DatagramPacket dp=new DatagramPacket(new byte[65507],65507); 
            while (true) {
                ds.receive(dp);
                ByteArrayInputStream bis=new ByteArrayInputStream(dp.getData()); 
                BufferedReader dis;
                dis =new BufferedReader(new InputStreamReader(bis));
                String s=dis.readLine();
                System.out.println(s); 
                s.toUpperCase();
                dp.setData(s.getBytes());
                dp.setLength(s.length());
                dp.setAddress (dp.getAddress());
                dp.setPort(dp.getPort());                
                ds.send(dp);
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
