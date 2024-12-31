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
import java.net.*;
public class Server {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        int port = 7777;
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server is waiting for connections...");
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket);
                // Xử lý yêu cầu từ client trong một luồng riêng biệt
                Thread clientHandler = new Thread(new ClientHandler(clientSocket));
                clientHandler.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (serverSocket != null && !serverSocket.isClosed()) {
                    serverSocket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

class ClientHandler implements Runnable {
    private Socket clientSocket;
    public ClientHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }
    @Override
    public void run() {
        try {
            // Nhận tên file từ client
            BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String fileName = reader.readLine();
            // Xác định đường dẫn lưu trữ file trên server (đường dẫn cứng coded)
            String serverFilePath = "C:\\Users\\TN\\Documents\\NetBeansProjects\\buoi07_UDP\\ServerFiles\\" + fileName;
            // Gửi phản hồi về client
            PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);
            // Kiểm tra xem là yêu cầu upload hay download
            if (fileName.startsWith("upload")) {
                // Upload file từ client lên server
                receiveFile(clientSocket, serverFilePath);
                writer.println("File uploaded successfully!");
            } else {
                // Download file từ server về client
                sendFile(clientSocket, serverFilePath);
                writer.println("File downloaded successfully!");
            }
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void receiveFile(Socket clientSocket, String serverFilePath) throws IOException {
        // Nhận và lưu file từ client
        InputStream inputStream = clientSocket.getInputStream();
        FileOutputStream fileOutputStream = new FileOutputStream(serverFilePath);
        byte[] buffer = new byte[1024];
        int bytesRead;
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            fileOutputStream.write(buffer, 0, bytesRead);
        }
        fileOutputStream.close();
    }

    private void sendFile(Socket clientSocket, String serverFilePath) throws IOException {
        // Gửi file từ server đến client
        File file = new File(serverFilePath);
        FileInputStream fileInputStream = new FileInputStream(file);
        OutputStream outputStream = clientSocket.getOutputStream();

        byte[] buffer = new byte[1024];
        int bytesRead;
        while ((bytesRead = fileInputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, bytesRead);
        }
        fileInputStream.close();
        outputStream.close();
    }
}

