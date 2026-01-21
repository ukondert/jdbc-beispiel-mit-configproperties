package com.example.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Database connection manager
 */
public class DatabaseConnection {
    private DatabaseConfig config;

    public DatabaseConnection(DatabaseConfig config) {
        this.config = config;
        try {
            // Load H2 driver
            Class.forName(config.getDriver());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("H2 Driver not found", e);
        }
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
            config.getUrl(),
            config.getUser(),
            config.getPassword()
        );
    }
}
