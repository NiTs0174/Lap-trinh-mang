/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bai.tap.buoi.pkg2;
import java.io.*;
public class StreamDemo {
    public static void main(String[] args) { 
        try{
            String fileName="C:\\TestC.txt";
            String s = "Hello File Reader/Writer!";
            System.out.println("Du lieu ban dau: "+s);
            // Ghi s vào tập tin
            FileWriter fw = new FileWriter (fileName);
            fw.write(s);
            fw.close();
            // Đọc tập tin vào chuỗi sb
            FileReader fr = new FileReader (fileName);
            StringBuffer sb = new StringBuffer();
            char ca[] = new char[5];		// Đọc mỗi lần tối đa 5 ký tự
            while (fr.ready()) {
                int len = fr.read(ca); 	// len: số ký tự đọc được thật sự
                sb.append(ca, 0, len);	
            }
            fr.close();
            // Xuất chuỗi sb
            System.out.println("Du lieu doc duoc: "+sb);
        }catch (IOException e) {}
    }
}
