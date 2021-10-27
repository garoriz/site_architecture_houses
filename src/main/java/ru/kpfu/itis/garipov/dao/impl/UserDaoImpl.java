package ru.kpfu.itis.garipov.dao.impl;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import ru.kpfu.itis.garipov.dao.Dao;
import ru.kpfu.itis.garipov.helper.PasswordHelper;
import ru.kpfu.itis.garipov.helper.PostgresConnectionHelper;
import ru.kpfu.itis.garipov.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl implements Dao<User> {

    public static final Logger LOGGER = LoggerFactory.getLogger(UserDaoImpl.class);

    private final Connection connection = PostgresConnectionHelper.getConnection();

    @Override
    public User get(String login) {
        String sql = "SELECT * FROM users WHERE login = ?;";
        User user = null;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, login);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet == null) {
                return null;
            }
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                String status = resultSet.getString("status");
                String urlPhoto = resultSet.getString("url_photo");
                String password = resultSet.getString("password");
                user = new User(name, surname, status, urlPhoto, login, password);
            }
        }  catch (SQLException throwables) {
            LOGGER.warn("Failed to get user.", throwables);
        }
        return user;
    }

    @Override
    public void save(User user) {
        String sql = "INSERT INTO users (name, surname, status, url_photo, login, password) VALUES (?, ?, ?, ?, ?, ?);";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getSurname());
            preparedStatement.setString(3, user.getStatus());
            preparedStatement.setString(4, user.getUrlPhoto());
            preparedStatement.setString(5, user.getLogin());
            preparedStatement.setString(6, user.getPassword());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            LOGGER.warn("Failed to save new user.", throwables);
        }
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    public void changeName(String login, String name) {
        String sql = "UPDATE users SET name = ? WHERE login = ?;";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, login);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            LOGGER.warn("Failed to update user.", throwables);
        }
    }

    public void changeSurname(String login, String surname) {
        String sql = "UPDATE users SET surname = ? WHERE login = ?;";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, surname);
            preparedStatement.setString(2, login);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            LOGGER.warn("Failed to update user.", throwables);
        }
    }

    public void changeLogin(String login, String newLogin) {
        String sql = "UPDATE users SET login = ? WHERE login = ?;";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, newLogin);
            preparedStatement.setString(2, login);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            LOGGER.warn("Failed to update user.", throwables);
        }
    }

    public void changeUrlPhoto(String login, String urlPhoto) {
        String sql = "UPDATE users SET url_photo = ? WHERE login = ?;";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, urlPhoto);
            preparedStatement.setString(2, login);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            LOGGER.warn("Failed to update user.", throwables);
        }
    }

    public void changeStatus(String login, String status) {
        String sql = "UPDATE users SET status = ? WHERE login = ?;";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, status);
            preparedStatement.setString(2, login);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            LOGGER.warn("Failed to update user.", throwables);
        }
    }

    public void changePassword(String login, String password) {
        String sql = "UPDATE users SET password = ? WHERE login = ?;";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, password);
            preparedStatement.setString(2, login);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            LOGGER.warn("Failed to update user.", throwables);
        }
    }
}
