/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import tables.Tours;

/**
 *
 * @author jibba_000
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    // Below code proces a Menu where you can choose to see the table tours from MYSQL or HyperSQL or insert into table
    
    public static void main(String[] args) throws SQLException {
        Scanner scan = new Scanner(System.in);
        int choice = 0;
        String input;
        boolean done = true;

        while (done) {
            System.out.println("1: Connect to Hyper SQL");
            System.out.println("2: Connect to MySQL");
            System.out.println("3: Insert into Tour");
            System.out.println("4: Quit menu");

            try {
                input = scan.nextLine();
                choice = Integer.parseInt(input);
            } catch (NumberFormatException ex) {
                System.out.println("invalid input, please try again");
                continue;
            }
            switch (choice) {
                case 1:
                    try (
                            Connection con = DBUtil.getConnection(DBType.HSQLDB);
                            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                            ResultSet rs = stmt.executeQuery("SELECT * FROM tours");) {

                        System.out.println("Connected");

                        Tours.displayData(rs);

                    } catch (SQLException e) {
                        DBUtil.processExeption(e);
                    }
                    break;

                case 2:

                    try (
                            Connection con = DBUtil.getConnection(DBType.MYSQL);
                            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                            ResultSet rs = stmt.executeQuery("SELECT * FROM tours")) {

                        System.out.println("Connected");

                        Tours.displayData(rs);

                    } catch (SQLException e) {
                        DBUtil.processExeption(e);
                    }
                    break;

                case 3:
                    System.out.println("1: Insert with MySQL");
                    System.out.println("2: Insert with HyperSQL");
                    try {
                        input = scan.nextLine();
                        choice = Integer.parseInt(input);
                    } catch (NumberFormatException ex) {
                        System.out.println("invalid input, please try again");
                        continue;
                    }
                    switch (choice) {

                        case 1:
                            String query = "insert into tours(packageId, tourName, blurb, description, price, difficulty, graphic, length, region, keywords)"
                                    + "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                            Connection con = DBUtil.getConnection(DBType.MYSQL);
                            PreparedStatement pstmt = con.prepareStatement(query);
                            pstmt.setInt(1, 9);
                            pstmt.setString(2, "WaterTube");
                            pstmt.setString(3, "nice");
                            pstmt.setString(4, "Tube after speedboat");
                            pstmt.setDouble(5, 100);
                            pstmt.setString(6, "Easy");
                            pstmt.setString(7, "abc");
                            pstmt.setInt(8, 30);
                            pstmt.setString(9, "Smålandsfarvandet");
                            pstmt.setString(10, "Do IT");

                            //execute the preparedstatement..
                            pstmt.execute();
                            con.close();

                        case 2:
                            String query2 = "insert into tours(packageId, tourName, blurb, description, price, difficulty, graphic, length, region, keywords)"
                                    + "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                            Connection con2 = DBUtil.getConnection(DBType.HSQLDB);
                            PreparedStatement pstmt2 = con2.prepareStatement(query2);
                            pstmt2.setInt(1, 9);
                            pstmt2.setString(2, "WaterTube");
                            pstmt2.setString(3, "nice");
                            pstmt2.setString(4, "Tube after speedboat");
                            pstmt2.setDouble(5, 100);
                            pstmt2.setString(6, "Easy");
                            pstmt2.setString(7, "abc");
                            pstmt2.setInt(8, 30);
                            pstmt2.setString(9, "Smålandsfarvandet");
                            pstmt2.setString(10, "Do IT");

                            //execute the preparedstatement..
                            pstmt2.execute();
                            con2.close();

                    }
                    break;

                case 4:
                    System.out.println("Menu closed");
                    done = false;
            }

        }
    }
}
/*try (
                Connection con = DBUtil.getConnection(DBType.HSQLDB);
                Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                ResultSet rs = stmt.executeQuery("SELECT * FROM tours");) {

//            rs.last();
//            System.out.println("Number of rows: " + rs.getRow());

                Tours.displayData(rs);

            //System.out.println("Connected");
        } catch (SQLException e) {
            DBUtil.processExeption(e);
        }
    }*/
