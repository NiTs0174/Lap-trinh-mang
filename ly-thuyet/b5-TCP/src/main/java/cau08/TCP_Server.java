/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package cau08;

/**
 *
 * @author TN
 */

import java.io.*;
import java.net.*;
import java.util.HashMap;
import java.util.Map;

public class TCP_Server {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(6789);
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
            ObjectOutputStream outToClient = new ObjectOutputStream(clientSocket.getOutputStream());
            ObjectInputStream inFromClient = new ObjectInputStream(clientSocket.getInputStream());

            // Nhận dãy số từ client
            double[] numbers = (double[]) inFromClient.readObject();

            // Xử lý dãy số và đếm số lần xuất hiện
            Map<Double, Integer> counter = new HashMap<>();
            for (double number : numbers) {
                counter.put(number, counter.getOrDefault(number, 0) + 1);
            }

            // Gửi kết quả về cho client
            outToClient.writeObject(counter);

            clientSocket.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}


