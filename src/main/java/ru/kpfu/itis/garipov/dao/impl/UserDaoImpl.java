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
    public void change(String name, String surname, String login, String urlPhoto, String status, String password) {
    }
}
