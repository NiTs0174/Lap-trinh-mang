/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bai1;

import java.io.*;
import java.net.Socket;

/**
 *
 * @author TN
 */
public class TCP_Client {
    public static void main(String[] args) throws IOException {
            Socket conn = new Socket("localhost",6789);
            
            //client gui du lieu
            //DataOutputStream dos = new DataOutputStream();
            //dos.writeInt(5);
            //dos.writeInt(10);
    }
}
