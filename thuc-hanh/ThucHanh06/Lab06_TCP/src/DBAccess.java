
import java.sql.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Administrator
 */
public class DBAccess {
    private Connection con;
    private Statement stmt;
    public DBAccess(){
        try{
            MyConnection myCon = new MyConnection();
            con = myCon.getConnection();
            stmt = con.createStatement();
        }catch(Exception e){
            
        }
    }
    public int update(String str){
        try{
            int i = stmt.executeUpdate(str);
            return i;
        }catch(Exception e){
            return -1;
        }
    }
    public ResultSet query(String str){
        try{
            ResultSet rs = stmt.executeQuery(str);
            return rs;
        }catch(Exception e){
            return null;
        }
    }
}
