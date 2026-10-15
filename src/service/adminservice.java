package service;

import database.DBconnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class adminservice {
    public void viewUsers() {

        try {

            Connection con = DBconnection.getConnection();

            String sql = "SELECT * FROM users";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while(rs.next()) {

                System.out.println("--------------------");

                System.out.println("User ID : "
                        + rs.getInt("user_id"));

                System.out.println("Name : "
                        + rs.getString("name"));

                System.out.println("Email : "
                        + rs.getString("email"));

                System.out.println("Role : "
                        + rs.getString("role"));

                System.out.println("--------------------");
            }

        } catch(Exception e) {

            e.printStackTrace();
        }
    }


    public void viewProjects() {

        try {

            Connection con = DBconnection.getConnection();

            String sql = "SELECT * FROM projects";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while(rs.next()) {

                System.out.println("--------------------");

                System.out.println("Project ID : "
                        + rs.getInt("project_id"));

                System.out.println("Title : "
                        + rs.getString("title"));

                System.out.println("Budget : "
                        + rs.getDouble("budget"));

                System.out.println("Status : "
                        + rs.getString("status"));

                System.out.println("--------------------");
            }

        } catch(Exception e) {

            e.printStackTrace();
        }
    }

    public void viewApplications() {

        try {

            Connection con = DBconnection.getConnection();

            String sql =
                    "SELECT * FROM applications";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while(rs.next()) {

                System.out.println("--------------------");

                System.out.println("Application ID : "
                        + rs.getInt("application_id"));

                System.out.println("Project ID : "
                        + rs.getInt("project_id"));

                System.out.println("Freelancer ID : "
                        + rs.getInt("freelancer_id"));

                System.out.println("Status : "
                        + rs.getString("status"));

                System.out.println("--------------------");
            }

        } catch(Exception e) {

            e.printStackTrace();
        }
    }

    public void deleteUser() {

        Scanner sc = new Scanner(System.in);

        try {

            Connection con = DBconnection.getConnection();

            System.out.print("Enter User ID : ");
            int id = sc.nextInt();

            String sql =
                    "DELETE FROM users WHERE user_id=?";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setInt(1,id);

            int rows = ps.executeUpdate();

            if(rows > 0) {

                System.out.println("User Deleted");
            }

        } catch(Exception e) {

            e.printStackTrace();
        }
    }

    public void deleteProject() {

        Scanner sc = new Scanner(System.in);

        try {

            Connection con = DBconnection.getConnection();

            System.out.print("Enter Project ID : ");
            int id = sc.nextInt();

            String sql =
                    "DELETE FROM projects WHERE project_id=?";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setInt(1,id);

            int rows = ps.executeUpdate();

            if(rows > 0) {

                System.out.println("Project Deleted");
            }

        } catch(Exception e) {

            e.printStackTrace();
        }
    }

    public void generateReport() {

        try {

            Connection con = DBconnection.getConnection();

            Statement st = con.createStatement();

            ResultSet rs1 =
                    st.executeQuery(
                            "SELECT COUNT(*) FROM users");

            rs1.next();
            int users = rs1.getInt(1);

            ResultSet rs2 =
                    st.executeQuery(
                            "SELECT COUNT(*) FROM projects");

            rs2.next();
            int projects = rs2.getInt(1);

            ResultSet rs3 =
                    st.executeQuery(
                            "SELECT COUNT(*) FROM applications");

            rs3.next();
            int applications = rs3.getInt(1);

            System.out.println("\n===== REPORT =====");

            System.out.println(
                    "Total Users : " + users);

            System.out.println(
                    "Total Projects : " + projects);

            System.out.println(
                    "Total Applications : "
                            + applications);

        } catch(Exception e) {

            e.printStackTrace();
        }
    }


}
