package ru.kpfu.itis.garipov.dao;

import java.util.List;

public interface Dao<T> {
    T get(String login);

    void save(T t);

    List<T> getAll();
}
