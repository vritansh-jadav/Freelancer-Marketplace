package service;
//package services;

import database.DBconnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class ProjectService {

    Scanner sc = new Scanner(System.in);

    public void postProject(int clientId) {

        try {

            Connection con = DBconnection.getConnection();

            System.out.print("Enter Project Title : ");
            String title = sc.nextLine();

            System.out.print("Enter Description : ");
            String description = sc.nextLine();

            System.out.print("Enter Budget : ");
            double budget = sc.nextDouble();
            sc.nextLine();

            System.out.print("Enter Deadline (YYYY-MM-DD) : ");
            String deadline = sc.nextLine();

            String sql =
                    "INSERT INTO projects(title,description,budget,deadline,status,client_id) VALUES(?,?,?,?,?,?)";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setString(1, title);
            ps.setString(2, description);
            ps.setDouble(3, budget);
            ps.setString(4, deadline);
            ps.setString(5, "OPEN");
            ps.setInt(6, clientId);

            int rows = ps.executeUpdate();

            if(rows > 0) {

                System.out.println();
                System.out.println("Project Posted Successfully");
            }

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    public void viewAllProjects() {

        try {

            Connection con = DBconnection.getConnection();

            String sql = "SELECT * FROM projects";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ResultSet rs =
                    ps.executeQuery();

            while(rs.next()) {

                System.out.println("----------------------------------");

                System.out.println("Project ID : "
                        + rs.getInt("project_id"));

                System.out.println("Title : "
                        + rs.getString("title"));

                System.out.println("Description : "
                        + rs.getString("description"));

                System.out.println("Budget : "
                        + rs.getDouble("budget"));

                System.out.println("Deadline : "
                        + rs.getString("deadline"));

                System.out.println("Status : "
                        + rs.getString("status"));

                System.out.println("----------------------------------");
            }

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    public void viewMyProjects(int clientId) {

        try {

            Connection con = DBconnection.getConnection();

            String sql =
                    "SELECT * FROM projects WHERE client_id=?";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setInt(1, clientId);

            ResultSet rs =
                    ps.executeQuery();

            while(rs.next()) {

                System.out.println("----------------------------------");

                System.out.println("Project ID : "
                        + rs.getInt("project_id"));

                System.out.println("Title : "
                        + rs.getString("title"));

                System.out.println("Budget : "
                        + rs.getDouble("budget"));

                System.out.println("Status : "
                        + rs.getString("status"));

                System.out.println("----------------------------------");
            }

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}
