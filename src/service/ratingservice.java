package service;

//package service;

import database.DBconnection;

import java.sql.*;
import java.util.Scanner;

public class ratingservice {

    Scanner sc = new Scanner(System.in);

    public void giveRating(int clientId) {

        try {

            Connection con =
                    DBconnection.getConnection();

            System.out.print("Enter Project ID : ");
            int projectId = sc.nextInt();

            System.out.print("Enter Freelancer ID : ");
            int freelancerId = sc.nextInt();

            System.out.print("Enter Rating (1-5) : ");
            int stars = sc.nextInt();
            sc.nextLine();

            if(stars < 1 || stars > 5) {

                System.out.println("Invalid Rating");
                return;
            }

            System.out.print("Enter Review : ");
            String review = sc.nextLine();

            String sql =
                    "INSERT INTO ratings(project_id,freelancer_id,client_id,stars,review) VALUES(?,?,?,?,?)";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setInt(1, projectId);
            ps.setInt(2, freelancerId);
            ps.setInt(3, clientId);
            ps.setInt(4, stars);
            ps.setString(5, review);

            int rows = ps.executeUpdate();

            if(rows > 0) {

                System.out.println("Rating Submitted Successfully");
            }

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    public void viewRatings(int freelancerId) {

        try {

            Connection con =
                    DBconnection.getConnection();

            String sql =
                    "SELECT * FROM ratings WHERE freelancer_id=?";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setInt(1, freelancerId);

            ResultSet rs =
                    ps.executeQuery();

            while(rs.next()) {

                System.out.println("--------------------------------");

                System.out.println("Project ID : "
                        + rs.getInt("project_id"));

                System.out.println("Rating : "
                        + rs.getInt("stars"));

                System.out.println("Review : "
                        + rs.getString("review"));

                System.out.println("--------------------------------");
            }

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}
