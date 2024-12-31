/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bai08;

/**
 *
 * @author TN
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class client {
    private static final String SERVER_IP = "localhost";
    private static final int SERVER_PORT = 12345;

    public static void main(String[] args) {
        try {
            Socket socket = new Socket(SERVER_IP, SERVER_PORT);
            Scanner in = new Scanner(socket.getInputStream());
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            Scanner consoleInput = new Scanner(System.in);

            // Read and print messages from the server
            new Thread(() -> {
                while (in.hasNextLine()) {
                    String message = in.nextLine();
                    System.out.println(message);
                }
            }).start();

            // Send messages to the server
            while (true) {
                String message = consoleInput.nextLine();
                out.println(message);
                if (message.equals("exit")) {
                    break;
                }
            }

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

