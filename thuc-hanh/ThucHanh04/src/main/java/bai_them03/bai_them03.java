/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bai_them03;

/**
 *
 * @author TN
 */
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

class FileReadWrite {
    private String fileName;
    private Object lock = new Object();

    public FileReadWrite(String fileName) {
        this.fileName = fileName;
    }

    public void writeToFile(String data) {
        synchronized (lock) {
            try (FileWriter writer = new FileWriter(fileName, true)) {
                writer.write(data + "\n");
                System.out.println("Write: " + data);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void readFromFile() {
        synchronized (lock) {
            try (FileReader fileReader = new FileReader(fileName);
                 BufferedReader bufferedReader = new BufferedReader(fileReader)) {

                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    System.out.println("Read: " + line);
                    Thread.sleep(100); // Simulate some work
                }
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class bai_them03 {
    public static void main(String[] args) {
        String fileName = "sharedFile.txt";
        FileReadWrite fileReadWrite = new FileReadWrite(fileName);

        // Tạo và chạy tiến trình viết
        Thread writeThread = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                fileReadWrite.writeToFile("Data " + i);
                try {
                    Thread.sleep(200); // Simulate some work
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // Tạo và chạy tiến trình đọc
        Thread readThread = new Thread(() -> {
            fileReadWrite.readFromFile();
        });

        writeThread.start();
        readThread.start();

        try {
            writeThread.join();
            readThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Main thread finished.");
    }
}

