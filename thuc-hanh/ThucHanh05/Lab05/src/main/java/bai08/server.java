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
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class server {
    private static final int PORT = 12345;
    private static Map<String, PrintWriter> connectedClients = new HashMap<>();

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server is running on port " + PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                new Thread(new ClientHandler(clientSocket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class ClientHandler implements Runnable {
        private Socket clientSocket;
        private Scanner in;
        private PrintWriter out;
        private String username;

        public ClientHandler(Socket socket) {
            this.clientSocket = socket;
        }

        @Override
        public void run() {
            try {
                in = new Scanner(clientSocket.getInputStream());
                out = new PrintWriter(clientSocket.getOutputStream(), true);

                // Prompt for username
                out.println("Enter your username:");
                username = in.nextLine();

                // Add client to the list
                connectedClients.put(username, out);

                // Broadcast a welcome message
                broadcast(username + " has joined the chat.", null);

                // Listen for messages
                while (true) {
                    String message = in.nextLine();
                    if (message.equals("exit")) {
                        break;
                    }
                    broadcast(username + ": " + message, username);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                // Remove client when they disconnect
                connectedClients.remove(username);
                broadcast(username + " has left the chat.", null);

                try {
                    clientSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void broadcast(String message, String sender) {
        for (PrintWriter writer : connectedClients.values()) {
            if (sender == null) {
                writer.println(message);
            } else if (!sender.equals(writer)) {
                writer.println(message);
            }
        }
    }
}

