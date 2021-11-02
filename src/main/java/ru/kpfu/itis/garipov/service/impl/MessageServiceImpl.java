package ru.kpfu.itis.garipov.service.impl;

import ru.kpfu.itis.garipov.dao.impl.MessageDaoImpl;
import ru.kpfu.itis.garipov.dto.MessageDTO;
import ru.kpfu.itis.garipov.helper.PasswordHelper;
import ru.kpfu.itis.garipov.model.Message;
import ru.kpfu.itis.garipov.service.MessageService;

import java.util.ArrayList;
import java.util.List;

public class MessageServiceImpl implements MessageService {

    private final MessageDaoImpl dao = new MessageDaoImpl();

    @Override
    public List<MessageDTO> getAll(int userId, int recipientId) {
        List<Message> messages = dao.getAll(userId, recipientId);
        List<MessageDTO> messagesDTO = new ArrayList<>();
        for (Message message : messages) {
            messagesDTO.add(new MessageDTO(message.getId(),
                    message.getUserId(),
                    message.getRecipientId(),
                    message.getContent()));
        }
        return messagesDTO;
    }

    @Override
    public void save(Message message) {
        dao.save(new Message(
                message.getUserId(),
                message.getRecipientId(),
                message.getContent()
        ));
    }
}
