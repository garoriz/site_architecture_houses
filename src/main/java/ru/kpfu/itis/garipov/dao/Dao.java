package ru.kpfu.itis.garipov.dao;

import java.util.List;

public interface Dao<T> {
    T get(int id);

    void save(T t);

    List<T> getAll();
}
