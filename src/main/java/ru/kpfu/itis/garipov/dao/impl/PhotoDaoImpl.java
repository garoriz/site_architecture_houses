package ru.kpfu.itis.garipov.dao.impl;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import ru.kpfu.itis.garipov.dao.Dao;
import ru.kpfu.itis.garipov.helper.PostgresConnectionHelper;
import ru.kpfu.itis.garipov.model.Article;
import ru.kpfu.itis.garipov.model.Photo;
import ru.kpfu.itis.garipov.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PhotoDaoImpl implements Dao<Photo> {

    public static final Logger LOGGER = LoggerFactory.getLogger(ArticleDaoImpl.class);

    private final Connection connection = PostgresConnectionHelper.getConnection();

    @Override
    public Photo get(int id) {
        String sql = "SELECT * FROM photos WHERE id = ?;";
        Photo photo = null;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                photo = new Photo(id,
                        resultSet.getInt("user_id"),
                        resultSet.getString("url_photo"));
            }
        } catch (SQLException throwables) {
            LOGGER.warn("Failed to get photo.", throwables);
        }
        return photo;
    }

    @Override
    public void save(Photo photo) {
        String sql = "INSERT INTO photos (user_id, url_photo) VALUES (?, ?);";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, photo.getUserId());
            preparedStatement.setString(2, photo.getUrlPhoto());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            LOGGER.warn("Failed to save new photo.", throwables);
        }
    }

    @Override
    public List<Photo> getAll() {
        String sql = "SELECT * FROM photos;";
        List<Photo> photos = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int userId = resultSet.getInt("user_id");
                String urlPhoto = resultSet.getString("url_photo");
                photos.add(new Photo(id, userId, urlPhoto));
            }
        } catch (SQLException throwables) {
            LOGGER.warn("Failed to get all photos.", throwables);
        }
        return photos;
    }

    public List<Photo> getAllById(int id) {
        String sql = "SELECT * FROM photos WHERE user_id = ?;";
        List<Photo> photos = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int resultId = resultSet.getInt("id");
                String urlPhoto = resultSet.getString("url_photo");
                photos.add(new Photo(resultId, id, urlPhoto));
            }
        } catch (SQLException throwables) {
            LOGGER.warn("Failed to get all photos.", throwables);
        }
        return photos;
    }
}
