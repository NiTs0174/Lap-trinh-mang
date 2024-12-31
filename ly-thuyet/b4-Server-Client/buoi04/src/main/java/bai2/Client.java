/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bai2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
public class Client {
    public static void main(String[] args) throws Exception {
        Socket conn = new Socket("localhost", 6788);
        // client gti de lieu
        DataOutputStream dos = new DataOutputStream(conn.getOutputStream());
        DataInputStream dis = new DataInputStream(conn.getInputStream());
        String s1="";
        while (true){
            s1=dis.readUTF();
            System.out.println("SV gui :"+ s1);
        }
    }
}
