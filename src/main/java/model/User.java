package model;

// Use for tracking user data, score and performance analysis
public class User {
    private String username;
    private String password;
    
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    // Set default password for performance test (not required actual password)
    public User(String username) {
        this(username, "");
    }
    
    public String getUsername() {
        return username;
    }
    
    public String getPassword(){
        return password;
    }
}
