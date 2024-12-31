/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package buoi3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
public class URLConnectionExample {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.hutech.edu.vn/");
            URLConnection urlConnection = url.openConnection();
            BufferedReader br = new BufferedReader (new InputStreamReader (urlConnection.getInputStream())); 
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line + "\n");
            }
            System.out.println(sb.toString());
        } 
        catch (IOException e) {
            e.printStackTrace();   
        }
    }
} 

