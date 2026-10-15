package database;

public class rating {
    private int ratingId;
    private int projectId;
    private int freelancerId;
    private int clientId;
    private int stars;
    private String review;

    public rating(){

    }

    public rating(int ratingId, int projectId, int freelancerId, int clientId, int stars, String review) {
        this.ratingId = ratingId;
        this.projectId = projectId;
        this.freelancerId = freelancerId;
        this.clientId = clientId;
        this.stars = stars;
        this.review = review;
    }

    public int getRatingId() {
        return ratingId;
    }

    public void setRatingId(int ratingId) {
        this.ratingId = ratingId;
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

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    @Override
    public String toString() {
        return "rating{" +
                "ratingId=" + ratingId +
                ", projectId=" + projectId +
                ", freelancerId=" + freelancerId +
                ", clientId=" + clientId +
                ", stars=" + stars +
                ", review='" + review + '\'' +
                '}';
    }
}
