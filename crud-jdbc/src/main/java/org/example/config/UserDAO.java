package org.example.config;

import org.example.model.User.User;
import org.example.query.UserQueries;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;

@Component
public class UserDAO {

    public int insert(User user) throws SQLException {
        java.sql.Connection connection = org.example.config.Connection.connect();

       PreparedStatement statement = connection.prepareStatement(UserQueries.INSERT, Statement.RETURN_GENERATED_KEYS);
       statement.setString(1, user.getName());
       statement.executeUpdate();
       return statement.getGeneratedKeys().getInt(1);
    }

    public User getById(Integer id) throws SQLException {
        java.sql.Connection connection = org.example.config.Connection.connect();

        PreparedStatement ps = connection.prepareStatement(UserQueries.GET_BY_ID);
        ps.setInt(1, id);
        ResultSet result = ps.executeQuery();
        if (result.next()) {
            User user = new User();
            user.setName(result.getString("name"));
            user.setId(result.getInt("id"));
            return user;
        }
        return null;
    }

    public ArrayList<User> getAll() throws SQLException {
        java.sql.Connection connection = org.example.config.Connection.connect();

        PreparedStatement ps = connection.prepareStatement(UserQueries.GET_ALL);
        ResultSet result = ps.executeQuery();
        ArrayList<User> users = new ArrayList<>();
        while (result.next()) {
            User user = new User();
            user.setName(result.getString("name"));
            user.setId(result.getInt("id"));
            users.add(user);
        }
        return users;
    }

    public boolean delete(Integer id) throws SQLException {
        java.sql.Connection connection = org.example.config.Connection.connect();

        PreparedStatement statement = connection.prepareStatement(UserQueries.DELETE);
        statement.setInt(1, id);
        int result = statement.executeUpdate();
        return result > 1;
    }
}
