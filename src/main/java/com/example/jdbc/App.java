package com.example.jdbc;

import java.sql.SQLException;
import java.util.List;

/**
 * Main application demonstrating JDBC operations with H2 database
 */
public class App {
    public static void main(String[] args) {
        System.out.println("=== JDBC H2 Database Example ===\n");

        try {
            // Load configuration
            DatabaseConfig config = new DatabaseConfig();
            DatabaseConnection dbConnection = new DatabaseConnection(config);
            UserDAO userDAO = new UserDAO(dbConnection);

            // Create table
            System.out.println("1. Creating table...");
            userDAO.createTable();
            System.out.println();

            // Insert users
            System.out.println("2. Inserting users...");
            userDAO.insertUser("Max Mustermann", "max@example.com");
            userDAO.insertUser("Anna Schmidt", "anna@example.com");
            userDAO.insertUser("Peter Klein", "peter@example.com");
            System.out.println();

            // Read all users
            System.out.println("3. Reading all users...");
            List<User> users = userDAO.getAllUsers();
            users.forEach(System.out::println);
            System.out.println();

            // Read user by ID
            System.out.println("4. Reading user with ID 2...");
            User user = userDAO.getUserById(2);
            System.out.println(user);
            System.out.println();

            // Update user
            System.out.println("5. Updating user with ID 2...");
            userDAO.updateUser(2, "Anna Müller", "anna.mueller@example.com");
            User updatedUser = userDAO.getUserById(2);
            System.out.println("Updated: " + updatedUser);
            System.out.println();

            // Delete user
            System.out.println("6. Deleting user with ID 3...");
            userDAO.deleteUser(3);
            System.out.println();

            // Show remaining users
            System.out.println("7. Final user list...");
            List<User> remainingUsers = userDAO.getAllUsers();
            remainingUsers.forEach(System.out::println);
            
            System.out.println("\n=== Demo completed successfully ===");

        } catch (SQLException e) {
            System.err.println("Database error: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Application error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
