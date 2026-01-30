/*
 * 🧩 Problem Statement
 * Simple user management program that:
 * - Registers users with username and age
 * - Automatically marks users below 18 as RESTRICTED
 * - Stores users in memory (no database)
 * - Prints all users with age or RESTRICTED label
 * 
 * Demonstrates: Classes, Objects, Constructors, ArrayList, Separation of Concerns
 */

import java.util.ArrayList;
import java.util.List;

/**
 * UserService - Service layer that handles user operations
 * Coordinates between the application and data storage
 */
class UserService {
    
    /**
     * Register a new user in the system
     */
    public void registerUser(String username, int age) {
        User user = new User(username, age);
        DataStore.getRepository().add(user);
    }
    
    /**
     * Print all registered users
     * Shows (RESTRICTED) for users under 18, otherwise shows age
     */
    public void printAllUsers() {
        for (User user : DataStore.getRepository().findAll()) {
            if (user.isRestricted()) {
                System.out.println(user.getUsername() + " (RESTRICTED)");
            } else {
                System.out.println(user.getUsername() + " (" + user.getAge() + ")");
            }
        }
    }
}

/**
 * UserRepository - Data storage layer
 * Stores users in memory using ArrayList
 */
class UserRepository {
    
    private List<User> users = new ArrayList<>();
    
    public void add(User user) {
        users.add(user);
    }
    
    public List<User> findAll() {
        return users;
    }
}

/**
 * User - Represents a user with username and age
 * Demonstrates encapsulation with private fields and public getters
 */
class User {
    
    private String username;
    private int age;
    private boolean restricted;
    
    /**
     * Constructor - automatically sets restricted flag based on age
     */
    public User(String username, int age) {
        this.username = username;
        this.age = age;
        this.restricted = age < 18;  // Users under 18 are restricted
    }
    
    public String getUsername() {
        return username;
    }
    
    public int getAge() {
        return age;
    }
    
    public boolean isRestricted() {
        return restricted;
    }
}

/**
 * DataStore - Provides a single shared UserRepository instance
 * Implements the Singleton pattern for centralized data access
 */
class DataStore {
    
    private static UserRepository repository = new UserRepository();
    
    public static UserRepository getRepository() {
        return repository;
    }
}

/**
 * Main - Entry point of the program
 */
public class Main {
    
    public static void main(String[] args) {
        UserService service = new UserService();
        
        // Register users with different ages
        service.registerUser("alice", 20);  // Not restricted
        service.registerUser("bob", 16);    // Restricted (under 18)
        
        // Display all users
        service.printAllUsers();
    }
}
