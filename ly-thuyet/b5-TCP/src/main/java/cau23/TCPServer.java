/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cau23;

/**
 *
 * @author TN
 */
import java.io.*;
import java.net.*;

public class TCPServer {
    private static final String SERVER_DIRECTORY = "C:/Users/TN/Documents/NetBeansProjects/B5TCP/";

    public static void main(String[] args) {
        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(8083);
            System.out.println("Trang thai ban dau: " + serverSocket);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Ket noi den Client: " + clientSocket.getInetAddress());

                handleClient(clientSocket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null && !serverSocket.isClosed()) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void handleClient(Socket clientSocket) {
        try {
            BufferedReader inFromClient = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter outToClient = new PrintWriter(clientSocket.getOutputStream(), true);

            // Nhận yêu cầu từ client (upload hoặc download)
            String request = inFromClient.readLine();

            if ("upload".equalsIgnoreCase(request)) {
                // Nhận tên file và nội dung từ client và lưu file vào server
                String fileName = inFromClient.readLine();
                String fileContent = inFromClient.readLine();
                saveFileOnServer(fileName, fileContent);
                outToClient.println("File uploaded successfully.");
            } else if ("download".equalsIgnoreCase(request)) {
                // Nhận tên file từ client và gửi nội dung file về cho client
                String fileName = inFromClient.readLine();
                String fileContent = readFileFromServer(fileName);
                outToClient.println(fileContent);
            } else {
                outToClient.println("Invalid request.");
            }

            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void saveFileOnServer(String fileName, String fileContent) throws IOException {
        try (PrintWriter writer = new PrintWriter(SERVER_DIRECTORY + fileName)) {
            writer.println(fileContent);
        }
    }

    private static String readFileFromServer(String fileName) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(SERVER_DIRECTORY + fileName))) {
            StringBuilder content = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
            return content.toString();
        }
    }
}