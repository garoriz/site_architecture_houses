package ru.kpfu.itis.garipov.dao;

public interface Dao<T> {
    T get(String login);

    void save(T t);
}
