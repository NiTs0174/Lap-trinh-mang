/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bai01;

/**
 *
 * @author TN
 */
public class Data {
    private int a;
    private int b;
    private int LaCo;
    
    public int getLaCo() {
        return LaCo;
    }
    
    public void setLaCo (int LaCo) {
        this. LaCo = LaCo;
    }
    
    public int getA() {
        return a;
    }
    
    public void setA(int a) {
        this.a = a;
    }
    
    public int getB() {
        return b;
    }
    
    public void setB (int b) { 
        this.b = b;
    }
    
    public int TinhTong () {
        return a+b;
    }
}
