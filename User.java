public abstract class User {
    private String username;
    private String password;

    abstract boolean validateLogin(String userAttempt, String passwordAttempt);
    public void setUsername(String newUser) {
        this.username = newUser;
    }
    public String getUsername() {
        return this.username;
    }
    public void setPassword(String newPass) {
        this.password = newPass;
    }
    public String getPassword() {
        return this.password;
    }
}