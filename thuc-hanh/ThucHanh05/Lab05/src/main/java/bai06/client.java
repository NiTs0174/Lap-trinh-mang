/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package bai06;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author TN
 */
public class client extends javax.swing.JFrame {

    /**
     * Creates new form from
     */
    public client() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtDomain = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        txtUser = new javax.swing.JTextField();
        txtPass = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstClientPath = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstPath = new javax.swing.JList<>();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Domain");

        jLabel2.setText("user");

        jLabel3.setText("Pass");

        jLabel4.setText("Client's Folder");

        txtDomain.setText("LocalHost");

        jButton1.setText("upload");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("download");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Login");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Browser");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(lstClientPath);

        jScrollPane2.setViewportView(lstPath);

        jLabel5.setText("Server Folder");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(38, 38, 38)
                                .addComponent(txtPass))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtDomain, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton1))
                                    .addComponent(txtUser))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton2)
                            .addComponent(jButton3)
                            .addComponent(jButton4))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtDomain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
//-----------------------------------------------------------------------------------
    Socket s;
    public static final int PORT = 10000;
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:﻿
        //tao socket
        String domain=this.txtDomain.getText();
        try {
            InetAddress ia = InetAddress.getByName (domain); 
            try {
                s = new Socket(ia, PORT);
                //goi user, pass len server
                PrintWriter pw=new PrintWriter(s.getOutputStream());
                //lay du lieu tu client do su dung go vao
                String user=this.txtUser.getText();
                String pass=this.txtPass.getText(); 
                String cmd="DANGNHAP";
                pw.println(cmd);
                pw.println(user);
                pw.println(pass);
                System.out.println(cmd);
                System.out.println(user);
                System.out.println(pass);
                pw.flush();
                //client doi phan hoi tu server
                Scanner sc=new Scanner(s.getInputStream()); 
                int cmdR=sc.nextInt();
                if (cmdR==1) {
                    JOptionPane.showMessageDialog(this, "Dang nhap thanh cong");
                    //luu duong dan hien tai ma list hien thi danh tạp tin trong folder do. 
                    DefaultListModel dm=new DefaultListModel();
                    int n=sc.nextInt();
                    for (int i=0;i<n;i++) {
                        dm.addElement(sc.nextLine());
                    }
                    this.lstPath.setModel(dm);
                }else
                    JOptionPane.showMessageDialog(this, "Dang nhap khong thanh cong");
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(this, ex.toString());
                }
            } catch (UnknownHostException ex) {
                    JOptionPane.showMessageDialog(this, ex.toString());
        }
    }//GEN-LAST:event_jButton3ActionPerformed
//-----------------------------------------------------------------------------------   
    String path;
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:    
        //fchPath.setVisible(true);
        //thiet lap
        //fchPath.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); 
        //kiem tra client nay duoc chon nut gi?
        //if(fchPath.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) 
        try{
            //path=fchPath.getSelectedFile().getCanonicalPath();
            File dir=new File(path);
            File dsFile[]=dir.listFiles();
            if(dsFile==null){
                JOptionPane.showMessageDialog(null, "sai duong dan!");
            }else{ 
                try{
                    //luu duong dan hien tai ma list hien thi danh tạp
                    // tin trong folder do.
                    DefaultListModel dm=new DefaultListModel(); 
                    for (int i=0;i<dsFile.length;i++) {
                        String filename=dsFile[i].getName(); 
                        dm.addElement (filename);
                    }
                    this.lstClientPath.setModel (dm);
                } catch (Exception e){
                    JOptionPane.showMessageDialog(null, e.toString());
                }
            }
        } catch (Exception e){ }
    }//GEN-LAST:event_jButton4ActionPerformed
