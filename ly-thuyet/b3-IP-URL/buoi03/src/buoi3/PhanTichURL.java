/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package buoi3;

import java.io.IOException;
import java.net.URL;
public class PhanTichURL {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://vnexpress.net/u23-viet-nam-vs-u23-guam-4650100-tong-thuat.html"); 
            System.out.println("URL: " + url.toString());
            System.out.println("protocol: " + url.getProtocol());
            System.out.println("authority: " + url.getAuthority());
            System.out.println("file name: " + url.getFile());
            System.out.println("host: " + url.getHost());
            System.out.println("path : " + url.getPath());
            System.out.println("port : " + url.getPort());
            System.out.println("default port: " + url.getDefaultPort()); 
            System.out.println("query: " + url.getQuery());
            System.out.println("ref: " + url.getRef());
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}