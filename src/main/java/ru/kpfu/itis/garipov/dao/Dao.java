package ru.kpfu.itis.garipov.dao;

public interface Dao<T> {
    T get(String login);

    void save(T t);

    void change(String name, String surname, String login, String urlPhoto, String status, String password);
}
