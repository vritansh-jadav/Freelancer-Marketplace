package database;

//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//
//public class DBconnection {
//    static void main(String[] args) throws ClassNotFoundException, SQLException {
//        //1.Loading Drivers
//        Class.forName("com.mysql.cj.jdbc.Driver");
//
//        //2.creating connections
//        String url = "JDBC:mysql://localhost:3306/freelancershub";
//        String user = "root";
//        String password = "";
//
//        Connection con = DriverManager.getConnection(url, user, password);
//
//        if (con != null) {
//            System.out.println("Connected to the database");
//        } else {
//            System.out.println("Failed to make connection");
//        }
//
//    }
//
//
//
//}
//package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBconnection {

    private static final String URL =
            "jdbc:mysql://localhost:3306/freelancershub";

    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static Connection getConnection() {

        try {

            Connection con =
                    DriverManager.getConnection(
                            URL,
                            USER,
                            PASSWORD
                    );

            return con;

        } catch (Exception e) {

            System.out.println("Database Connection Failed");
            e.printStackTrace();

            return null;
        }
    }
}