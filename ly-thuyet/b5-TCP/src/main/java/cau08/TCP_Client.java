/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cau08;

/**
 *
 * @author TN
 */
import java.io.*;
import java.net.*;
import java.util.Map;

public class TCP_Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 6789);

            ObjectOutputStream outToServer = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream inFromServer = new ObjectInputStream(socket.getInputStream());

            // Nhập dãy số từ người dùng
            System.out.print("Nhap day so (cach nhau bang dau phay): ");
            String input = new BufferedReader(new InputStreamReader(System.in)).readLine();
            String[] numbersStr = input.split(",");
            double[] numbers = new double[numbersStr.length];
            for (int i = 0; i < numbersStr.length; i++) {
                numbers[i] = Double.parseDouble(numbersStr[i]);
            }

            // Gửi dãy số cho server
            outToServer.writeObject(numbers);

            // Nhận kết quả từ server
            Map<Double, Integer> result = (Map<Double, Integer>) inFromServer.readObject();

            // In kết quả ra màn hình
            System.out.println("Ket qua:");
            for (Map.Entry<Double, Integer> entry : result.entrySet()) {
                System.out.println("So " + entry.getKey() + " - " + entry.getValue() + " lan");
            }

            socket.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

