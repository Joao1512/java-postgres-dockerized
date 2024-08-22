package org.example.config;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection {
    public static java.sql.Connection connection = null;

    public static java.sql.Connection connect() {
        try {
            if (connection == null) {
                String dbUrl = System.getenv("DB_URL");
                String password = System.getenv("POSTGRES_PASSWORD");
                Driver driver = DriverManager.getDriver(dbUrl);
                DriverManager.registerDriver(driver);
                connection = DriverManager.getConnection(dbUrl, "postgres", password);
                System.out.println("Successful connection!");
            }
        } catch (SQLException exception) {
            System.out.println("Connection failed!");
            System.out.println(exception.getMessage());
        }
        return connection;
    }
}
