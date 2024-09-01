package org.example.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionSingleton {
    private Connection connection = null;
    private static ConnectionSingleton connectionSingleton;
    private static final Logger logger = LoggerFactory.getLogger(ConnectionSingleton.class);

    public static ConnectionSingleton getInstance() {
        if (connectionSingleton == null) {
            connectionSingleton = new ConnectionSingleton();
            return connectionSingleton;
        }
        return connectionSingleton;
    }

    public Connection connect() {
        try {
            if (connection == null) {
                String dbUrl = System.getenv("DB_URL");
                String password = System.getenv("POSTGRES_PASSWORD_FILE");
                Driver driver = DriverManager.getDriver(dbUrl);
                DriverManager.registerDriver(driver);
                connection = DriverManager.getConnection(dbUrl, "postgres", password);
                logger.info("Successful connection!");
            }
        } catch (SQLException exception) {
            logger.error(String.format("Connection failed: %s", exception.getMessage()));
        }
        return connection;
    }
}
