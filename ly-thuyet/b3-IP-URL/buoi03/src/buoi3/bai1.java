/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package buoi3;

import java.net.InetAddress;
import java.net.UnknownHostException;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class bai1 {
    private void jButton1ActionPerformed (java.awt.event.ActionEvent evt) {
        try {
            int i,j;
            InetAddress addr[] = InetAddress.getAllByName(txttenmien.getText());//lấy tất cả các IP của địa chỉ
            DefaultListModel dm = new DefaultListModel();
            for (i=0; i<addr.length; i++) {
                byte[] ipAddr = addr[1].getAddress(); 
                String ipAddrStr="";
                for(j=0; j<ipAddr.length; j++) {                    
                    if (j >0){ ipAddrStr += "."; }
                    ipAddrStr += ipAddr[j]&0xFF;
                }
                dm.addElement (ipAddrStr);
            }
            list_IP.setModel(dm);
        }
        catch (UnknownHostException e) {
            JOptionPane.showMessageDialog(null, "Địa chỉ của bạn nhập sai!!!");
        }
    }
}
