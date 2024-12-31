/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bai_them02;

/**
 *
 * @author TN
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class FileTReader extends Thread {
    private String fileName;

    public FileTReader(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void run() {
        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(Thread.currentThread().getName() + ": " + line);
                Thread.sleep(100); // Simulate some work
            }

            bufferedReader.close();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class bai_them02 {
    public static void main(String[] args) {
        String file1 = "file1.txt";
        String file2 = "file2.txt";
        String file3 = "file3.txt";

        FileTReader thread1 = new FileTReader(file1);
        FileTReader thread2 = new FileTReader(file2);
        FileTReader thread3 = new FileTReader(file3);

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

        System.out.println("All threads finished reading files.");
    }
}

