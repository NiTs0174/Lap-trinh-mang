/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package URL;

import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author TN
 */
public class bai01_URLEx1 {
    public static void main(String[] args) {
        try {
            URL u = new URL("http://www.poly.edu/fall97/grad.php?q=idx#cs "); 
            System.out.println("The protocol is:" + u.getProtocol()); 
            System.out.println("The host is:" + u.getHost());
            System.out.println("The port is:" + u.getPort());
            System.out.println("The file is:" + u.getFile()); 
            System.out.println("The anchor is:" + u.getRef());
            System.out.println("The query is:" + u.getQuery());
        } catch (MalformedURLException e) {
        }
    }
}
