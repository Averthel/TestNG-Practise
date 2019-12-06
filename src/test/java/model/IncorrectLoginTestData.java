package model;

public class IncorrectLoginTestData {

    private String username;
    private String password;
    private String expectedWarning;

    public IncorrectLoginTestData(String username, String password, String expectedWarning) {
        this.username = username;
        this.password = password;
        this.expectedWarning = expectedWarning;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getExpectedWarning() {
        return expectedWarning;
    }

    public void setExpectedWarning(String expectedWarning) {
        this.expectedWarning = expectedWarning;
    }
}
