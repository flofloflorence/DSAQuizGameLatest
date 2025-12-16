package model;

import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import dataSaving.FileManager;

public class UserManager {
    private static UserManager instance; // Store the single instance of UserManager
    private List<User> users; // Create a user list to store many User objects
    private User currentUser; // Store the current logged-in user
    
    // Private constructor (Other classes cannot create a new instance of UserManager)
    private UserManager(){
        users = new ArrayList<>(); // Initialize the users list to an empty ArrayList
        // Load users.txt into memory
        Map<String, String> map = FileManager.loadUsers();
        for (Map.Entry<String, String> e : map.entrySet()) {
            users.add(new User(e.getKey(), e.getValue())); // Store password
        }
    }
    
    // Can access to the one UserManager instance
    // Create a new instance of UserManager only once and returns the same instance every time
    public static UserManager getInstance(){
        if (instance == null)
            instance = new UserManager();
        return instance;
    }
    
    // Login operation
    public String login(String username, String password){
        System.out.println("Attempting to login user: " + username);
        
        try {
            if (username == null || password == null)
                return "Invalid input: null values are not allowed";

            if (username.trim().isEmpty() || password.trim().isEmpty())
                return "Please fill in all fields";

            for (User user : users) {
                if (user.getUsername().equals(username)) {
                    if (user.getPassword().equals(password)) {
                        currentUser = user;
                        return "Login successful";
                    }
                    return "Incorrect password";
                }
            }
            return "Username not found";
            
        } catch (Exception e) {
            System.err.println("Error in login: " + e.getMessage());
            return "Login failed due to system error";
        }
    }
    
    // Registration operation
    public String register(String username, String password){
        System.out.println("Attempting to register user: " + username);

        try {
            if (username == null || password == null) 
                return "Invalid input: null values are not allowed";

            if (username.trim().isEmpty() || password.trim().isEmpty())
                return "Please fill in all fields";

            if (username.length() > 30)
                return "Username is too long (maximum 30 characters)";
            
            if (password.length() <= 6)
                return "Password must be more than 6 characters long";
            
            for (User user : users) {
                if (user.getUsername().equals(username))
                    return "Username already exists";
            }

            // Create new user
            User newUser = new User(username, password); 
            users.add(newUser); 
            FileManager.saveUser(username, password);
            return "Registration successful";
            
        } catch (Exception e) {
            System.err.println("Error in registration: " + e.getMessage());
            return "Registration failed due to system error";
        }   
    }
    
    // Get current user
    public User getCurrentUser(){
        return currentUser;
    }
    
    // Logout operation
    public void logout(){
        currentUser = null; 
    }
}
