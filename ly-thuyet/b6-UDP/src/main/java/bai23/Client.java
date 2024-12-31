/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bai23;

/**
 *
 * @author TN
 */
import java.io.*;
import java.net.Socket;
public class Client {
    public static void main(String[] args) {
        Socket socket = null;
        int port = 7777;
        try {
            // Kết nối đến server
            socket = new Socket("localhost", port);
            // Gửi tên file muốn upload hoặc download
            System.out.print("Nhập tên file: ");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String fileName = reader.readLine();
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            writer.println(fileName);
            // Kiểm tra xem là yêu cầu upload hay download
            if (fileName.startsWith("upload")) {
                // Upload file từ client lên server
                sendFile(socket, fileName);
            } else {
                // Download file từ server về client
                receiveFile(socket, fileName);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (socket != null && !socket.isClosed()) {
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void sendFile(Socket socket, String fileName) throws IOException {
        // Gửi file từ client lên server
        OutputStream outputStream = socket.getOutputStream();
        FileInputStream fileInputStream = new FileInputStream(fileName);
        byte[] buffer = new byte[1024];
        int bytesRead;
        while ((bytesRead = fileInputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, bytesRead);
        }
        fileInputStream.close();
        outputStream.close();
    }

    private static void receiveFile(Socket socket, String fileName) throws IOException {
        // Nhận file từ server về client
        InputStream inputStream = socket.getInputStream();
        FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\TN/Documents\\NetBeansProjects\\buoi07_UDP\\ServerFiles\\" + fileName);
        byte[] buffer = new byte[1024];
        int bytesRead;
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            fileOutputStream.write(buffer, 0, bytesRead);
        }
        fileOutputStream.close();
    }
}

