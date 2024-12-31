/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package bai04;

/**
 *
 * @author TN
 */
import java.net.*;
import java.io.*;
import java.util.ArrayList;

public class Client {
    public static void main(String args[]) {
        DatagramSocket socket = null;
        int port = 7777;
        try {
            socket = new DatagramSocket();
            // Nhập giá trị n từ người dùng
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Nhap gia tri cua n: ");
            int n = Integer.parseInt(reader.readLine());
            // Gửi giá trị n đến server
            InetAddress serverAddress = InetAddress.getByName("localhost");
            byte[] sendData = String.valueOf(n).getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, port);
            socket.send(sendPacket);
            // Nhận danh sách số nguyên tố từ server
            byte[] receiveData = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            socket.receive(receivePacket);
            ByteArrayInputStream byteStream = new ByteArrayInputStream(receivePacket.getData());
            ObjectInputStream inputStream = new ObjectInputStream(byteStream);
            ArrayList<Integer> primeNumbers = (ArrayList<Integer>) inputStream.readObject();
            // Hiển thị danh sách số nguyên tố
            System.out.println("Cac so nguyen to nho hon " + n + " la:");
            for (Integer primeNumber : primeNumbers) {
                System.out.print(primeNumber + " ");
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (socket != null && !socket.isClosed()) {
                socket.close();
            }
        }
    }
}

