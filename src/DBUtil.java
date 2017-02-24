
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jibba_000
 */
// makes sure we can connect to our databases 
// Username and password can be changed if another user will need acces
public class DBUtil {
	private static final String USERNAME = "dbuser";
	private static final String PASSWORD = "12345";
	private static final String H_CONN_STRING =
			"jdbc:hsqldb:src/data/explorecalifornia";
	private static final String M_CONN_STRING =
			"jdbc:mysql://localhost/explorecalifornia";

        public static Connection getConnection(DBType dbType) throws SQLException{
            switch (dbType){
                case MYSQL:
                return DriverManager.getConnection(M_CONN_STRING, USERNAME, PASSWORD);
                
                case HSQLDB:
                return DriverManager.getConnection(H_CONN_STRING, USERNAME, PASSWORD);
                
                default:
                return null;
                
            }
            
        }
        
        public static void processExeption(SQLException e){
            System.err.println("Error message: " + e.getMessage());
            System.err.println("Error code: " + e.getErrorCode());
            System.err.println("SQL state: " + e.getSQLState());
        }
        
}
    

