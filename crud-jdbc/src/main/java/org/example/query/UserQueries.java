package org.example.query;

public final class UserQueries {

    private UserQueries(){}

    public static final String GETALL = "SELECT id, name FROM users u";

    public static final String GETBYID = "SELECT * FROM users " +
            "WHERE (" +
            "id = ?" +
            ")";
    public static final String INSERT = "INSERT INTO users (nome) VALUES (?)";

    public static final String DELETE = "DELETE from users " +
            "WHERE (" +
            "id = ?" +
            ")";
}
