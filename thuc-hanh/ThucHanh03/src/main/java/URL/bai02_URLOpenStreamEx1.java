/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package URL;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author TN
 */
public class bai02_URLOpenStreamEx1 {
    public static void main(String[] args) throws MalformedURLException { 
        String s = "https://www.hutech.edu.vn";
        String thisLine;
        try {
            URL u= new URL(s);
            try {
                DataInputStream dis= new DataInputStream (u.openStream());
                BufferedReader br = new BufferedReader (new InputStreamReader (dis)); 
                while ((thisLine = br.readLine()) != null) {
                    System.out.println (thisLine);
                }
            } catch (IOException e) {
                System.err.println(e);
            }
        } catch (MalformedURLException e) {
        System.err.println(e);
        }
    }    
}
