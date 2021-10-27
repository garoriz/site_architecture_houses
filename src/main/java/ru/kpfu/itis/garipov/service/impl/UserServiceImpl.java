package ru.kpfu.itis.garipov.service.impl;


import ru.kpfu.itis.garipov.dao.impl.UserDaoImpl;
import ru.kpfu.itis.garipov.dto.UserDTO;
import ru.kpfu.itis.garipov.helper.PasswordHelper;
import ru.kpfu.itis.garipov.model.User;
import ru.kpfu.itis.garipov.service.UserService;

public class UserServiceImpl implements UserService {

    private final UserDaoImpl dao = new UserDaoImpl();

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

    public void changeName(String login, String name) {
        dao.changeName(login, name);
    }

    public void changeSurname(String login, String surname) {
        dao.changeSurname(login, surname);
    }

    public void changeLogin(String login, String newLogin) {
        dao.changeLogin(login, newLogin);
    }

    public void changeUrlPhoto(String login, String urlPhoto) {
        dao.changeUrlPhoto(login, urlPhoto);
    }

    public void changeStatus(String login, String status) {
        dao.changeStatus(login, status);
    }

    public void changePassword(String login, String password) {
        dao.changePassword(login, PasswordHelper.encrypt(password));
    }
}
