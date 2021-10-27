package ru.kpfu.itis.garipov.dao.impl;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import ru.kpfu.itis.garipov.dao.Dao;
import ru.kpfu.itis.garipov.helper.PostgresConnectionHelper;
import ru.kpfu.itis.garipov.model.Article;
import ru.kpfu.itis.garipov.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ArticleDaoImpl implements Dao<Article> {

    public static final Logger LOGGER = LoggerFactory.getLogger(ArticleDaoImpl.class);

    private final Connection connection = PostgresConnectionHelper.getConnection();

    @Override
    public Article get(String login) {
        return null;
    }

    @Override
    public void save(Article article) {

    }

    @Override
    public List<Article> getAll() {
        String sql = "SELECT * FROM articles;";
        List<Article> articles = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String date = resultSet.getString("date");
                String heading = resultSet.getString("heading");
                int userId = resultSet.getInt("user_id");
                String urlPhoto = resultSet.getString("url_photo");
                String content = resultSet.getString("content");
                articles.add(new Article(userId, date, heading, content, urlPhoto));
            }
        } catch (SQLException throwables) {
            LOGGER.warn("Failed to get all articles.", throwables);
        }
        return articles;
    }
}
