package ru.kpfu.itis.garipov.dao.impl;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import ru.kpfu.itis.garipov.dao.Dao;
import ru.kpfu.itis.garipov.helper.PostgresConnectionHelper;
import ru.kpfu.itis.garipov.model.Message;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MessageDaoImpl implements Dao<Message> {

    public static final Logger LOGGER = LoggerFactory.getLogger(ArticleDaoImpl.class);

    private final Connection connection = PostgresConnectionHelper.getConnection();

    @Override
    public Message get(int id) {
        return null;
    }

    @Override
    public void save(Message message) {
        String sql = "INSERT INTO messages (user_id, recipient_id, content) VALUES (?, ?, ?);";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, message.getUserId());
            preparedStatement.setInt(2, message.getRecipientId());
            preparedStatement.setString(3, message.getContent());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            LOGGER.warn("Failed to save new message.", throwables);
        }
    }

    @Override
    public List<Message> getAll() {
        return null;
    }

    public List<Message> getAll(int userId, int recipientId) {
        String sql = "SELECT * FROM messages WHERE user_id = ? AND recipient_id = ?;";
        List<Message> messages = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, userId);
            preparedStatement.setInt(2, recipientId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String content = resultSet.getString("content");
                messages.add(new Message(id, userId, recipientId, content));
            }
        } catch (SQLException throwables) {
            LOGGER.warn("Failed to get all messages.", throwables);
        }
        return messages;
    }
}

