package database;

public class client{
    private int clientId;
    private int userId;
    private String companyName;

    public client(){

    }


    public client(int clientId, int userId, String companyName) {
        this.clientId = clientId;
        this.userId = userId;
        this.companyName = companyName;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public String toString() {
        return "client{" +
                "clientId=" + clientId +
                ", userId=" + userId +
                ", companyName='" + companyName + '\'' +
                '}';
    }
}
