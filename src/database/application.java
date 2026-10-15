package database;

public class application {
    private int applicationId;
    private int projectId;
    private int freelancerId;
    private String status;
    private String applicationDate;

    public application(){

    }


    public application(int applicationId, int projectId, int freelancerId, String status, String applicationDate) {
        this.applicationId = applicationId;
        this.projectId = projectId;
        this.freelancerId = freelancerId;
        this.status = status;
        this.applicationDate = applicationDate;
    }

    public int getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(int applicationId) {
        this.applicationId = applicationId;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public int getFreelancerId() {
        return freelancerId;
    }

    public void setFreelancerId(int freelancerId) {
        this.freelancerId = freelancerId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(String applicationDate) {
        this.applicationDate = applicationDate;
    }

    @Override
    public String toString() {
        return "application{" +
                "applicationId=" + applicationId +
                ", projectId=" + projectId +
                ", freelancerId=" + freelancerId +
                ", status='" + status + '\'' +
                ", applicationDate='" + applicationDate + '\'' +
                '}';
    }
}
