/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bai04;

/**
 *
 * @author TN
 */
import java.net.*;
import java.util.ArrayList;
import java.io.*;

public class Server {
    public static void main(String args[]) {
        DatagramSocket socket = null;
        int port = 7777;
        System.out.println("Server bat dau: " + port); 
        System.out.println("Lang nghe Client...");
        try {
            socket = new DatagramSocket(port);
            byte[] receiveData = new byte[1024];
            while (true) {                
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                socket.receive(receivePacket);
                InetAddress clientAddress = receivePacket.getAddress();
                int clientPort = receivePacket.getPort();
                // Nhận giá trị n từ client
                int n = Integer.parseInt(new String(receivePacket.getData(), 0, receivePacket.getLength()));
                // Liệt kê số nguyên tố nhỏ hơn n
                ArrayList<Integer> primeNumbers = getPrimeNumbers(n);
                // Gửi danh sách số nguyên tố về client
                ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
                ObjectOutputStream outputStream = new ObjectOutputStream(byteStream);
                outputStream.writeObject(primeNumbers);
                byte[] sendData = byteStream.toByteArray();
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientAddress, clientPort);
                socket.send(sendPacket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (socket != null && !socket.isClosed()) {
                socket.close();
            }
        }
    }

    // Hàm kiểm tra số nguyên tố
    private static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    // Hàm lấy danh sách số nguyên tố nhỏ hơn n
    private static ArrayList<Integer> getPrimeNumbers(int n) {
        ArrayList<Integer> primeNumbers = new ArrayList<>();
        for (int i = 2; i < n; i++) {
            if (isPrime(i)) {
                primeNumbers.add(i);
            }
        }
        return primeNumbers;
    }
}

