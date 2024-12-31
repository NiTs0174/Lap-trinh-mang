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
public class UDPClient{
    public final static int CONG_MAC_DINH=6789;
    public static void main(String args[]) {
        String hostname;
        int port=CONG_MAC_DINH; 
        hostname="127.0.0.1";
        try{
            InetAddress dc=InetAddress.getByName(hostname); 
            System.out.println("Hay nhap vai dong ky tu de gui toi Server:");
            BufferedReader userInput=new BufferedReader(new InputStreamReader(System.in));
            DatagramSocket ds=new DatagramSocket(port); 
            while(true){
                String line=userInput.readLine();
                if (line.equals("exit")) break;
                byte[] data=line.getBytes();
                DatagramPacket dp=new DatagramPacket(data, data.length, dc, port); 
                ds.send(dp);
                dp.setLength(65507);  
                ds.receive(dp);
                ByteArrayInputStream bis=new ByteArrayInputStream(dp.getData());
                BufferedReader dis =new BufferedReader(new InputStreamReader(bis)); 
                System.out.println(dis.readLine());
            } 
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
