package com.example.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Configuration manager that loads database properties from db.properties file
 */
public class DatabaseConfig {
    private Properties properties;

    public DatabaseConfig() {
        properties = new Properties();
        try (InputStream input = getClass().getClassLoader()
                .getResourceAsStream("db.properties")) {
            if (input == null) {
                throw new RuntimeException("Unable to find db.properties");
            }
            properties.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Error loading db.properties", e);
        }
    }

    public String getUrl() {
        return properties.getProperty("db.url");
    }

    public String getUser() {
        return properties.getProperty("db.user");
    }

    public String getPassword() {
        return properties.getProperty("db.password");
    }

    public String getDriver() {
        return properties.getProperty("db.driver");
    }
}
