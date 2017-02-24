/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jibba_000
 */
public class MysqlMain {
    private static final String USERNAME = "dbuser";
    private static final String PASSWORD = "12345";
    private static final String CON_STRING =  "jdbc:mysql://localhost/Lynda";
           
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        Connection con = null;
        
        try {
            con = DriverManager.getConnection(CON_STRING, USERNAME, PASSWORD);
            System.out.println("Connected");
        } catch (SQLException e) {
            System.err.println(e);
        }finally{
            if (con != null){
                con.close();
            }
        }
    }
    
}
