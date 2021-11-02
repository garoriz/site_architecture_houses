package ru.kpfu.itis.garipov.service;


import ru.kpfu.itis.garipov.dto.MessageDTO;
import ru.kpfu.itis.garipov.model.Message;

import java.util.List;

public interface MessageService {
    List<MessageDTO> getAll(int userId, int recipientId);
    void save(Message message);
}
