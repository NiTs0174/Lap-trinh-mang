/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BTNangCao;

/**
 *
 * @author TN
 */

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class bai01_WebPageDownloader {

    public static void main(String[] args) {
        String websiteUrl = "http://www.hutech.edu.vn";
        String outputFilePath = "hutech_source_code.html";

        try {
            String sourceCode = downloadWebPageSource(websiteUrl);
            saveSourceCodeToFile(outputFilePath, sourceCode);
            System.out.println("Source code downloaded and saved to " + outputFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String downloadWebPageSource(String url) throws IOException {
        URL website = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) website.openConnection();

        StringBuilder result = new StringBuilder();

        try (InputStream is = connection.getInputStream();
             Scanner scanner = new Scanner(is)) {

            while (scanner.hasNextLine()) {
                result.append(scanner.nextLine()).append("\n");
            }
        } finally {
            connection.disconnect();
        }

        return result.toString();
    }

    private static void saveSourceCodeToFile(String filePath, String sourceCode) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(sourceCode);
        }
    }
}
