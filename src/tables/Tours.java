/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tables;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;

/**
 *
 * @author jibba_000
 */
// tours is a table in our database
public class Tours {
    public static void displayData(ResultSet rs) throws SQLException{
     while (rs.next()) {
         StringBuffer buffer = new StringBuffer();
         buffer.append("Tour " + rs.getInt("tourId") + ": ");
         buffer.append(rs.getString("tourName"));
         
         double price = rs.getDouble("price");
         NumberFormat nf = NumberFormat.getCurrencyInstance();
         String formattedPrice = nf.format(price);
         buffer.append(" (" + formattedPrice +")");
         
         System.out.println(buffer.toString());
     }  
    }
}
