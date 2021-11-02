package ru.kpfu.itis.garipov.dao.impl;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import ru.kpfu.itis.garipov.dao.Dao;
import ru.kpfu.itis.garipov.helper.PostgresConnectionHelper;
import ru.kpfu.itis.garipov.model.Article;
import ru.kpfu.itis.garipov.model.Photo;
import ru.kpfu.itis.garipov.model.SaleAd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SaleAdDaoImpl implements Dao<SaleAd> {

    public static final Logger LOGGER = LoggerFactory.getLogger(ArticleDaoImpl.class);

    private final Connection connection = PostgresConnectionHelper.getConnection();

    @Override
    public SaleAd get(int id) {
        String sql = "SELECT * FROM sale_ads WHERE id = ?;";
        SaleAd saleAd = null;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                saleAd = new SaleAd(id,
                        resultSet.getInt("user_id"),
                        resultSet.getString("heading"),
                        resultSet.getString("content"),
                        resultSet.getInt("price"),
                        resultSet.getString("phone_number"),
                        resultSet.getString("url_photo"));
            }
        } catch (SQLException throwables) {
            LOGGER.warn("Failed to get sale ad.", throwables);
        }
        return saleAd;
    }

    @Override
    public void save(SaleAd saleAd) {
        String sql = "INSERT INTO sale_ads (user_id, heading, content, price, phone_number, url_photo)" +
                " VALUES (?, ?, ?, ?, ?, ?);";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, saleAd.getUserId());
            preparedStatement.setString(2, saleAd.getHeading());
            preparedStatement.setString(3, saleAd.getContent());
            preparedStatement.setInt(4, saleAd.getPrice());
            preparedStatement.setString(5, saleAd.getPhoneNumber());
            preparedStatement.setString(6, saleAd.getUrlPhoto());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            LOGGER.warn("Failed to save new sale ad.", throwables);
        }
    }

    @Override
    public List<SaleAd> getAll() {
        String sql = "SELECT * FROM sale_ads;";
        List<SaleAd> saleAds = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int userId = resultSet.getInt("user_id");
                String heading = resultSet.getString("heading");
                String content = resultSet.getString("content");
                int price = resultSet.getInt("price");
                String phoneNumber = resultSet.getString("phone_number");
                String urlPhoto = resultSet.getString("url_photo");
                saleAds.add(new SaleAd(id, userId, heading, content, price, phoneNumber, urlPhoto));
            }
        } catch (SQLException throwables) {
            LOGGER.warn("Failed to get all sale ads.", throwables);
        }
        return saleAds;
    }

    public void delete(int id) {
        String sql = "DELETE FROM sale_ads WHERE id = ?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            LOGGER.warn("Failed to delete sale ad.", throwables);
        }
    }

    public List<SaleAd> getAllById(int id) {
        String sql = "SELECT * FROM sale_ads WHERE user_id = ?;";
        List<SaleAd> saleAds = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int resultId = resultSet.getInt("id");
                String heading = resultSet.getString("heading");
                String content = resultSet.getString("content");
                int price = resultSet.getInt("price");
                String phoneNumber = resultSet.getString("phone_number");
                String urlPhoto = resultSet.getString("url_photo");
                saleAds.add(new SaleAd(resultId, id, heading, content, price, phoneNumber, urlPhoto));
            }
        } catch (SQLException throwables) {
            LOGGER.warn("Failed to get all sale ads.", throwables);
        }
        return saleAds;
    }

    public List<SaleAd> getAllByNameAndPice(String text, int maxPrice) {
        String sql = "SELECT * FROM sale_ads WHERE heading LIKE ? AND price <= ?;";
        List<SaleAd> saleAds = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            text = "%" + text + "%";
            preparedStatement.setString(1, text);
            preparedStatement.setInt(2, maxPrice);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int resultId = resultSet.getInt("id");
                int userId = resultSet.getInt("user_id");
                String heading = resultSet.getString("heading");
                String content = resultSet.getString("content");
                int price = resultSet.getInt("price");
                String phoneNumber = resultSet.getString("phone_number");
                String urlPhoto = resultSet.getString("url_photo");
                saleAds.add(new SaleAd(resultId, userId, heading, content, price, phoneNumber, urlPhoto));
            }
        } catch (SQLException throwables) {
            LOGGER.warn("Failed to get sale ads.", throwables);
        }
        return saleAds;
    }
}
