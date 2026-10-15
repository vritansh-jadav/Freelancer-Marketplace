package service;
import database.DBconnection;
import database.user;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;


public class ApplicationService {
    public void applyProject(int projectId,
                             int freelancerId) {

        try {

            Connection con =
                    DBconnection.getConnection();

            String sql =
                    "INSERT INTO applications(project_id,freelancer_id,status,application_date) VALUES(?,?,?,CURDATE())";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setInt(1, projectId);
            ps.setInt(2, freelancerId);
            ps.setString(3, "PENDING");

            int rows = ps.executeUpdate();

            if(rows > 0) {

                System.out.println("Application Submitted");
            }

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    public void viewApplications() {

        try {

            Connection con =
                    DBconnection.getConnection();

            String sql =
                    "SELECT * FROM applications";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ResultSet rs =
                    ps.executeQuery();

            while(rs.next()) {

                System.out.println("-------------------");

                System.out.println(
                        "Application ID : "
                                + rs.getInt("application_id"));

                System.out.println(
                        "Project ID : "
                                + rs.getInt("project_id"));

                System.out.println(
                        "Freelancer ID : "
                                + rs.getInt("freelancer_id"));

                System.out.println(
                        "Status : "
                                + rs.getString("status"));

                System.out.println("-------------------");
            }

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    public void acceptApplication(int applicationId) {

        try {

            Connection con =
                    DBconnection.getConnection();

            String sql =
                    "UPDATE applications SET status='ACCEPTED' WHERE application_id=?";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setInt(1, applicationId);

            int rows = ps.executeUpdate();

            if(rows > 0) {

                System.out.println(
                        "Application Accepted");
            }

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    public void rejectApplication(int applicationId) {

        try {

            Connection con =
                    DBconnection.getConnection();

            String sql =
                    "UPDATE applications SET status='REJECTED' WHERE application_id=?";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setInt(1, applicationId);

            int rows = ps.executeUpdate();

            if(rows > 0) {

                System.out.println(
                        "Application Rejected");
            }

        } catch (Exception e) {

            e.printStackTrace();
        }
    }




}
