/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BTNangCao;

/**
 *
 * @author TN
 */
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class bai02_ImageDownloader {

    public static void main(String[] args) {
        String websiteUrl = "http://www.hutech.edu.vn";
        String outputDirectory = "downloaded_images";

        try {
            Document document = Jsoup.connect(websiteUrl).get();
            Elements imgElements = document.select("img");

            for (Element imgElement : imgElements) {
                String imageUrl = imgElement.absUrl("src");
                downloadImage(imageUrl, outputDirectory);
            }

            System.out.println("Images downloaded and saved to " + outputDirectory);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
//--------------------------------------------------------------------------------------------------
    private static void downloadImage(String imageUrl, String outputDirectory) throws IOException {
        URL url = new URL(imageUrl);
        try (InputStream in = url.openStream();
             BufferedOutputStream out = new BufferedOutputStream(
                     new FileOutputStream(outputDirectory + "/" + getFileNameFromUrl(imageUrl)))) {

            byte[] buffer = new byte[1024];
            int bytesRead;

            while ((bytesRead = in.read(buffer, 0, 1024)) != -1) {
                out.write(buffer, 0, bytesRead);
            }
        }
    }
//----------------------------------------------------------
    private static String getFileNameFromUrl(String url) {
        return url.substring(url.lastIndexOf('/') + 1);
    }
}

