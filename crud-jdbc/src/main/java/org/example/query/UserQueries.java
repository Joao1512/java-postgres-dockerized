package org.example.query;

public class UserQueries {

    public static String GET_ALL = "SELECT id, name FROM users u";

    public static final String GET_BY_ID = "SELECT * FROM users " +
            "WHERE (" +
            "id = ?" +
            ")";
    public static String INSERT = "INSERT INTO users (nome) VALUES (?)";

    public static final String DELETE = "DELETE from users " +
            "WHERE (" +
            "id = ?" +
            ")";
}
