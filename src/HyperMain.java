/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jibba_000
 */
public class HyperMain {
    private static final String USERNAME = "dbuser";
    private static final String PASSWORD = "12345";
    private static final String CONN_STRING =  "jdbc:hsqldb:src/data/explorecalifornia";
           
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        try {
            con = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
            
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery("SELECT * FROM states");
            
            rs.last();
            System.out.println("Number of rows: " + rs.getRow());
            
            //System.out.println("Connected");
        } catch (SQLException e) {
            System.err.println(e);
        }finally{
            if (rs != null){
                rs.close();
            }
            if (stmt != null){
                stmt.close();
        }
            if (con != null){
                con.close();
    }
    
}}}
