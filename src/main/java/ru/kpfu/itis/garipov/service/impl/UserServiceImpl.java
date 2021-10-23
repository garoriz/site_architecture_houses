package ru.kpfu.itis.garipov.service.impl;


import ru.kpfu.itis.garipov.dao.Dao;
import ru.kpfu.itis.garipov.dao.impl.UserDaoImpl;
import ru.kpfu.itis.garipov.dto.UserDTO;
import ru.kpfu.itis.garipov.helper.PasswordHelper;
import ru.kpfu.itis.garipov.model.User;
import ru.kpfu.itis.garipov.service.UserService;

public class UserServiceImpl implements UserService {

    private final Dao<User> dao = new UserDaoImpl();

    @Override
    public UserDTO get(String login) {
        User user = dao.get(login);
        if (user == null) {
            return null;
        }
        return new UserDTO(user.getName(), user.getSurname(), user.getStatus(),
                user.getUrlPhoto(), user.getLogin(), user.getPassword());
    }

    @Override
    public void save(User user) {
        dao.save(new User(
                user.getName(),
                user.getSurname(),
                user.getStatus(),
                user.getUrlPhoto(),
                user.getPassword(),
                PasswordHelper.encrypt(user.getPassword())
        ));
    }
}
