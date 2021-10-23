package ru.kpfu.itis.garipov.service;

import ru.kpfu.itis.garipov.dto.UserDTO;
import ru.kpfu.itis.garipov.model.User;

public interface UserService {
    UserDTO get(String login);
    void save(User user);
}
