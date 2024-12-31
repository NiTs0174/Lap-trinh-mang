/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package upload_download;

/**
 *
 * @author TN
 */
import java.io.*;
import java.net.*;
public class TCPClient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 8084);

            BufferedReader inFromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter outToServer = new PrintWriter(socket.getOutputStream(), true);

            // Nhập tên file và yêu cầu từ người dùng
            System.out.print("Nhap ten file: ");
            String fileName = new BufferedReader(new InputStreamReader(System.in)).readLine();

            System.out.print("Nhap yeu cau (upload/download): ");
            String request = new BufferedReader(new InputStreamReader(System.in)).readLine();

            // Gửi yêu cầu đến server
            outToServer.println(request);

            if ("upload".equalsIgnoreCase(request)) {
                // Đọc nội dung file từ client và gửi lên server
                System.out.print("Nhap noi dung file: ");
                String fileContent = new BufferedReader(new InputStreamReader(System.in)).readLine();
                outToServer.println(fileName);
                outToServer.println(fileContent);
            } else if ("download".equalsIgnoreCase(request)) {
                // Gửi tên file đến server và nhận nội dung file từ server
                outToServer.println(fileName);
                String fileContent = inFromServer.readLine();
                System.out.println("Noi dung file tu server:\n" + fileContent);
            } else {
                System.out.println("Yeu cau khong hop le.");
            }

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}