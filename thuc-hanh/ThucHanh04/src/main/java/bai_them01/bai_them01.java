/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bai_them01;

/**
 *
 * @author TN
 */
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

class FileTWriter extends Thread {
    private String fileName;

    public FileTWriter(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void run() {
        try {
            FileWriter writer = new FileWriter(fileName);

            Random random = new Random();
            for (int i = 0; i < 10; i++) {
                int randomNumber = random.nextInt(100);
                writer.write(randomNumber + "\n");
                Thread.sleep(100); // Simulate some work
            }

            writer.close();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class bai_them01 {
    public static void main(String[] args) {
        String file1 = "file1.txt";
        String file2 = "file2.txt";
        String file3 = "file3.txt";

        FileTWriter thread1 = new FileTWriter(file1);
        FileTWriter thread2 = new FileTWriter(file2);
        FileTWriter thread3 = new FileTWriter(file3);

        thread1.start();
        thread2.start();
        thread3.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("All threads finished writing to files.");
    }
}

