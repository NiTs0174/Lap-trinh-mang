/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package bai1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;

/**
 *
 * @author TN
 */
public class TCP_Server {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(6789);
        System.out.println("Ban dau: "+serverSocket);
        
        Socket socket = serverSocket.accept();
        //System.out.println("Client accpeted:" +);
    }
}
