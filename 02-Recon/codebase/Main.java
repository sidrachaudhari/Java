/*
 * 🧩 Problem Statement
 * User management program with age validation that:
 * - Registers users only if they are 18 or older
 * - Rejects users under 18 with a message
 * - Stores eligible users in memory
 * - Prints all registered users with their age
 * 
 * Demonstrates: Input validation, Classes, Objects, ArrayList, Separation of Concerns
 */

import java.util.ArrayList;
import java.util.List;

/**
 * UserService - Service layer that handles user operations
 * Includes validation logic to ensure only eligible users are registered
 */
class UserService {

    /**
     * Register a new user in the system
     * Only users 18 or older are eligible for registration
     */
    public void registerUser(String username, int age) {
        // Validate age requirement - reject users under 18
        if (age < 18) {
            System.out.println("User not eligible: " + username);
            return;
        }

        // Create and store the user if eligible
        User user = new User(username, age);
        DataStore.getRepository().add(user);
    }

    /**
     * Print all registered users with their age
     */
    public void printAllUsers() {
        for (User user : DataStore.getRepository().findAll()) {
            System.out.println(user.getUsername() + " (" + user.getAge() + ")");
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

    /**
     * Constructor - initializes a user with username and age
     */
    public User(String username, int age) {
        this.username = username;
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public int getAge() {
        return age;
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

        // Attempt to register users with different ages
        service.registerUser("alice", 20);  // Eligible (18+)
        service.registerUser("bob", 16);    // Not eligible (under 18)

        // Display all successfully registered users
        service.printAllUsers();
    }
}
