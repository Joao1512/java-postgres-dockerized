package org.example.config;

import org.example.model.user.User;
import org.example.query.UserQueries;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserDAO {
    private final ConnectionSingleton connectionSingleton = ConnectionSingleton.getInstance();
    private static final Logger LOGGER = LoggerFactory.getLogger(UserDAO.class);

    public int insert(User user) {

        Connection connection = connectionSingleton.connect();
        try {
           PreparedStatement statement = connection.prepareStatement(UserQueries.INSERT, Statement.RETURN_GENERATED_KEYS);
           statement.setString(1, user.getName());
           statement.executeUpdate();
           return statement.getGeneratedKeys().getInt(1);
        } catch (SQLException exception) {
            LOGGER.error("Delete failed: " + exception.getMessage());
            return 0;
        }
    }

    public User getById(Integer id) {
        Connection connection = connectionSingleton.connect();
        try {

            PreparedStatement ps = connection.prepareStatement(UserQueries.GETBYID);
            ps.setInt(1, id);
            ResultSet result = ps.executeQuery();
            if (result.next()) {
                User user = new User();
                user.setName(result.getString("name"));
                user.setId(result.getInt("id"));
                return user;
            }
            return null;
        } catch (SQLException exception) {
            LOGGER.error("get failed: " + exception.getMessage());
            return null;
        }
    }
    public List<User> getAll() {
        Connection connection = connectionSingleton.connect();
        try {

            PreparedStatement ps = connection.prepareStatement(UserQueries.GETALL);
            ResultSet result = ps.executeQuery();
            ArrayList<User> users = new ArrayList<>();
            while (result.next()) {
                User user = new User();
                user.setName(result.getString("name"));
                user.setId(result.getInt("id"));
                users.add(user);
            }
            return users;
        } catch (SQLException exception) {
            LOGGER.error("Delete failed: " + exception.getMessage());
            return null;
        }
    }

    public boolean delete(Integer id) {
        Connection connection = connectionSingleton.connect();
        try {

            PreparedStatement statement = connection.prepareStatement(UserQueries.DELETE);
            statement.setInt(1, id);
            int result = statement.executeUpdate();
            return result > 1;
        } catch (SQLException exception) {
            LOGGER.error("Delete failed: " + exception.getMessage());
            return false;
        }
    }
}