//-----------------------------------------------------------------------------------
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String fileName=(String) this.lstClientPath.getSelectedValue(); 
        String cpath=path+"\\" + fileName;
        System.out.println(cpath);
        try{
            PrintWriter pw=new PrintWriter (s.getOutputStream()); 
            //goi tin hieu lenh
            pw.println("UPLOAD");
            pw.flush();
            System.out.println("Da goi lenh upload len server"); 
            pw.println(fileName);
            pw.flush();
            System.out.println("Da goi ten tap tin len server");
            BufferedOutputStream bos=new BufferedOutputStream(s.getOutputStream()); 
            DataOutputStream dos=new DataOutputStream (bos);
            //mo tap tin ra
            BufferedInputStream bis=new BufferedInputStream (new FileInputStream (cpath)); 
            //lap doc noi dung tap tin va goi lieu len server
            byte buf[]=new byte[bis.available()];
            //tao bo dem doc het du lieu tu tap tin vao bo dem roi day
            //vao luong len server.
            bos.write(bis.read(buf));
            System.out.println("da goi du lieu tap tin len server");
            bos.flush();
            //bis.close();
            //doi nhan danh sách tập thu của folder o server voi tinh trang moi
            Scanner sc=new Scanner (s.getInputStream());
            String cmd=sc.nextLine();
            System.out.println("da nhan dap tra tu server"); 
            if(cmd.equals("DANHAN"))            
                JOptionPane.showMessageDialog(null, "Đã gửi tập tin thành công");
            else
                JOptionPane.showMessageDialog(null, "Gửi tập tin thất bại");
            //nhan update
            updateFolderServer();
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_jButton1ActionPerformed
//------------------------------------------------------------------------------------        
    public void updateFolderServer(){
        try{
            BufferedInputStream bi= new BufferedInputStream(s.getInputStream());
            Scanner sc=new Scanner(bi);
            DefaultListModel dm=new DefaultListModel();
            //server gọi ve so luong tập tin thu mục sau khi upload 
            int n=sc.nextInt();
            System.out.println("Da nhan duoc so luong tap tin gọi tu server"); 
            //nhan ten tung tập tin thu mục
            for (int i=0;i<n;i++){
                String filename=sc.nextLine(); 
                dm.addElement (filename);
            }
            System.out.println("Da hien thi xong danh sách tập tin");
            //hien thi len client
            this.lstPath.setModel (dm);
            //ve lại giao dien
            this.validate();
        }catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi", e.toString(), JOptionPane.ERROR_MESSAGE);
        }
    }//-----------------------------------------------------------------------------------
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        //lay tap tin can download
        String fileName=(String) this.lstPath.getSelectedValue(); 
        System.out.println(fileName);
        try{
            PrintWriter pw=new PrintWriter(s.getOutputStream()); 
            //goi tin hieu lenh
            pw.println("DOWNLOAD");
            pw.flush();
            System.out.println("Da goi lenh download len server");
            pw.println(fileName);
            pw.flush();
            //doi server goi noi dung tap tin ve
            System.out.println("Doi server goi noi dung tap tin ve"); 
            String cpath=path+"\\" + fileName; 
            FileOutputStream fos;
            fos = new FileOutputStream(new File(cpath)); 
            BufferedOutputStream bos=new BufferedOutputStream(fos); 
            BufferedInputStream bis=new BufferedInputStream(s.getInputStream());
            byte buf[]=new byte[bis.available()];
            bos.write(bis.read(buf));
            bos.flush(); bos.close();
            pw=new PrintWriter(s.getOutputStream());
            pw.println("DANHAN");
            pw.flush();
            //cap nhat lai thu mục client vua download
            this.capNhatClientFolder(cpath);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed
//-----------------------------------------------------------------------------------
    private void capNhatClientFolder (String cpath) {
        //mo thu muc voi duong dan path ra
        File dir=new File(path);
        File dsFile[]=dir.listFiles();
        if (dsFile==null){
            JOptionPane.showMessageDialog(null, " Duong dan sai!");
        }else{
            try{
            //luu duong dan hien tai mà list hien thi danh tap tin trong folder do.
            //path=txtPath.getText();
                DefaultListModel dm=new DefaultListModel();
                for(int i=0;i<dsFile.length;i++){
                String filename=dsFile[i].getName(); 
                dm.addElement (filename);
            }
            this.lstClientPath.setModel(dm);
            this.validate();
            }catch (Exception e){
                JOptionPane.showMessageDialog(this,e);
            }
        }
    }
//-----------------------------------------------------------------------------------
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the client */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new client().setVisible(true);
            }
        });
    }
//-----------------------------------------------------------------------------------
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> lstClientPath;
    private javax.swing.JList<String> lstPath;
    private javax.swing.JTextField txtDomain;
    private javax.swing.JTextField txtPass;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
