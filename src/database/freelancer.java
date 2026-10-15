package database;
import java.sql.*;
public class freelancer {


    public class Freelancer extends user {

        // -------------------------------
        // Variables
        // -------------------------------
        private int freelancerId;
        private String skills;
        private int experience;
        private double rating;

        // -------------------------------
        // Default Constructor
        // -------------------------------
        public Freelancer() {

        }

        // -------------------------------
        // Parameterized Constructor
        // -------------------------------
        public Freelancer(int freelancerId, int userId, String name,
                          String email, String password, String role,
                          String phone, String skills,
                          int experience, double rating) {

            super(userId, name, email, password, role, phone);

            this.freelancerId = freelancerId;
            this.skills = skills;
            this.experience = experience;
            this.rating = rating;
        }

        // -------------------------------
        // Getter Methods
        // -------------------------------

        public int getFreelancerId() {
            return freelancerId;
        }

        public String getSkills() {
            return skills;
        }

        public int getExperience() {
            return experience;
        }

        public double getRating() {
            return rating;
        }

        // -------------------------------
        // Setter Methods
        // -------------------------------

        public void setFreelancerId(int freelancerId) {
            this.freelancerId = freelancerId;
        }

        public void setSkills(String skills) {
            this.skills = skills;
        }

        public void setExperience(int experience) {
            this.experience = experience;
        }

        public void setRating(double rating) {
            this.rating = rating;
        }

        // ===================================
        // Method : addSkill()
        // ===================================

        public void addSkill() {

            try {

                Connection con = DBconnection.getConnection();

                String sql = "UPDATE freelancers SET skills=? WHERE freelancer_id=?";

                PreparedStatement ps = con.prepareStatement(sql);

                ps.setString(1, skills);
                ps.setInt(2, freelancerId);

                int rows = ps.executeUpdate();

                if (rows > 0) {

                    System.out.println("Skills Added Successfully.");

                } else {

                    System.out.println("Skill Update Failed.");

                }

                ps.close();

            } catch (Exception e) {

                System.out.println(e);

            }

        }

        // ===================================
        // Method : viewProjects()
        // ===================================

        public void viewProjects() {

            try {

                Connection con = DBconnection.getConnection();

                String sql = "SELECT * FROM projects";

                PreparedStatement ps = con.prepareStatement(sql);

                ResultSet rs = ps.executeQuery();

                while (rs.next()) {

                    System.out.println("--------------------------------");

                    System.out.println("Project ID : " + rs.getInt("project_id"));
                    System.out.println("Title : " + rs.getString("title"));
                    System.out.println("Description : " + rs.getString("description"));
                    System.out.println("Budget : " + rs.getDouble("budget"));
                    System.out.println("Deadline : " + rs.getString("deadline"));
                    System.out.println("Status : " + rs.getString("status"));

                }

                rs.close();
                ps.close();

            } catch (Exception e) {

                System.out.println(e);

            }

        }

        // ===================================
        // Method : applyForProject()
        // ===================================

        public void applyForProject(int projectId) {

            try {

                Connection con = DBconnection.getConnection();

                String sql = "INSERT INTO applications(project_id,freelancer_id,status,application_date) VALUES(?,?,?,CURDATE())";

                PreparedStatement ps = con.prepareStatement(sql);

                ps.setInt(1, projectId);
                ps.setInt(2, freelancerId);
                ps.setString(3, "Pending");

                int rows = ps.executeUpdate();

                if (rows > 0) {

                    System.out.println("Application Submitted.");

                } else {

                    System.out.println("Application Failed.");

                }

                ps.close();

            } catch (Exception e) {

                System.out.println(e);

            }

        }

        // ===================================
        // Method : viewApplicationStatus()
        // ===================================

        public void viewApplicationStatus() {

            try {

                Connection con = DBconnection.getConnection();

                String sql = "SELECT * FROM applications WHERE freelancer_id=?";

                PreparedStatement ps = con.prepareStatement(sql);

                ps.setInt(1, freelancerId);

                ResultSet rs = ps.executeQuery();

                while (rs.next()) {

                    System.out.println("--------------------------------");

                    System.out.println("Application ID : " + rs.getInt("application_id"));
                    System.out.println("Project ID : " + rs.getInt("project_id"));
                    System.out.println("Status : " + rs.getString("status"));
                    System.out.println("Date : " + rs.getString("application_date"));

                }

                rs.close();
                ps.close();

            } catch (Exception e) {

                System.out.println(e);

            }

        }

        // ===================================
        // Method : viewCompletedProjects()
        // ===================================

        public void viewCompletedProjects() {

            try {

                Connection con = DBconnection.getConnection();

                String sql = "SELECT * FROM projects WHERE status='Completed'";

                PreparedStatement ps = con.prepareStatement(sql);

                ResultSet rs = ps.executeQuery();

                while (rs.next()) {

                    System.out.println("--------------------------------");

                    System.out.println("Project ID : " + rs.getInt("project_id"));
                    System.out.println("Title : " + rs.getString("title"));
                    System.out.println("Budget : " + rs.getDouble("budget"));
                    System.out.println("Status : " + rs.getString("status"));

                }

                rs.close();
                ps.close();

            } catch (Exception e) {

                System.out.println(e);

            }

        }

    }
}
