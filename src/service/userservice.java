package service;

//package services;
import database.DBconnection;
import database.user;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class userservice {

     static Scanner sc = new Scanner(System.in);

    public void registerUser() {

        try {

            Connection con =
                    DBconnection.getConnection();

            user user = new user();

            System.out.print("Enter Name : ");
            user.setName(sc.nextLine());

            System.out.print("Enter Email : ");
            user.setEmail(sc.nextLine());

            System.out.print("Enter Password : ");
            user.setPassword(sc.nextLine());

            System.out.print("Enter Phone : ");
            user.setPhone(sc.nextLine());

            System.out.print("Enter Role (CLIENT/FREELANCER) : ");
            user.setRole(sc.nextLine());

            String sql =
                    "INSERT INTO user(name,email,password,phone,role) VALUES(?,?,?,?,?)";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getPhone());
            ps.setString(5, user.getRole());

            int rows = ps.executeUpdate();

            if(rows > 0) {

                System.out.println();
                System.out.println("Registration Successful");
            }

        } catch (Exception e) {

            System.out.println("Registration Failed");
            e.printStackTrace();
        }

    }

    public static user loginUser() {

        try {

            Connection con =
                    DBconnection.getConnection();

            System.out.print("Enter Email : ");
            String email = sc.nextLine();

            System.out.print("Enter Password : ");
            String password = sc.nextLine();

            String sql =
                    "SELECT * FROM user WHERE email=? AND password=?";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setString(1,email);
            ps.setString(2,password);

            ResultSet rs = ps.executeQuery();

            if(rs.next()) {
                user u = new user();


                System.out.println();
                System.out.println("Login Successful");

                System.out.println("Welcome "
                        + rs.getString("name"));

                System.out.println("Role : "
                        + rs.getString("role"));
                return u;

            } else {

                System.out.println();
                System.out.println("Invalid Email or Password");
            }

        } catch (Exception e) {

            e.printStackTrace();
        }
        return null;
    }
}
