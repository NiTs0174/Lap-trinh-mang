/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bai02;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author TN
 */
public class ServerThread implements Runnable {
    private Scanner in=null;
    private PrintWriter out=null;
    private Socket socket;
    private String name;
    
    public ServerThread (Socket socket, String name) throws IOException{
        this.socket=socket;
        this.name=name;
        this.in=new Scanner(this.socket.getInputStream());
        this.out=new PrintWriter (this.socket.getOutputStream(), true);
        new Thread (this).start();
    }
    public void run() {
        try{
            while (true) {
                String chuoi=in.nextLine().trim();               
                Scanner sc=new Scanner(chuoi); 
                sc.useDelimiter("@");
                int sol=sc.nextInt();
                String pheptoan=sc.next();
                int so2=sc.nextInt();
                
                if (pheptoan.equals("+"))
                    out.println(sol+so2);
                else if (pheptoan.equals("-")) 
                    out.println(sol-so2); 
                else if (pheptoan.equals("*") )
                    out.println(sol*so2);
                else if (pheptoan.equals("/"))
                    out.println((float) sol/so2);
            }
        } catch (Exception e) {
            System.out.println(name+" has departed");
        } finally{
            try{socket.close();} catch (IOException e) {}
        }
    }
}